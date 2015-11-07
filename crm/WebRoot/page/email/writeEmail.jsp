<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		//ajax获取收件人信息
		getReceiver();
		//发送邮箱事件
		$('#sendMail').click(sendEmail);
	});
	//获取收件人信息
	function getReceiver(){
		$('#person select').empty();
		$.ajax({
			url:'/crm/getReceiver.do',
			type:'post',
			dataType:'json',
			success:function(data){
				for(var i = 0; i <data.length; i++){
					var e = data[i];
					console.log(e.name+" "+e.id);
					var op = new Option(e.name,e.id);
					$('#person select').append(op);
				}
			},
			error:function(){
				console.log('错误');
			}
		});
	}
	
	
	//发送邮件
	function sendEmail(){
		var receiver = $('#person select').val();//获取select的选择
		//console.log(receiver);
		var sender = 2;
		var theme = $('#title').val();
		//console.log(theme);
		var content = $('#context').val();
		console.log(content);
		if(theme == "" || content == ""){
			$('#content_msg').html('邮件主题或内容不能为空');
			$('#content_msg').css('color','red');
			return;
		}
		//ajax发送数据
		$.ajax({
			url:'/crm/sendMail.do',
			type:'post',
			data:'receiver='+receiver+'&theme='+theme+'&content='+content+'&sender='+sender,
			success:function(data){
				console.log('添加成功');
				$('#crm-main').empty();
				$('#crm-main').append('<h2>'+data+'</h2>');
			},
			error:function(){
				console.log('添加出错');
			}
		});
	}
</script>
<strong class="am-text-primary am-text-lg">写邮件</strong>&nbsp;/&nbsp;<small>邮件相关</small>
<hr/>
<form class="am-form am-form-horizontal">
	<div class="am-form-group">
		<label for="person" class="am-u-sm-2 am-form-label">收件人：</label>
	    <div id="person" class="am-u-sm-10">
	    	<select>
		        <option value="1">老王</option>
		        <option value="2">张三</option>
		        <option value="3">李四</option>
      		</select>
	    </div>
	</div>
	<div class="am-form-group">
    	<label for="title" class="am-u-sm-2 am-form-label">邮件主题：</label>
    	<div class="am-u-sm-10">
      		<input type="text" id="title" placeholder="请输入邮件主题">
    	</div>
	</div>
	<div class="am-form-group">
    	<label for="context" class="am-u-sm-2 am-form-label">邮件内容：</label>
    	<div class="am-u-sm-10">
    		<textarea rows="10" id="context"></textarea>
    	</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
      		<button type="button" class="am-btn am-btn-primary" id="sendMail">发送</button>
      		<button type="button" class="am-btn am-btn-default">存草稿</button>
      		<button type="reset" class="am-btn am-btn-default">重写</button><br/>
			<span id="content_msg"></span>
		</div>
  	</div>
</form>