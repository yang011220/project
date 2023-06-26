<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>



<div class="pageHeader">
	
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="../cusstate/preAdd" target="navTab"><span>添加</span></a></li>
		</ul>
	</div>
	<table class="table" width="1200" layoutH="138">
		<thead>
			<tr>
				<th width="120" orderField="accountNo" class="asc">客户类型ID</th>
				
				<th width="60" align="center" orderField="accountLevel">客户类型</th>
				
				<th width="70">操作</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${list }" var="cusstate">
			<tr target="sid_user" rel="1">
				<td>${cusstate.stateId}</td>
				<td>${cusstate.stateName }</td>
				
				<td>
					<a title="删除" target="ajaxTodo" href="../cusstate/doDelete/${cusstate.stateId }" class="btnDel">删除</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>