<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(function(){
		$('#edit').click(f1);
		$('#ret').click(f2);
	});
	function f1(){
	 	$("#crm-main").load('/crm/page/customer/customerEdit.jsp');
	}
	function f2(){
	 	$("#crm-main").load('/crm/page/customer/customerList.jsp');
	}
</script>
<strong class="am-text-primary am-text-lg">客户信息详情</strong>&nbsp;/&nbsp;<small>客户信息</small>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-horizontal">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">负责员工：</label>
		<div class="am-u-sm-4">
			${custom.belongTo }
		</div>
		<label class="am-u-sm-2 am-form-label">客户来源：</label>
		<div class="am-u-sm-4">
			${custom.source }
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户姓名：</label>
		<div class="am-u-sm-4">
			${custom.name }
		</div>
		<label class="am-u-sm-2 am-form-label">客户状态：</label>
		<div class="am-u-sm-4">
			${custom.status }
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">性别：</label>
		<div class="am-u-sm-4">
			${custom.gender }
		</div>
		<label class="am-u-sm-2 am-form-label">客户类型：</label>
		<div class="am-u-sm-4">
			${custom.type }
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">出生日期：</label>
		<div class="am-u-sm-4">
			${custom.birthday }
		</div>
		<label class="am-u-sm-2 am-form-label">客户手机：</label>
		<div class="am-u-sm-4">
			${custom.mobliePhone }
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户QQ：</label>
		<div class="am-u-sm-4">
			${custom.qq }
		</div>
		<label class="am-u-sm-2 am-form-label">客户地址：</label>
		<div class="am-u-sm-4">
			${custom.address }
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户邮箱：</label>
		<div class="am-u-sm-4">
			${custom.email }
		</div>
		<label class="am-u-sm-2 am-form-label">客户职位：</label>
		<div class="am-u-sm-4">
			${custom.job }
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户微博：</label>
		<div class="am-u-sm-4">
			${custom.weibo}
		</div>
		<label class="am-u-sm-2 am-form-label">客户座机：</label>
		<div class="am-u-sm-4">
			${custom.phone }
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户MSN：</label>
		<div class="am-u-sm-4">
			${custom.msn }
		</div>
		<label class="am-u-sm-2 am-form-label">客户公司：</label>
		<div class="am-u-sm-4">
			${custom.company }
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">创建人：</label>
		<div class="am-u-sm-4">
			${custom.creator }
		</div>
		<label class="am-u-sm-2 am-form-label">修改人：</label>
		<div class="am-u-sm-4">
			${custom.modifier }
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">创建时间：</label>
		<div class="am-u-sm-4">
			${custom.createDate }
		</div>
		<label class="am-u-sm-2 am-form-label">修改时间：</label>
		<div class="am-u-sm-4">
			本行无数据
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-offset-2 am-u-sm-4">
			<button id="edit" type="button" class="am-btn am-btn-default">编辑</button>
			<button id="ret" type="button" class="am-btn am-btn-default">返回</button>
		</div>
	</div>
</form>