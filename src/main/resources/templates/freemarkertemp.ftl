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
            <td>电影详情</td>
            <td>电影标签id</td>
            <td>电影时长</td>
            <td>电影上映时间</td>
        </tr>

        <#list movielist as movielist>
            <tr>
                <td>${movielist.movieid}</td>
                <td>${movielist.movietitle}</td>
                <td>${movielist.moviestory}</td>
                <td>${movielist.movietid}</td>
                <td>${movielist.movietime}</td>
                <td>${movielist.movieuptime}</td>
            </tr>
        </#list>
    </table>
</div>

<script src="/webjars/jquery/jquery.min.js "></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>