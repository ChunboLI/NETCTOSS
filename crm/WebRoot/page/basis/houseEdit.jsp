<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">房屋信息编辑</strong>&nbsp;/&nbsp;<small>房屋信息</small>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>
<% request.setAttribute("id", request.getParameter("id")); %>
<div id="id">${id}</div>
<script type="text/javascript">
	$(function(){
		findById();
		$("#id").hide();
	});
	//根据id查询房屋信息
	function findById(){
		$.ajax({
			'url':'/crm/house/findById.do',
			'type':'post',
			'data':{'id':$("#id").text()},
			'dataType':'json',
			'success':function(data){
				if(data.type==1){
					type = "两室一厅";
				}else{
					type = "总统房";
				}
				$("#type").prepend("<option>"+type+"</option>");
				var slt = document.getElementById("type");
				slt.options[0].selected='selected';
				$("#emp").text(data.emp);
				$("#address").val(data.address);
				$("#price").val(data.price);
				$("#environment").val(data.environment);
			},
			'error':function(){
				alert("出错了");
			}
		});
	}
	//返回&刷新
	function back(){
		$("#crm-main").load('/crm/page/basis/houseList.jsp');
	}
</script>
<form class="am-form am-form-horizontal">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			房屋类型：
		</label>
		<div class="am-u-sm-10">
			<select id="type">
				<option>茅屋</option>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			房屋管理者：
		</label>
		<div class="am-u-sm-10">
			<select>
				<option id="emp"></option>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			房屋地址：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="address">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			价格（每平米）：
		</label>
		<div class="am-u-sm-10">
			<input type="number" id="price">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			房屋环境：
		</label>
		<div class="am-u-sm-10">
			<textarea rows="8" id="environment"></textarea>
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