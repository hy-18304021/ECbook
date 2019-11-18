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
				document.getElementById("result").innerHTML = xmlHttpRequest.responseText;
			} else {
				alert("HTTP error " + xmlHttpRequest.status + ": " + xmlHttpRequest.statusText);
			}
		}
	};
}

function regist(){
	var xmlHttpRequest = getXMLHttpRequest();
	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
	xmlHttpRequest.open("POST","registbook.do",true);
	xmlHttpRequest.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	var book_kind=document.getElementById("book_kind").value;
	var book_name=document.getElementById("book_name").value;
	var book_price=document.getElementById("book_price").value;
	var book_count=document.getElementById("book_count").value;
	var book_isbn=document.getElementById("book_isbn").value;
	var params = "book_kind="+book_kind
				+"&book_name="+book_name
				+"&book_price="+book_price
				+"&book_count="+book_count
				+"&book_isbn="+book_isbn;
	alert(params);
	xmlHttpRequest.send(params);
}



function findTrTagIndex(){ //by clicking button 削除
	var tag = Array.prototype.slice.call(document.getElementsByTagName('tr'));

	var thisTag = document.activeElement;
	var trTagParent = thisTag.parentNode.parentNode;

	var index = tag.indexOf(trTagParent);
	alert(index);
	return index;
}

function deleteData(){

	var index = findTrTagIndex();
	var name = document.getElementsByTagName('th')[index].innerText;

	var xmlHttpRequest = getXMLHttpRequest();
	xmlHttpRequest.onreadystatechange=getReadyStateHandler(xmlHttpRequest);
	xmlHttpRequest.open("POST","deletedata.do",true);
	xmlHttpRequest.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");

	param = 'name='+name;
	alert(param);

	//remove 'tr' row from table
	document.getElementsByTagName('tr')[index].remove();
	
	xmlHttpRequest.send(param);

}


// $(document).ready(function(){
//         $(".add-row").click(function(){
//             var name = $("#name").val();
//             var email = $("#email").val();
//             var markup = "<tr><td><input type='checkbox' name='record'></td><td>" + name + "</td><td>" + email + "</td></tr>";
//             $("table tbody").append(markup);
//         });
         
//         // Find and remove selected table rows
//         $(".delete-row").click(function(){
//             $("table tbody").find('input[name="record"]').each(function(){
//                 if($(this).is(":checked")){
//                     $(this).parents("tr").remove();
//                 }
//             });
//         });
//     });    



        // $(document).ready(function(){
        //     $("table tbody").find('button[name="delete"]').click(function(){
        //         $(this).parents("tr").remove();
        //     });
        // });
