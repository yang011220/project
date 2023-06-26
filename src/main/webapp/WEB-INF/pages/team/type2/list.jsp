
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="pagerForm" method="post" action="../team/type2/list" >
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">

</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="../team/type2/presave" target="navTab"><span>添加</span></a></li>
            <li><a class="delete" href="../team/type2/delete?id={scaleId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="../team/type2/preupdate?id={scaleId}" target="navTab"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
        <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="50">编号</th>
             <th width="50">所属大类行业</th>
            <th width="50">所属小类行业</th>
        </tr>
        </thead>
        <tbody> 
        <c:forEach items="${list}" var="scale">
        	<c:forEach items="${scale.list}" var="type2">
        	<tr target="scaleId" rel="${type2.teamType2Id }">
        	 <td><input name="ids" value="xxx" type="checkbox"></td>
            	<td>${type2.teamType2Id}</td>
            	 <td>${scale.teamType1Name}</td>
                <td>${type2.teamType2Name}</td>    
            </tr>
        	</c:forEach>	
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



   
