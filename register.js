function inputCheck(){
    if(document.register.id.value == ""){
        alter("IDを入力してください");
    }else if(document.register.pass.value == ""){
        alter("passwordを入力してください");
    }else if(document.register.tel.value == ""){
        alter("電話番号を入力してください");
    }else if(document.register.mail.value == ""){
        alter("メールアドレスを入力してください");
    }else if(document.register.sex[0].value == ""){
        alter("性別を入力してください");
    }else if(document.register.birth.value == ""){
        alter("誕生日を入力してください");
    }else{
        document.register.submit();
    }
}