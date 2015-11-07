<%@ page language="java" pageEncoding="UTF-8"%>
<header class="am-topbar admin-header">
<div class="am-topbar-brand">
	<strong>房地产客户管理系统</strong>
	<small>Real Estate Customer Management System</small>
</div>
<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
	<ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
		<li>
			<a href="${pageContext.request.contextPath}/main.do">
				<span class="am-icon-home"></span> 首页
			</a>
		</li>
		<li>
			<a href="javascript:link('${pageContext.request.contextPath}/page/email/inBox.jsp');">
				<span class="am-icon-envelope-o"></span>
				收件箱
				 <span class="am-badge am-badge-warning">10</span>
			</a>
		</li>
		<li class="am-dropdown" data-am-dropdown>
			<a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
				<span class="am-icon-users"></span>
				${loginUser.name}的信息
				<span class="am-icon-caret-down"></span>
			</a>
			<ul class="am-dropdown-content">
				<li>
					<a href="javascript:link('${pageContext.request.contextPath}/page/base/userInfo.jsp');"><span class="am-icon-user"></span> 用户资料</a>
				</li>
				<li>
					<a href="javascript:link('${pageContext.request.contextPath}/page/base/modifyPwd.jsp');""><span class="am-icon-cog"></span> 修改密码</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/login.do"><span class="am-icon-power-off"></span> 退出系统</a>
				</li>
			</ul>
		</li>
		<li class="am-hide-sm-only">
			<a href="javascript:;" id="admin-fullscreen">
				<span class="am-icon-arrows-alt"></span>
				<span class="admin-fullText">开启全屏</span>
			</a>
		</li>
	</ul>
</div>
</header>