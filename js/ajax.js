function getXMLHttpRequest() {
	var xmlHttpReq = false;
	// to create XMLHttpRequest object in non-Microsoft browsers
	if (window.XMLHttpRequest) {
		xmlHttpReq = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			// to create XMLHttpRequest object in later versions
			// of Internet Explorer
			xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (exp1) {
			try {
				// to create XMLHttpRequest object in older versions
				// of Internet Explorer
				xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (exp2) {
				xmlHttpReq = false;
			}
		}
	}
	return xmlHttpReq;
}
/*
 * Returns a function that waits for the state change in XMLHttpRequest
 */
function getReadyStateHandler(xmlHttpRequest) {

	// an anonymous function returned
	// it listens to the XMLHttpRequest instance
	return function() {
		if (xmlHttpRequest.readyState == 4) {
			if (xmlHttpRequest.status == 200) {
				document.getElementById("review").innerHTML = this.responseText;
			} else {
				alert("HTTP error " + xmlHttpRequest.status + ": " + xmlHttpRequest.statusText);
			}
		}
	};
}
// $(document).ready(function(){
// 	$(".changebutton").click(function(){
// 	 	var book_isbn = $(".book_isbn").html();
// 		var user_id = $(".sessionId").html();
// 		var review_text = $(this).parent().parent().children(".review-text").html();
// 		var review_star = $(this).parent().parent().children(".review-star").html();
// 		var review_date = $(this).parent().parent().children(".review-date").html();

// 		var params ="";

// 		alert($(this).parent().parent().children(".review-text").html());
// 	});
// });


// book regist
// function regist(){
// 	var book_kind=document.getElementById("book_kind").value;
// 	var book_name=document.getElementById("book_name").value;
// 	var book_price=document.getElementById("book_price").value;
// 	var book_count=document.getElementById("book_count").value;
// 	var book_isbn=document.getElementById("book_isbn").value;
// 	var book_image=document.getElementById("book_image").value;
// 	var params = "book_kind="+book_kind
// 				+"&book_name="+book_name
// 				+"&book_price="+book_price
// 				+"&book_count="+book_count
// 				+"&book_isbn="+book_isbn
// 				+"&book_image="+book_image;
// 	alert(params);

// 	var xmlHttpRequest = getXMLHttpRequest();
// 	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
// 	xmlHttpRequest.open("POST","registbook.do",true);
// 	xmlHttpRequest.setRequestHeader("Content-Type",
// 			"application/x-www-form-urlencoded");
// 	xmlHttpRequest.send(params);
// }



// function findTrTagIndex(){ //by clicking button 削除 or 修正
// 	var tag = Array.prototype.slice.call(document.getElementsByTagName('tr'));

// 	var thisTag = document.activeElement;
// 	var trTagParent = thisTag.parentNode.parentNode;

// 	var index = tag.indexOf(trTagParent);
// 	alert(index);
// 	return index;
// }


// // delete book or user
// function deleteData(){
// 	var index = findTrTagIndex();
// 	var data = document.getElementsByTagName('th')[index].innerText;
// 	param = 'data='+data;
// 	alert(param);

// 	var xmlHttpRequest = getXMLHttpRequest();
// 	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
// 	xmlHttpRequest.open("POST","deletedata.do",true);
// 	xmlHttpRequest.setRequestHeader("Content-Type",
// 			"application/x-www-form-urlencoded");
// 	xmlHttpRequest.send(param);

// 	//remove 'tr' row from table
// 	document.getElementsByTagName('tr')[index].remove();
// }


//find bookisbn
function appear(){
	appearUpdateForm();
	var index = findTrTagIndex();
	isbn = document.getElementsByTagName('th')[index].innerText;
	document.getElementById("book_isbn").value;
	return isbn;
}

//make updated form appear
function appearUpdateForm(){
	document.getElementById("update").style.display='block';
}

//make updated form disappear
function disappear(){
	document.getElementById("update").style.display='none';
}

// // update book
// function updateBookData(){
// 	var book_kind=document.getElementById("book_kind").value;
// 	var book_name=document.getElementById("book_name").value;
// 	var book_price=document.getElementById("book_price").value;
// 	var book_count=document.getElementById("book_count").value;
// 	var book_image=document.getElementById("book_image").value;
// 	var params = "book_kind="+book_kind
// 				+"&book_name="+book_name
// 				+"&book_price="+book_price
// 				+"&book_count="+book_count
// 				+"&book_isbn="+isbn
// 				+"&book_image="+book_image;
// 	alert(params);

// 	var xmlHttpRequest = getXMLHttpRequest();
// 	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
// 	xmlHttpRequest.open("POST","updatebook.do",true);
// 	xmlHttpRequest.setRequestHeader("Content-Type",
// 			"application/x-www-form-urlencoded");
// 	xmlHttpRequest.send(params);
// 	location = location;
// }

// function updateUserData(){
// 	var name=document.getElementById("name").value;
// 	var pass=document.getElementById("pass").value;
// 	var mail=document.getElementById("mail").value;
// 	var birth=document.getElementById("birth").value;
// 	var sex=document.getElementById("sex").value;
// 	var params = "name="+name
// 				+"&pass="+pass
// 				+"&mail="+mail
// 				+"&sex="+sex
// 				+"&birth="+birth;
// 	alert(params);

// 	var xmlHttpRequest = getXMLHttpRequest();
// 	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
// 	xmlHttpRequest.open("POST","updateuser.do",true);
// 	xmlHttpRequest.setRequestHeader("Content-Type",
// 			"application/x-www-form-urlencoded");
// 	xmlHttpRequest.send(params);
// 	// location = location;
// }


// function updateUserCart(user_id){
// 	var index = findTrTagIndex();
// 	var book_isbn = document.getElementsByTagName("th")[index].innerText;
// 	var cart_amount = document.getElementsByName("cart_amount")[index].value;
// 	var param = "user_id="+user_id
// 				+"&book_isbn="+book_isbn
// 				+"&cart_amount="+cart_amount;
// 	alert(param);

// 	var xmlHttpRequest = getXMLHttpRequest();
// 	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
// 	xmlHttpRequest.open("POST","updateusercart.do",true);
// 	xmlHttpRequest.setRequestHeader("Content-Type",
// 			"application/x-www-form-urlencoded");
// 	xmlHttpRequest.send(param);
// }
// // remove book from cart

// // function takeBookTable(){
// // 	alert("TakeBookTable");
// // 	var xmlHttpRequest = getXMLHttpRequest();
// // 	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
// // 	xmlHttpRequest.open("GET","takebooktable.do",true);
// // 	// xmlHttpRequest.setRequestHeader("Content-Type",
// // 	// 		"application/x-www-form-urlencoded");
// // 	xmlHttpRequest.send();
// // }


