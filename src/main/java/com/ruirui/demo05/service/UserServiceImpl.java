package com.ruirui.demo05.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruirui.demo05.mapper.UserMapper;
import com.ruirui.demo05.pojo.User;
import com.ruirui.demo05.vo.PageUtil;
import com.ruirui.demo05.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Override
    public List<User> getUserList(UserVo userVo) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(userVo.getUserCode()),"user_code",userVo.getUserCode())
                .like(!StringUtils.isEmpty(userVo.getUserName()),"username",userVo.getUserName())
                .eq(userVo.getUserRole()!=null,"user_role",userVo.getUserRole())
                .gt(userVo.getAtime()!=null,"birthday",userVo.getAtime())
                .lt(userVo.getEtime()!=null,"birthday",userVo.getEtime());
        return super.list(queryWrapper);
    }

    @Override
    public PageUtil<User> getUserPageList(Integer pageNo, Integer pageSize, UserVo userVo) {
        Page<User> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNo);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(!org.springframework.util.StringUtils.isEmpty(userVo.getUserCode()),"user_code",userVo.getUserCode())
                .like(!org.springframework.util.StringUtils.isEmpty(userVo.getUserName()),"username",userVo.getUserName())
                .eq(userVo.getUserRole()!=null,"user_role",userVo.getUserRole())
                .gt(userVo.getAtime()!=null,"birthday",userVo.getAtime())
                .lt(userVo.getEtime()!=null,"birthday",userVo.getEtime());
        //IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);

        IPage<User> ipage = super.page(page,queryWrapper);

        return PageUtil.getInstance(ipage);
    }
}
