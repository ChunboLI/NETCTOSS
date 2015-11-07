<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<strong class="am-text-primary am-text-lg">客户类型</strong>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入客户类型关键字">
	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#">
		<i class="am-icon-search"></i>
		搜索
	</a>
	<a class="am-btn am-btn-warning am-btn-sm" href="javascript:link('${pageContext.request.contextPath}/page/customer/typeAdd.jsp');">
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
				<th>客户类型</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="typeLoad">
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
<script>
	$(function(){
		typeLoad();
	});
	function typeDelete(t){
		$.ajax({
			'url':'/crm/customType/delete.do',
			'type':'post',
			'data':{'id':$(t).parent().parent().find("td:eq(0)").html()},
			'dataType':'text',
			'success':function(data){
				alert(data);
				if(data == "ok"){
					typeLoad();
				}
			},
			'error':function(){
			}
		});
	}
	function typeLoad(){
		$.ajax({
			'url':'/crm/customType/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				if("fail" != data){
					$('#typeLoad').empty();
					for(i=0;i<(data.length<10?data.length:10);i++){
						var t = data[i];
						$('#typeLoad').append(
							"<tr><td>"+t.id+"</td><td>"
							+ t.type +"</td><td><a href='javascript:;' onclick='typeDelete(this);'>删除</a></td></tr>");
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