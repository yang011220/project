<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<form id="pagerForm" method="post" action="../cushistoryr/listAll">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="" method="post">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>客户历史：</label>
				<input type="text" name="keywords" value=""/>
			</li>
			<li>
				起始时间：<input id="satrttime" type="date" name="satrttime"/>
				结束时间：<input id="endtime" type="date" name="endtime"/>
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
			<li><a class="add" href="../cushistory/preAdd3?teamId=${currentTeam.teamId }" target="navTab"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html" class="delete"><span>批量删除默认方式</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="demo/common/ajaxDone.html" class="delete"><span>批量删除逗号分隔</span></a></li>
			<li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<!--<li><a target="selectedLoad" rel="ids" postType="string" href="demo_page1.html" class="icon"><span>批量Dialog Load逗号分隔</span></a></li>-->
		</ul>
	</div>
	<table class="table" width="1200" layoutH="138">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="120" orderField="accountNo" class="asc">客户历史ID</th>
				<th orderField="accountName">创建时间</th>
				<th width="80" orderField="accountType">经办人</th>
				<th width="130" orderField="accountCert">客户</th>
				<th width="60" align="center" orderField="accountLevel">内容</th>
				<th width="70">归属团队</th>
				<th width="70">操作</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${list }" var="cushistory">
			<tr target="sid_user" rel="1">
				<td><input name="ids" value="xxx" type="checkbox"></td>
				<td>${cushistory.historyId }</td>
				<td>${cushistory.createTime }</td>
				<td>${cushistory.emp.empName }</td>
				<td>${cushistory.customer.cusName }</td>
				<td>${cushistory.context }</td>
				<td>${cushistory.team.teamName }</td>
				<td>
					<a title="删除" target="ajaxTodo" href="../cushistory/doDelete/${cushistory.historyId }" class="btnDel">删除</a>
					<a title="编辑" target="navTab" href="../cushistory/preUpdate3?teamId=${currentTeam.teamId }&historyId=${cushistory.historyId }" class="btnEdit">编辑</a>
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