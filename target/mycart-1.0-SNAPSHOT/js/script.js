function add_to_card(pid, pname, price)
{
    let cart = localStorage.getItem("cart");

    if (cart == null) {
//        no cart yet
        let products = [];
        let product = {
            productId: pid, productName: pname, productQuantity: 1, productPrice: price
        }
        products.push(product);
        localStorage.setItem("cart", JSON.stringify(products));
        console.log("product quantity is for first time");
        showToast("Item is added to cart");
    } else {
        //cart is already present

        let pcart = JSON.parse(cart);

        let oldProduct = pcart.find((item) => item.productId == pid);

        if (oldProduct)
        {
            //we have to icrease the quantity
            oldProduct.productQuantity = oldProduct.productQuantity + 1;
            pcart.map((item) => {
                if (item.productId == oldProduct.productId) {
                    item.productQuantity = oldProduct.productQuantity;
                }
            })
            localStorage.setItem("cart", JSON.stringify(pcart));
            console.log("product quantity is increased");
            showToast("Item is added to cart");
        } else {
            //we have to add the product
            let product = {
                productId: pid, productName: pname, productQuantity: 1, productPrice: price
            }
            pcart.push(product);
            localStorage.setItem("cart", JSON.stringify(pcart));
            console.log("product added");
            showToast("Item is added to cart");
        }


    }
     updateCart();

}


//$(document).ready(function(){
//    updateCart();
//})
//update cart
function updateCart()
{
    console.log("inside updateCart");
    let cartString = localStorage.getItem("cart");
    let cart = JSON.parse(cartString);
    if (cart == null || cart.length == 0) {
        console.log("cart is empty");
        $(".cart-items").html("(0)");
        $(".cart-body").html("<h3>Cart does not have any items</h3>");
        $(".checkout-btn").addClass('disabled');
//        $(".checkout-btn").attr('disabled',true);

    } else {
        //there is some in cart to show
        console.log(cart);
        $(".cart-items").html(`(${cart.length})`);
        let table = `
         <table class='table'>
            <thead class='thead-light'>
            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total price</th>
                <th>Action</th>
        
        
            </tr>
        
        
        
        
            </thead>
 



                    `;
               let totalprice=0;
                cart.map((item)=>{
                    table+=`
                           <tr>
                             <td>${item.productName}</td>
                             <td>${item.productPrice}</td>
                             <td>${item.productQuantity}</td>
                             <td>${item.productQuantity*item.productPrice}</td>
                             <td><button onclick='deleteItemFromCart(${item.productId}), showToast("Item is removed from cart");' class='btn btn-danger btn-sm'>Remove</button></td>
                           </tr>
            
            
              
                        `
            totalprice += item.productPrice*item.productQuantity;
                })

        table = table + `
          <tr><td colspan='5' class='text-right text-font-weight-bold mb-5'>Total Price: ${totalprice}</td></tr>
          </table>`
        $(".cart-body").html(table);
         $(".checkout-btn").removeClass('disabled');
//         $(".checkout-btn").attr('disabled',false);

    }
    }
    
    //delete item
    function deleteItemFromCart(pid){
        let cart=JSON.parse(localStorage.getItem('cart'));
        let newcart=cart.filter((item)=>item.productId!=pid);
        localStorage.setItem('cart',JSON.stringify(newcart));
        updateCart();
        
        showToast("Item is added to cart");
    }
    

//$(document).ready(function () {
//    updateCart()
//})


  function showToast(content)
        {
            $("#toast").addClass("display");
            $("#toast").html(content);

            setTimeout(()=>{
                $("#toast").removeClass("display");
            },2000);

            
        }
        
        
        
        function gotoCheckout(){
            console.log("checkout page");
            window.location="checkout.jsp";
        }
