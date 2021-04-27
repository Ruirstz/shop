package com.ruirui.demo05.service;

import com.ruirui.demo05.mapper.RoleMapper;
import com.ruirui.demo05.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRoleList() {
        return roleMapper.selectList(null);
    }

    @Override
    public Role getRoleById(int id) {
        return roleMapper.selectById(id);
    }

    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public int deleteById(int id) {
        return roleMapper.deleteById(id);
    }
}
