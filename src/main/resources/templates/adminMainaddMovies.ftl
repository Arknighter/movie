<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">

    <title>心海</title>

    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <!-- Custom styles for this template-->
    <link href="${request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${request.contextPath}/css/adminMain.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">电影管理后台<sup>admin</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="${request.contextPath}/movie/movieCount">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>主页</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-folder"></i>
                <span>功能列表</span>
            </a>
            <div id="collapsePages" class="collapse"  >
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="${request.contextPath}/movie/toMAINUser">用户管理</a>
                    <a class="collapse-item" href="${request.contextPath}/movie/toADDmoive">添加影片信息</a>

                </div>
            </div>
        </li>

        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href="${request.contextPath}/movie/toMAINmoive/page/1">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>影片库</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">



    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
<#--            <div id="container">-->

<#--                <div class="search bar8">-->
<#--                    <form>-->
<#--                        <input type="text" id="seachtext" placeholder="请输入您要搜索的内容...">-->
<#--                        <button type="submit" >🔍</button>-->
<#--                    </form>-->
<#--                </div>-->
<#--            </div>-->
            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">


                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>
                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <!-- 用户信息 -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <!-- 登录用户名 -->
                            <#list users! as users>
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small " id = "username">${users.uname!}</span>
                            </#list>
                            <!-- 用户头像地址img-profile rounded-circle -->
                            <img class="img-profile rounded-circle" src="${request.contextPath}/img/headimg.jpg" />
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                可增加功能模块
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                登出
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid" style="display: block;">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">添加影片</h1>
                    <!-- <i class="fas fa-download fa-sm text-white-50"></i> -->
                    <p  id="Times" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> 时间模块</p>
                </div>

                <!-- Content Row -->
                <section id="main" >
                         <form style="display: block;margin-right: 100%;">
                             电影名：<input type="text" placeholder="输入电影名字" id="movietitle"/>
                             导演：<input type="text" placeholder="人名" id="moviedirector"/>
                             主演：<input type="text" placeholder="人名" id="movieaction"/>
                             图片路径：<input type="text" placeholder="不需要+https://" id="movieimgurl"/>
                             </br>
                             总分钟：<input type="text" placeholder="xxx分钟 "  id="movietime"/>
                             上映地区和时间：<input type="text" placeholder="xxxx-xx-xx(country)" id="movieuptime"/>
                             简介：<textarea style="width: 600px;height: 300px;" id="moviestory"></textarea>
                             <input type="submit" onclick="addmovie()">
                         </form>
                </section>

            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; 心海电影后台管理 2020 by晏江海</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<!-- 滚动到顶部按钮 -->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<!-- 注销模式 -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">确定退出？</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">你将会退出此界面并且回到登录界面</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
                <a class="btn btn-primary" href="${request.contextPath}/user/logout">确认</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="${request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${request.contextPath}/js/sb-admin-2.min.js"></script>
    <script src="${request.contextPath}/js/adminMain.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/jquery.min.js "></script>
    <script src="${request.contextPath}/js/echarts.min.js"></script>

<script>

    // 递归刷新系统时间
    getCode();
    function getCode(){
        i = self.setInterval("countdown()", 1000);
    }
    function countdown() {
        var myDate = new Date();
        //获取当前年
        var year=myDate.getFullYear();
        //获取当前月
        var month=myDate.getMonth()+1;
        //获取当前日
        var date=myDate.getDate();
        var h=myDate.getHours();       //获取当前小时数(0-23)
        var m=myDate.getMinutes();     //获取当前分钟数(0-59)
        var s=myDate.getSeconds();
        var now=year+'-'+getNow(month)+"-"+getNow(date)+" "+getNow(h)+':'+getNow(m)+":"+getNow(s);
        // 赋值给展示时间
        $('#Times').html(now);
    }
    // 获取当前时间
    function getNow(s) {
        return s < 10 ? '0' + s: s;
    }
</script>
</body>

</html>
