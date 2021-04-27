<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/header.jsp" %>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<div id="root">
    <div class="layout">
        <Layout>
            <Header>
                <i-Menu mode="horizontal" theme="dark" active-name="1">
                    <div class="layout-logo">
                    <Avatar src="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"></Avatar>
                    </div>
                    <div class="layout-nav">
                        <h3 style="color:white">超市订单管理系统</h3>
                        <i-button type="primary" size="small" style="position:relative;top:-30px;left:990px;" @click="logout()">退出</i-button>
                    </div>
                </i-Menu>
            </Header>
            <Layout>
                <%--<sider collapsible collapsible-width="1%"  v-model="isCollapsed" :style="{background: '#fff'}" :class="menuitemClasses">--%>
                    <%--<i-Menu active-name="1-2" theme="light" width="auto" :open-names="['1']">--%>
                        <%--<submenu v-for="m1 in menus" :name="m1.id">--%>
                            <%--<template slot="title">--%>
                                <%--<icon :type="m1.icon"></icon>--%>
                                <%--{{m1.name}}--%>
                            <%--</template>--%>
                            <%--<menu-item v-for="m2 in m1.children" :name="m2.id">--%>
                                <%--<a :href="m2.url" target="main">{{m2.name}}</a>--%>
                            <%--</menu-item>--%>
                        <%--</submenu>--%>

                    <%--</i-Menu>--%>
                <%--</sider>--%>
                    <Sider hide-trigger :style="{background: '#fff'}">
                        <i-Menu active-name="1-2" theme="light" width="auto" :open-names="['1']">
                            <Submenu name="1">
                                <template slot="title">
                                    <Icon type="ios-navigate"></Icon>
                                    系统设置
                                </template>
                                <Menu-Item name="1-1">
                                    <a href="sys/role/index" target="main">角色管理</a>
                                </Menu-Item>
                                <Menu-Item name="1-2">
                                    <a href="sys/user/index" target="main">用户管理</a>
                                </Menu-Item>
                                <Menu-Item name="1-3">机构管理</Menu-Item>
                            </Submenu>
                            <Submenu name="2">
                                <template slot="title">
                                    <Icon type="ios-keypad"></Icon>
                                    销售管理
                                </template>
                                <Menu-Item name="2-1">销售预收</Menu-Item>
                                <Menu-Item name="2-2">销售合适</Menu-Item>
                            </Submenu>
                            <Submenu name="3">
                                <template slot="title">
                                    <Icon type="ios-analytics"></Icon>
                                    客户管理
                                </template>
                                <Menu-Item name="3-1">客户资源管理</Menu-Item>
                                <Menu-Item name="3-2">客户发展计划</Menu-Item>
                            </Submenu>
                        </i-Menu>
                    </Sider>
                <Layout :style="{padding: '0 24px 24px'}">
                    <i-Content :style="{minHeight: '650px', background: '#fff'}">
                        <iframe name="main" width="100%" height="100%" frameborder="0"></iframe>
                    </i-Content>
                </Layout>
            </Layout>
        </Layout>
    </div>


</div>


<script>
    new Vue({
        el:"#root"
    })
</script>
</body>
</html>
