<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="pagerForm" method="post" action="../user/list">
    <input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="../user/preRegister" ><span>添加</span></a></li>
            <li><a class="delete" href="../user/delete/{userId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="../user/preUpdate/{userId}" target="navTab"><span>修改</span></a></li>

            <li><a class="add" href="../user/preAddAuth/{userId}" target="navTab"><span>用户赋权</span></a></li>

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
        <c:forEach items="${userList}" var="usr">
            <tr target="userId" rel="${usr.userId}">
                <td>${usr.userName}</td>
                <td>${usr.userNickname}</td>
                <td>${usr.createTime}</td>
                <td>${usr.creator}</td>
                <td>${usr.updateTime}</td>
                <td>${usr.updator}</td>
                <td>${usr.sex}</td>
                <td>${usr.birthday}</td>
                <td>${usr.idCard}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="200">200</option>
            </select>
            <span>条，共${totalPage}条</span>
        </div>

        <div class="pagination" targetType="navTab" totalCount="${totalPage}" numPerPage="20" pageNumShown="10" currentPage="${pageNum}"></div>

    </div>
</div>
