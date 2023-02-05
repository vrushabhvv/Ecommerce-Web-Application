
<%@page import="com.kodnest.mycart.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.kodnest.mycart.factoryprovider"%>
<%@page import="com.kodnest.mycart.dao.CategoryDao"%>
<%@page import="com.kodnest.mycart.entities.User"%>
<!--protect admin page from normal user and user who have not logged in-->
<%
    User user = (User) session.getAttribute("current-user");
    if (user == null) {
        session.setAttribute("message", "you are not logged in !! Login First");
        response.sendRedirect("login.jsp");
        return;
    } else {
        if (user.getUserType().equals("normal")) {
            session.setAttribute("message", "you are not admin! do not try to access this page");
            response.sendRedirect("login.jsp");
            return;
        }
    }


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>
        <%@include file="components/common_css_js.jsp" %>
        <style>
            /*ask why my css page is not linking inside common_css_js.jsp*/
            .admin .card{
                border: 1px solid #673ab7;
            }

            .admin .card:hover{
                background: #e2e2e2;
                cursor:pointer;
            }
        </style>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>

        <div class="container admin">
            <div class="fluid-container mt-3">
                <%@include file="components/message.jsp" %>
            </div>

            <!--first row-->
            <div class="row mt-4">
                <!--row will get 12-grid-->
                <!--give 4-grid to each column-->
                <!--column-1-->

                <!--first-row-first-column-->
                <!--box-1-->
                <div class="col-md-4">
                    <!--creating box mean creating card-->
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width:150px;" class="img-fluid rounded-circle" src="image/user.png" alt="user-icon"/>
                            </div>

                            <h1>1</h1>
                            <h1>Users</h1>
                        </div>
                    </div>
                </div>


                <!--column-2-->

                <!--first-row-second-column-->
                <!--box-2-->
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width:150px;" class="img-fluid rounded-circle" src="image/categories.png" alt="user-icon"/>
                            </div>
                            <h1>2
                            </h1>
                            <h1>Categories</h1>
                        </div>
                    </div>
                </div>




                <!--column-3-->

                <!--first-row-third-column-->
                <!--box-3-->
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width:150px;" class="img-fluid rounded-circle" src="image/product.png" alt="user-icon"/>
                            </div>
                            <h1>3</h1>
                            <h1>Products</h1>
                        </div>
                    </div>
                </div>






            </div>


            <!--second row-->
            <!--second-row-first-column-->
            <div class="row mt-4" >
                <div class="col-md-6">
                    <div class="card" data-toggle="modal" data-target="#add-category-modal">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width:150px;" class="img-fluid rounded-circle" src="image/categories_add.png" alt="user-icon"/>
                            </div>
                            <p class="mt-2">click here to add category</p>
                            <h1>Add Category</h1>
                        </div>
                    </div>
                </div>

                <!<!-- second-row-second-column -->
                <div class="col-md-6">
                    <div class="card" data-toggle="modal" data-target="#add-product-modal">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width:150px;" class="img-fluid rounded-circle" src="image/add product.png" alt="user-icon"/>
                            </div>
                            <p class="mt-2">add product</p>
                            <h1>Add Product</h1>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!--add category modal-->
        <!-- Button trigger modal -->




        <!-- Modal -->

        <!--id attr we have to change it same as data-target as in card component of respective model-->
        <div class="modal fade" id="add-category-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Fill Category Details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                        <form action="ProductOpearationServlet" method="post">

                            <input name="operation" type="hidden" value="addcategory"><!-- by this method we are sending value if we execute this block -->


                            <div class="form-group">
                                <input type="text" class="form-control" name="cattitle" placeholder="enter the category title" required>
                            </div>

                            <div class="form-group">
                                <textarea class="form-control" placeholder="enter category description" name="catDescription" required></textarea>
                            </div>


                            <div class="container text-center">
                                <button class="btn btn-outline-success">Add Category</button>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                    </div>
                </div>
            </div>
        </div>



        <!--end category modal--> 


        <!--start product modal-->

        <div class="modal fade" id="add-product-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">products details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                        <form action="ProductOpearationServlet" method="post" enctype="multipart/form-data"><!-- if we have img,audio and video then use enctype -->

                            <input type="hidden" name="operation" value="addproduct">
                            <div class="form-group">
                                <input type="text" class="form-control" name="pname" placeholder="enter the product name" required>
                            </div>

                            <div class="form-group">
                                <textarea class="form-control" placeholder="enter product description" name="proddescription" required></textarea>
                            </div>


                            <div class="form-group">
                                <input type="number" class="form-control" name="pprice" placeholder="enter the product price" required>
                            </div>


                            <div class="form-group">
                                <input type="number" class="form-control" name="pdiscount" placeholder="enter the product discount" required>
                            </div>


                            <div class="form-group">
                                <input type="number" class="form-control" name="pquantity" placeholder="enter the product quantity" required>
                            </div>






                            <!--product categories-->

                            <%  CategoryDao categorydao = new CategoryDao(factoryprovider.getfaFactory());
                                List<Category> list = categorydao.getCategories();

                            %>
                            <div class="form-group">
                                <select name="catId" class="form-control" id="">


                                    <%for (Category c : list) {
                                    %>
                                    <option value="<%=c.getCategory_id()%>"><%=c.getCategory_Title()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                    </div>




                    <div class="file-upload-wrapper mt-2 px-4">
                        <!--                                <label for="input-file-now" name="fileupload">Product image</label>-->
                        <input type="file" id="input-file-now" class="file-upload" name="fileupload" />
                    </div>

                    <div class="container text-center mt-2">
                        <button class="btn btn-outline-success">Add product</button>
                    </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!--end product modal--> 

</body>
</html>
