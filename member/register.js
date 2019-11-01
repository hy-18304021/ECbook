$(document).ready(function(){
	$("#checkId").click(function(){//重複確認
	  if($("#id").val()){
		var query = {id:$("#id").val()};
		
	    $.ajax({
	    	type:"post",
	    	url:"/shoppingmall/confirmId.do",
	    	data:query,
	    	success:function(data){
	    		var str1 = '<p id="ck">';
	    		var loc = data.indexOf(str1);
	    		var len = str1.length;
	    		var check = data.substr(loc+len,1);
	    		if(check == "1"){//使用できないID
	    			alert("使用できないIDです。");
	    	    	$("#id").val("");
	    	     }else//使用できるID
	    	  	    alert("使用できるID");
	 	    }
	    });
	  }else{//IDを入力しないまま重複確認を押す場合
		  alert("使用するIDを入力");
		  $("#id").focus();
	  }
	});
	
	$("#process").click(function(){//会員登録を押す
		  var query = {id:$("#id").val(), 
				  pass:$("#pass").val(),
			      name:$("#name").val(),
				  tel:$("#tel").val(),
				  birth:$("#birth").val(),
				  sex:$("#sex").val(),
				  mail:$("#mail").val(),
				};
				  
		  
		  $.ajax({
		      type:"post",
		      url:"/shoppingmall/registerPro.do",
		      data:query,
		      success:function(data){
		    	  window.location.href("/shoppingmall/index.do");
		 	  }
		  });
	});
	
	$("#cancle").click(function(){//キャンセルを押す
		window.location.href("/shoppingmall/index.do");
	});

 });
