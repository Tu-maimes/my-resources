<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新角色 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>更新角色</h3>
		<form action="<c:url value="/role/updateRole.action"/>" method="post" enctype="multipart/form-data">
			<table class="form-table">
				<tr>
					<td>角色名称</td>
					<td colspan="3" class="control">
						<input type="text" name="re.rName" value="${ role.rName }" placeholder="填写角色名称">
					</td>
					<td>爱好</td>
					<td colspan="3" class="control">
						篮球<input type="checkbox" name="st" value="lq" >
						足球<input type="checkbox" name="st" value="zq" >
						皮球<input type="checkbox" name="st" value="pq" >
					</td>
				</tr>
				<tr>
					<td>角色描述</td>
					<td colspan="3" class="control">
						<textarea class="p100" name="re.Desc" placeholder="请填写角色描述">${ role.rDesc }</textarea>
					</td>
					<td>
					<input type="file" placeholder="请选择上传文件" name = "pic">
					</td>
				</tr>
			</table>
			<div class="buttons">
				<input type="hidden" name="re.rId" value="${ role.rId }">
				<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>