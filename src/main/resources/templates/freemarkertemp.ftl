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
            <td>id</td>
            <td>电影名称</td>
        </tr>

        <#list movielist as movielist>
            <tr>
                <td>${movielist.movieid}</td>
                <td>${movielist.movietitle}</td>
            </tr>
        </#list>
    </table>
</div>

<script src="/webjars/jquery/jquery.min.js "></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>