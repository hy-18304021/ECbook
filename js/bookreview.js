var changedreviewtext = null;
var i = 0, $reviewdivs;

// var reviewstarvalue = null;
$(document).ready(function(){
	$(".write-review-button").click(function(){
		addReview($(this));
	})

	$(".delete-review-button").click(function(){
		deleteReview($(this));
		$("#writereviewwithajax").css("display","block");
		$("#written").css("display","none");
	})

	$(".appear-update-review-form-button").click(function(){
		changeform($(this));
		$(".update-review-button").click(function(){
			updateReview($(this));
		});
	})

	$("#review").on('DOMNodeInserted', "input", function() {
    	
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
		if($(this).parent().children(".user-id").html()==$(".sessionId").html()){
			$("#writereviewwithajax").css("display","none");
			$("#written").css("display","block");
			if($("#flag").html()==""){
				$("#writereviewwithajax").css("display","none");
			}
			// alert(1);
		}
		// else{
		// 	$("#writereviewwithajax").css("display","block");
		// 	$("#written").css("display","none");
		// }
	})
	$(".appear-update-review-form-button").each(function(){
		if($(this).parent().children(".user-id").html()!=$(".sessionId").html()){
			$(this).css("display","none");
		}
	})
	$(".star-image").click(function(){
		changestar($(this));
	})
	displayreview(i);
});


function addReview(clickedButton){
	if(typeof reviewstarvalue==='undefined'){
		// reviewstarvalue = 0;
		location.href = "#writereviewwithajax";
		$("#checkreview").html("レビューを更新するには全体的な評価が必要です");
		return 0;
	}
	var params = {
		method: "addreview",
		book_isbn:$(".book-isbn").html(),
		user_id:$(".sessionId").html(),
		review_text:$("#review_text").val()
				.replace(/&/g,"&amp;")
				.replace(/</g,"&lt;")
				.replace(/>/g,"&gt;")
				.replace(/\r?\n/g,"<br>"),
		// review_star: clickedButton.parent().children(".review_star").val(),
		review_star:reviewstarvalue,
		review_date:null
	};
		// alert(params.review_text+"\n"+params.review_star);
	$.post("bookreviewchange.do",$.param(params),function(responseJson){
		changeResponse(responseJson);
		i=0;
		displayreview(i);
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
		i=0;
		displayreview(i);
	});
}

function updateReview(clickedButton){
	if(changedreviewtext == null){
		changedreviewtext = clickedButton.parent().children(".review-text").html().replace(/<br>/g,"\r\n");
	}
	if(typeof reviewstarvalue === 'undefined'){
		reviewstarvalue = clickedButton.parent().children(".review-star").html();
	}
	var params={
		method:"updatereview",
		book_isbn:$(".book-isbn").html(),
		user_id:$(".sessionId").html(),
		review_text:changedreviewtext.replace(/&/g,"&amp;")
									.replace(/</g,"&lt;")
									.replace(/>/g,"&gt;")
									.replace(/\r?\n/g,"<br>"),
		review_star:reviewstarvalue,
		review_date:clickedButton.parent().children(".a-spacing-micro").children(".a-color-secondary").text()
	};
		// alert(params.review_text+"\n"+params.review_star);
	$.post("bookreviewchange.do",$.param(params),function(responseJson){
		changeResponse(responseJson);
		i=0;
		displayreview(i);
	});
}

function changeform(el){
	var $div = el.parent().children(".a-spacing-small").children(".a-section");
	var review_text=el.parent().children(".review-text").html().replace(/<br>/g,"\r\n");
	var review_star=el.parent().children(".review-star").text();
	// alert("??/");
	$div.html("")
				.append($("<textarea>").attr({col:3,row:2})
									.addClass("write-review-area")
									.html(review_text))
				.append($("<input>").attr({type:"hidden",min:1,max:5,required:"required",value: review_star})
									.addClass("changed-review-star review-star"));
	el.addClass("update-review-button").removeClass("appear-update-review-form-button");
	
	for(var i=1;i<=review_star;i++){
		$div.append($("<img>").attr({src:"starimage/star.png",alt:"review-star-"+i})
									.addClass("star-image"));
	}
	for(var i=parseInt(review_star)+1;i<=5;i++){
		$div.append($("<img>").attr({src:"starimage/emptystar.png",alt:"review-star-"+i})
									.addClass("star-image"));
	}
	$(".star-image").click(function(){
		changestar($(this));
	})
	// var stars = $div.children('.star-image');
	// stars[parseInt(el.parent().children(".review-star").text())-1].click();
	// alert("changeform");
	$(".write-review-area").keyup(function(){
		changedreviewtext = $(this).val();
	})
}

function changeResponse(responseJson){
	var $review =$("#review");
			$review.html("");
			$.each(responseJson,function(index,review){
				$("<div>").appendTo($review)
							.addClass("a-section")
							// .css("display","none")
							.append($("<hr>"))
							.append($("<h4>").text(review.user_id))
							.append($("<hr>"))
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
				if($(".sessionId").text()==review.user_id){
					$("#writereviewwithajax").css("display","none");
					// alert(review.user_id);
					$("#written").css("display","block");
				}
				// alert(review.user_id);
			})
			$(".delete-review-button").click(function(){
			deleteReview($(this));
			$("#writereviewwithajax").css("display","block");
			$("#written").css("display","none");
		})
		$(".appear-update-review-form-button").click(function(){
			changeform($(this));
			$(".update-review-button").click(function(){
				updateReview($(this));
			})
		})
}


// star iamge
function changestar(thisstar){
	if($("#checkreview").html()!=""){
		$("#checkreview").html("");
	}
	var $div=thisstar.parent();
	// var stars = $div.children(".star-image").map(function(){
		
	// })
	var stars = $div.children('.star-image');
	// alert(stars.length);
	for(var i = 0;i<stars.length;i++){
		stars[i].src="starimage/emptystar.png";
	}
	var index = stars.index(thisstar);
	// alert(index);
	for(var i = 0;i<=index;i++){
		stars[i].src="starimage/star.png";
	}
	reviewstarvalue = index+1;
	// reviewstarvalue=index+1;
	// alert(reviewstarvalue);
	return reviewstarvalue;
}


function olderreview() {
  if (i < $reviewdivs.length/4-1) {
    i++;
    displayreview(i);
  }
}

function newerreview() {
  if (i > 0) {
    i--;
    displayreview(i);
  }
}
function displayreview(i){
	// alert(i)
	$reviewdivs = $("#review").children(".a-section");
	if(i>=$reviewdivs.length/4-1){
		$(".older-review-button").css("display","none");
	}else{
		$(".older-review-button").css("display","block");
	}
	if(i==0){
	  	$(".newer-review-button").css("display","none");
	 }else{
	 	$(".newer-review-button").css("display","block");
	 }
	// alert($reviewdivs.length);
	for(var a=0;a<$reviewdivs.length;a++){
		var $review = $reviewdivs[a];
		$review.style.display = 'none';
	}
	for(var y=i*4;y<((i+1)*4);y++){
		var $review = $reviewdivs[y];
		if(typeof $review !=='undefined'){
			$review.style.display = 'block';
		}
	}
}