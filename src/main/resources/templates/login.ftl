<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" href="${request.contextPath}/css/style.css">
    <link rel="shortcut icon" href="${request.contextPath}/img/1.ico">
</head>
<body>

<script src="/webjars/jquery/jquery.min.js "></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/js/mylogin.js"></script>

<section class="section">

    <!-- 登录 -->

    <div class="container">
        <div class="user singinBx">
            <div class="imgBx"><img src="${request.contextPath}/img/2.jpg" alt=""></div>
            <div class="formBx">
                <form  action="${request.contextPath}/user/login" method="post">
<#--                    <form onsubmit="return false" action="##" >-->
                    <h2>登录</h2>
                    <input type="email" name="uname" placeholder="邮箱">
                    <input type="password" name="upwd" placeholder="密码">
                    <input type="submit" value="登录" >
                    <p class="signup">没有账号？<a href="#" onclick="topggleForm();">注册</a></p>
                    <p class="signup">忘记密码？<a href="${request.contextPath}/welcome/forgetpwd" >找回密码</a></p>
                </form>
            </div>
        </div>

        <!-- 注册 -->

        <div class="user singupBx">
            <div class="formBx">
                <form action="">
                    <h2>注册</h2>
                    <input type="text" name="" placeholder="用户名">
                    <p id="message"></p>
                    <input type="email" name="" placeholder="邮箱地址">
                    <input type="password" name="" placeholder="密码">
                    <input type="password" name="" placeholder="再次输入密码">
                    <input type="submit" name="" value="注册">
                    <p class="signup">已有账号？<a href="#" onclick="topggleForm();">登录</a></p>
                </form>
            </div>
            <div class="imgBx"><img src="${request.contextPath}/img/3.jpg" alt=""></div>
        </div>


    </div>
</section>
<script type="text/javascript">
    function topggleForm(){
        var container = document.querySelector('.container');
        // var section = document.querySelector('.section');
        // section.style.backgroundImage="url(./img/3.jpg)"
        // section.style.backgroundSize="100%"
        container.classList.toggle('active');
    }
</script>
</body>
</html>