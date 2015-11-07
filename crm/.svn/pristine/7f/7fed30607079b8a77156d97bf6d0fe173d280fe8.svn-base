<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">公告</strong>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>
<script type="text/javascript">
	$(function(){
		allNotice();
	});
	//查询所有的房屋类型信息
	function allNotice(){
		$.ajax({
			'url':'/crm/notice/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				$('#tb').empty();
				for(i=0;i<data.length;i++){
					var s = data[i];
					$('#tb').append(
						'<tr><td>'+(i+1)+
						'</td><td>'+s.emp+
						'</td><td>'+s.theme+
						'</td><td>'+s.content+
						'</td><td>'+s.time+
						'</td><td>'+s.endTime+
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
			findByTheme();
		}
	}
	//根据主题查询
	function findByTheme(){
		$.ajax({
			'url':'/crm/notice/findByTheme.do',
			'type':'post',
			'dataType':'json',
			'data':{'notice.theme':$("#theme").val()},
			'success':function(data){
			$('#tb').empty();
			for(i = 0; i < data.length; i ++){
				var s = data[i];
				$('#tb').append(
					'<tr><td>'+(i+1)+
						'</td><td>'+s.emp+
						'</td><td>'+s.theme+
						'</td><td>'+s.content+
						'</td><td>'+s.time+
						'</td><td>'+s.endTime+
						'</td></tr>'
				);
				}
			},
			'error':function(){
				alert('没有这个主题');
			}
		});
	}
</script>
<form class="am-form am-form-inline" role="form">
	<div class="am-form-group am-u-sm-4">
		<input type="text" class="am-form-field am-input-sm" placeholder="请输入关键字" id="theme" name="notice.theme">
	</div>
	<div class="am-form-group am-form-select am-u-sm-2">
	    <select class="am-input-sm">
	    	<option value="option1">公告主题</option>
	    </select>
  	</div>
  	<a class="am-btn am-btn-warning am-btn-sm" href="#" onclick="selectBy();">
		<i class="am-icon-search"></i>
		搜索
	</a>
	<a class="am-btn am-btn-warning am-btn-sm" href="javascript:link('${pageContext.request.contextPath}/page/basis/noticeAdd.jsp');">
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
				<th>公告人</th>
				<th>公告主题</th>
				<th>公告内容</th>
				<th>公告时间</th>
				<th>公告截至时间</th>
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