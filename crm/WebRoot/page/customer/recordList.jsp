<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">联系记录</strong>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入关键字">
	</div>
	<div class="am-form-group am-form-select am-u-sm-2">
	    <select class="am-input-sm">
	    	<option value="option1">联系客户</option>
	    </select>
  	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#">
		<i class="am-icon-search"></i>
		搜索
	</a>
	<a class="am-btn am-btn-warning am-btn-sm" href="javascript:link('${pageContext.request.contextPath}/page/customer/recordAdd.jsp');">
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
				<th>客户姓名</th>
				<th>联系时间</th>
				<th>下次联系时间</th>
				<th>联系类型</th>
				<th>是谁联系的</th>
				<th>联系主题</th>
				<th>联系备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="recordLoad">
			<tr>
				<td>1</td>
				<td>阿三</td>
				<td>2013-09-09 23:33</td>
				<td>2013-09-10</td>
				<td>打电话</td>
				<td>小狗子</td>
				<td>过来买房</td>
				<td>不错</td>
				<td>
					<a href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>2</td>
				<td>阿三</td>
				<td>2013-09-09 23:33</td>
				<td>2013-09-10</td>
				<td>打电话</td>
				<td>小狗子</td>
				<td>过来买房</td>
				<td>不错</td>
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
		recordLoad();
	});
	function recordDelete(t){
		$.ajax({
			'url':'/crm/relRecord/delete.do',
			'type':'post',
			'data':{'id':$(t).parent().parent().find("td:eq(0)").html()},
			'dataType':'text',
			'success':function(data){
				alert(data);
				if("ok" == data){
					recordLoad();
				}
			},
			'error':function(){
			}
		});
	}
	function recordLoad(){
		$.ajax({
			'url':'/crm/relRecord/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				if("fail" != data){
					$('#recordLoad').empty();
					for(i=0;i<(data.length<10?data.length:10);i++){
						var t = data[i];
						$('#recordLoad').append(
							"<tr><td>"+t.id+"</td><td>" + t.custom + "</td><td>"
							+ t.time +"</td><td>"+ t.nextTime +"</td><td>"+ t.type +"</td><td>"
							+ t.emp +"</td><td>"+ t.theme +"</td><td>" + t.remarks 
							+"</td><td><a href='javascript:;' onclick='recordDelete(this);'>删除</a></td></tr>");
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