var body = document.body,
 	wishlistresult = document.querySelector('.wishlist-result'),
    overlayIs = document.querySelectorAll('i[class$="overlay"]');
// var wishlist;

[].forEach.call(overlayIs, function(i) {

	i.addEventListener('click', function() {

		var overlayOpen = this.className === 'open-overlay';

		wishlistresult.setAttribute('aria-hidden', !overlayOpen);
		body.classList.toggle('noscroll', overlayOpen);

		if(overlayOpen){
			// alert(1);
			addtofavorite();
		}
		setTimeout(function() {
		    wishlistresult.scrollTop = 0;
		}, 1000)
	}, false);

});

function addtofavorite(){
	var params={
		book_isbn:$(".book-isbn").html(),
		user_id:$(".sessionId").html()
	};
	$.post("addtofavorite.do",$.param(params),function(responseJson){
		// wishlist = responseJson;
		// alert(wishlist);
		if(responseJson=='1'){
			// alert("OK");
			$(".result1").css("display","block");
			$(".result2").css("display","none");
		}else{
			$(".result1").css("display","none");
			$(".result2").css("display","block");
		}
	})
}


