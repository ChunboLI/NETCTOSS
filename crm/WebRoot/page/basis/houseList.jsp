<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">房屋信息</strong>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>
<script type="text/javascript">
	$(function(){
		allHouse();
	});
	//查询所有的房屋信息
	function allHouse(){
		$.ajax({
			'url':'/crm/house/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				$('#tb').empty();
				for(i=0;i<data.length;i++){
					var s = data[i];
					$('#tb').append(
						'<tr><td>'+(i+1)+
						'</td><td>'+s.type+
						'</td><td>'+s.emp+
						'</td><td>'+s.address+
						'</td><td>'+s.price+
						'</td><td>'+s.environment+
						'</td><td>'+
						"<a href=\"javascript:link('${pageContext.request.contextPath}/page/basis/houseEdit.jsp?id="+s.id+"');\">编辑</a>"+
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
			findByType();
		}
	}
	//根据房屋类型查询
	function findByType(){
		$.ajax({
			'url':'/crm/house/findByType.do',
			'type':'post',
			'dataType':'json',
			'data':{'housetype.type':$("#type").val()},
			'success':function(data){
			$('#tb').empty();
			for(i = 0; i < data.length; i ++){
				var s = data[i];
				$('#tb').append(
					'<tr><td>'+(i+1)+
						'</td><td>'+s.type+
						'</td><td>'+s.emp+
						'</td><td>'+s.address+
						'</td><td>'+s.price+
						'</td><td>'+s.environment+
						'</td><td>'+
						"<a href=\"javascript:link('${pageContext.request.contextPath}/page/basis/houseEdit.jsp?id="+s.id+"');\">编辑</a>"+
						"<a href=\"#\" onclick='deleteById("+s.id+");'>删除</a>"+
						'</td></tr>'
				);
				}
			},
			'error':function(){
				alert('没有这个户型');
			}
		});
	}
	//删除房屋信息
	function deleteById(id){
		$.ajax({
			'url':'/crm/house/delete.do',
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
		$("#crm-main").load('/crm/page/basis/houseList.jsp');
	}
</script>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入关键字" name="housetype.type" id="type">
	</div>
	<div class="am-form-group am-form-select am-u-sm-2">
	    <select class="am-input-sm">
	    	<option value="option1">房屋类型</option>
	    </select>
  	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#" onclick="selectBy();">
		<i class="am-icon-search"></i>
		搜索
	</a>
	<a class="am-btn am-btn-warning am-btn-sm" href="javascript:link('${pageContext.request.contextPath}/page/basis/houseAdd.jsp');">
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
				<th>户型</th>
				<th>管理员工</th>
				<th>房屋地址</th>
				<th>房屋价格（平米）</th>
				<th>房屋环境</th>
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