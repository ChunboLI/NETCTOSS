<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">草稿箱</strong>&nbsp;/&nbsp;<small>邮件相关</small>
<hr/>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入关键字">
	</div>
	<div class="am-form-group am-form-select am-u-sm-2">
	    <select class="am-input-sm">
	    	<option value="option1">收件人</option>
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
	<table id="draftboxTalbe" class="am-table am-table-compact am-table-striped am-table-hover am-text-nowrap">
		<thead>
			<tr>
				<th>序号</th>
				<th>收件人</th>
				<th>主题</th>
				<th>邮件内容</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>2</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>3</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>4</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>5</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>6</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>7</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>8</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>9</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>10</td>
				<td>老王</td>
				<td>你好</td>
				<td>你好，你大爷</td>
				<td>
					<a href="#">发送</a>
					<a href="#">删除</a>
				</td>
			</tr>
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
		getDraftbox();
	});
	function getDraftbox(){
		var sender = 2; //发件人 搜索条件
		$.ajax({
			url:'/crm/getDraftbox.do',
			type:'post',
			data:'sender='+sender,
			dataType:'json',
			success:function(data){
				$('#draftboxTalbe tbody').empty();
				console.log(11);
				for(var i = 0; i < data.length; i++){
					var email = data[i];
					$('#draftboxTalbe tbody').append(
						'<tr><td>'+(i+1)+
						'</td><td>'+email.receiver+
						'</td><td>'+email.theme+
						'</td><td>'+email.content+
						'</td><td><a href="javascript:;" onclick="sendDraft(this)">发送</a> <a href="javascript:;" id="1" onclick="delDraftbox(this)">删除</a><span style="display:none;">'+email.id+'</span></td></tr>'
					);
				}
			},
			error:function(data){
				console.log('错啦啦啦');
			}
		});
	}
	
	function sendDraft(e){
		var emailId = $(e).next().next().html();
		$.ajax({
			url:'/crm/sendDraft.do',
			type:'post',
			data:'emailId='+emailId,
			success:function(data){
				var str = data;
				$('#crm-main').empty();
				$('#crm-main').append('<h2>'+str+'</h2>');
			},
			error:function(){
				console.log('错误啦');
			}
		});
		
	}
	function delDraftbox(e){
		var emainId = $(e).next().html();
	}
	
</script>