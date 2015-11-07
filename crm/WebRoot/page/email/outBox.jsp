<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">发件箱</strong>&nbsp;/&nbsp;<small>邮件相关</small>
<hr/>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入关键字">
	</div>
	<div class="am-form-group am-form-select am-u-sm-2">
	    <select class="am-input-sm">
	    	<option value="option2">收件人</option>
	    	<option value="option3">邮件主题</option>
	    	<option value="option4">邮件内容</option>
	    </select>
  	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#">
		<i class="am-icon-search"></i>
		搜索
	</a>
</form>
<br/>
<div class="am-scrollable-horizontal">
	<table id="outboxTalbe" class="am-table am-table-compact am-table-striped am-table-hover am-text-nowrap">
		<thead>
			<tr>
				<th>序号</th>
				<th>收件人</th>
				<th>主题</th>
				<th>发送内容</th>
				<th>发送时间</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
</div>
<ul class="am-pagination am-pagination-right">
	<li class="am-disabled"><a href="#">&laquo;</a></li>
	<li class="am-active"><a href="#">1</a></li>
	<li><a href="#">2</a></li>
	<li><a href="#">3</a></li>
	<li><a href="#">4</a></li>
	<li><a href="#">5</a></li>
	<li><a href="#">&raquo;</a></li>
</ul>
<script type="text/javascript">
	$(function(){
		getOutbox();
	});
	function getOutbox(){
		$('#outboxTalbe tbody').empty();
		$('#outboxTalbe tbody').append('<h1>正在加载...</h1>');
		var sender = 2; //发件人 搜索条件
		$.ajax({
			url:'/crm/getOutbox.do',
			type:'post',
			data:'sender='+sender,
			dataType:'json',
			success:function(data){
				$('#outboxTalbe tbody').empty();
				console.log(11);
				for(var i = 0; i < data.length; i++){
					var email = data[i];
					$('#outboxTalbe tbody').append(
						'<tr><td>'+(i+1)+
						'</td><td>'+email.receiver+
						'</td><td>'+email.theme+
						'</td><td>'+email.content+
						'</td><td>'+email.time+
						'</td></tr>'
					);
				}
			},
			error:function(data){
				console.log('错啦啦啦');
			}
		});
	}
	
</script>