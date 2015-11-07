<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">员工信息</strong>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>

<script type="text/javascript">
	$(function(){
		allEmp();
	});
	//查询所有的员工信息
	function allEmp(){
		$.ajax({
			'url':'/crm/emp/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				$('#tb').empty();
				for(i=0;i<data.length;i++){
					var s = data[i];
					if(s.gender==1){
						gender = "男";
					}else{
						gender = "女";
					}
					$('#tb').append(
						'<tr><td>'+(i+1)+
						'</td><td>'+s.name+
						'</td><td>'+gender+
						'</td><td>'+s.age+
						'</td><td>'+s.nation+
						'</td><td>'+s.department+
						'</td><td>'+s.role+
						'</td><td>'+s.education+
						'</td><td>'+s.marriage+
						'</td><td>'+s.address+
						'</td><td>'+s.mobilePhone+
						'</td><td>'+s.phone+
						'</td><td>'+s.email+
						'</td><td>'+
						"<a href=\"javascript:link('${pageContext.request.contextPath}/page/basis/employeeEdit.jsp?id="+s.id+"');\">编辑</a>"+
						"<a href=\"javascript:link('${pageContext.request.contextPath}/page/basis/employeeInfo.jsp?id="+s.id+"');\">详情</a>"+
						"<a href=\"#\" onclick='deleteById("+s.id+");'>删除</a>"+
						'</td></tr>'
					);
				}
			},
			'error':function(){
				alert('出错了！');
			}
		});
	}
	//查询项选择
	function selectBy(){
		if($("select option:selected").val()=="option1"){
			findByName();
		}
	}
	//根据员工姓名查询
	function findByName(){
				$.ajax({
					'url':'/crm/emp/findByName.do',
					'type':'post',
					'dataType':'json',
					'data':{'emp.name':$("#name").val()},
					'success':function(data){
					$('#tb').empty();
					for(i = 0; i < data.length; i ++){
						var s = data[i];
						if(s.gender==1){
							gender = "男";
						}else{
							gender = "女";
						}
						$('#tb').append(
							'<tr><td>'+(i+1)+
							'</td><td>'+s.name+
							'</td><td>'+gender+
							'</td><td>'+s.age+
							'</td><td>'+s.nation+
							'</td><td>'+s.department+
							'</td><td>'+s.role+
							'</td><td>'+s.education+
							'</td><td>'+s.marriage+
							'</td><td>'+s.address+
							'</td><td>'+s.mobilePhone+
							'</td><td>'+s.phone+
							'</td><td>'+s.email+
							'</td><td>'+
							"<a href=\"javascript:link('${pageContext.request.contextPath}/page/basis/employeeEdit.jsp?id="+s.id+"');\">编辑</a>"+
							"<a href=\"javascript:link('${pageContext.request.contextPath}/page/basis/employeeInfo.jsp?id="+s.id+"');\">详情</a>"+
							"<a href=\"#\" onclick='deleteById("+s.id+");'>删除</a>"+
							'</td></tr>'
						);
						}
					},
					'error':function(){
						alert('出错了！');
					}
				});
			}
			
	
	//删除员工信息
	function deleteById(id){
		$.ajax({
			'url':'/crm/emp/delete.do',
			'type':'post',
			'data':{'id':id},
			'dataType':'json',
			'success':function(data){
				if(data==true){
					back();
				}
			},
			'error':function(){
				alert("删除失败！");
			}
		});
	}
	//返回&刷新
	function back(){
		$("#crm-main").load('/crm/page/basis/employeeList.jsp');
	}
</script>

<form class="am-form am-form-inline" role="form" action="${pageContext.request.contextPath}/emp/findByName.do" method="post">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入关键字" id="name" name="emp.name">
	</div>
	<div class="am-form-group am-form-select am-u-sm-2">
	    <select class="am-input-sm" id="s1">
	    	<option value="option1">员工姓名</option>
	    	<option value="option2">年龄</option>
	    </select>
  	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#" onclick="selectBy();">
		<i class="am-icon-search"></i>
		搜索
	</a>
</form>
<br/>
<div class="am-scrollable-horizontal">
	<table class="am-table am-table-compact am-table-striped am-table-hover am-text-nowrap">
		<thead>
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>名族</th>
				<th>部门</th>
				<th>角色</th>
				<th>学历</th>
				<th>婚姻</th>
				<th>家庭住址</th>
				<th>手机</th>
				<th>电话</th>
				<th>邮箱</th>
				<th>操作</th>
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