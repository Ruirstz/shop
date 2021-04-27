package com.ruirui.demo05.controller;

import com.ruirui.demo05.pojo.Role;
import com.ruirui.demo05.service.RoleService;
import com.ruirui.demo05.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/sys/role")

public class RoleController {
    @Resource
    private RoleService roleService;
    @GetMapping("/list")
    public ResultVo roleList(){
        return ResultVo.sucess(roleService.getRoleList());
    }
    /*
        @GetMapping("/list")
        public Object roleList(){
            return roleService.getRoleList();
        }
    */
//    //添加
//    @PostMapping("/add")
//    public void add(@RequestBody Role role){
//        role.setCreatedBy(1);
//        role.setCreationDate(LocalDateTime.now());
//        roleService.addRole(role);
//    }
    //添加
    @PostMapping("/add")
    public ResultVo add(@RequestBody Role role){
        try{
            role.setCreatedBy(1);
            role.setCreationDate(LocalDateTime.now());
            roleService.addRole(role);
            //log.info("添加角色成功--");
            return ResultVo.sucess("添加角色成功");
        }catch (Exception e){
            e.printStackTrace();
            //log.error("添加角色失败--");
            return  ResultVo.file("添加角色失败",e);
        }

    }
    //修改
    @PostMapping("/update")
    public ResultVo update(Role role){
        try{
            role.setModifyBy(1);
            //  role.setModifyDate(LocalDateTime.now());
            roleService.updateRole(role);
            //log.info("添加角色成功--");
            return ResultVo.sucess("修改角色成功");
        }catch (Exception e){
            e.printStackTrace();
            //log.error("添加角色失败--");
            return  ResultVo.file("修改角色失败",e);
        }

    }
    //删除
    @PostMapping("/del")
    public ResultVo del(String id){
        try{
            roleService.deleteById(Integer.parseInt(id));
            return ResultVo.sucess("删除角色成功");
        }catch (Exception e){
            e.printStackTrace();
            //log.error("添加角色失败--");
            return  ResultVo.file("删除角色失败",e);
        }

    }
}
