<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">收件箱</strong>&nbsp;/&nbsp;<small>邮件相关</small>
<hr/>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" id="keyWords" class="am-form-field am-input-sm" placeholder="请输入关键字">
	</div>
	<div class="am-form-group am-form-select am-u-sm-2" id="condition">
	    <select class="am-input-sm">
	    	<option value="sender">发件人</option>
	    	<option value="theme">邮件主题</option>
	    	<option value="content">邮件内容</option>
	    </select>
  	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="javascript:;" id="inboxSearch">
		<i class="am-icon-search"></i>
		搜索
	</a>
</form>
<br/>
<div class="am-scrollable-horizontal">
	<table class="am-table am-table-compact am-table-striped am-table-hover am-text-nowrap" id="inboxTable">
		<thead>
			<tr>
				<th>序号</th>
				<th>发件人</th>
				<th>主题</th>
				<th>邮件内容</th>
				<th>时间</th>
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
		getInbox();
		$('#inboxSearch').click(inboxSearch);
	});
	function getInbox(){
		$('#inboxTable tbody').empty();
		$('#inboxTable tbody').append('<h1>正在加载...</h1>');
		var receiver = 1;//收件人 搜索条件
		$.ajax({
			url:'/crm/getInbox.do',
			type:'get',
			data:'receiver='+receiver,
			dataType:'json',
			success:function(data){
				showEmails(data);
			},
			error:function(){
				console.log('听说服务器出错了');
			}
		});	
	}
	function inboxSearch(){
		var condition = $('#condition select').val();//搜索条件
		var keyWords = $('#keyWords').val();
		var receiver = 1;//收件人 搜索条件
		console.log(condition+" "+keyWords);
		if(keyWords == ""){
			getInbox();
			return;
		}
		$.ajax({
			url:'/crm/inboxSearch.do',
			type:'post',
			data:'condition='+condition+'&keyWords='+keyWords+'&receiver='+receiver,
			dataType:'json',
			success:function(data){
				showEmails(data);
			},
			error:function(){
				console.log('哎呀，出错啦');
			}
			
		});
	}
	function showEmails(data){
		$('#inboxTable tbody').empty();
		for(var i = 0; i < data.length; i++){
			var email = data[i];
			$('#inboxTable tbody').append(
				'<tr><td>'+(i+1)+
				'</td><td>'+email.sender+
				'</td><td>'+email.theme+
				'</td><td>'+email.content+
				'</td><td>'+email.time+
				'</td></tr>'
			);
		}
	}
</script>