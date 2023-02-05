
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login  - mycart</title>
        
        <%@include file="components/common_css_js.jsp" %>
        
         <style>
            body{
                /*overflow-x: hidden;*/
                background: url(image/signup-background.jpg);
                background-size: cover;
            }

        </style>
       
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card mt-3">
                        <div class="card-header custom-bg  text-center">
                             <%@include file="components/message.jsp" %>
                            <h3>Login Here</h3>
                        </div>

                        <div class="card-body">
                            <form action="LoginServlet" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp" placeholder="Enter email">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
                                </div>
                                
                                <a href="Register.jsp" class="text-center d-block mb-4"> if not registered click here</a>


                                <div class="container text-center">
                                    <button type="submit" class="btn btn-primary bg-dark">Submit</button>
                                    <button type="reset" class="btn btn-primary bg-dark">Reset</button>
                                </div>
                            </form>
                        </div>

                        
                    </div>

                </div>

            </div>



        </div>








    </body>
</html>
