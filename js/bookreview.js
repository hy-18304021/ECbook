$(document).ready(function(){
	$(".review-user-id").each(function(){
		// alert("Session:"+$(".sessionId").html()+"reviewID:"+$(this).html());
		if($(this).html()!=$(".sessionId").html()){
			$(this).parent().children(".changebutton").css("display","none");
		}
	})
});

function bookreviewchange(method,book_isbn,user_id,review_text,review_star,review_date){
	var params = "";
	if(method=="addreview"){
		// alert("add");
		var text = document.getElementById("review_text").value;
		var star = document.getElementById("review_star").value;
		params ="method="+method
				+"&book_isbn="+book_isbn
				+"&user_id="+user_id
				+"&review_text="+text
				+"&review_star="+star
				+"&review_date="+review_date;
	}
	if(method=="deletereview"){
		// alert("deletereview");
		params ="method="+method
				+"&book_isbn="+book_isbn
				+"&user_id="+user_id
				+"&review_text="+review_text
				+"&review_star="+review_star
				+"&review_date="+review_date;
	}
	// alert(params);
	var xmlHttpRequest = getXMLHttpRequest();
	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
	xmlHttpRequest.open("POST","bookreviewchange",true);
	xmlHttpRequest.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttpRequest.send(params);
}