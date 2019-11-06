//パスワード確認JS
function passwordCheckFunction(){
    var pass1 = $('#pass').val();
    var pass2 = $('#pass2').val();
    if(pass != pass2){
     $('#passwordCheckMessage').html('パスワードがちがいます。');
    }else{
     $('#passwordCheckMessage').html('');  
    }
    
   }
 
   
   