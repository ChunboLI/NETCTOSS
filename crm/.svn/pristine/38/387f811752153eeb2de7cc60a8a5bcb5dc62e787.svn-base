<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">房屋类型</strong>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>
<script type="text/javascript">
	$(function(){
		allHouse();
	});
	//查询所有的房屋类型信息
	function allHouse(){
		$.ajax({
			'url':'/crm/housetype/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				$('#tb').empty();
				for(i=0;i<data.length;i++){
					var s = data[i];
					$('#tb').append(
						'<tr><td>'+(i+1)+
						'</td><td>'+s.type+
						'</td><td>'+
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
	//根据类型查询房屋类型
	function findByType(){
		$.ajax({
			'url':'/crm/housetype/findByType.do',
			'type':'post',
			'dataType':'json',
			'data':{'housetype.type':$("#type").val()},
			'success':function(data){
				$('#tb').empty();
				$('#tb').append(
					'<tr><td>'+1+
					'</td><td>'+data.type+
					'</td><td>'+
					"<a href=\"#\" onclick='deleteById("+data.id+");'>删除</a>"+
					'</td></tr>'
				);
			},
			'error':function(){
				alert('没有这个户型');
			}
		});
	}
</script>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入房屋类型" id="type" name="housetype.type">
	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#" onclick="findByType();">
		<i class="am-icon-search"></i>
		搜索
	</a>
	<a class="am-btn am-btn-warning am-btn-sm" href="javascript:link('${pageContext.request.contextPath}/page/basis/houseTypeAdd.jsp');">
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
				<th>房屋类型名称</th>
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