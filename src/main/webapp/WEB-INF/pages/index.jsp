<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
    <base href="<%=request.getContextPath()%>/dwz/"/>

    <link href="themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
    <link href="uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
    <!--[if IE]>
    <link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
    <![endif]-->

    <!--[if lte IE 9]>
    <script src="js/speedup.js" type="text/javascript"></script>
    <![endif]-->
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
    <script src="js/jquery-1.7.2.js" type="text/javascript"></script>
    <script src="js/jquery.cookie.js" type="text/javascript"></script>
    <script src="js/jquery.validate.js" type="text/javascript"></script>
    <script src="js/jquery.bgiframe.js" type="text/javascript"></script>
    <script src="xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
    <script src="xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
    <script src="uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

    <!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
    <script type="text/javascript" src="chart/raphael.js"></script>
    <script type="text/javascript" src="chart/g.raphael.js"></script>
    <script type="text/javascript" src="chart/g.bar.js"></script>
    <script type="text/javascript" src="chart/g.line.js"></script>
    <script type="text/javascript" src="chart/g.pie.js"></script>
    <script type="text/javascript" src="chart/g.dot.js"></script>

    <script src="js/dwz.core.js" type="text/javascript"></script>
    <script src="js/dwz.util.date.js" type="text/javascript"></script>
    <script src="js/dwz.validate.method.js" type="text/javascript"></script>
    <script src="js/dwz.regional.zh.js" type="text/javascript"></script>
    <script src="js/dwz.barDrag.js" type="text/javascript"></script>
    <script src="js/dwz.drag.js" type="text/javascript"></script>
    <script src="js/dwz.tree.js" type="text/javascript"></script>
    <script src="js/dwz.accordion.js" type="text/javascript"></script>
    <script src="js/dwz.ui.js" type="text/javascript"></script>
    <script src="js/dwz.theme.js" type="text/javascript"></script>
    <script src="js/dwz.switchEnv.js" type="text/javascript"></script>
    <script src="js/dwz.alertMsg.js" type="text/javascript"></script>
    <script src="js/dwz.contextmenu.js" type="text/javascript"></script>
    <script src="js/dwz.navTab.js" type="text/javascript"></script>
    <script src="js/dwz.tab.js" type="text/javascript"></script>
    <script src="js/dwz.resize.js" type="text/javascript"></script>
    <script src="js/dwz.dialog.js" type="text/javascript"></script>
    <script src="js/dwz.dialogDrag.js" type="text/javascript"></script>
    <script src="js/dwz.sortDrag.js" type="text/javascript"></script>
    <script src="js/dwz.cssTable.js" type="text/javascript"></script>
    <script src="js/dwz.stable.js" type="text/javascript"></script>
    <script src="js/dwz.taskBar.js" type="text/javascript"></script>
    <script src="js/dwz.ajax.js" type="text/javascript"></script>
    <script src="js/dwz.pagination.js" type="text/javascript"></script>
    <script src="js/dwz.database.js" type="text/javascript"></script>
    <script src="js/dwz.datepicker.js" type="text/javascript"></script>
    <script src="js/dwz.effects.js" type="text/javascript"></script>
    <script src="js/dwz.panel.js" type="text/javascript"></script>
    <script src="js/dwz.checkbox.js" type="text/javascript"></script>
    <script src="js/dwz.history.js" type="text/javascript"></script>
    <script src="js/dwz.combox.js" type="text/javascript"></script>
    <script src="js/dwz.print.js" type="text/javascript"></script>
    <!--
    <script src="bin/dwz.min.js" type="text/javascript"></script>
    -->
    <script src="js/dwz.regional.zh.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function(){
            DWZ.init("dwz.frag.xml", {
                //loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
                statusCode:{ok:200, error:300, timeout:301}, //【可选】
                pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
                debug:false,	// 调试模式 【true|false】
                callback:function(){
                    initEnv();
                    $("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
                }
            });
        });

    </script>
</head>

