var changedreviewtext = null;
var changedreviewstar = null;
$(document).ready(function(){
	$(".write-review-button").click(function(){
		addReview();
	})

	$(".delete-review-button").click(function(){
		deleteReview($(this));
	})

	$(".appear-update-review-form-button").click(function(){
		changeform($(this));
		$(".update-review-button").click(function(){
			updateReview($(this));
		});
	})

	$("#review").on('DOMNodeInserted', "input", function() {
    	$(".delete-review-button").click(function(){
			deleteReview($(this));
		})
		$(".appear-update-review-form-button").click(function(){
			// var changedreviewtext = el.parent().children(".review-text").html().replace(/<br>/g,"\r\n");
			// var changedreviewstar = el.parent().children(".review-star").val();
			// 	alert(changedreviewtext);
			changeform($(this));
			$(".update-review-button").click(function(){
				updateReview($(this));
			})
		})
		$(".delete-review-button").each(function(){
			if($(this).parent().children(".user-id").html()!=$(".sessionId").html()){
				$(this).css("display","none");
			}
		})
		$(".appear-update-review-form-button").each(function(){
			if($(this).parent().children(".user-id").html()!=$(".sessionId").html()){
				$(this).css("display","none");
			}
	});

	});

	$(".delete-review-button").each(function(){
		if($(this).parent().children(".user-id").html()!=$(".sessionId").html()){
			$(this).css("display","none");
		}
	})
	$(".appear-update-review-form-button").each(function(){
		if($(this).parent().children(".user-id").html()!=$(".sessionId").html()){
			$(this).css("display","none");
		}
	})
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
		review_date:clickedButton.parent().children(".a-spacing-micro").children(".a-color-secondary").text()
	};
		// alert(params.review_date);
	$.post("bookreviewchange.do",$.param(params),function(responseJson){
		changeResponse(responseJson);
	});
}

function updateReview(clickedButton){
	if(changedreviewtext == null){
		changedreviewtext = clickedButton.parent().children(".review-text").html().replace(/<br>/g,"\r\n");
	}
	if(changedreviewstar == null){
		changedreviewstar = clickedButton.parent().children(".review-star").html().replace(/<br>/g,"\r\n");
	}
	var params={
		method:"updatereview",
		book_isbn:$(".book-isbn").html(),
		user_id:$(".sessionId").html(),
		review_text:changedreviewtext.replace(/&/g,"&amp;")
									.replace(/</g,"&lt;")
									.replace(/>/g,"&gt;")
									.replace(/\r?\n/g,"<br>"),
		review_star:changedreviewstar,
		review_date:clickedButton.parent().children(".a-spacing-micro").children(".a-color-secondary").text()
	};
		// alert(params.review_text+"\n"+params.review_star);
	$.post("bookreviewchange.do",$.param(params),function(responseJson){
		changeResponse(responseJson);
	});
}

function changeform(el){
	var $review_text = el.parent().children(".a-spacing-small").children(".a-section");
	var review_text=el.parent().children(".review-text").html().replace(/<br>/g,"\r\n");
	
	$review_text.html("")
				.append($("<textarea>").attr({col:3,row:2})
									.addClass("write-review-area")
									.html(review_text))
				.append($("<input>").attr({type:"number",min:1,max:5,required:"required",value:el.parent().children(".review-star").text()})
									.addClass("changed-review-star"));
	el.addClass("update-review-button").removeClass("appear-update-review-form-button");
	$(".write-review-area").keyup(function(){
		changedreviewtext = $(this).val();
	})
	$(".changed-review-star").keyup(function(){
		changedreviewstar =$(this).val();
		// alert(changedreviewstar);
	})
	$(".changed-review-star").change(function(){
		changedreviewstar=$(this).val();
		// alert(changedreviewstar);
	})
	return changedreviewtext;
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
								// .append($("<span>").addClass("a-size-mini a-color-state a-text-bold").text("Title"))
								.append($("<div>").addClass("a-section").html(review.review_text)))
							.append($("<h4>").addClass("review-text").html(review.review_text))
							.append($("<h4>").addClass("review-star").text(review.review_star))
							.append($("<h4>").addClass("user-id").text(review.user_id))
							.append($("<input>").addClass("appear-update-review-form-button").attr({type:"button",value:"修正"}))
							.append($("<input>").addClass("delete-review-button").attr({type:"button",value:"削除"}));
			});
}


function change(el){
	el.val(1);
}
