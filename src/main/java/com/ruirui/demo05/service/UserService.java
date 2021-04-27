package com.ruirui.demo05.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruirui.demo05.pojo.User;
import com.ruirui.demo05.vo.PageUtil;
import com.ruirui.demo05.vo.UserVo;

import java.util.List;

public interface UserService extends IService<User> {
    public List<User> getUserList(UserVo userVo);

    //分页
    public PageUtil<User> getUserPageList(Integer pageNo, Integer pageSize, UserVo userVo);
}
