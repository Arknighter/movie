function loginmod() {
    let uemail = document.getElementById("uname").value;
    let upwd = document.getElementById("upwd").value;
    //console.log(uemail,upwd)
    $.ajax({
        url:"/user/login",
        type:"POST",
        data:{"email":uemail,"pwd":upwd},
        success:function (data){
            if (data.toString() == "no"){
                window.location.href="/welcome/login";
            }else {
                window.location.href="/tomain";
            }
        }

    })
}