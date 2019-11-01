$(document).ready(function(){
	$("#uRes").click(function(){//会員登録を押す
		window.location.href("/shoppingmall/registerForm.do");
	});
	
	$("#uLogin").click(function(){//loginクリック
		  var query = {id : $("#cid").val(), 
				       passwd:$("#cpasswd").val()};
		  
		  $.ajax({
		     type: "POST",
		     url: "/loginPro.do",
		     data: query,
		     success: function(data){
		    	 var str1 = '<p id="ck">';
		    	 var loc = data.indexOf(str1);
		    	 var len = str1.length;
		    	 var check = data.substr(loc+len,1);
		    	 if(check == "1"){//
		    		window.location.href("/index.do");
		    	 }else if(check == "0"){
		    	  	alert("パスワードが違います");
		    	  	$("#cpasswd").val("");
		    	 }else{
		    	    alert("IDが違います");
		    	    $("#cid").val("");
		    	    $("#cpasswd").val("");
		        }
		 	}
		  });
	});
	
	$("#uUpdate").click(function(){//会員情報の変更
		window.location.href("/modify.do");
	});
	
	$("#uLogout").click(function(){//LOgoutをクリック
		$.ajax({
		   type: "POST",
		   url: "/logout.do",
		   success: function(data){
			   window.location.href("/index.do");
		   }
		});
	});
	
	$("#cart").click(function(){//[장바구니]버튼 클릭
		window.location.href("/shoppingmall/cartList.do");
	});
	
	$("#buy").click(function(){//[구매내역]버튼 클릭
		window.location.href("/shoppingmall/buyList.do");
	});

});
