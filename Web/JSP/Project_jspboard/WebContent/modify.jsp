<%@page import="com.study.jsp.*" %>		
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> JAM#1♥ MODIFY </title>
		
		<!-- Required meta tags -->
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		
		<script language="JavaScript" src="members.js"></script>
	
		<style>
		div.col-sm-10 { 
			width:60%;
			height: 90%;
			margin: auto;	 
		}
		</style>
		
	</head>
		<%@ include file="header.jsp" %>	
		
	<body>
	<p></p>
		<div class="container">
			<table class="table table-bordered width=40%">
	  	    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	        <div class="panel panel-success">
	            <div class="panel-heading">
	            <p></p>
	            
	         <% request.setCharacterEncoding("UTF-8"); %> 
			 <%	id = (String)session.getAttribute("id");
	
					MemberDao mdao = MemberDao.getInstance();
					MemberDto mdto = mdao.getMember(id); %>
					
		<form action="modifyOK.do" method="post" name="reg_frm">
		<div class="form-group">
  		     		<label for="id"> 아이디 </label>
    		 		<%= mdto.getId() %>
				 </div>
		<div class="form-group">
  		     		<label for="password"> 비밀번호 </label>
    		 		<input type="password" class="form-control" id="pw" name="pw" placeholder="Password를 입력해 주세요">
			 	</div>
			 	<div class="form-group">
  		     		<label for="pw_check"> 비밀번호 </label>
    		 		<input type="password" class="form-control" id="pw_check" name="pw_check" placeholder="Password를 한번 더 입력해 주세요">
			 	</div>
		<div class="form-group">
  		     		<label for="name"> 이름 </label>
    		 		<%= mdto.getName() %>
				 </div>
		<div class="form-group">
  		     		<label for="eMail"> 메일 </label>
  		     			<input type="text" class="form-control" id="eMail" name="eMail"  value="<%= mdto.geteMail() %>">
				 </div>	
		<div class="form-group">
  		     		<label for="address"> 주소 </label>
  		     			<input type="text" class="form-control" id="address" name="address"  value="<%= mdto.getAddress() %>">
				 </div>		
			 <input type="button" class="btn btn-primary"  value="수정" onclick="updateInfoConfirm()"></button>
			 <input type="reset" class="btn btn-primary"  value="취소" onclick="javascript:window.location='main.jsp'"></button>
		</form>
		
		</div>
		</div>
		</div>
		</table>
		</div>
		
</body>

  <%@ include file="footer.jsp" %>
</html>