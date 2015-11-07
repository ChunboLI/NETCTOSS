<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">公告添加</strong>&nbsp;/&nbsp;<small>公告</small>&nbsp;/&nbsp;<small>基础相关</small>
<hr/>
<div id="id">2</div>
<script type="text/javascript">
	//添加公告
	function addNotice(){
		$.ajax({
			'url':'/crm/notice/addNotice.do',
			'type':'post',
			'dataType':'json',
			'data':{
				'notice.theme':$("#theme").val(),
				'notice.emp':$("#id").text(),
				'notice.endTime':$("#endTime").val(),
				'notice.content':$("#content").val(),
			},
			'success':function(data){
				if(data!=null){
					alert("添加成功");
					back();
				}
			},
			'error':function(){
				alert("出错了！");
			}
		});
	}
	//返回&刷新
	function back(){
		$("#crm-main").load('/crm/page/basis/noticeList.jsp');
	}
</script>
<form class="am-form am-form-horizontal">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			公告主题：
		</label>
		<div class="am-u-sm-10">
			<input type="text" placeholder="输入公告标题" id="theme" name="notice.theme">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			截止日期：
		</label>
		<div class="am-u-sm-10">
			<input type="text" placeholder="例：2015-10-10" id="endTime" name="notice.endTime">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			公告内容：
		</label>
		<div class="am-u-sm-10">
			<textarea rows="8" id="content" name="notice.content"></textarea>
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
			<button type="button" class="am-btn am-btn-primary" onclick="addNotice();">
				发布
			</button>
			<button type="reset" class="am-btn am-btn-default">
				重置
			</button>
			<button type="button" class="am-btn am-btn-default" onclick="back();">
				返回
			</button>
		</div>
	</div>
</form>