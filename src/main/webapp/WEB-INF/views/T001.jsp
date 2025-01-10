<%@page import="dto.Section"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.School"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
<title><%= request.getAttribute("title") %></title>
<style>
body {
  font-family: sans-serif;
}

h2{
	text-align: center;
}

.form-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  width: 80%;
  margin: 0 auto;
}

.form-group {
  width: 48%;
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"],
input[type="email"],
input[type="date"],
select {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

button[type="submit"] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  width: 100%;
}
   
  </style>
</head>
<body>
	<h2>Form Thêm Sinh Viên</h2>
<form action="/submit" method="POST" class="form-container">
  <div class="form-group">
    <label for="soCMND">Số CMND</label>
    <input type="text" id="soCMND" name="soCMND" required>
  </div>

  <div class="form-group">
    <label for="hoTen">Họ Tên</label>
    <input type="text" id="hoTen" name="hoTen" required>
  </div>

  <div class="form-group">
    <label for="email">Email</label>
    <input type="email" id="email" name="email" required>
  </div>

  <div class="form-group">
    <label for="soDT">Số Điện Thoại</label>
    <input type="text" id="soDT" name="soDT" required>
  </div>

  <div class="form-group">
    <label for="diaChi">Địa Chỉ</label>
    <input type="text" id="diaChi" name="diaChi" required>
  </div>

  <div class="form-group">
    <label for="maTruong">Mã Trường</label>
    <select id="maTruong" name="maTruong" required>
      <%
      	ArrayList<School> schools = (ArrayList<School>) request.getAttribute("schools");
    	for(School school : schools) { %>
    		<option value="<%= school.getMaTruong() %>">
    			<%= school.getTenTruong() %>
    		</option>
      <% } %>
    </select>
  </div>

  <div class="form-group">
    <label for="maNganh">Mã Ngành</label>
    <select id="maNganh" name="maNganh" required>
      <%
      	ArrayList<Section> sections = (ArrayList<Section>) request.getAttribute("sections");
    	for(Section section : sections) { %>
    		<option value="<%= section.getMaNganh() %>">
    			<%= section.getTenNganh() %>
    		</option>
      <% } %>
    </select>
  </div>

  <div class="form-group">
    <label for="heTN">Hệ Tốt Nghiệp</label>
    <input type="text" id="heTN" name="heTN" required>
  </div>

  <div class="form-group">
    <label for="ngayTN">Ngày Tốt Nghiệp</label>
    <input type="date" id="ngayTN" name="ngayTN" required>
  </div>

  <div class="form-group">
    <label for="loaiTN">Loại Tốt Nghiệp</label>
    <input type="text" id="loaiTN" name="loaiTN" required>
  </div>

  <button type="submit">Thêm Sinh Viên</button>
</form>
</body>
</html>