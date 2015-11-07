<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	
	$(function(){
			allot();
			allot2();
			
			$('#a1').click(function(){
				var id = $('#t1 :checked').attr('id');
				var name = $(':selected').val();
				$.get('/crm/allot2.do?id='+id+'&name='+name,function(data){
					allot();
				},'json');
			});
			
		});
	function allot(){
			$.get('/crm/allot1.do',function(data){
			$('#tb1').empty();
			for( i =0;i<data.length;i++){
				var s = data[i];
				$('#tb1').append('<tr><th><input type="checkbox" class="c" id="'+s.id+'" value="'+s.id+'"></th><td>'+s.name+'</td><td>'+s.status+'</td><td>'+s.source+'</td><td>'+s.type+'</td><td>'+s.createDate+'</td><td>'+s.company+'</td><td>'+s.remarks+'</td><span style="display:none" id="sid">'+s.id+'</span></tr>');
				}
			},'json');
	
		
		}
	function allot2(){
			$.get('/crm/getReceiver.do',function(data){
			for( i =0;i<data.length;i++){
				var s = data[i];
				var op = new Option(s.name,s.id);
				$('#s1').append(op);
				}
			},'json');
	
		
		}
			
		
		
		
</script>
<strong class="am-text-primary am-text-lg">客户分配</strong>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-form-select am-u-sm-2">
	    <select class="am-input-sm" id="s1">
	    </select>
  	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#" id="a1">
		分配
	</a>
</form>
<br/>
<div class="am-scrollable-horizontal">
	<table class="am-table am-table-compact am-table-striped am-table-hover am-text-nowrap" id="t1">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>姓名</th>
				<th>状态</th>
				<th>来源</th>
				<th>类型</th>
				<th>创建时间</th>
				<th>公司</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody id="tb1">
		</tbody>
		
		
		<!--  
		<tbody>
			<tr>
				<td><input type="checkbox"></td>
				<td>李四</td>
				<td>潜在客户</td>
				<td>自己上门</td>
				<td>客户</td>
				<td>2015-08-23 18:23</td>
				<td>思科</td>
				<td>小鲜肉</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<td>李四</td>
				<td>潜在客户</td>
				<td>自己上门</td>
				<td>客户</td>
				<td>2015-08-23 18:23</td>
				<td>思科</td>
				<td>小鲜肉</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<td>李四</td>
				<td>潜在客户</td>
				<td>自己上门</td>
				<td>客户</td>
				<td>2015-08-23 18:23</td>
				<td>思科</td>
				<td>小鲜肉</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<td>李四</td>
				<td>潜在客户</td>
				<td>自己上门</td>
				<td>客户</td>
				<td>2015-08-23 18:23</td>
				<td>思科</td>
				<td>小鲜肉</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<td>李四</td>
				<td>潜在客户</td>
				<td>自己上门</td>
				<td>客户</td>
				<td>2015-08-23 18:23</td>
				<td>思科</td>
				<td>小鲜肉</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<td>李四</td>
				<td>潜在客户</td>
				<td>自己上门</td>
				<td>客户</td>
				<td>2015-08-23 18:23</td>
				<td>思科</td>
				<td>小鲜肉</td>
			</tr>
			<tr>
				<td><input type="checkbox"></td>
				<td>李四</td>
				<td>潜在客户</td>
				<td>自己上门</td>
				<td>客户</td>
				<td>2015-08-23 18:23</td>
				<td>思科</td>
				<td>小鲜肉</td>
			</tr>
		</tbody>
		-->
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