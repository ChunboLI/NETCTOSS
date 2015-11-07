<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">员工信息详情</strong>&nbsp;/&nbsp;<small>员工信息</small>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>
<% request.setAttribute("id", request.getParameter("id")); %>
<div id="id">${id}</div>
<script type="text/javascript">
	$(function(){
		findById();
		$("#id").hide();
	});
	//按ID查找员工
	function findById(){
		$.ajax({
			'url':'/crm/emp/findById.do',
			'type':'post',
			'data':{'id':$("#id").text()},
			'dataType':'json',
			'success':function(data){
				$("#name").val(data.name);
				$("#age").val(data.age);
				if(data.age==1){
					$("#gender").val("男");
				}else{
					$("#gender").val("女");
				}
				$("#nation").val(data.nation);
				$("#education").val(data.education);
				$("#marriage").val(data.marriage);
				$("#department").val(data.department);
				$("#role").val(data.role);
				$("#phone").val(data.phone);
				$("#interest").val(data.interest);
				$("#payCard").val(data.payCard);
				$("#mobilePhone").val(data.mobilePhone);
				$("#idCard").val(data.idCard);
				$("#createDate").val(data.createDate);
				$("#emp").val(data.emp);
				$("#modifyier").val(data.modifyier);
				$("#email").val(data.email);
				$("#address").val(data.address);
			},
			'error':function(){
				alert('出错了！');
			}
		});
	}
	
	//返回&刷新
	function back(){
		$("#crm-main").load('/crm/page/basis/employeeList.jsp');
	}
</script>
<form class="am-form am-form-horizontal">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">姓名：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="name">
		</div>
		<label class="am-u-sm-2 am-form-label">年龄：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="age">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">性别：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="gender">
		</div>
		<label class="am-u-sm-2 am-form-label">民族：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="nation">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">学历：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="education">
		</div>
		<label class="am-u-sm-2 am-form-label">婚姻：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="marriage">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">部门：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="department">
		</div>
		<label class="am-u-sm-2 am-form-label">角色：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="role">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">座机：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="mobilePhone">
		</div>
		<label class="am-u-sm-2 am-form-label">爱好：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="interest">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">工资卡号：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="payCard">
		</div>
		<label class="am-u-sm-2 am-form-label">手机：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="phone">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">身份证：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="idCard">
		</div>
		<label class="am-u-sm-2 am-form-label">添加时间：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="createDate">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">添加人：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="emp">
		</div>
		<label class="am-u-sm-2 am-form-label">修改人：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="modifyier">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">邮箱：</label>
		<div class="am-u-sm-4">
			<input type="text" id="email">
		</div>
		<label for="age" class="am-u-sm-2 am-form-label">修改时间：</label>
		<div class="am-u-sm-4" >
			<input type="text" id="">
		</div>
	</div>
	<div class="am-form-group">
		<label for="age" class="am-u-sm-2 am-form-label">住址：</label>
		<div class="am-u-sm-10">
			<input type="text" id="address">
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
			<button type="submit" class="am-btn am-btn-primary">
				确认
			</button>
			<button type="button" class="am-btn am-btn-default" onclick="back();">
				返回
			</button>
		</div>
	</div>
</form>