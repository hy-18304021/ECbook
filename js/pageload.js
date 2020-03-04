$(document).ready(function(){
    var flag=document.getElementById("flag").innerText;
    if(flag=="OK"){
        document.getElementById("loginli").style.display='none';
    }else{
        document.getElementById("logoutli").style.display='none';
        document.getElementById("mypage").style.display='none';
        document.getElementById("mycart").style.display='none';
        // document.getElementById("writereviewwithajax").style.display='none';
    }
});

