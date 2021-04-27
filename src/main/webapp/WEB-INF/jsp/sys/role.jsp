<%--
  Created by IntelliJ IDEA.
  User: 64805
  Date: 2021/4/26
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色展示</title>
    <%@include file="/common/header.jsp"%>
</head>
<body>
<div id="roleroot">
    <card>
        <i-button type="info" @click="add()">添加角色</i-button>
        <i-button type="error">修改角色</i-button>
    </card>
    <i-table :columns="columns" :data="data" border stripe>
        <template slot-scope="{ row, index }" slot="action">
            <i-Button type="primary" size="large" @click="update(row)">修改</i-Button>
            <i-Button type="error" size="large" @click="del(row,index)">删除</i-Button>
        </template>
    </i-table>
    <Modal v-model="modaladd" title="添加角色"  @on-ok="doadd">
        <i-Form :label-width="80">
            <Form-Item label="角色编码">
                <i-Input v-model="role.roleCode" placeholder="请输入角色编码"></i-Input>
            </Form-Item>
            <Form-Item label="角色名字">
                <i-Input v-model="role.roleName" placeholder="请输入角色名字"></i-Input>
            </Form-Item>
        </i-Form>
    </Modal>
    <Modal v-model="modalupdate" title="修改角色"  @on-ok="doupdate" @on-cancel="cancel">
        <i-Form :label-width="80">
            <Form-Item label="角色编码">
                <i-Input v-model="role.roleCode" placeholder="请输入角色编码"></i-Input>
            </Form-Item>
            <Form-Item label="角色名字">
                <i-Input v-model="role.roleName" placeholder="请输入角色名字"></i-Input>
            </Form-Item>
            <Form-Item label="角色修改">
                <%--<i-Input v-model="role.modifyDate" placeholder="请输入角色修改"></i-Input>--%>
                <Date-Picker v-model="role.modifyDate" type="datetime" style="width: 200px"></Date-Picker>
            </Form-Item>
        </i-Form>
    </Modal>
</div>
<script>
    new Vue({
        el:"#roleroot",
        data:{
            columns:[
                {title:"角色id",key:"id"},
                {title:"角色编码",key:"roleCode"},
                {title:"角色名字",key:"roleName"},
                {title:"角色日期",key:"creationDate"},
                {title:"角色修改",key:"modifyDate"},
                {title:"角色操作", slot:"action"}
            ],
            data:[],
            modaladd:false,
            modalupdate:false,
            role:{}
        },
        mounted() {
            this.getRoleList();
        },
        methods:{
            getRoleList(){
                axios.get("sys/role/list").then(
                    ({data})=>{
                        this.data=data.result;
                    }
                )
            },
            cancel(){
                this.getRoleList();
            },

            add(){
                this.modaladd=true;
            },
            doadd(){
                axios.post("${apath}/sys/role/add",this.role).then(
                    ({data})=>{
                        iview.Message.success({content:"角色添加成功"})
                        this.getRoleList();
                    }
                )
            },
            update(row){
                this.role=row;
                this.modalupdate=true;
            },
            doupdate(){
                axios.defaults.headers = {
                    "Content-type": "application/x-www-form-urlencoded"
                };
                //Qs.stringify(this.role: 转为序列化字符串
                let params=Qs.stringify(this.role,{serializeDate:(date)=>{
                        return moment(date).format("YYYY-MM-DD HH:mm:ss");
                    }});
                axios.post("${apath}/sys/role/update",params).then(
                    ({data})=>{
                        iview.Message.success({content:"角色修改成功"})
                        this.getRoleList();
                    }
                )
            },
            del(row,index){
                _this=this;
                iview.Modal.confirm({
                    title:"删除角色",
                    content: "确定删除这个角色吗?",
                    onOk(){
                        axios.post("${apath}/sys/role/del?id="+row.id)
                            .then(({data})=>{
                                iview.Message.success({content:"删除角色成功"});
                                _this.getRoleList();
                            })
                    },
                    onCancel(){

                    }
                })
            }
        }
    })
</script>
</body>
</html>

