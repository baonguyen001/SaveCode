<%@page import="crm.model.Role"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Data</title>
</head>

<!-- Nhận giá trị từ RoleController req.setAttribute("/role", roleService.getRole()); 
<% List<Role> list = (List<Role>) request.getAttribute("role");%>
-->
<body>
	<table>
		<thead>
			<tr>
				<th>STT</th>
				<th>Tên Quyền</th>
				<th>Mô Tả</th>
				<th>Hành Động</th>
			</tr>
		</thead>

		<tbody> 
    		 <!-- role trả ra req.setAttribute("role", roleService.getRole()); -->
			<c:forEach items="${role}" var="itemData">
   				<tr>
    				<td> 
    					${itemData.getId()}
    				</td>
    				<td> 
    					${itemData.getRole_name()}
    				</td>
    				<td> 
    					${itemData.getDescription()}
    				</td>
    				<td>
    				<button>Sửa</button>
    				<button class="btn-xoa" id-role="${itemData.getId()}">Xóa</button>
    				</td>
    			</tr>		
			</c:forEach>
		</tbody>
	</table>

	<!-- Jquery -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<!-- Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous">
	</script>
	<script src="js/role.js"></script>
</body>
</html>
