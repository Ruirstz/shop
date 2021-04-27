<%--
  Created by IntelliJ IDEA.
  User: 64805
  Date: 2021/4/26
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true"%>
<html>
<head>
    <title>用户展示</title>
    <%@include file="/common/header.jsp"%>
</head>
<body>
<div id="root">
    <div style="margin-bottom: 10px;margin-top: 10px">
        <Collapse value="value1" v-model="coll1" style="line-height: 20px">
            <Panel name="1">
                多条件查询
                <p slot="content" <%--style="height: 20px;margin-top: -12px"--%>>
                    <i-Form :inline="true" :label-width="60">
                        <Form-Item label="用户编码">
                            <i-Input v-model="userVo.userCode" placeholder="请输入用户编码"></i-Input>
                        </Form-Item>
                        <Form-Item label="用户名字">
                            <i-Input v-model="userVo.userName" placeholder="请输入用户名字"></i-Input>
                        </Form-Item>
                        <Form-Item label="用户角色">
                            <i-Select v-model="userVo.userRole" style="width: 100px;">
                                <i-option value="">--全部--</i-option>
                                <i-Option v-for="item in roleList" :value="item.id" :key="item.value">{{ item.roleName }}</i-Option>
                            </i-Select>
                        </Form-Item>
                        <Form-Item label="用户生日">
                            <Date-Picker v-model="userVo.atime" type="date"  placeholder="start date" style="width: 120px" ></Date-Picker>
                            <Date-Picker v-model="userVo.etime" type="date"  placeholder="end date" style="width: 120px" ></Date-Picker>
                        </Form-Item>
                        <i-button type="primary" style="margin-left:20px; " @click="pageNo=1;getUserPageList()">搜索</i-button>
                    </i-Form>
                </p>
            </Panel>
        </Collapse>
    </div>
    <i-table :columns="columns" :data="data" border stripe height="428">
        <template slot-scope="{ row, index }" slot="gender">
            {{row.gender==1?"男":"女"}}
        </template>
        <template slot-scope="{ row, index }" slot="action">
            <i-Button type="primary">修改</i-Button>
            <i-Button type="error"  @click="">删除</i-Button>
            <i-Button type="info" @click="">查看</i-Button>
            <i-Button type="success"  @click="">上传</i-Button>
        </template>
    </i-table>
        <div style="text-align: center;margin-top: 10px">
            <template>
            <Page  :total="total"
                   :current.sync="pageNo"
                   :page-size="pageSize"
                   :page-size-opts="[8,10,15]"
                   @on-change="getUserPageList()"
                   @on-page-size-change="pageSize=arguments[0];getUserPageList()"
                show-total
                show-sizer></Page>
            </template>
        </div>
</div>
<script>
    new Vue({
        el:"#root",
        data:{
            columns:[
                {title:"用户编码",key:"userCode"},
                {title:"用户名字",key:"username"},
                {title:"用户性别",key:"gender"},
                {title:"用户角色",key:"userRole"},
                {title:"用户地址",key:"address"},
                {title:"用户生日",key:"birthday"},
                {title:"用户操作",slot:"action",minWidth:110,align:"center"}
            ],
            data:[],
            userVo:{},
            roleList:{},
            // tableHeight:535,
            coll1: '1',
            total:50,
            pageSize:8,
            pageNo:1
        },
        mounted(){
            this.getUserPageList();
            this.getRoleList();
        },
        methods:{
            getUserPageList(){
                axios.get(`${apath}/sys/user/list/${this.pageNo}/${this.pageSize}`,{params:this.userVo}).then(
                    ({data})=>{
                        this.data=data.result.records;
                        this.total=data.result.total;
                    }
                )
            },
            getRoleList(){
                axios.get(`${apath}/sys/role/list`).then(
                    ({data})=>{
                        this.roleList=data.result;
                    }
                )
            }
        }
    })
</script>
</body>
</html>
