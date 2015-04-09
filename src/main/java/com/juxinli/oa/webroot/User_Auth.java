package com.juxinli.oa.webroot;

/**
 * Created by noahli on 2015/4/9.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import com.juxinli.oa.model.SysUser;
import com.juxinli.oa.tools.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/**
 * 一个自定义的类用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
 *
 * @author
 */
public class User_Auth implements UserDetailsService {

    protected static Logger logger = Logger.getLogger("CustomUserDetailsService");//log4j，不用解释了吧。。

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        UserDetails user = null;
        try {
            // 搜索数据库以匹配用户登录名.
            // 我们可以通过dao使用Hibernate来访问数据库
            System.out.println(username + "   用户页面输入的用户名");

            //模拟一个从数据库获取的用户
            SysUser sysUser = new SysUser();
            sysUser.setName("noah");
            sysUser.setPassword("79309ad0c2d14d546b780cb88a3c42b8");//12345
            sysUser.setRole(SysUser.ROLE.ROLE_USER);
            System.out.println(sysUser.getName() + "   数据库取出的用户名");
            //可以对用户属性进行检测 如用户名、密码、是否启用、是否被锁定、是否过期、权限

            /*String salt = sysUser.getName();
            MD5Encoder encoderMd5 = new MD5Encoder(salt, "MD5");
            String encode = encoderMd5.encode(sysUser.getPassword());*/

            user = new User(sysUser.getName(),sysUser.getPassword(), true, true, true, true, getAuthorities(sysUser.getRole().toString()));
        } catch (Exception e) {
            throw new UsernameNotFoundException("异常处理：检索用户信息未通过！");
        }
        return user;
    }

    /**
     * 获得访问角色权限列表
     *
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(String role) {
        System.out.println("取得的权限是  :" + role);
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

        // 所有的用户默认拥有ROLE_USER权限
        if (role == SysUser.ROLE.ROLE_ADMIN.name()) {
            System.out.println("管理员");
            authList.add(new GrantedAuthorityImpl(SysUser.ROLE.ROLE_ADMIN.name()));
        }
        // 如果参数role为1.则拥有ROLE_ADMIN权限
        if (role == SysUser.ROLE.ROLE_USER.name()) {
            System.out.println("普通用户");
            authList.add(new GrantedAuthorityImpl(SysUser.ROLE.ROLE_USER.name()));
        }
        System.out.println(authList.size() + "  权限列表长度");
        return authList;
    }
}
