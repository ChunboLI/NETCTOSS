<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		allCustom();
		$('#find').click(f1);
	});
	function f1(){
	
		$.ajax({
			'url':'/crm/custom/findOne.do',
			'type':'post',
			'data':{
				'name':$('#name').val()
			},
			'dataType':'json',
			'success':function(data){
				if("error" != data){
					$('#custom').empty();
					for(var i=0;i<(data.length<10?data.length:10);i++){
						var c1 = data[i];
						$('#custom').append(
							"<tr><td>"+c1.customName+"</td><td>"
							+ c1.status +"</td><td>"+c1.source+"</td><td>"+c1.empName+"</td><td>"+c1.type
							+"</td><td>"+c1.gender+"</td><td>"+c1.mobliePhone+"</td><td>"+c1.qq
							+"</td><td>"+c1.email+"</td><td>"+c1.job+"</td><td>"+c1.company+"</td><td>"+c1.remarks
							+"</td><td><a href='javascript:;' onclick='editinfo("+c1.id+");'>编辑</a>"
							+" <a href='javascript:;' onclick='seeinfo("+c1.id+");'>详情</a>"
							+" <a href='javascript:;' onclick='customDelete("+c1.id+");'>删除</a></td></tr>");
					}
				}else{
					alert("类型加载失败");
				}
			},
			'error':function(){
				alert("类型加载失败");
			}
		});
	
	}
	function editinfo(id){
		
		$.ajax(
			{
				'url':'/crm/custom/see.do',
				'type':'post',
				'data':{
					'id':id
					},
				'success':function(){
					$("#crm-main").load('/crm/page/customer/customerEdit.jsp');
				},
				'error':function(){}
				
			}
		);
		
	}
	function customDelete(id){
		
		$.ajax(
			{
				'url':'/crm/custom/delete.do',
				'type':'post',
				'data':{
					'id':id
					},
				'success':function(data){
					alert(data);
					$("#crm-main").load('/crm/page/customer/customerList.jsp');
				},
				'error':function(){}
				
			}
		);
	}
	function seeinfo(id){
	 
		$.ajax(
			{
				'url':'/crm/custom/see.do',
				'type':'post',
				'data':{
					'id':id
					},
				'success':function(){
					$("#crm-main").load('/crm/page/customer/customerInfo.jsp');
				},
				'error':function(){}
				
			}
		);
	}
	function allCustom(){
		
		$.ajax({
			'url':'/crm/custom/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				if("error" != data){
					$('#custom').empty();
					for(var i=0;i<(data.length<10?data.length:10);i++){
						var c1 = data[i];
						$('#custom').append(
							"<tr><td>"+c1.customName+"</td><td>"
							+ c1.status +"</td><td>"+c1.source+"</td><td>"+c1.empName+"</td><td>"+c1.type
							+"</td><td>"+c1.gender+"</td><td>"+c1.mobliePhone+"</td><td>"+c1.qq
							+"</td><td>"+c1.email+"</td><td>"+c1.job+"</td><td>"+c1.company+"</td><td>"+c1.remarks
							+"</td><td><a href='javascript:;' onclick='editinfo("+c1.id+");'>编辑</a>"
							+" <a href='javascript:;' onclick='seeinfo("+c1.id+");'>详情</a>"
							+" <a href='javascript:;' onclick='customDelete("+c1.id+");'>删除</a></td></tr>");
					}
				}else{
					alert("类型加载失败");
				}
			},
			'error':function(){
				alert("类型加载失败");
			}
		});
	}
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<strong class="am-text-primary am-text-lg">客户信息</strong>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入关键字"
		id="name">
	</div>
	<div class="am-form-group am-form-select am-u-sm-2">
	    <select  class="am-input-sm" disabled="disabled">
	    	<option>客户姓名</option>
	    	<c:forEach items="${clist }" var="cus" varStatus="s">
	    	<option value="${cus.id }">${cus.name}</option>
	    	</c:forEach>
	    
	    	
	    </select>
  	</div>
  	<a id="find" class="am-btn am-btn-warning am-btn-sm" href="javascript:;">
		<i class="am-icon-search"></i>
		搜索
	</a>
	<a class="am-btn am-btn-warning am-btn-sm" href="javascript:link('${pageContext.request.contextPath}/page/customer/customerAdd.jsp');">
		<i class="am-icon-plus"></i>
		添加
	</a>
</form>
<br/>
<div class="am-scrollable-horizontal">
	<table class="am-table am-table-compact am-table-striped am-table-hover am-text-nowrap">
		<thead>
			<tr>
				<th>姓名</th>
				<th>状态</th>
				<th>来源</th>
				<th>所属员工</th>
				<th>类型</th>
				<th>性别</th>
				<th>手机</th>
				<th>QQ</th>
				<th>邮箱</th>
				<th>职位</th>
				<th>公司</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id ="custom">   					
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