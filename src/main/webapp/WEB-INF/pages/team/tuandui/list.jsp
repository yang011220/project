<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<form id="pagerForm" method="post" action="../team/tuandui/list" >
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="w_removeSelected.html" method="post" >
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
           
           
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="是要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
        <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            
             <th width="50">团队名称</th>
              <th width="50">团队管理员</th>
            <th width="50">详情</th>
        </tr>
        </thead>
        <tbody> 
        <c:forEach items="${list}" var="scale">
        	<tr target="scaleId" rel="${scale.teamId}">
        	 <td><input name="ids" value="xxx" type="checkbox"></td>
            	
            	 <td>${scale.teamName}</td>
            	 <td>${scale.creator}</td>
            	 <td><a href="../team/dept/sessionTeam?id=${scale.teamId }" target="navTab"  >进入团队</a></td>
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



   


