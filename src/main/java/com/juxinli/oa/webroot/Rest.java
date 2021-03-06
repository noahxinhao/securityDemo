package com.juxinli.oa.webroot;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

/**
 * Created by noahli on 2015/4/9.
 */
@Controller
@RequestMapping("/rs")
public class Rest {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/main/admin", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView admin(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        return new ModelAndView("admin/admin");
    }

    @RequestMapping(value = "/main/common", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView common(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        //获取登陆用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        //获取登陆用户的所有权限
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        
        return new ModelAndView("common");
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView denied(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        return new ModelAndView("denied");
    }
}
