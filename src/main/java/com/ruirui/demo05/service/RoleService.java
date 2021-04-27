package com.ruirui.demo05.service;

import com.ruirui.demo05.pojo.Role;

import java.util.List;

public interface RoleService {
    //获取所有的Role
    public List<Role> getRoleList();

    //根据id获取Role
    public Role getRoleById(int id);

    //添加
    public int addRole(Role role);

    //修改
    public int updateRole(Role role);

    //删除
    public int deleteById(int id);
}
