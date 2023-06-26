<%@ page isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="edit" href="../user/preUpdate/{userId}" target="navTab"><span>修改个人信息</span></a></li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="80">用户名</th>
            <th width="80">昵称</th>
            <th width="100">创建时间</th>
            <th width="100">创建者</th>
            <th width="100">更新时间</th>
            <th width="100">更新者</th>
            <th width="80">性别</th>
            <th width="80">生日</th>
            <th width="80">身份证</th>
        </tr>
        </thead>
        <tbody>
            <tr target="userId" rel="${user.userId}">
                <td>${user.userName}</td>
                <td>${user.userNickname}</td>
                <td>${user.createTime}</td>
                <td>${user.creator}</td>
                <td>${user.updateTime}</td>
                <td>${user.updator}</td>
                <td>${user.sex}</td>
                <td>${user.birthday}</td>
                <td>${user.idCard}</td>
            </tr>
        </tbody>
    </table>
    </div>
</div>
