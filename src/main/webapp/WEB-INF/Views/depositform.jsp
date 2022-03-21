<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script type="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box
}

body {
    background: #9ab3f5;
    font-family: 'Ubuntu', sans-serif
}

.wrapper {
    background-color: #f4f2f7;
    margin: 20px auto;
    max-width: 400px;
    padding: 15px 20px;
    border-radius: 10px
}

h4 {
    font-weight: 800;
    color: #888
}

label {
    font-weight: 700;
    color: #888;
    font-size: 12px
}

.card-no {
    border: none;
    outline: none;
    width: 90%;
    padding-left: 8px
}

.form-control {
    outline: none;
    border: none;
    box-shadow: none
}

.card-number {
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 5px;
    padding: 5px 8px 2px
}

a {
    font-size: 12px;
    font-weight: 900;
    margin-left: 30%
}

a {
    text-decoration: none
}

.form-inline label {
    font-size: 1rem
}

.focused {
    border: 2px solid #9ab3f5
}

#form-footer a {
    margin: 0
}

#form-footer p {
    margin: 0;
    text-align: center;
    font-size: 14px;
    font-weight: 500;
    color: #777
}

@media(max-width:395px) {
    .form-inline label {
        font-size: 12px
    }

    #form-footer p {
        font-size: 11px
    }

    .card-no {
        width: 85%
    }
}
</style>
</head>
<body>

<form action="./depositAmount" method="post">
    <div class="wrapper">
    <h4 class="text-uppercase">Payment Details</h4>
    <form class="form mt-4">
        <div class="form-group"> <label for="name" class="text-uppercase">Name Of Account Holder Name</label> <input type="text" class="form-control" placeholder="Enter Your Name" name=""> </div>
        <div class="form-group"> <label for="card" class="text-uppercase">Account Number</label>
            <div class="card-number"> <input type="number" class="card-no" step="4" placeholder="*********" name="accountNumber"> <span class=""> <img src="https://www.freepnglogos.com/uploads/mastercard-png/mastercard-marcus-samuelsson-group-2.png" alt="" width="30" height="30"> </span> </div>
        </div>
        <div class="d-flex w-100">
            <div class="d-flex w-50 pr-sm-4">
                <div class="form-group"> <label for="number" >Amount</label> <input type="text" class="form-control" placeholder="*********"> </div>
            </div>
            <div class="d-flex w-50 pl-sm-5 pl-3">
                <div class="form-group"> <label for="number">Mobile Number</label> <a href="#" title="CVV is a credit or debit card number, the last three digit number printed on the signature panel">what's this</a> <input type="tel" class="form-control pr-5" maxlength="10" > </div>
            </div>
        </div>
        <div class="form-inline pt-sm-3 pt-2"> <input type="checkbox" name="address" id="address"> <label for="address" class="px-sm-1 pl-1 pt-sm-0 pt-2">My billing address is the same as the shipping</label> </div>
        <div class="form-inline py-sm-2"> <input type="checkbox" name="details" id="details"> <label for="details" class="px-sm-2 pl-2 pt-sm-0 pt-2">Save my details for future purchases</label> </div>
        <div class="my-3"> <input type="submit" value="Deposit" class="text-uppercase btn btn-primary btn-block p-3"> </div>
        <div id="form-footer">
            <p>By Deposit, you agree to our</p>
            <p><a href="#">privacy notice</a> & <a href="#">terms of use</a>.</p>
        </div>
    </form>
</div>
    </form>
</body>
</html>