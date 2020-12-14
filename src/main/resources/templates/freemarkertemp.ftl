<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <td>名字</td>
            <td>邮箱</td>
            <td>密码</td>
        </tr>

        <#list users as users>
            <tr>
                <td>${users.uname}</td>
                <td>${users.uemail}</td>
                <td>${users.upassword}</td>
            </tr>
        </#list>
    </table>
</div>

<script src="/webjars/jquery/jquery.min.js "></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>