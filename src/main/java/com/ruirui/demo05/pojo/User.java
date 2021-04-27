package com.ruirui.demo05.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class User {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    private String salt;

    /**
     * 性别（1:女、 2:男）
     */
    private Integer gender;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.time.LocalDate birthday;

    /**
     * 手机
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户角色（取自角色表-角色id）
     */
    private Integer userRole;

    /**
     * 创建者（userId）
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private java.time.LocalDateTime creationDate;

    /**
     * 更新者（userId）
     */
    private Integer modifyBy;

    /**
     * 更新时间
     */
    private java.time.LocalDateTime modifyDate;

    private String attachPath;

    private String attachDescr;


}
