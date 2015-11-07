<%@ page language="java" pageEncoding="UTF-8"%>
<strong class="am-text-primary am-text-lg">联系记录添加</strong>&nbsp;/&nbsp;<small>联系记录</small>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-horizontal" id="record" action="javascript:;">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			客户名称：
		</label>
		<div class="am-u-sm-10" >
			<select id="custom" name="record.custom">
				<option>华纳</option>
				<option>华纳</option>
				<option>华纳</option>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			联系类型：
		</label>
		<div class="am-u-sm-10">
			<input type="text" name="record.type">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label" >
			下次联系时间：
		</label>
		<div class="am-u-sm-10">
			<input readonly="readonly" type="text" class="Wdate" name="record.nextTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			是谁联系的：
		</label>
		<div class="am-u-sm-10">
			<select id="emp" name="record.emp">
				<option>华纳</option>
				<option>华纳</option>
				<option>华纳</option>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			联系主题：
		</label>
		<div class="am-u-sm-10">
			<input type="text" name="record.theme">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">
			联系备注：
		</label>
		<div class="am-u-sm-10">
			<textarea rows="8" name="record.remarks"></textarea>
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-10 am-u-sm-offset-2">
			<button type="submit" class="am-btn am-btn-primary" onclick="recordAdd();">
				添加
			</button>
			<button type="reset" class="am-btn am-btn-default">
				重置
			</button>
			<button type="submit" class="am-btn am-btn-default">
				返回
			</button>
		</div>
	</div>
</form>

<script>
	$(function(){
		customLoad();
		empLoad();
	});
	
	function customLoad(){
		$.ajax({
			'url':'/crm//custom/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				if(!data) return;
				$('#custom').empty();
				for(i=0;i<data.length;i++){
					var s = data[i];
					$('#custom').append(
						"<option value="+s.id+">"+s.name+"</option>"
					);
				}	
			},
			'error':function(){
				alert("系统出错!");
			}
		});
	}
	
	function empLoad(){
		$.ajax({
			'url':'/crm/emp/findAll.do',
			'type':'post',
			'dataType':'json',
			'success':function(data){
				if(!data) return;
				$('#emp').empty();
				for(i=0;i<data.length;i++){
					var s = data[i];
					$('#emp').append(
						"<option value="+s.id+">"+s.name+"</option>"
					);
				}	
			},
			'error':function(){
				alert("系统出错!");
			}
		});
	}
	
	function recordAdd(){
		$.ajax({
			'url':'/crm/relRecord/add.do',
			'type':'post',
			'data':$('#record').serialize(),
			'dataType':'text',
			'success':function(data){
				alert(data);
				if("ok" == data){
					link('/crm/page/customer/sourceList.jsp');
				}	
			},
			'error':function(){
				alert("系统出错!");
			}
		});
	}
	
</script>