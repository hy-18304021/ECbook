$(document).ready(function(){
	$(".write-review-button").click(function(){
		var params = {
			method: "addreview",
			book_isbn:$(".book-isbn").html(),
			user_id:$(".sessionId").html(),
			review_text:$("#review_text").val()
					.replace(/&/g,"&amp;")
					.replace(/</g,"&lt;")
					.replace(/>/g,"&gt;")
					.replace(/\r?\n/g,"<br/>"),
			review_star: $("#review_star").val(),
			review_date:null
		};
		// alert(params.review_text);
		$.post("bookreviewchange.do",$.param(params),function(responseJson){
			var $review =$("#review");
			$review.html("");
			$.each(responseJson,function(index,review){
				$("<hr>").appendTo($review);
				$("<h4>").appendTo($review).text(review.user_id);
				$("<hr>").appendTo($review);
				// alert("Ajax:"+review.review_text);
				$("<div>").appendTo($review)
							.addClass("a-section")
							.append($("<div>").addClass("a-row a-spacing-micro")
											.append($("<div>").addClass("a-icon-row a-spacing-none")
												.append($("<a>").addClass("a-link-normal a-text-normal a-color-base")
													.append($("<i>").addClass("a-icon a-icon-star a-star-"+review.review_star)))
												.append($("<span>").addClass("a-letter-space"))
												.append($("<a>").addClass("a-link-normal a-text-normal a-color-base")))
											.append($("<span>").addClass("a-color-secondary").text(review.review_date)))
							.append($("<div>").addClass("a-row a-spacing-small")
								.append($("<span>").addClass("a-size-mini a-color-state a-text-bold").text("Title"))
								.append($("<div>").addClass("a-section").html(review.review_text)));
			});
		});
	});

	$(".delete-review-button").click(function(){

	});
});




// function bookreviewchange(method,book_isbn,user_id,review_text,review_star,review_date){
// 	var params = "method="+method
// 				+"&book_isbn="+book_isbn
// 				+"&user_id="+user_id
// 				+"&review_text="+review_text
// 				+"&review_star="+review_star
// 				+"&review_date="+review_date;
// 	alert(params);
// 	var xmlHttpRequest = getXMLHttpRequest();
// 	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
// 	xmlHttpRequest.open("POST","bookreviewchange.do",true);
// 	xmlHttpRequest.setRequestHeader("Content-Type",
// 			"application/x-www-form-urlencoded");
// 	xmlHttpRequest.send(params);
// }

// function bookreviewchange(method,book_isbn,user_id,review_text,review_star,review_date){
// 	var params = "";
// 	if(method=="addreview"){
// 		alert("add");
// 		review_text = document.getElementById("review_text").value;
// 		review_star = document.getElementById("review_star").value;
// 		params ="method="+method
// 				+"&book_isbn="+book_isbn
// 				+"&user_id="+user_id
// 				+"&review_text="+review_text
// 				+"&review_star="+review_star
// 				+"&review_date="+review_date;
// 	}
// 	if(method=="deletereview"){
// 		alert("deletereview");
// 		params ="method="+method
// 				+"&book_isbn="+book_isbn
// 				+"&user_id="+user_id
// 				+"&review_text="+review_text
// 				+"&review_star="+review_star
// 				+"&review_date="+review_date;
// 	}
// 	alert(params);
// 	var xmlHttpRequest = getXMLHttpRequest();
// 	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
// 	xmlHttpRequest.open("POST","bookreviewchange.do",true);
// 	xmlHttpRequest.setRequestHeader("Content-Type",
// 			"application/x-www-form-urlencoded");
// 	xmlHttpRequest.send(params);
// }