<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<jsp:include page="common/head.jsp"></jsp:include>
		<style type="text/css">
			.header {
				text-align: center;
			}
			.header h1 {
				font-size: 200%;
				color: #333;
				margin-top: 30px;
			}
		</style>

	   
	</head>
	<body>
		<div class="header">
			<div class="am-g">
				<h1>房地产客户关系管理系统</h1>
			</div>
			<hr/>
		</div>
		<div class="am-g">
			<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
				<h3>系统登录</h3>
				<hr>
				<form method="post" class="am-form" action="javascript:;">
					<label for="username">用户名：</label>
					<%! 
						Cookie[] cc = null;
					 %>
					 <% cc = request.getCookies(); %>
					<input type="text" name="username" id="username" value=<%=cc.length==1?"":request.getCookies()[0].getValue() %>>
					
					<span id="msg_user"></span>
					<br>
					<label for="password" >密码：</label>
					<input type="password" name="password" id="password" value=<%=cc.length==1?"":request.getCookies()[1].getValue() %>>
					<br>
					<label for="remember-me">
						<input id="remember" type="checkbox">&nbsp;记住密码
					</label>
					<br />
					<div class="am-cf">
						<input type="button" value="登录系统" class="am-btn am-btn-primary am-btn-sm am-fl" id="login">
						<input type="submit" value="忘记密码 ^_^?" class="am-btn am-btn-default am-btn-sm am-fr">
					</div>
				</form>
				<hr>
				<p>©&nbsp;2015&nbsp;达内软件技术(杭州)有限公司-英才添翼-华东大学生基地&nbsp;翻版必究</p>
			</div>
		</div>
		<jsp:include page="common/js.jsp"></jsp:include>
		 <script type="text/javascript">
	       $(function(){
	          $('#login').click(function(){
	             var username=$('#username').val();
	             var password=$('#password').val();
	             var remember;
	             if($(':checked').length==1){
	             	remember='checked';
	             }
	             if(username==""||password==""){
	                $('#msg_user').html('用户名或密码不能为空');
	                return;
	             }
	     		$.ajax(
	       	    {
	        	'url':'/crm/user/login.do',
	        	'type':'post',
	        	'data':{'username':$('#username').val(),'password':$('#password').val(),'remember':remember},
	        	'dataType':'text',
	        	'success':function(data){
	        		if("fail"==data){
					  $('#msg_user').html('用户名或密码不正确');
					}else{
	        			window.location.href='http://localhost:8080/crm/main.do';
	        		}
	        	}
	          });
	          });
	        });
	     </script>
	</body>
</html>