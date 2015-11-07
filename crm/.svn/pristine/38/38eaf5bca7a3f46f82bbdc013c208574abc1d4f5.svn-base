<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">部门信息</strong>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>

<script type="text/javascript">
	$(function(){
		allDepartment();
	});
	//查找所有的部门信息
	function allDepartment(){
				$.ajax({
					'url':'/crm/department/findAll.do',
					'type':'post',
					'dataType':'json',
					'success':function(data){
					$('#tb').empty();
					for(i = 0; i < data.length; i ++){
						var s = data[i];
						$('#tb').append(
						'<tr><td>' + (i+1) 
						+ '</td><td>' + s.name 
						+ '</td><td>' + s.description
						 + '</td></tr>');
						}
					},
					'error':function(){
						alert('出错了！');
					}
				});
			}
	//根据部门名称查找
	function findByName(){
				$.ajax({
					'url':'/crm/department/findByName.do',
					'type':'post',
					'dataType':'json',
					'data':{'department.name':$("#name").val()},
					'success':function(data){
					$('#tb').empty();
					for(i = 0; i < data.length; i ++){
						var s = data[i];
						$('#tb').append(
						'<tr><td>' + (i+1) 
						+ '</td><td>' + s.name 
						+ '</td><td>' + s.description
						 + '</td></tr>');
						}
					},
					'error':function(){
						alert('出错了！');
					}
				});
			}
	
</script>

<form class="am-form am-form-inline" role="form" action="${pageContext.request.contextPath}/department/findByName.do" method="post">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入部门名称" id="name" name="department.name">
	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#" onclick="findByName();">
		<i class="am-icon-search"></i>
		搜索
	</a>
</form>
<br/>
<div class="am-scrollable-horizontal" >
	<table class="am-table am-table-compact am-table-striped am-table-hover am-text-nowrap">
		<thead>
			<tr>
				<th>序号</th>
				<th>部门名称</th>
				<th>部门描述</th>
			</tr>
		</thead>
		<tbody id="tb">
			
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