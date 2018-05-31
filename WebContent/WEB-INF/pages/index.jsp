<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table cellpadding="10px" cellspacing="0" width="60%" align="center"
		border="1px">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>password</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td align="center">${user.id }</td>
				<td align="center">${user.name }</td>
				<td align="center">${user.password }</td>
				<td align="center"><a class="upd" href="${pageContext.request.contextPath }/user/upd/${user.id}">修改</a></td>
				<td align="center"><a class="del" href="${pageContext.request.contextPath }/user/delUserById/${user.id}">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="5" align="center"><a id="add" href="${pageContext.request.contextPath }/user/toAdd">添加</a></th>
		</tr>
	</table>
	<form id="form1" action="" method="post">
		<input type="hidden" name="_method" value="">
	</form>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/scripts/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		$('.del').click(function() {
			$('#form1 input').attr("value", "delete");
			var href = $(this).attr("href");
			$("#form1").attr("action", href).submit();
			return false;
		});
		$('.upd').click(function() {
			$('#form1 input').attr("value", "put");
			var href = $(this).attr("href");
			$("#form1").attr("action", href).submit();
			return false;
		});
	</script>
</body>
</html>