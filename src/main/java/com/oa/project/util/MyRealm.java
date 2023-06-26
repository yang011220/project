package com.oa.project.util;

import com.oa.project.biz.lt.UserBiz;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.team.Team;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Account;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 * Shiro自定义域
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserBiz userBiz;

    /**
     * 用于的权限的认证。
     * @param principalCollection
     * @return
     */
    
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	Subject sub=SecurityUtils.getSubject();
    	Team team=(Team) sub.getSession().getAttribute("currentTeam");
    	User username =(User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        Set<String> roleName = userBiz.findRoles(username.getUserName(), team) ;
        Set<String> permissions = userBiz.findAuths(username.getUserName()) ;
        info.setRoles(roleName);
        info.setStringPermissions(permissions);
        return info;
    }
    /**
   * @param tokens'sa'a's
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException{
        //获取用户账号
        String userName = token.getPrincipal().toString() ;
       User user = userBiz.findUserByUsername(userName) ;
        if (user != null){
        	String salt = user.getSalt();
            //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
            AuthenticationInfo authenticationInfo = 
            		new SimpleAuthenticationInfo
            		(user,user.getUserPwd(),ByteSource.Util.bytes(salt),"myRealm") ;
            return authenticationInfo ;
        }else{
            return  null ;
        }
    }
    public void clearAuthz(){
    	this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    	}
   
}


