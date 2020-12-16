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


<section class="section">

    <!-- 忘记密码-发送邮件 -->

    <div class="container">
        <div class="user singinBx  ">
            <div class="imgBx"><img src="${request.contextPath}/img/findpw.jpg" alt=""></div>
            <div class="formBx">
                <form action="">
                    <h2>忘记密码</h2>
                    <p>通过短信找回你的密码（需要连接互联网)</p>
                    <input type="email" name="" placeholder="邮箱地址">
                    <input type="text" name="" placeholder="验证码">
                    <input type="submit" name="" value="发送验证码">
                    <div class="gopasswddiv"><a href="#" onclick="topggleForm()"  class="gopasswd" > 验证</a></div>
                    <p class="signup">想起来密码？<a href="${request.contextPath}/welcome/login" >登录</a></p>
                </form>
            </div>


        </div>

        <!-- 忘记密码 -输入密码 -->

        <div class="user singupBx">

            <div class="formBx">
                <form action="">
                    <h2>输入新密码</h2>
                    <input type="password" name="" placeholder="新密码" onkeydown="imgchange()" onblur="reimg()" >
                    <input type="password" name="" placeholder="再次输入新密码" onkeydown="imgchange()" onblur="reimg()">
                    <input type="submit" name="" value="重置密码">
                    <p class="signup">已有账号？<a href="${request.contextPath}/welcome/login" >登录</a></p>
                </form>
            </div>
            <div class="imgBx"><img id="myimg" src="${request.contextPath}/img/account.png" alt="" ></div>
        </div>
    </div>
</section>
<script type="text/javascript">
    function topggleForm(){
        var container = document.querySelector('.container');
        container.classList.toggle('active');
    }

    function imgchange(){
        //alert("1");
        document.getElementById("myimg").src='${request.contextPath}/img/password.png';
    }
    function reimg(){
        //  alert("2");
        document.getElementById("myimg").src='${request.contextPath}/img/account.png';
    }
</script>

</body>
</html>