

// window.onload = function(){
function Mainlogin(){
    //console.log($('#usersid').html());
    if($('#usersid').html() != null){
        loginMAIN();
    }
    //console.log($('#movieYear').html());
    if($('#movieYear').html() != null){
        notlogin();
        if($('#usersid').html() != null){
            loginBAS();
        }

    }

}


//ajax login
function ajaxlogin(){
    let phone= $('#uname').val();
    let pwd = $('#upwd').val();
    let x = document.getElementById("snackbar");
    $.ajax({
        url:"/user/loginajax",
        type:"POST",
        data:{"uphonenumber":phone,"pwd":pwd},
        success: function (data) {
            if (data.toString() == "admin") {
                x.className = "show";
                x.innerHTML="欢迎你，管理员";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                    window.location.href="/movie/movieCount";
                }, 1500);


            }else if(data.toString() == "user"){
                x.className = "show";
                x.innerHTML="欢迎回来";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                    window.location.href="/movie/findallbypage/1";

                }, 1500);
                //document.getElementById("loginMAIN").click();

            }
            else if(data.toString() == "no"){
                window.location.href="/welcome/login";
            }
        }

    })
}



// 控制点击头像动画
function userConter(){
    document.getElementById("userConter").style.display = "block";
    
}
function ConterDie(){
    document.getElementById("userConter").style.display = "none";
}

//影片详情页面展示 没有登录
function notlogin(){
    $('#bodymain').css("display","block");
    $('#unloginuserBox').css("display","block");
    $('#loginuserBox').css("display","none");
    $('#userConter').css("display","none");
    $('#imgBottonMSG1').html("即刻观看");
    $('#imgBottonMSG2').html("立刻加入");
    $('#moviesBody').css("display","none");

    $('#imgBotton2').css("display","none");
    // document.getElementById("bodymain").style.display="block" ;//显示
    // document.getElementById("unloginuserBox").style.display="block" ; //显示
    // document.getElementById("loginuserBox").style.display="none" ; //不显示
    // document.getElementById("userConter").style.display="none" ; //不显示
    //
    // document.getElementById("imgBottonMSG1").innerText="即刻观看"; //即刻观看
    // document.getElementById("imgBottonMSG2").innerText="立刻加入"; //立刻加入
    //
    // document.getElementById("moviesBody").style.display="none";//不显示
}

 //影片详情页面展示 登录后--------------------------------------
function loginBAS(){

    $('#bodymain').css("display","block");
    $('#unloginuserBox').css("display","none");
    $('#loginuserBox').css("display","block");
    $('#imgBottonMSG1').html("收藏电影");
    $('#imgBottonMSG2').html("收藏");
    $('#moviesBody').css("display","none");

    $('#imgBotton').css("display","none");
    $('#imgBotton2').css("display","block");
        // document.getElementById("bodymain").style.display="block"; //显示
        // document.getElementById("unloginuserBox").style.display="none"; //不显示
        // document.getElementById("loginuserBox").style.display="block"; //显示
        //
        // document.getElementById("imgBottonMSG1").innerText="收藏电影"; //收藏电影
        // document.getElementById("imgBottonMSG2").innerText="收藏"; //收藏
        //
        // document.getElementById("moviesBody").style.display="none";//不显示
}

//主界面全部影片界面 登录后--------------------------------------
function loginMAIN(){
    $('#bodymain').css("display","block");
    $('#unloginuserBox').css("display","none");
    $('#loginuserBox').css("display","block");
    $('#bodymain').css("display","none");
    $('#moviesBody').css("display","block");
    // document.getElementById("bodymain").style.display="block"; //显示
    // document.getElementById("unloginuserBox").style.display="none"; //不显示
    // document.getElementById("loginuserBox").style.display="block"; //显示
    //
    // document.getElementById("bodymain").style.display="none" ;//不显示
    // document.getElementById("moviesBody").style.display="block";//显示
}
//主界面全部影片界面 没有登录--------------------------------------
function unloginMAIN(){

    $('#bodymain').css("display","block");
    $('#unloginuserBox').css("display","block");
    $('#loginuserBox').css("display","none");
    $('#userConter').css("display","none");
    $('#bodymain').css("display","none");
    $('#moviesBody').css("display","block");
    // document.getElementById("bodymain").style.display="block" ;//显示
    // document.getElementById("unloginuserBox").style.display="block" ; //显示
    // document.getElementById("loginuserBox").style.display="none" ; //不显示
    // document.getElementById("userConter").style.display="none" ; //不显示
    //
    // document.getElementById("bodymain").style.display="none" ;//不显示
    // document.getElementById("moviesBody").style.display="block";//显示
}
  


//影片详情页面展示 没有登录--------------------------------------
// document.getElementById("bodymain"); //显示
// document.getElementById("unloginuserBox"); //显示
// document.getElementById("loginuserBox"); //不显示
// document.getElementById("userConter"); //不显示

// document.getElementById("imgBottonMSG1"); //即刻观看
// document.getElementById("imgBottonMSG2"); //立刻加入

//影片详情页面展示 登录后--------------------------------------
// document.getElementById("bodymain"); //显示
// document.getElementById("unloginuserBox"); //不显示
// document.getElementById("loginuserBox"); //显示
// document.getElementById("userConter"); //显示

// document.getElementById("imgBottonMSG1"); //收藏电影
// document.getElementById("imgBottonMSG2"); //收藏


//主界面全部影片界面--------------------------------------
//document.getElementById("moviesBody");//显示
