<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">客户来源添加</strong>&nbsp;/&nbsp;<small>客户来源</small>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-horizontal" action="javascript:;">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			客户来源名称：
		</label>
		<div class="am-u-sm-10">
			<input type="text" id="source">
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
			<button type="submit" class="am-btn am-btn-primary" onclick="sourceAdd();">
				提交
			</button>
			<button type="submit" class="am-btn am-btn-default">
				返回
			</button>
		</div>
	</div>
</form>

<script>
	
	function sourceAdd(){
		$.ajax({
			'url':'/crm/customSource/add.do',
			'type':'post',
			'data':{'source':$('#source').val()},
			'dataType':'text',
			'success':function(data){
				alert(data);
				if("ok" == data){
					link('/crm/page/customer/sourceList.jsp');
				}	
			},
			'error':function(){
				alert("系统出错!");
			}
		});
	}
</script>