
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<form id="pagerForm" method="post" action="../team/tuandui/listAll" >
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="w_removeSelected.html" method="post">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>团队名称：</label>
				<input type="text" name="teamName" value=""/>
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
            <li><a class="add" href="../team/tuandui/presave" target="navTab"><span>创建团队</span></a></li>
            <li><a class="delete" href="../team/tuandui/delete?id={scaleId}" target="ajaxTodo" title="确定要删除吗?"><span>解散团队</span></a></li>
            <li><a  class="edit"  href="../team/tuandui/preupdate?id={scaleId}" target="navTab"><span>修改团队信息</span></a></li>


            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
        <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="50">编号</th>
             <th width="50">团队名称</th>
              <th width="50">团队管理员</th>
            <th width="50">详情</th>
        </tr>
        </thead>
        <tbody> 
        <c:forEach items="${list}" var="scale">
        	<tr target="scaleId" rel="${scale.teamId}">
        	 <td><input name="ids" value="xxx" type="checkbox"></td>
            	<td>${scale.teamId}</td>
            	 <td>${scale.teamName}</td>
            	 <td>${scale.creator}</td>
            	 <td><a href="../team/dept/sessionTeam?id=${scale.teamId }" target="navTab" >进入团队</a></td>
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

        <div class="pagination" targetType="navTab" totalCount="${totalCount}" numPerPage="20" pageNumShown="10" currentPage="${pageNum}"></div>

    </div>
</div>



   


