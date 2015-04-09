package com.juxinli.oa.model;

/**
 * Created by noahli on 2015/4/9.
 */
public class SysUser {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public String password;
    public ROLE role;

    public enum ROLE{
        ROLE_ADMIN,
        ROLE_USER;
    }

}
