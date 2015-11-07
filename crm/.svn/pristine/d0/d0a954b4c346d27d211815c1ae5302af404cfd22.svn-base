<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">客户来源</strong>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入客户来源关键字">
	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#">
		<i class="am-icon-search"></i>
		搜索
	</a>
	<a class="am-btn am-btn-warning am-btn-sm" href="javascript:link('${pageContext.request.contextPath}/page/customer/sourceAdd.jsp');">
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
				<th>客户来源</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="sourceLoad">
			<tr>
				<td>1</td>
				<td>自己上门</td>
				<td>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>2</td>
				<td>朋友推荐</td>
				<td>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>3</td>
				<td>百度网</td>
				<td>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>4</td>
				<td>搜房网</td>
				<td>
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
<script>
	$(function(){
		sourceLoad();
	});
	function sourceDelete(t){
		$.ajax({
			'url':'/crm/customSource/delete.do',
			'type':'post',
			'data':{'id':$(t).parent().parent().find("td:eq(0)").html()},
			'dataType':'text',
			'success':function(data){
				alert(data);
				if("ok" == data){
					sourceLoad();
				}
			},
			'error':function(){
			}
		});
	}
	function sourceLoad(){
		$.ajax({
			'url':'/crm/customSource/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				if("fail" != data){
					$('#sourceLoad').empty();
					for(i=0;i<(data.length<10?data.length:10);i++){
						var t = data[i];
						$('#sourceLoad').append(
							"<tr><td>"+t.id+"</td><td>" + t.source + 
							"</td><td><a href='javascript:;' onclick='sourceDelete(this);'>删除</a></td></tr>");
					}
				}else{
					alert("状态加载失败");
				}
			},
			'error':function(){
				alert("状态加载失败");
			}
		});
	}
</script>