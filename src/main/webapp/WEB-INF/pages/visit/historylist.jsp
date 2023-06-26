<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<form id="pagerForm" method="post" action="../customer/listAll">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="w_removeSelected.html" method="post">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>我的拜访历史记录：</label>
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
			<li><a class="add" href="../history/historyPreAdd" target="navTab"><span>添加</span></a></li>
			<li><a class="edit" href="../history/historyPreUpdate/{historyId}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
			<li class="line">line</li>
			<!--<li><a target="selectedLoad" rel="ids" postType="string" href="demo_page1.html" class="icon"><span>批量Dialog Load逗号分隔</span></a></li>-->
		</ul>
	</div>
	<table class="table" width="1200" layoutH="138">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="120" orderField="accountNo" class="asc">员工姓名</th>
				<th orderField="accountName">客户姓名</th>
				<th width="80" orderField="accountType">拜访时间</th>
				<th width="130" orderField="accountCert">拜访结果</th>
				<th width="60" align="center" orderField="accountLevel">拜访原因</th>
				<th width="70">拜访地址</th>
				<th width="70">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${hisList }" var="his">
			<tr target="historyId" rel="${his.vhId }">
				<td><input name="ids" value="xxx" type="checkbox"></td>
				<td>${his.emp.empName }</td>
				<td>${his.cust.cusName }</td>
				<td>${his.visitTime }</td>
				<td>${his.visitRecord }</td>
				<td>${his.visitReason }</td>
				<td>${his.visitPlace }</td>
				<td>
					<a title="删除" target="ajaxTodo" href="../history/historyDelete/${his.vhId }" class="btnDel">删除</a>
					<a title="编辑" target="navTab" href="demo_page4.html?id=xxx" class="btnEdit">编辑</a>
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