<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">房屋信息添加</strong>&nbsp;/&nbsp;<small>房屋信息</small>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>
<script type="text/javascript">
	$(function(){
		slt1();
		slt2();
	});
	//查找所有房屋类型
	function slt1(){
		$.ajax({
			'url':'/crm/housetype/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				$('#housetype').empty();
				for(i=0;i<data.length;i++){
					var s = data[i];
					$("#housetype").prepend("<option value="+s.id+">"+s.type+"</option>");
				}
			},
			'error':function(){
				alert("出错了！");
			}
		});
	}
	//查找所有房屋管理者
	function slt2(){
		$.ajax({
			'url':'/crm/emp/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				$('#emp').empty();
				for(i=0;i<data.length;i++){
					var s = data[i];
					$("#emp").prepend("<option value="+s.id+">"+s.name+"</option>");
				}
			},
			'error':function(){
				alert("出错了！");
			}
		});
	}
	//添加房屋
	function addHouse(){
		$.ajax({
			'url':'/crm/house/add.do',
			'type':'post',
			'dataType':'json',
			'data':{
				'house.type':$("#housetype option").val(),
				'house.emp':$("#emp option").val(),
				'house.address':$("#address").val(),
				'house.price':$("#price").val(),
				'house.environment':$("#environment").val()
			},
			'success':function(data){
				if(data!=null){
					alert("添加成功");
					back();
				}
			},
			'error':function(){
				alert("出错了！");
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
			<select id="housetype" name="house.type">
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			房屋管理者：
		</label>
		<div class="am-u-sm-10">
			<select id="emp" name="house.emp">
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			房屋地址：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="address" name="house.address">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			价格（每平米）：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="price" name="house.price">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			房屋环境：
		</label>
		<div class="am-u-sm-10">
			<textarea rows="8" id="environment" name="house.environment"></textarea>
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
			<button type="button" class="am-btn am-btn-primary" onclick="addHouse();">
				添加
			</button>
			<button type="reset" class="am-btn am-btn-default">
				重置
			</button>
			<button type="button" class="am-btn am-btn-default" onclick="back();">
				返回
			</button>
		</div>
	</div>
</form>