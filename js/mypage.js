function display(divclassname){
	$(".meminfo").css("display","none");
	$(".favorite").css("display","none");

	$("."+divclassname).css("display","block");
}

var body = document.body,
 	overlayresult = document.querySelector('.overlay-result'),
    overlayIs = document.querySelectorAll('i[class$="overlay"]');

var itag = null;
[].forEach.call(overlayIs, function(i) {

	i.addEventListener('click', function() {
		itag = this;

		var overlayOpen = this.className === 'open-overlay';

		overlayresult.setAttribute('aria-hidden', !overlayOpen);
		body.classList.toggle('noscroll', overlayOpen);

		if(overlayOpen){
			getBookInfo(this);
		}
		setTimeout(function() {
		    overlayresult.scrollTop = 0;
		}, 1000)
	}, false);

});

function getBookInfo(i){
	// alert(i.childNodes[1].alt);
	var params={
		book_isbn:i.childNodes[1].alt
		// user_id:$(".sessionId").html()
	};
	$.post("bookinfo.do",$.param(params),function(responseJson){
		$("#overlay_result_image").html("")
								.append($("<img>").attr({src:"bookimage/"+responseJson.book_isbn,width:180,height:230}));
		$("#overlay_result").html(responseJson.book_name+"<br><br>値段："+responseJson.book_price+"円<br><br>")
							.append($("<button>").text("詳細を見る")
												.attr({onclick:"window.location.href='bookinfo.do?book_isbn="+responseJson.book_isbn+"';"}))
							.append($("<br>"))
							.append($("<form>").attr({action:"addtocart.do",method:"post"})
												.append($("<input>").attr({type:"hidden",name:"user_id",value:$(".sessionId").text()}))
												.append($("<input>").attr({type:"hidden",name:"book_isbn",value:i.childNodes[1].alt}))
												.append($("<input>").attr({type:"hidden",name:"cart_amount",value:1}))
												.append($("<button>").text("カートに入れ")))
							.append("<br>")
							.append($("<button>").text("リストから消す")
												.attr({onclick:"deletefavorite()"}));
	})
}

function deletefavorite(){
	var params={
		book_isbn:itag.childNodes[1].alt,
		user_id:$(".sessionId").html()
	};
	// alert(itag);
	$.post("deleteuserfavorite.do",$.param(params),function(responseJson){
		itag.remove();
		$("#overlay_result").html("<br><br>欲しいリストから外しました<br><br>");
	})
}


