<%@ page language="java" pageEncoding="UTF-8"%>
<!-- sidebar start -->
<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
	<div class="am-offcanvas-bar admin-offcanvas-bar">
		<ul class="am-list admin-sidebar-list">
			<li class="admin-parent">
				<a class="am-cf" data-am-collapse="{target: '#customer-nav'}">
					<span class="am-icon-navicon"></span> 客户相关 <span class="am-icon-angle-right am-fr am-margin-right"></span>
				</a>
				<ul class="am-list am-collapse admin-sidebar-sub" id="customer-nav">
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/customer/customerList.jsp');" class="am-cf"><span class="am-icon-gears"></span> 客户信息 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/customer/allotList.jsp');"><span class="am-icon-exchange"></span> 客户分配 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/customer/careList.jsp');"><span class="am-icon-heart"></span> 客户关怀 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/customer/typeList.jsp');"><span class="am-icon-calendar"></span> 客户类型 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/customer/stateList.jsp');"><span class="am-icon-shekel"></span> 客户状态 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/customer/sourceList.jsp');"><span class="am-icon-spinner"></span> 客户来源 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/customer/recordList.jsp');"><span class="am-icon-history"></span> 联系记录 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/customer/contactList.jsp');"><span class="am-icon-globe"></span> 联系人 </a></li>
				</ul>
			</li>
			<li class="admin-parent">
				<a class="am-cf" data-am-collapse="{target: '#base-nav'}">
					<span class="am-icon-navicon"></span> 基础相关 <span class="am-icon-angle-right am-fr am-margin-right"></span>
				</a>
				<ul class="am-list am-collapse admin-sidebar-sub" id="base-nav">
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/basis/employeeList.jsp');" class="am-cf"><span class="am-icon-users"></span> 员工信息 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/basis/deptList.jsp');"><span class="am-icon-indent"></span> 部门信息 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/basis/houseList.jsp');"><span class="am-icon-building"></span> 房屋信息 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/basis/houseTypeList.jsp');"><span class="am-icon-bank"></span> 房屋类型 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/basis/noticeList.jsp');"><span class="am-icon-file"></span> 公告 </a></li>
				</ul>
			</li>
			<li class="admin-parent">
				<a class="am-cf" data-am-collapse="{target: '#email-nav'}">
					<span class="am-icon-navicon"></span> 邮件相关 <span class="am-icon-angle-right am-fr am-margin-right"></span>
				</a>
				<ul class="am-list am-collapse admin-sidebar-sub" id="email-nav">
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/email/writeEmail.jsp');" class="am-cf"><span class="am-icon-plus"></span> 写邮件 <span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/email/inBox.jsp');"><span class="am-icon-reply"></span> 收件箱 <span class="am-badge am-badge-secondary am-margin-right am-fr">10</span></a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/email/outBox.jsp');"><span class="am-icon-send"></span> 发件箱 <span class="am-badge am-badge-secondary am-margin-right am-fr">10</span></a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/email/draftBox.jsp');"><span class="am-icon-folder"></span> 草稿箱 <span class="am-badge am-badge-secondary am-margin-right am-fr"></span></a></li>
				</ul>
			</li>
			<li class="admin-parent">
				<a class="am-cf" data-am-collapse="{target: '#admin-nav'}">
					<span class="am-icon-navicon"></span> 管理员 <span class="am-icon-angle-right am-fr am-margin-right"></span>
				</a>
				<ul class="am-list am-collapse admin-sidebar-sub" id="admin-nav">
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/manage/addEmployee.jsp');" class="am-cf"><span class="am-icon-user-plus"></span> 添加员工 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/manage/addRole.jsp');"><span class="am-icon-user-md"></span> 添加角色 </a></li>
					<li><a href="javascript:link('${pageContext.request.contextPath}/page/manage/addDept.jsp');"><span class="am-icon-sitemap"></span> 添加部门 </a></li>
				</ul>
			</li>
		</ul>

		<div class="am-panel am-panel-default admin-sidebar-panel">
			<div class="am-panel-bd">
				<p><span class="am-icon-tag"></span> 时间日期</p>
				<p class="now-time">2015年9月1日 09:23:45</p>
			</div>
		</div>
	</div>
</div>
