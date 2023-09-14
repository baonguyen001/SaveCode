<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple Data</title>
</head>


<body>
	<!-- khi nhấn submit thì form sẽ tự động lấy các thông tin trong input 
	thẻ form tự động lấy name và giá trị của name đóng vai trò là tên của tham số -->
    <form action="http://localhost:8080/CRM/api/role/add" method="post">
    	<div class="form-group">
    		<label>Tên Quyền</label>
    		<input id="name" type="text" name = "name" placeholder="Tên Quyền"></input>
    	</div>
    	
    	<div class="form-group">
    		<label>Mã loại</label>
    		<input id="decs" type="text" name = "decs" placeholder="Mã loại"></input>
    	</div>
    	
    	<div class="form-group">
    		<button type="submit">Add</button>
    	</div>

    </form>
    
  
    	

    
    
    
      <!-- Jquery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        
       <!-- Popper -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous">
        </script>
        
     <script src="js/role.js"></script>
</body>
</html>
