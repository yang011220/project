<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>



<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="w_removeSelected.html" method="post">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>我的员工：</label>
				<input type="text" name="keywords" value=""/>
			</li>
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="../emp/empPreAdd" target="navTab"><span>添加</span></a></li>
			<li><a class="add" href="../plan/planList" target="navTab"><span>查看拜访计划</span></a></li>
			<li><a class="add" href="../history/historyList" target="navTab"><span>拜访历史记录</span></a></li>
			<li><a class="edit" href="../" target="navTab" warn="请选择一个用户"><span>我的客户</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html" class="delete"><span>批量删除默认方式</span></a></li>
			<li class="line">line</li>
			<!--<li><a target="selectedLoad" rel="ids" postType="string" href="demo_page1.html" class="icon"><span>批量Dialog Load逗号分隔</span></a></li>-->
		</ul>
	</div>
	<table class="table" width="1200" layoutH="138">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="120" orderField="accountNo" class="asc">员工号ID</th>
				<th orderField="accountName">员工名称</th>
				<th width="80" orderField="accountType">员工所属部门</th>
				<th width="130" orderField="accountCert">员工角色</th>
				<th width="60" align="center" orderField="accountLevel">员工职位</th>
				<th width="70">员工用户帐号</th>
				<th width="70">员工所属公司</th>
				<th width="70">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList }" var="emp">
			<tr target="empId" rel="${emp.empId }">
				<td><input name="ids" value="xxx" type="checkbox"></td>
				<td>${emp.empId }</td>
				<td>${emp.empName }</td>
				<td>${emp.dept.deptName }</td>
				<td>${emp.role.roleName }</td>
				<td>${emp.empJob }</td>
				<td>${emp.user.userName }</td>
				<td>${emp.team.teamName }</td>
				<td>
					<a title="删除" target="ajaxTodo" href="../emp/empDelete/${emp.empId }" class="btnDel">删除</a>
					<a title="编辑" target="navTab" href="../emp/empPreUpdate/${emp.empId }" class="btnEdit">编辑</a>
				</td>
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
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${totalCount }" numPerPage="20" pageNumShown="10" currentPage="${pageNum }"></div>

	</div>
</div>