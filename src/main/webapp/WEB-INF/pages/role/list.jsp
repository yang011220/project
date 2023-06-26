<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="pagerForm" method="post" action="../role/list">
    <input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="../role/preAdd" target="navTab"><span>添加</span></a></li>
            <li><a class="delete" href="../role/delete/{roleId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="../role/preUpdate/{roleId}" target="navTab"><span>修改</span></a></li>
            <li><a class="add" href="../role/preAddAuth/{roleId}" target="navTab"><span>角色赋权</span></a></li>
            <li><a class="edit" href="../role/preUpdateAuth/{roleId}" target="navTab"><span>更改角色权限</span></a></li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="80">角色id</th>
            <th width="80">角色名</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${roleList}" var="role">
            <tr target="roleId" rel="${role.roleId}">
                <td>${role.roleId}</td>
                <td>${role.roleName}</td>
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
