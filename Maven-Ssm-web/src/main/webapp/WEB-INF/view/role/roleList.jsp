<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色管理 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>角色管理</h3>
		<div class="actions">
			
			<div>
				<a class="btn btn-primary" href="<c:url value="/addRole" />">添加角色</a>
			</div>
		</div>
		<form action="<c:url value="/role/reo.action" />">
		<table class="list">
            <tr>
            ${data}
                <th>序号</th>
                <th>角色名称</th>
                <th>角色描述</th>
                <th>更新时间</th>
                <th>头像</th>
                
                <th>操作</th>
            </tr>
            <c:forEach var="role" items="${ list }" varStatus="status" >
            <tr>
                <td>${ status.count }</td>
                
                
                <td>
                <input type = "text" name = "itemList[${status.index}].rName" value = "${ role.rName }"></td>
                <td>
                <input type = "text" name = "itemList[${status.index}].rDesc" value = "${ role.rDesc }"></td>
                <td>
                <input type = "datetime-local" name="itemList[${status.index}].rUpdatetime"
                	value ='<fmt:formatDate value="${role.rUpdatetime}" 
                	type="both" pattern="yyyy-MM-dd'T'HH:mm"/>'
                	placeholder = "修改日期">
                </td>
                <td>
                <img alt="" src="/pic/${ role.rPic }" width="100px" height="100px">
                </td>
                <td>
                	<a class="fa fa-pencil" title="编辑" href="<c:url value="/role/updateRole.action?id=${role.rId}" />"></a>
                	&nbsp;&nbsp;
                	<a class="fa fa-remove" title="删除" href="<c:url value="/deleteRole?id=${role.rId}" />"></a>
                 <input type = "hidden" name = "itemList[${status.index}]re.rId" value = "${ role.rId }">
                	
                </td>
            </tr>
            </c:forEach>
           
        </table>
       <input class="btn btn-primary va-bottom" type="submit" value="提交">
       </form>
	</div>
</body>
</html>