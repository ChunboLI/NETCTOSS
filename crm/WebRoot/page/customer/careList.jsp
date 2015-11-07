<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		careload();
		$('#find').click(f1);
		
	});
	function careload(){
	
		$.ajax({
			'url':'/crm/care/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				if("error" != data){
					$('#tb1').empty();
					for(var i=0;i<(data.length<10?data.length:10);i++){
						var c1 = data[i];
						$('#tb1').append(
							"<tr><td>"+c1.id+"</td><td>"
							+ c1.customName +"</td><td>"+c1.theme+"</td><td>"+c1.way+"</td><td>"+c1.time
							+"</td><td>"+c1.nextTime+"</td><td>"+c1.remarks+"</td><td>"+c1.empName
							+"</td><td><a href='javascript:;' onclick='editinfo("+c1.id+");'>编辑</a>"
							+" <a href='javascript:;' onclick='careDelete("+c1.id+");'>删除</a></td></tr>");
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
	
	function f1(){
		$.ajax({
			'url':'/crm/care/findOne.do',
			'type':'post',
			'data':{
				'id':$('#id').val()
			},
			'dataType':'json',
			'success':function(data){
				if("error" != data){
					$('#tb1').empty();
					
						var c1 = data;
						$('#tb1').append(
							"<tr><td>"+c1.id+"</td><td>"
							+ c1.customName +"</td><td>"+c1.theme+"</td><td>"+c1.way+"</td><td>"+c1.time
							+"</td><td>"+c1.nextTime+"</td><td>"+c1.remarks+"</td><td>"+c1.empName
							+"</td><td><a href='javascript:;' onclick='editinfo("+c1.id+");'>编辑</a>"
							+" <a href='javascript:;' onclick='careDelete("+c1.id+");'>删除</a></td></tr>");
					
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
				'url':'/crm/care/see.do',
				'type':'post',
				'data':{
					'id':id
					},
				'success':function(){
					$("#crm-main").load('/crm/page/customer/careEdit.jsp');
				},
				'error':function(){}
				
			}
		);
	}
	
	
	function careDelete(id){
	
	$.ajax(
			{
				'url':'/crm/care/delete.do',
				'type':'post',
				'data':{
					'id':id
					},
				'success':function(data){
					alert(data);
					$("#crm-main").load('/crm/page/customer/careList.jsp');
				},
				'error':function(){}
				
			}
		);
	}

</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<strong class="am-text-primary am-text-lg">客户关怀</strong>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入关键字"
		id="id">
	</div>
	<div class="am-form-group am-form-select am-u-sm-2">
	    <select  id="s1" class="am-input-sm" disabled="disabled">
	    	<option>编号</option>
	    	<c:forEach items="${cclist }" var="care" varStatus="s">
	    		<option value="${care.id }">${care.custom }</option>
	    	</c:forEach>   	
	    </select>
  	</div>
  	<a id="find" class="am-btn am-btn-warning am-btn-sm" href="javascript:;">
		<i class="am-icon-search"></i>
		搜索
	</a>
	<a class="am-btn am-btn-warning am-btn-sm" href="javascript:link('${pageContext.request.contextPath}/page/customer/careAdd.jsp');">
		<i class="am-icon-plus"></i>
		添加
	</a>
</form>
<br/>
<div class="am-scrollable-horizontal">
	<table class="am-table am-table-compact am-table-striped am-table-hover am-text-nowrap">
		<thead>
			<tr>
				<th>序号</th>
				<th>客户</th>
				<th>关怀主题</th>
				<th>关怀方式</th>
				<th>关怀时间</th>
				<th>下次关怀时间</th>
				<th>备注</th>
				<th>关怀人</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="tb1">
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