// function loginmod() {
//     let uemail = document.getElementById("uname").value;
//     let upwd = document.getElementById("upwd").value;
//     //console.log(uemail,upwd)
//     $.ajax({
//         url:"/user/login",
//         type:"POST",
//         data:{"email":uemail,"pwd":upwd},
//         success:function (data){
//             if (data.toString() == "no"){
//                 window.location.href="/welcome/login";
//             }else {
//                 window.location.href="/tomain";
//             }
//         }
//
//     })
// }






//验证邮箱重复性
function findEmail(){
    let email = $('#registerEmail').val();
    let registerButton = document.getElementById("registerButton");
    $.ajax({
        url:"/user/findemail",
        type:"POST",
        data:{"email":email},
        success: function (data) {
            if (data.toString() == "ok") {
                $('#registerEmail').css("border", "1px solid red");
                registerButton.disabled=true;
                registerButton.style.backgroundColor="#f5f5f5";

            } else {
                $('#registerEmail').css("border", "");
                registerButton.disabled=false;
                registerButton.style.backgroundColor="#677eff";
            }
        }

    })

}


//验证手机号重复性
function findPhone(){
    let phonenumber = $('#registerPhone').val();
    let registerButton = document.getElementById("registerButton");
    let x = document.getElementById("snackbar");
    if(phonenumber.length>11){
        x.className = "show";
        x.innerHTML="手机号过长";
        setTimeout(function() {
            x.className = x.className.replace("show", "");
        }, 3000);
    }

    $.ajax({
        url:"/user/findphone",
        type:"POST",
        data:{"phonenumber":phonenumber},
        success: function (data) {
            if (data.toString() == "ok") {
                $('#registerPhone').css("border", "1px solid red");
                registerButton.disabled=true;
                registerButton.style.backgroundColor="#f5f5f5";

            } else {
                $('#registerPhone').css("border", "");
                registerButton.disabled=false;
                registerButton.style.backgroundColor="#677eff";
            }
        }

    })

}


//忘记密码   页面验证手机号是否存在
function forgetfindPhone(){
    let phonenumber = $('#forgetPhone').val();
    let codeButton = document.getElementById("codeButton");

    $.ajax({
        url:"/user/findphone",
        type:"POST",
        data:{"phonenumber":phonenumber},
        success: function (data) {
            if (data.toString() == "ok") {
                $('#forgetPhone').css("border", "");
                codeButton.disabled=false;
                codeButton.style.backgroundColor="#677eff";
            } else {
                $('#forgetPhone').css("border", "1px solid red");
                codeButton.disabled=true;
                codeButton.style.backgroundColor="#f5f5f5";
            }
        }

    })

}

//发送验证码
function sendSMS() {
    let phonenumber = $('#forgetPhone').val();
    let codeButton = document.getElementById("codeButton");
    let button = document.getElementById("codeButton2");
    let x = document.getElementById("snackbar");
    $.ajax({
        url:"/user/sendSMS",
        type:"POST",
        data:{"phonenumber":phonenumber},
        success:function (data){
            if (data.toString() == "ok"){
                x.className = "show";
                x.innerHTML="发送成功";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                    codeButton.disabled=true;
                    codeButton.style.backgroundColor="#f5f5f5";
                    button.style.pointerEvents="auto";
                    button.style.backgroundColor="#677eff";
                }, 3000);
            }else {
                x.className = "show";
                x.innerHTML="发生未知错误，请刷新界面....";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                }, 3000);
            }
        }

    })

}


//注册密码核实
function rePwd() {

    let registerRePwd= document.getElementById("registerRePwd").value;
    let registerPwd= document.getElementById("registerPwd").value;
    let registerRePwdStyle = document.getElementById("registerRePwd");
    let registerButton = document.getElementById("registerButton");
    //console.log(registerRePwd,registerPwd)
    if (registerRePwd == registerPwd && registerPwd!=""){
        registerRePwdStyle.style.border="";
        registerButton.disabled=false;
        registerButton.style.backgroundColor="#677eff";
    }else{
        registerRePwdStyle.style.border="1px solid red";
        registerButton.disabled=true;
        registerButton.style.backgroundColor="#f5f5f5";
    }

}



//注册实现方法
function registerUser() {
    //$("id").value();
    let registerEmail= document.getElementById("registerEmail").value;
    let registerPhone= document.getElementById("registerPhone").value;
    let registerPwd= document.getElementById("registerPwd").value;
    let x = document.getElementById("snackbar");

    $.ajax({
        url:"/user/register",
        type:"POST",
        data:{"uemail":registerEmail,"uphonenumber":registerPhone,"pwd":registerPwd},
        success:function (data){
            if (data.toString() == "ok"){
                x.className = "show";
                x.innerHTML="成功注册 3秒后跳转至登录界面....";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                    window.location.href="/welcome/login";
                }, 3000);
            }else {
                x.className = "show";
                x.innerHTML="请输入正确信息，红色表示已经注册或者不可用....";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");

                }, 3000);
            }
        }

    })

}

// toast 测试
let mytoast = function() {
    let x = document.getElementById("snackbar");
    x.className = "show";
    x.innerHTML="成功注册 3秒后跳转至登录界面....";
    setTimeout(function() {
        x.className = x.className.replace("show", "");
        alert("login!");
    }, 3000);

};


//验证码判断
function topggleForm(){

    let code = $('#code').val();
    let container = document.querySelector('.container');
    let button = document.getElementById("codeButton2");
    let x = document.getElementById("snackbar");

    $.ajax({
        url:"/user/code",
        type:"POST",
        data:{"code":code},
        success:function (data){
            if (data.toString() == "ok"){
                button.style.pointerEvents="none";
                button.style.backgroundColor="#00CC00";
                x.className = "show";
                x.innerHTML="验证成功.... 即将跳转";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                    //切换到输入密码
                   container.classList.toggle('active');
                }, 1000);

            }else {
                x.className = "show";
                x.innerHTML="验证失败，请输入正确验证码";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                }, 3000);
            }
        }

    })


}

function imgchange(){
    //alert("1");
    document.getElementById("myimg").src='/img/password.png';
}
function reimg(){
    //  alert("2");
    document.getElementById("myimg").src='/img/account.png';
}


function checkSMS() {

    let registerPwd= document.getElementById("registerPwd").value;
    let forgetPhone = document.getElementById("forgetPhone").value;
    let x = document.getElementById("snackbar");

    $.ajax({
        url:"/user/checkSMS",
        type:"POST",
        data:{"phonenumber":forgetPhone,"pwd":registerPwd},
        success:function (data){
            if (data.toString() == "ok"){
                x.className = "show";
                x.innerHTML="更改密码成功.... 即将跳转";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                    window.location.href="/welcome/login";
                }, 1500);
            }else {
                x.className = "show";
                x.innerHTML="更改密码失败，检查账号状态或重新重置密码";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                }, 1500);
            }
        }

    })
    
}