<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
	
		$('#sb').click(f1);
		$('#ret').click(f2);
	
	});
	
	function f1(){
		
		$.ajax({
				
				'url':'/crm/care/update.do',
			'type':'post',
			'data':{
				'id':$('#id').val(),
				'theme':$('#theme').val(),
				'custom':$('#s1 option').val(),
				'time':$('#time').val(),
				'nextTime':$('#nextTime').val(),
				'way':$('#way').val(),
				'emp':$('#emp').val(),
				'remarks':$('#remarks').val()
			},
			'dateType':'text',
			'success':function(data){
					alert(data);
					$("#crm-main").load('/crm/page/customer/careList.jsp');	
			}
			
			
				
				
			
		});
	
	}
	function f2(){
		$("#crm-main").load('/crm/page/customer/careList.jsp');
	}
	
</script>
<strong class="am-text-primary am-text-lg">客户关怀编辑</strong>&nbsp;/&nbsp;<small>客户关怀</small>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-horizontal">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			关怀主题：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="theme">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			关怀对象：
		</label>
		<div class="am-u-sm-10">
			<select id="s1" disabled="disabled">
				<option value="${care.custom}">${care.custom}</option>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			关怀时间：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="time" disabled="disabled" value="${care.time}">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			下次关怀时间：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="nextTime">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			关怀方式：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="way">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			关怀人：
		</label>
		<div class="am-u-sm-10">
			<input type="text" disabled="disabled" value="${care.emp}" id="emp">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			关怀备注：
		</label>
		<div class="am-u-sm-10">
			<textarea rows="8" id="remarks"></textarea>
			<input  type="text" style="display: none"
			value="${care.id }" id="id">
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
			<button id="sb" type="button" class="am-btn am-btn-primary">
				提交
			</button>
			<button type="reset" class="am-btn am-btn-default">
				重置
			</button>
			<button id="ret" type="button" class="am-btn am-btn-default">
				返回
			</button>
		</div>
	</div>
</form>