<body scroll="no">
<div id="layout">
    <div id="header">
        <div class="headerNav">
            <a class="logo" href="javascript:void(0)">标志</a>
            <ul class="nav">
                <li><a href="javascript:void(0)">欢迎您，${users.userName }</a></li>
                <li><a href="../user/preLogin">退出</a></li>

            </ul>
            <ul class="themeList" id="themeList">
                <li theme="default"><div class="selected">蓝色</div></li>
                <li theme="green"><div>绿色</div></li>
                <li theme="purple"><div>紫色</div></li>
                <li theme="silver"><div>银色</div></li>
                <li theme="azure"><div>天蓝</div></li>
            </ul>
        </div>

        <!-- navMenu -->

    </div>

    <div id="leftside">
        <div id="sidebar_s">
            <div class="collapse">
                <div class="toggleCollapse"><div></div></div>
            </div>
        </div>
        <div id="sidebar">
            <div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

            <div class="accordion" fillSpace="sidebar">
                <div class="accordionHeader">
                    <h2><span>Folder</span>我的主页	</h2>
                </div>
                <div class="accordionContent">
                    <ul class="tree treeFolder">

                       <shiro:hasAnyRoles name="普通用户,员工">
                        <li><a href="javascript:void(0);" >我的团队</a>
                            <ul>
                            	 <shiro:hasAnyRoles name="普通用户">
                                <li><a href="../team/tuandui/list" target="navTab" rel="main">我的团队</a></li>
                                 </shiro:hasAnyRoles>
                                 <li><a  href="../team/tuandui/presave" target="navTab">创建团队</a></li>
                            	  	
                            </ul>
                        </li>
                    <shiro:hasAnyRoles name="员工,团队负责人">
                        <li><a href="javascript:void(0);" >客户管理</a>
                            <ul>
                                <li><a href="../customer/listByempId?pageNum=1" target="navTab" rel="main">查看我的客户</a></li>
                                <li><a href="../contract/listByempId?pageNum=1" target="navTab" rel="main">查看我签署的合同</a></li>
                                <li><a href="../cushistory/listByempId?pageNum=1" target="navTab" rel="main">查看我的客户历史</a></li>	
                                <shiro:hasRole name="团队负责人">
                                <li><a href="../customer/listByteamId?pageNum=1" target="navTab" rel="main">查看本公司客户</a></li>
                                <li><a href="../customer/findEmp" target="navTab" rel="main">查看员工客户</a></li>
                                <li><a href="../contract/listByteamId?pageNum=1" target="navTab" rel="main">合同管理</a></li>
                                <li><a href="../cushistory/listByteamId?pageNum=1" target="navTab" rel="main">历史管理</a></li>
                                </shiro:hasRole>
                            </ul>
                        </li>
 					</shiro:hasAnyRoles>
                        </shiro:hasAnyRoles>
                          <shiro:hasRole name="普通用户">
                        <li><a href="javascript:void(0);" >个人管理</a>
                            <ul>
                                <li><a href="../user/listOne" target="navTab" rel="main">我的个人信息</a></li>
                              	 <li><a href="../friend/findMyAllFriend" target="navTab" >我的好友管理 </a></li>
                            </ul>
                        </li>
                        </shiro:hasRole>
                 	  <shiro:hasAnyRoles name="员工,团队负责人">

                        <li><a href="javascript:void(0);" >客户管理</a>

                            <ul>
                                <li><a href="../customer/listByempId?pageNum=1" target="navTab" rel="main">查看我的客户</a></li>
                                <li><a href="../contract/listByempId?pageNum=1" target="navTab" rel="main">查看我签署的合同</a></li>
                                <li><a href="../cushistory/listByempId?pageNum=1" target="navTab" rel="main">查看我的客户历史</a></li>	
                                <shiro:hasRole name="团队负责人">
                                <li><a href="../customer/listByteamId?pageNum=1" target="navTab" rel="main">查看本公司客户</a></li>
                                <li><a href="../customer/findEmp" target="navTab" rel="main">查看员工客户</a></li>
                                <li><a href="../contract/listByteamId?pageNum=1" target="navTab" rel="main">合同管理</a></li>
                                <li><a href="../cushistory/listByteamId?pageNum=1" target="navTab" rel="main">历史管理</a></li>
                                </shiro:hasRole>
                                </ul>
                        </li>
 					
 					</shiro:hasAnyRoles>
                        <shiro:hasRole name="团队负责人">
                        <li><a href="javascript:void(0);" >员工管理</a>
                            <ul>
                                <li><a href="../emp/list" target="navTab" rel="main">员工总览</a></li>
                               <li><a href="../friend/list" target="navTab" rel="main" >好友列表</a></li>
                            </ul>
                        </li>
                   </shiro:hasRole>
						<shiro:hasRole name="管理员">
                        <li><a href="javascript:void(0);" >管理员管理</a>
                            <ul>
                                <li><a href="../user/list?pageNum=1" target="navTab" rel="main">用户管理</a></li>
                                <li><a href="../role/list?pageNum=1" target="navTab" rel="main">角色管理</a></li>
                             <li><a href="../auth/list?pageNum=1" target="navTab" rel="main">权限管理</a></li>
                             <li><a href="../auth/list?pageNum=1" target="navTab" rel="main">团队管理</a></li>
                            </ul>
                        </li>
                        

                        <li><a href="javascript:void(0);" >客户管理</a>
                            <ul>
                                <li><a href="../customer/listAll?pageNum=1" target="navTab" rel="main">客户管理</a></li>
                                <li><a href="../custype/list" target="navTab" rel="main">客户类型管理</a></li>
                                <li><a href="../cusstate/list" target="navTab" rel="main">状态管理</a></li>
                                <li><a href="../custag/list" target="navTab" rel="main">标签管理</a></li>
                                <li><a href="../tagtype/list" target="navTab" rel="main">标签类型管理</a></li>
                                <li><a href="../contract/listAll?pageNum=1" target="navTab" rel="main">合同管理</a></li>
                                <li><a href="../cushistory/listAll?pageNum=1" target="navTab" rel="main">历史管理</a></li>
                            </ul>
                        </li>

                        <li><a href="javascript:void(0);">团队基础管理</a>
                        	<ul>
                        	 <li><a href="../team/tuandui/listAll?pageNum=1" target="navTab" rel="main" >所有团队</a></li>
                        	 <li><a href="../team/scale/list" target="navTab" rel="main">设置初始团队规模</a></li>
   								 <li><a href="../team/type1/list" target="navTab" rel="main">设置初始行业大类</a></li> 
      							<li><a href="../team/type2/list?pageNum=1" target="navTab" rel="main">设置初始行业小类</a></li>
      							 <li> <a href="../team/dept/list" target="navTab" rel="main">设置初始部门</a> </li>
                        	</ul>
                       	</li>		

                        </shiro:hasRole>
                        <shiro:hasRole name="普通用户">
                        <li><a href="javascript:void(0);" >个人管理</a>
                            <ul>
                                <li><a href="../user/listOne" target="navTab" rel="main">我的个人信息</a></li>
                              	 <li><a href="../friend/findMyAllFriend" target="navTab" rel="main">我的好友管理 </a></li>
                            </ul>
                        </li>
                        </shiro:hasRole>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div id="container">
        <div id="navTab" class="tabsPage">
            <div class="tabsPageHeader">
                <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                    <ul class="navTab-tab">
                        <li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">龙工主页</span></span></a></li>
                    </ul>
                </div>
                <div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
                <div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
                <div class="tabsMore">more</div>
            </div>
            <ul class="tabsMoreList">
                <li><a href="javascript:;">主页</a></li>
            </ul>
            <div class="navTab-panel tabsPageContent layoutBox">
                <div class="page unitBox">
                    <div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">
                        <iframe width="100%" height="430" class="share_self"  frameborder="0" scrolling="no" src=""></iframe>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>

<div id="footer"></div>


</body>
</html>



<%--!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>首页</title>

		<link rel="icon" href="img/logo.ico" />
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
	</head>
	<body onload="fn()">
		<div id="content">
			<div id="top">
				<img src="img/logo.ico" />
				<span>XX学生信息管理系统</span>
			</div>
			<div id="left">
				<ul>
					<li><a href="Student.do" target="contentFrame">学生信息管理</a></li>
					<li><a href="Classes.do" target="contentFrame">班级信息管理</a></li>
					<li><a href="#">学生成绩管理</a></li>
					<li><a href="#">学生课程管理</a></li>
				</ul>
			</div>
			<div id="center">
				<iframe name="contentFrame" src="Student.do" width="100%" height="99%"></iframe>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		function fn(){
			document.getElementById("content").style.height = window.innerHeight + "px";
		}
	</script>
</html--%>


