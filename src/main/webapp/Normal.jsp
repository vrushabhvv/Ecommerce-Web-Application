
<%@page import="com.kodnest.mycart.Helper"%>
<%@page import="com.kodnest.mycart.entities.Category"%>
<%@page import="com.kodnest.mycart.dao.CategoryDao"%>
<%@page import="com.kodnest.mycart.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.kodnest.mycart.factoryprovider"%>
<%@page import="com.kodnest.mycart.dao.ProductDao"%>
<%@page import="com.kodnest.mycart.entities.User"%>
<%
    User user=(User)session.getAttribute("current-user");
    if(user==null){
    session.setAttribute("message","you are not logged in !! Login First");
    response.sendRedirect("login.jsp");
    return;
    }
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="components/navbar.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My cart:home</title>
        <!--use this common jsp file to use bootstrap cdn for css and js everywhere-->
        <%@include file="components/common_css_js.jsp" %>

        <style>
            body{
                overflow-x: hidden;
            }
            .text-secondary{
                
                
            }
            .discount-lable{
                font-size: 10px;
            }
            .strikethrough{
                color: black;
            }
            .addition-style:hover{
                background: lavender;
                transition: 2ms ease-in-out;
                cursor: pointer;
            }
        </style>

    </head>
    <body>
        <!--container fluid makes page full on full screen and small on small screen-->
        <div class="container-fluid">
            <div class="row mt-4">
                <%                 ProductDao dao = new ProductDao(factoryprovider.getfaFactory());
                    List<Product> list =null;//first it is null after depending upon condition it will load product that is upon click

                    String cat = request.getParameter("category");
//                    out.println(cat);//this is for testing

                    
                    
                    //this benifits us when we directly open our index.jsp page it will not give any error
                    if(cat==null){
                    list = dao.getAllProducts();
                    }
    //                here code instruct if we click on all ,also any other product then we are redirecting to that page
    else if (cat.trim().equals("all")) {
                    list = dao.getAllProducts();

                    }else{
                    
//                    convert cat to int by triming that is by removing white spaces because if anyone added space while seeing url on url-section then we might get some error,so always remove spaces
                    int cid=Integer.parseInt(cat.trim());
                    list=dao.getAllProductsById(cid);
                    
                    }

                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    CategoryDao cdao = new CategoryDao(factoryprovider.getfaFactory());
                    List<Category> clist = cdao.getCategories();

                %>
                <!--show categories-->
                <div class="col-md-2">



                    <div class="list-group mt-4">
                        <!--make sure using that category--> 
                        <a href="index.jsp?category=all" class="list-group-item list-group-item-action active">
                            ALL Products
                        </a>

                        <% for (Category category : clist) {

                        %>
                        <!--url rewritting in order to move to perticular section when we click on category-->
                        <a href="index.jsp?category=<%= category.getCategory_id()%>" class="list-group-item list-group-item-action"><%=category.getCategory_Title()%></a>

                        <%
                            }

                        %>



                        <!--getting category id using category from url rewriting-->
                        <%  //this code also written first scriptlet tag
    //                        String cat=request.getParameter("category");
    //                        out.println(cat);
    //                        next code is written in first scriptlet tag for simplicity in order to avoid confusion
                        %>

                    </div>
                </div>





                <!--show products-->
                <div class="col-md-9">
                    <!--row-->
                    <div class="row mt-4">
                        <!--column-->
                        <div class="col-md-12">
                            <div class="card-columns">
                                <!--traversing-->
                                <%                                for (Product p : list) {
                                %>
<!--product card-->
                                <div class="card">
                                    <div class="container text-center mt-4 addition-style">
                                        <img src="image/products/<%= p.getpPhoto()%>" style="max-height: 270px;max-width:100%; width: auto; "  class="card-img-top"  alt="Card image cap"><!-- load photo from path on which you have added products in admin section -->
                                    </div>

                                    <div class="card-body addition-style">
                                        <h5 class="card-title"><%=Helper.get10Words(p.getPName())%></h5>
                                        <p class="card-text">
                                            <%=Helper.get10Words(p.getpDesc())%>
                                        </p>
                                    </div>

                                    <!--card footer-->
                                    <div class="card-footer">
                                        <button class="btn " onclick="add_to_card(<%=p.getpId() %>, '<%=p.getPName()  %>','<%= p.getPriceAfterApplyingDiscount()%>')">Add to cart</button>
                                        <button class="btn btn-outline-success">  <span><s class="strikethrough"> &#8360;<%=p.getpPrice()%></s>/-<br> <span><%=p.getPriceAfterApplyingDiscount() %></span> <span style="padding-left: 4px" class="text-secondary discount-lable">  <%=p.getpDiscount() %>% off</span></button>                                            
                                    </div>
                                </div>


                                <%
                                    }
if(list.size()==0){
out.println("<h1>No Items Are There In This Category<h1>");
}
                                %>

                            </div>
                        </div>
                    </div>



                </div>
            </div>
        </div>
                                <%@include file="components/commonmodals.jsp" %>
    </body>
</html>

