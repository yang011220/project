
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="pagerForm" method="post" action="../team/type/list" >
    <input type="hidden" name="pageNum" value="1" />
</form>


<div class="pageHeader">

</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="../team/type1/presave" target="navTab"><span>添加</span></a></li>
            <li><a class="delete" href="../team/type1/delete?id={scaleId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="../team/type1/preupdate?id={scaleId}" target="navTab"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
        <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="50">编号</th>
            <th width="50">规模</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="scale">
            <tr target="scaleId" rel="${scale.teamType1Id }">
             <td><input name="ids" value="xxx" type="checkbox"></td>
            	<td>${scale.teamType1Id}</td>
                <td>${scale.teamType1Name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示20条，共${totalCount}条</span>
        </div>

        <div class="pagination" targetType="navTab" totalCount="${totalCount}" numPerPage="20" pageNumShown="10" currentPage="${pageNum}"></div>

    </div>
</div>



