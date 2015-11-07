<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(function(){
		$('#sb').click(f1);
		$('#ret').click(f2);
	});
	function f1(){
		$.ajax({
			'url':'/crm/custom/update.do',
			'type':'post',
			'data':{
				'id':$('#id').val(),
				'belongto':$('#s1 option').val(),
				'name':$('#name').val(),
				'source':$('#s2 option').val(),
				'job':$('#job').val(),
				'type':$('#s4 option').val(),
				'gender':$(':radio').val(),
				'email':$('#email').val(),
				'birthday':$('#birthday').val(),
				'mobliephone':$('#mobliephone').val(),
				'qq':$('#qq').val(),
				'address':$('#address').val(),
				'weibo':$('#weibo').val(),
				'phone':$('#phone').val(),
				'msn':$('#msn').val(),
				'company':$('#company').val(),
				'creator':$('#creator').val(),
				'modifier':$('#modifier').val(),
				'status':$('#s3 option').val()
				
			},
			'dateType':'text',
			'success':function(data){
					alert(data);
					$("#crm-main").load('/crm/page/customer/customerList.jsp');
				
				
			}
			
			
			}
			
	);
		
	}
	function f2(){
	 	$("#crm-main").load('/crm/page/customer/customerList.jsp');
	}
</script>

<strong class="am-text-primary am-text-lg">客户信息编辑</strong>&nbsp;/&nbsp;<small>客户信息</small>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-horizontal">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">负责员工：</label>
		<div class="am-u-sm-4">
			<select id="s1">
				<c:forEach items="${elist}" var="emp"
						varStatus="s">
				<option value="${emp.id }">${ emp.name}</option>
				</c:forEach>
			</select>
		</div>
		<label class="am-u-sm-2 am-form-label">客户来源：</label>
		<div class="am-u-sm-4">
			<select id="s2">
				<c:forEach items="${csdlist}" var="customsource"
						varStatus="s">
				<option value="${customsource.id }">${ customsource.source}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户姓名：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" disabled="disabled"
			value="${custom.name }" id="name">
		</div>
		<label class="am-u-sm-2 am-form-label">客户状态：</label>
		<div class="am-u-sm-4">
			<select id="s3">
				<c:forEach items="${csslist}" var="customstatus"
						varStatus="s">
				<option value="${customstatus.id }">${customstatus.status}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">性别：</label>
		<div class="am-u-sm-4">
			<label class="am-radio-inline">
				<input type="radio" name="sex" checked="checked" value="0">&nbsp;男
			</label>
			<label class="am-radio-inline">
				<input type="radio" name="sex" value="1">&nbsp;女
			</label>
		</div>
		<label class="am-u-sm-2 am-form-label">客户类型：</label>
		<div class="am-u-sm-4">
			<select id="s4">
				<c:forEach items="${ctlist}" var="customtype"
						varStatus="s">
				<option value="${customtype.id }">${customtype.type}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">出生日期：</label>
		<div class="am-u-sm-4">
			<input type="text" disabled="disabled"
			value="${custom.birthday }" id="birthday">
		</div>
		<label class="am-u-sm-2 am-form-label">客户手机：</label>
		<div class="am-u-sm-4">
			<input type="text" id="mobliephone">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户QQ：</label>
		<div class="am-u-sm-4">
			<input type="text" id="qq">
		</div>
		<label class="am-u-sm-2 am-form-label">客户地址：</label>
		<div class="am-u-sm-4">
			<input type="text" id="address">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户邮箱：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text"
			id="email">
		</div>
		<label class="am-u-sm-2 am-form-label">客户职位：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text"
			id="job">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户微博：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text"
			id="weibo">
		</div>
		<label class="am-u-sm-2 am-form-label">客户座机：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text"
			id="phone">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户MSN：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text"
			id="msn">
		</div>
		<label class="am-u-sm-2 am-form-label">客户公司：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text"
			id="company">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">创建人：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" disabled="disabled"
			value="${custom.creator }" id="creator">
		</div>
		<label class="am-u-sm-2 am-form-label">修改人：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" 
			id="modifier">
			
			<input  type="text" style="display: none"
			value="${custom.id }" id="id">
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-offset-2 am-u-sm-4">
			<button id="sb" type="button" class="am-btn am-btn-primary">提交</button>
			<button id="ret" type="button" class="am-btn am-btn-default">返回</button>
		</div>
	</div>
</form>