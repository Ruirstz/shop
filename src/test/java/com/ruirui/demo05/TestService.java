package com.ruirui.demo05;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruirui.demo05.pojo.User;
import com.ruirui.demo05.service.UserService;
import com.ruirui.demo05.vo.PageUtil;
import com.ruirui.demo05.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService {
    @Resource
    private UserService userService;
    @Test
    public void testPageUserList(){
        UserVo userVo = new  UserVo();
        userVo.setUserCode("a");
        PageUtil<User> ipage= userService.getUserPageList(1,5,userVo);
        ipage.getRecords().forEach(System.out::println);
    }
}
