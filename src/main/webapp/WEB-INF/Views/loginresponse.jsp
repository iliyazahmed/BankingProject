<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    String message =(String) request.getAttribute("msg");
    Date date = new Date();
    out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
   
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Bank of India</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>




</head>
<body class="bg">
       <h2><%=message %></h2>
     <div style="background-image: url('https://images.unsplash.com/photo-1620714223084-8fcacc6dfd8d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8YmFua3xlbnwwfHwwfHw%3D&w=1000&q=80'); background-repeat: no-repeat;background-size: cover">
     
       <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link">Disabled</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<form action ="./deposit">
             <button class="btn btn-primary" type="submit" style="display:inline-block; margin:10px; text-decoration:none">Deposit</button>
</form>

<form>
             <button class="btn btn-primary" type="submit" style="display:inline-block; margin:10px; text-decoration:none">Withdraw</button>
</form>
<form>
           <input class="btn btn-primary" type="button" style="display:inline-block; margin:10px; text-decoration:none" value="View Ministatement ">
</form>
<form>
          <input class="btn btn-primary" type="submit" style="display:inline-block; margin:10px; text-decoration:none" value="Apply for Debitcard">
</form>
<form>
           <input class="btn btn-primary" type="reset"style="display:inline-block; margin:10px; text-decoration:none" value="Loan Offers">
</form>
<form>
           <input class="btn btn-primary" type="button"style="display:inline-block; margin:10px; text-decoration:none" value="Shopping Offers">
</form>
<form>
          <input class="btn btn-primary" type="submit" style="display:inline-block; margin:10px; text-decoration:none"value="View Account Details">
</form>
<form>
           <input class="btn btn-primary" type="reset" style="display:inline-block; margin:10px; text-decoration:none"value="update Profile Details">
</form>
<form>
           <input class="btn btn-primary" type="button" style="display:inline-block; margin:10px; text-decoration:none" value="ContactUs">
</form>
<form>
          <input class="btn btn-primary" type="submit" style="display:inline-block; margin:10px; text-decoration:none" value="LogOut">
</form>

</div>




</body>
</html>