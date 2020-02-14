$(document).ready(function(){
	$(".write-review-button").click(function(){
		addReview();
	});

	$(".delete-review-button").click(function(){
		deleteReview($(this));
		// window.location=location;
	});

	$("#review").on('DOMNodeInserted', "input", function() {
    	$(".delete-review-button").click(function(){
			deleteReview($(this));
		});
		$(".delete-review-button").each(function(){
			if($(this).parent().children(".user-id").html()!=$(".sessionId").html()){
				$(this).css("display","none");
			}
		});

	});

	$(".delete-review-button").each(function(){
		if($(this).parent().children(".user-id").html()!=$(".sessionId").html()){
			$(this).css("display","none");
		}
	});
});

function addReview(){
	var params = {
		method: "addreview",
		book_isbn:$(".book-isbn").html(),
		user_id:$(".sessionId").html(),
		review_text:$("#review_text").val()
				.replace(/&/g,"&amp;")
				.replace(/</g,"&lt;")
				.replace(/>/g,"&gt;")
				.replace(/\r?\n/g,"<br>"),
		review_star: $("#review_star").val(),
		review_date:null
	};
		// alert(params.review_text);
	$.post("bookreviewchange.do",$.param(params),function(responseJson){
		changeResponse(responseJson);
	});
}

function deleteReview(clickedButton){
	var params={
		method:"deletereview",
		book_isbn:$(".book-isbn").html(),
		user_id:$(".sessionId").html(),
		review_text:clickedButton.parent().children(".review-text").html(),
		review_star:clickedButton.parent().children(".review-star").html(),
		review_date:clickedButton.parent().children(".a-color-secondary").text()
	};
		// alert(params.review_text);
	$.post("bookreviewchange.do",$.param(params),function(responseJson){
		changeResponse(responseJson);
	});
}
function changeResponse(responseJson){
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
								.append($("<div>").addClass("a-section").html(review.review_text)))
							.append($("<h4>").addClass("review-text").html(review.review_text))
							.append($("<h4>").addClass("review-star").text(review.review_star))
							.append($("<h4>").addClass("user-id").text(review.user_id))
							.append($("<input>").addClass("delete-review-button").attr({type:"button",value:"削除"}));
			});
}
