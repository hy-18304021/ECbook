var status = true;

$(document).ready(function(){
    $("#registProduct").click(function(){
        window.location.href='bookregisterform';
    });
    $("#updateProduct").click(function(){
		window.location.href='booklist';
	});
	$("#userProduct").click(function(){
		window.location.href='userlist';
	});
});