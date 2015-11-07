<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">客户状态添加</strong>&nbsp;/&nbsp;<small>客户状态</small>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-horizontal" action="javascript:;">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			客户状态名称：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="status">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			客户状态描述：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="described">
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
			<button type="submit" class="am-btn am-btn-primary" onclick="stateAdd();">
				提交
			</button>
			<button type="submit" class="am-btn am-btn-default">
				返回
			</button>
		</div>
	</div>
</form>

<script>
	
	function stateAdd(){
		$.ajax({
			'url':'/crm/customStatus/add.do',
			'type':'post',
			'data':{'entity.status':$('#status').val(),'entity.described':$('#described').val()},
			'dataType':'text',
			'success':function(data){
				alert(data);
				if("ok" == data){
					link('/crm/page/customer/stateList.jsp');
				}	
			},
			'error':function(){
				alert("系统出错!");
			}
		});
	}
</script>