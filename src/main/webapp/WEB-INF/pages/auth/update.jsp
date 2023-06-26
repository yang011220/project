<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="pageContent">
	<form method="post" action="../auth/update" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageFormContent" layoutH="58">
		<div class="unit">
				<input type="hidden" name="authId" size="30"  value="${auth.authId}" />
			</div>
			<div class="unit">
				<label>权限：</label>
				<input type="text" name="authName" size="30" class="required" value="${auth.authName}" />
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>