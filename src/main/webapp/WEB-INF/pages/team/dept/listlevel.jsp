

<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form id="pagerForm" method="post" action="../team/dept/list" >
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="w_removeSelected.html" method="post">
	<div class="searchBar">
		<ul class="searchContent">
		  <li><label>上级部门名称：</label><span> ${dept.deptName }</span></li>
		</ul>
	</div>
	</form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
          <shiro:hasAnyRoles name="团队负责人,管理员">
            <li><a class="add" href="../team/dept/preSaveTwo/${dept.deptId }" target="navTab"><span>添加部门</span></a></li>
            <li><a class="delete" href="../team/dept/delete?id={scaleId}" target="ajaxTodo" title="确定要删除吗?"><span>删除部门</span></a></li>
            <li><a class="edit" href="../team/dept/preupdate?id={scaleId}" target="navTab"><span>修改部门名称</span></a></li>
       		<li><a class="edit" href="../team/dept/preSaveTwo?id={scaleId}" target="navTab"><span>创建下级部门</span></a></li>
       		<li><a class="edit" href="../emp/list" target="navTab" ><span>员工管理</span></a></li>
       	</shiro:hasAnyRoles>
           <li><a class="edit" href="#" target="navTab"><span>查看部门员工</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    
    <table class="table" width="100%" layoutH="138">
   
        <thead>
       
        <tr>
        <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
          
             <th width="50">部门名称</th>
               <th width="50">详情</th>
        </tr>
        </thead>
        <tbody> 
        <c:forEach items="${list}" var="ddd">		
        	<tr target="scaleId" rel="${ddd.deptId }">
        	 <td><input name="ids" value="xxx" type="checkbox"></td>
            
            	 <td>${ddd.deptName}</td>
                <td><a href="../team/dept/listTeamLevel?id=${ddd.deptId }" target="navTab" >查看</a></td>
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



   


