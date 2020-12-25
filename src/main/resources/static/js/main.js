

// 控制点击头像动画
function userConter(){
    document.getElementById("userConter").style.display = "block";
    
}
function ConterDie(){
    document.getElementById("userConter").style.display = "none";
}

//影片详情页面展示 没有登录
function notlogin(){
    document.getElementById("bodymain").style.display="block" ;//显示
    document.getElementById("unloginuserBox").style.display="block" ; //显示
    document.getElementById("loginuserBox").style.display="none" ; //不显示
    document.getElementById("userConter").style.display="none" ; //不显示

    document.getElementById("imgBottonMSG1").innerText="即刻观看"; //即刻观看
    document.getElementById("imgBottonMSG2").innerText="立刻加入"; //立刻加入

    document.getElementById("moviesBody").style.display="none";//不显示
}

 //影片详情页面展示 登录后--------------------------------------
function loginBAS(){
 
        document.getElementById("bodymain").style.display="block"; //显示
        document.getElementById("unloginuserBox").style.display="none"; //不显示
        document.getElementById("loginuserBox").style.display="block"; //显示
        //document.getElementById("userConter").style.display="block"; //显示

        document.getElementById("imgBottonMSG1").innerText="收藏电影"; //收藏电影
        document.getElementById("imgBottonMSG2").innerText="收藏"; //收藏

        document.getElementById("moviesBody").style.display="none";//不显示
}

//主界面全部影片界面 登录后--------------------------------------
function loginMAIN(){
    document.getElementById("bodymain").style.display="block"; //显示
    document.getElementById("unloginuserBox").style.display="none"; //不显示
    document.getElementById("loginuserBox").style.display="block"; //显示
   // document.getElementById("userConter").style.display="block"; //显示

    document.getElementById("bodymain").style.display="none" ;//不显示
    document.getElementById("moviesBody").style.display="block";//显示
}
//主界面全部影片界面 没有登录--------------------------------------
function unloginMAIN(){
    document.getElementById("bodymain").style.display="block" ;//显示
    document.getElementById("unloginuserBox").style.display="block" ; //显示
    document.getElementById("loginuserBox").style.display="none" ; //不显示
    document.getElementById("userConter").style.display="none" ; //不显示

    document.getElementById("bodymain").style.display="none" ;//不显示
    document.getElementById("moviesBody").style.display="block";//显示
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
