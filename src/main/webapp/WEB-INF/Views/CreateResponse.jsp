<%@page import="java.util.Date"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.util.Random"%>
<%@page import="com.te.dtolayer.Customer" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String str = (String)request.getAttribute("message");
    Customer cust = (Customer)request.getAttribute("customerSaved");
    
    Date date = new Date();
    out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
    Random accountNo = new Random();
    long num = accountNo.nextInt(624561234)+10000000;
    
    String ifscCode = "SBIN20708";
    String branchName = "Hyderabad";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>

</head>
<body>
<h3>Hi ,Mr.<%=cust.getLastName() %></h3>
   <br></br>
<%=str %><br>
<b>,Below are the details that your Registered.</b><br>
<b>Generated login ID  :</b><%=cust.getCustomerId() %><br>
<b>Email Address  :</b><%=cust.getEmailId() %><br>
<b>Full Name  : </b><%=cust.getFirstName() %> <%=cust.getLastName() %><br>
<b>Contact Info :  </b><%=cust.getMobileNumber() %><br>
<b>Pan Card Number :</b><%=cust.getPancard() %><br>
<b>Gender : </b><%=cust.getGender()%>
<b>Account Number </b><%=num %>
<b>IFSC code :</b><%=ifscCode %>
<b>Branch Name :</b><%=branchName %>
<form action="./loginpage">
<div >
        <input type="submit" class="btnRegister"  value="Login"/>
      </div>
</form>

<form action="./register" >
<div>
  <button type="submit" class="btn btn-primary">Create New Account !!</button>
      </div>
</form>

</body>
</html>