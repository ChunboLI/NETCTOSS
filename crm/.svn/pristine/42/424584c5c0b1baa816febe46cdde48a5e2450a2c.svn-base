<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">员工信息编辑</strong>&nbsp;/&nbsp;<small>员工信息</small>&nbsp;/&nbsp;<small>基础相关</small>
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
				if(data.gender==1){
					$(':radio[name="sex"]').eq(0).attr("checked",true);
					$(':radio[name="sex"]').eq(1).attr("checked",false);
				}else{
					$(':radio[name="sex"]').eq(0).attr("checked",false);
					$(':radio[name="sex"]').eq(1).attr("checked",true);
				}
				$("#nation").val(data.nation);
				if($('#education option').eq(0).text()==data.education){
					$('#education option').eq(0).attr("selected",true);
					$('#education option').eq(1).attr("selected",false);
				}else{
					$('#education option').eq(1).attr("selected",true);
					$('#education option').eq(0).attr("selected",false);
				}
				if($("#marriage option").eq(0).text()==data.marriage){
					$("#marriage option").eq(0).attr("selected",true);
					$("#marriage option").eq(1).attr("selected",false);
				}else{
					$("#marriage option").eq(1).attr("selected",true);
					$("#marriage option").eq(0).attr("selected",false);
				}
				if($("#department option").eq(0).text()==data.department){
					$("#department option").eq(0).attr("selected",true);
					$("#department option").eq(1).attr("selected",false);
				}else{
					$("#department option").eq(1).attr("selected",true);
					$("#department option").eq(0).attr("selected",false);
				}
				if($("#role option").eq(0).text()==data.role){
					$("#role option").eq(0).attr("selected",true);
					$("#role option").eq(1).attr("selected",false);
				}else{
					$("#role option").eq(1).attr("selected",true);
					$("#role option").eq(0).attr("selected",false);
				}
				$("#phone").val(data.phone);
				$("#payCard").val(data.payCard);
				$("#mobilePhone").val(data.mobilePhone);
				$("#interest").val(data.interest);
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
	//修改员工信息
	function modify(){
		$.ajax({
			'url':'/crm/employeeEdit.do',
			'type':'post',
			'data':'',
			'dataType':'json',
			'success':function(data){
				
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
		<div class="am-u-sm-4">
			<input id="name" class="am-form-field am-input-sm" disabled="disabled" type="text" value="老王">
		</div>
		<label class="am-u-sm-2 am-form-label">年龄：</label>
		<div class="am-u-sm-4">
			<input id="age" class="am-form-field am-input-sm" type="number" value="20">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">性别：</label>
		<div class="am-u-sm-4">
			<label class="am-radio-inline">
				<input id="m" type="radio" name="sex" checked="checked">&nbsp;男
			</label>
			<label class="am-radio-inline">
				<input id="f" type="radio" name="sex">&nbsp;女
			</label>
		</div>
		<label class="am-u-sm-2 am-form-label">民族：</label>
		<div class="am-u-sm-4">
			<input id="nation" class="am-form-field am-input-sm" type="text" value="汉">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">学历：</label>
		<div class="am-u-sm-4">
			<select id="education">
				<option>本科</option>
				<option>硕士</option>
			</select>
		</div>
		<label class="am-u-sm-2 am-form-label">婚姻：</label>
		<div class="am-u-sm-4">
			<select id=marriage>
				<option>未婚</option>
				<option>已婚</option>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">部门：</label>
		<div class="am-u-sm-4">
			<select id="department">
				<option>财务部</option>
				<option>销售部</option>
			</select>
		</div>
		<label class="am-u-sm-2 am-form-label">角色：</label>
		<div class="am-u-sm-4">
			<select id="role" disabled="disabled">
				<option>管理员</option>
				<option>员工</option>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">座机：</label>
		<div class="am-u-sm-4">
			<input id="phone" class="am-form-field am-input-sm" type="text" value="234234234234">
		</div>
		<label class="am-u-sm-2 am-form-label">爱好：</label>
		<div class="am-u-sm-4">
			<input id="interest" class="am-form-field am-input-sm" type="text" value="玩皮球">
		</div>
	</div>
	<div class="am-form-group">
		<label id="payCard" class="am-u-sm-2 am-form-label">工资卡号：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" value="1231232131234334455454">
		</div>
		<label class="am-u-sm-2 am-form-label">手机：</label>
		<div class="am-u-sm-4">
			<input id="mobilePhone" class="am-form-field am-input-sm" type="text" value="12333232344">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">身份证：</label>
		<div class="am-u-sm-4">
			<input id="idCard" class="am-form-field am-input-sm" type="text" value="333333333333333333">
		</div>
		<label class="am-u-sm-2 am-form-label">添加时间：</label>
		<div class="am-u-sm-4">
			<input id="createDate" class="am-form-field am-input-sm" type="text" value="2013-12-23 23:23" disabled="disabled">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">添加人：</label>
		<div class="am-u-sm-4">
			<input id="" class="am-form-field am-input-sm" type="text" value="老王" disabled="disabled">
		</div>
		<label class="am-u-sm-2 am-form-label">修改人：</label>
		<div class="am-u-sm-4">
			<input id="modifyier" class="am-form-field am-input-sm" type="text" value="未修改">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">邮箱：</label>
		<div class="am-u-sm-4">
			<input id="email" class="am-form-field am-input-sm" type="text" value="776@qq.com">
		</div>
		<label for="age" class="am-u-sm-2 am-form-label">住址：</label>
		<div class="am-u-sm-4">
			<input id="address" class="am-form-field am-input-sm" type="text" value="宁波">
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