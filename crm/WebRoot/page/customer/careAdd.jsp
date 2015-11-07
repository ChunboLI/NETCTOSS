<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){

	$('#sb1').click(f1);
	$('#ret1').click(f2);

	});
	function f1(){
		
		$.ajax({
			'url':'/crm/care/add.do',
			'type':'post',
			'data':{
				'theme':$('#theme').val(),
				'custom':$('#s1 option').val(),
				'nextTime':$('#nextTime').val(),
				'way':$('#way').val(),
				'emp':$('#s2 option').val(),
				'remarks':$('#remarks').val()
			},
			'dataType':'text',
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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<strong class="am-text-primary am-text-lg">客户关怀添加</strong>&nbsp;/&nbsp;<small>客户关怀</small>&nbsp;/&nbsp;<small>客户相关</small>
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
			<select id="s1">
				<c:forEach items="${clist }" var="custom" varStatus="s">
				<option value="${custom.id }">${custom.name }<option>
				</c:forEach>
			</select>
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
			<select id="s2">
				<c:forEach items="${elist }" var="emp" varStatus="s">
				<option value="${emp.id }">${emp.name }<option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			关怀备注：
		</label>
		<div class="am-u-sm-10">
			<textarea rows="8" id="remarks"></textarea>
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
			<button id="sb1" type="button" class="am-btn am-btn-primary">添加</button>
			<button type="reset" class="am-btn am-btn-default">重置</button>
			<button id="ret1" type="button" class="am-btn am-btn-default">返回</button>
		</div>
	</div>
</form>