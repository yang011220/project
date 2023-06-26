<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="../user/update" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageFormContent" layoutH="58">
			<div style="display: none" class="unit">
				 <input type="hidden" readonly="readonly" name="userId" value="${user.userId}" />
			</div>
			
			<div class="unit">
				<label>用户名：</label>
				 <input type="text" readonly="readonly" name="userName" value="${user.userName}" />
			</div>
			<div class="unit">
				<label>昵称：</label>
				<input type="text" name="userNickname" value="${user.userNickname}"/>
			</div>
			<div class="unit">
				<label>性别：</label>
                <input type="radio" name="sex" checked="checked" value="男"/>男
                <input type="radio" name="sex" value="女"/>女
			</div>
			<div class="unit">
				<label>生日：</label>
				 <input type="date" name="birth" value="${user.birthday}">
			</div>
			<div class="unit">
				<label>身份证号：</label>
				<input type="text" name="idCard" minlength="18" maxlength="18" value="${user.idCard }">
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