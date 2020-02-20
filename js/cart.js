var check = false;

function changeVal(el) {
  var qt = parseFloat(el.parent().children(".qt").html());
  var price = parseFloat(el.parent().children(".price").html());
  var eq = Math.round(price * qt * 100) / 100;
  // alert(el.parent().children(".price").html());
  el.parent().children(".full-price").html( eq + "円" );

  var index=el.parents(".cart").index();
  console.log(index);
  $(".totalamount").eq(index).val(qt);
  
  changeTotal();
}

function changeTotal() {
  
  var price = 0;
  
  $(".full-price").each(function(index){
    // alert($(".full-price").eq(index).html());
    price += parseFloat($(".full-price").eq(index).html());
  });
  
  price = Math.round(price * 100) / 100;
  //var tax = Math.round(price * 0.05 * 100) / 100
  // var shipping = parseFloat($(".shipping span").html());
  //var fullPrice = Math.round((price + tax ) *100) / 100;
  // alert("price="+price);
  if(price == 0) {
    fullPrice = 0;
  }
  $(".subtotal span").html(price);
  //$(".tax span").html(tax);
  $(".total span").html(price);
  $(".totalprice").val(price);
}

$(document).ready(function(){
  
  $(".remove").click(function(){
    var el = $(this);
    el.parent().parent().addClass("removed");
    deleteBookFromUserCart(el);
    window.setTimeout(
      function(){
        el.parent().parent().slideUp('fast', function() { 
          el.parent().parent().remove(); 
          if($(".product").length == 0) {
            if(check) {
              $("#cart").html("<h1>The shop does not function, yet!</h1><p>If you liked my shopping cart, please take a second and heart this Pen on <a href='https://codepen.io/ziga-miklic/pen/xhpob'>CodePen</a>. Thank you!</p>");
            } else {
              $("#cart").html("<h1>No products!</h1>");
            }
          }
          changeTotal(); 
        });
      }, 200);
  });
  
  $(".qt-plus").click(function(){
    $(this).parent().children(".qt").html(parseInt($(this).parent().children(".qt").html()) + 1);
    
    // $(this).parent().children(".cart_amount").val()=$(this).parent().children(".qt").html().toString();
    var cart_amount = parseInt($(this).parent().children(".cart_amount").val())+1;
    $(this).parent().children(".cart_amount").val(cart_amount);
    // alert($(this).parent().children(".cart_amount").val());
    $(this).parent().children(".full-price").addClass("added");
    
    var el = $(this);
    window.setTimeout(function(){el.parent().children(".full-price").removeClass("added"); changeVal(el);}, 150);

    
  });
  
  $(".qt-minus").click(function(){
    
    child = $(this).parent().children(".qt");
    
    if(parseInt(child.html()) > 1) {
      child.html(parseInt(child.html()) - 1);
      var cart_amount = parseInt($(this).parent().children(".cart_amount").val())-1;
      $(this).parent().children(".cart_amount").val(cart_amount);
    }
    
    $(this).parent().children(".full-price").addClass("minused");
    
    var el = $(this);
    window.setTimeout(function(){el.parent().children(".full-price").removeClass("minused"); changeVal(el);}, 150);
  });
  
  window.setTimeout(function(){$(".is-open").removeClass("is-open")}, 1200);
  
  $(".btn").click(function(){
    check = true;
  });
  // changeTotal();
});


function deleteBookFromUserCart(el){
  var params = {
    user_id:el.children("h3").children(".user-id").val(),
    book_isbn:el.children("h3").children(".book-isbn").val()
  };
  // alert(params.user_id +"  "+params.book_isbn);
  $.post("deletebookfromusercart.do",$.param(params),function(responseJson){
    // alert(responseJson);
  });
}