<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>忘记密码</title>
    <link rel="stylesheet" href="${request.contextPath}/css/style.css">
    <link rel="shortcut icon" href="${request.contextPath}/img/1.ico">
</head>
<body>
<script src="/webjars/jquery/jquery.min.js "></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/js/mylogin.js"></script>

<section class="section">

    <!-- 忘记密码-发送验证码 -->

    <div class="container">
        <div class="user singinBx  ">
            <div class="imgBx"><img src="${request.contextPath}/img/findpw.jpg" alt=""></div>
            <div class="formBx">
                <#--  <form></form>表单会拦截请求-->
                <form onsubmit="return false" action="##" >
                    <h2>忘记密码</h2>
                    <input type="tel"  id="forgetPhone" placeholder="手机号" onblur="forgetfindPhone()">
                    <input type="text" name="" id="code" placeholder="验证码">
                    <input type="submit" name="" id="codeButton" value="发送验证码" onclick="sendSMS()">
                <#-- 测试tosat                   <input type="submit" value="test" onclick="mytoast()">-->
                    <div class="gopasswddiv"><a href="#" onclick="topggleForm()"  class="gopasswd" > 验证</a></div>
                    <p class="signup">想起来密码？<a href="${request.contextPath}/welcome/login" >登录</a></p>
                </form>
            </div>


        </div>

        <!-- 忘记密码 -输入密码 -->

        <div class="user singupBx">

            <div class="formBx">
                <#--  <form></form>表单会拦截请求-->
                <form onsubmit="return false" action="##" >
                    <h2>输入新密码</h2>
                    <input type="password" id="registerPwd" placeholder="新密码" onkeydown="imgchange()" onblur="reimg();rePwd();" >
                    <input type="password" id="registerRePwd" placeholder="再次输入新密码" onkeydown="imgchange()" onblur="reimg();rePwd();">
                    <input type="submit" id="registerButton" value="重置密码" onclick="checkSMS()">
                    <p class="signup">已有账号？<a href="${request.contextPath}/welcome/login" >登录</a></p>
                </form>
            </div>
            <div class="imgBx"><img id="myimg" src="${request.contextPath}/img/account.png" alt="" ></div>
        </div>
    </div>
    <div id="snackbar">   默认值</div>
</section>


</body>
</html>