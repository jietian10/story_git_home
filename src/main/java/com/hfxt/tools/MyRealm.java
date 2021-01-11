package com.hfxt.tools;

import com.hfxt.service.AccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    AccountService accountService;

//    @Autowired
//    RoleVoService roleVoService;

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        //授权对象
//        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//
//        //获取认证对象
//        com.hfxt.entity.Easybuy_user user= (com.hfxt.entity.Easybuy_user) SecurityUtils.getSubject().getPrincipal();
//
//        //获取该认证对象的角色
//        List<RoleVo> roleVos=roleVoService.selRoleByUser(user);
//        for (RoleVo role:roleVos){
//            info.addRole(role.getRoleCode());
//        }
//
//        return info;
        return null;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取认证对象
        Object username= token.getPrincipal();
        String password=new String((char[]) token.getCredentials());
        com.hfxt.model.Account user=new com.hfxt.model.Account();
        user.setUsername((String) username);
        try {
            user=accountService.selectByCon(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //账号不存在
        if (user == null){
            throw new UnknownAccountException();
        }

//        //加密 密码
//        String newPwd=new Md5Hash(password,user.getSalt(),1024).toString();

        //密码不正确
        if (!user.getPassword().equals(password)){
            throw new IncorrectCredentialsException();
        }


        //获取盐值
//        ByteSource salt=ByteSource.Util.bytes(user.getSalt());
        //第一个参数，认证的用户
        //第二个参数，数据库获取的密码
        //第三个参数，盐值，用于加密密码的对象    ,salt
        //第四个参数，当前real的名称
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),getName());

        return info;
    }
}
