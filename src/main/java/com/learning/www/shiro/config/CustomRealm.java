package com.learning.www.shiro.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.learning.www.entity.User;
import com.learning.www.service.RoleService;
import com.learning.www.service.UserMapperService;

public class CustomRealm extends AuthorizingRealm{
	//private UserMapperService usermapperservice;
	
	
	@Autowired
	private UserMapperService usermapperservice;
	@Autowired
	private RoleService roleService;
//	private void setUserMapperService (UserMapperService usermapperservice) {
//		this.usermapperservice = usermapperservice;
//	}
    
    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        int role_id = usermapperservice.getPasswordByUsername(username).getRole_id();
        String role = roleService.getRoleNmae(role_id);
        List<String> permList = roleService.getPermTokenByRoleID(role_id);
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        //设置用户的permission
        info.addStringPermissions(permList);
        return info;
	}
    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。  
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = usermapperservice.getPasswordByUsername(token.getUsername());
	        if(null == user) {
	        	throw new AccountException("用户名不正确");
	        }
	        String oringnPassword = new String((char[]) token.getCredentials());
	        String salt = user.getSalt();
	        System.out.println(token.getUsername()+"===="+oringnPassword);
	        String encodedPassword = ShiroEncryption.shiroEncryption(oringnPassword,salt);
	        //System.out.println("密码："+encodedPassword);
	        //String password = null;
	        // 从数据库获取对应用户名密码的用户
	        // usermapperservice.getPasswordByUsername(token.getUsername()).getPassword() --> 获取用户名对应的密码
	        if (!user.getPassword().equals(encodedPassword)) {
	            throw new AccountException("密码不正确");
	        }
	        return new SimpleAuthenticationInfo(user.getUsername(), oringnPassword, ByteSource.Util.bytes(salt) , getName());
	}
}
