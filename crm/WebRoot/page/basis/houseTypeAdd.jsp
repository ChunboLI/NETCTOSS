<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">房屋类型添加</strong>&nbsp;/&nbsp;<small>房屋类型</small>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>
<script type="text/javascript">
	//添加房屋类型
	function addHousetype(){
		$.ajax({
			'url':'/crm/house/add.do',
			'type':'post',
			'dataType':'json',
			'data':{'housetype.type':$("#type").val(),},
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
		$("#crm-main").load('/crm/page/basis/houseTypeList.jsp');
	}
</script>
<form class="am-form am-form-horizontal">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			房屋类型名称：
		</label>
		<div class="am-u-sm-10">
			<input type="text" placeholder="输入房屋类型" id="type" name="housetype.type">
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
			<button type="button" class="am-btn am-btn-primary" onclick="addHousetype();">
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