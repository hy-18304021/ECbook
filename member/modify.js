$(document).ready(function(){

	$("#modifyProcess").click(function(){//修正する
		var query = {id:$("#id").val(), 
				  passwd:$("#pass").val(),
			      name:$("#name").val(),
				  tel:$("#tel").val(),
				  birth:$("#birth").val(),
				  sex:$("#sex").val(),
				  mail:$("#mail").val(),};
		
		$.ajax({
			type: "post",
			url: "/shoppingmall/modifyPro.do",
			data: query,
			success: function(data){
				var str1 = '<p id="ck">';
	    		var loc = data.indexOf(str1);
	    		var len = str1.length;
	    		var check = data.substr(loc+len,1);
	    		if(check == "1"){//
	    			alert("会員情報修正されました.");
					window.location.href("/modify.do");
	    	    }else{
	    	    	alert("パスワードが違います。.");
	    	    	$("#pass").val("");
	    	    	$("#pass").focus();
	    	    }
		   }
		});
	});
	
	$("#cancle").click(function(){//キャンセル
		window.location.href("/modify.do");
	});
	
 });