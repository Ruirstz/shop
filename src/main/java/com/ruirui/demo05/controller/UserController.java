package com.ruirui.demo05.controller;

import com.ruirui.demo05.service.UserService;
import com.ruirui.demo05.vo.ResultVo;
import com.ruirui.demo05.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sys/user")
public class UserController {
    @Resource
    private UserService userService;

    //    @GetMapping("/list")
//    public ResultVo getUserList(UserVo userVo){
//        System.out.println(userVo.getAtime()+":"+userVo.getUserName());
//        return ResultVo.sucess(userService.getUserList(userVo));
//    }

//    @GetMapping("list/{pageNo}/{pageSize}")
//    public ResultVo getUserList(@PathVariable("pageNo") String pageNo, @PathVariable("pageSize") String pageSize,UserVo userVo) {
//        return ResultVo.sucess(userService.getUserPageList(Integer.parseInt(pageNo), Integer.parseInt(pageSize), userVo));
//    }

    @GetMapping("/list/{pageNo}/{pageSize}")
    public ResultVo getUserList(@PathVariable("pageNo")String pageNo,@PathVariable("pageSize") String pageSize, UserVo userVo){
        return ResultVo.sucess(userService.getUserPageList(Integer.parseInt(pageNo),Integer.parseInt(pageSize),userVo));
    }
}
