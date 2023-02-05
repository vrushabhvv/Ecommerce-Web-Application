<%-- 
    Document   : Register
    Created on : Jan 29, 2023, 4:14:57 PM
    Author     : Vrushabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User</title>
        <%@include file="components/common_css_js.jsp" %>
        <%--<%@include file="css/style.css" %>--%>
        <style>
            body{
                /*overflow-x: hidden;*/
                background: url(image/registration-page.jpg);
                background-size: cover;
            }

        </style>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        <div class="container-fluid">


            <div class="row mt-5 " >

                <div class="col-md-4 offset-md-4"><!-- use 4 grid of 12 and give offset of 4 it make center this form -->

                    <div class="card">
                        <%@include file="components/message.jsp" %>
                        <div class="card-body px-5">


                            <h3 class="text-center my-3 ">Sign Up Here!!</h3>
                            <form action="RegisterServlet" method="post">

                                <div class="form-group">
                                    <label for="name">User Name</label>
                                    <input type="text" class="form-control" id="name" name="user_name" aria-describedby="emailHelp" placeholder="Enter Here">
                                </div>
                                
                                

                                <div class="form-group">
                                    <label for="email">User Email</label>
                                    <input type="email" class="form-control" id="email" name="user_email" aria-describedby="emailHelp" placeholder="Enter Here">

                                </div>
                                <div class="form-group">
                                    <label for="password">User Password</label>
                                    <input type="password" class="form-control" id="password" name="user_password"  aria-describedby="emailHelp" placeholder="Enter Here">

                                </div>
                                <div class="form-group">
                                    <label for="userphone">User Phone</label>
                                    <input type="number" class="form-control" id="userphone" name="user_phone" aria-describedby="emailHelp" placeholder="Enter Here">

                                </div>

                                <div class="form-group">
                                    <label for="useraddress">User Address</label>
                                    <textarea class="form-control" placeholder="Enter here" name="user_address"></textarea>


                                </div>

                                <div class="container text-center">
                                    <button class="btn btn-outline-success">Register</button>
                                    <button class="btn btn-outline-warning">Reset</button>
                                </div>




                            </form>  
                        </div>
                    </div>

                </div>



            </div>
        </div>
    </body>
</html>
