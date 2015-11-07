<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/resource/js/add.js"></script>

<strong class="am-text-primary am-text-lg">客户信息添加</strong>&nbsp;/&nbsp;<small>客户信息</small>&nbsp;/&nbsp;<small>客户相关</small>
<hr/>
<form class="am-form am-form-horizontal">
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户姓名：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" name="customname" id="name">
		</div>
		<label class="am-u-sm-2 am-form-label">客户来源：</label>
		<div class="am-u-sm-4">
			<select id="s1">
				<c:forEach items="${csdlist }"var="customersource"
						varStatus="s">
				<option value="${customersource.id }">${customersource.source }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户职位：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" name="job" id="job">
		</div>
		<label class="am-u-sm-2 am-form-label">客户类型：</label>
		<div class="am-u-sm-4">
			<select id="s2">
				<c:forEach items="${ctlist }"var="customertype"
						varStatus="s">
				<option value="${customertype.id }">${customertype.type }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">性别：</label>
		<div class="am-u-sm-4">
			<label class="am-radio-inline">
				<input type="radio" id="sex" name="sex" value="0">&nbsp;男
			</label>
			<label class="am-radio-inline">
				<input type="radio" id="sex" name="sex" value="1">&nbsp;女
			</label>
		</div>
		<label class="am-u-sm-2 am-form-label">Email：</label>
		<div class="am-u-sm-4">
			<input type="text" name="email" id="email">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">出生日期：</label>
		<div class="am-u-sm-4">
			<input type="text" name="birthday" id="birthday">
		</div>
		<label class="am-u-sm-2 am-form-label">客户手机：</label>
		<div class="am-u-sm-4">
			<input type="text" name="mobliephone" id="mobliephone">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户QQ：</label>
		<div class="am-u-sm-4">
			<input type="text" name="qq" id="qq">
		</div>
		<label class="am-u-sm-2 am-form-label">客户地址：</label>
		<div class="am-u-sm-4">
			<input type="text" name="address" id="address">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户微博：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" name="weibo" id="weibo">
		</div>
		<label class="am-u-sm-2 am-form-label">客户座机：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" name="phone" id="phone">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户MSN：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" name="msn" id="msn">
		</div>
		<label class="am-u-sm-2 am-form-label">客户公司：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" name="company" id="company">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">创建人：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" name="creator" id="creator">
		</div>
		<label class="am-u-sm-2 am-form-label">修改人：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" name="modifier" id="modifier">
		</div>
	</div>
	<div class="am-form-group">
		<label class="am-u-sm-2 am-form-label">客户状态：</label>
		<div class="am-u-sm-4">
			<select id="s3">
				<c:forEach items="${csslist }" var="customerstatus"
						varStatus="s">
				<option value="${customerstatus.id }">${customerstatus.status }</option>
				</c:forEach>
			</select>
		</div>
		<label class="am-u-sm-2 am-form-label">备注：</label>
		<div class="am-u-sm-4">
			<input class="am-form-field am-input-sm" type="text" name="remarks" id="remarks">
		</div>
	</div>
	<div class="am-form-group">
		<div class="am-u-sm-offset-2 am-u-sm-4">
			<button id="sb" type="button" class="am-btn am-btn-primary">添加</button>
			<button type="reset" class="am-btn am-btn-default">重置</button>
			<button id="ret" type="button" class="am-btn am-btn-default">返回</button>
		</div>
	</div>
</form>