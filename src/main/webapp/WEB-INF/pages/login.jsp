<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<base href="<%= request.getContextPath()%>/"/>
<link href="dwz/themes/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
</head>
<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="http://demo.dwzjs.com"><img style="width: 80px;height:70px;" src="dwz/themes/default/images/login_logo.png" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href="http://bbs.dwzjs.com">反馈</a></li>
						<li><a href="doc/dwz-user-guide.pdf" target="_blank">帮助</a></li>
					</ul>
				</div>
				
			</div>
		</div>
		
		<div id="login_content">
			<div class="loginForm">
			
				<form>
					<p>
						<label>用户名：</label>
						<input type="text" id="username" name="username" size="20"  minlength="3" maxlength="20" class="required" class="login_input"  />
					</p>
					<p>
						<label>密码：</label>
						<input type="password" id="password" name="password" size="20" minlength="3" maxlength="20" class="required" class="login_input" />
					</p>
				</form>
				<div class="login_bar">
						<button style="display:block; width:75px; height:30px; border:none;" onclick="checkPost1();" value="注册"><img src="dwz/themes/default/images/register.png"></button>
						<button class="sub" onclick="checkPost2();" value="登录"></button>
				</div>
			</div>
			<div class="login_banner"><img src="dwz/themes/default/images/login_ban.jpg" /></div>
			<div class="login_main">
				<ul class="helpList">
					<li><a href="#">下载驱动程序</a></li>
					<li><a href="#">如何安装密钥驱动程序？</a></li>
					<li><a href="#">忘记密码怎么办？</a></li>
					<li><a href="#">为什么登录失败？</a></li>
				</ul>
				<div class="login_inner">
					<p>您可以使用 网易网盘 ，随时存，随地取</p>
					<p>您还可以使用 闪电邮 在桌面随时提醒邮件到达，快速收发邮件。</p>
					<p>在 百宝箱 里您可以查星座，订机票，看小说，学做菜…</p>
				</div>
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2009 www.dwzjs.com Inc. All Rights Reserved.
		</div>
	</div>

</body>
</html>
<script>
	function checkPost2(){
		var uname=$("#username").val();
		var pwd=$("#password").val();
		$(function() {
			$.get("user/login",{userName:uname,userPwd:pwd},function(data){
				if(data=="success"){
					window.location.href="user/preIndex?userName="+uname;
				}else {
					alert("用户名或密码错误，请重新登录");
					window.location.href="user/preLogin";
				}
			});
		})
		
	};

	function checkPost1(){
		window.location.href="user/preRegister";
		
	};
	
	
	
</script>
<!-- function checkPost(){
    		var $userName=$("#userName").val();
    		var $password=$("#password").val();
    		$.post("UserServlet",
        			{
        				method:"login", 
        				userName:$userName,
        				password: $password				
        			},
        			function(data,status){
        				if("fail"==data){
        					alert("登录失败");
        					return false;
        				}else if ("success" == data) {
        					alert("登录成功");
        					window.location.href='wedding.jsp';
        					return true;
    					}else if("constraint"==data){
    						alert("登录出现异常");
    						return false;
    					}
        			}
        			);
    		} -->