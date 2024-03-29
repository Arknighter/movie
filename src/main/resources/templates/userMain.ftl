<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">

    <title>心海</title>

    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <!-- Custom styles for this template-->
    <link href="${request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${request.contextPath}/css/usermain.css" rel="stylesheet">
</head>
<script src="/webjars/jquery/jquery.min.js "></script>
<script src="${request.contextPath}/js/usermain.js"></script>

<!-- Page Wrapper -->
<div id="wrapper" >

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${request.contextPath}/movie/findallbypage/1" >
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3" >网址首页</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <#list users! as users>
            <a class="nav-link" href="${request.contextPath}/user/findemailpro/${users.uemail!}">
                </#list>
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>个人主页</span></a>
        </li>



        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <#list users! as users>
            <a class="nav-link" href="${request.contextPath}/ucollect/tousercollect/${users.uid?c}">
                </#list>
                <i class="fas fa-fw fa-chart-area"></i>
                <span>收藏库</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">



    </ul>

    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

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
                            <#list users as users>
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small " id = "username">${users.uname}</span>
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
            <#--               中间主内容开始-->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">个人中心</h1>
                </div>
               <div class="mymessage">
                   <#list users! as users>
                       <h5>基本信息</h5>
                       <div class="mymessageID">用户id： ${users.uid?c! }</div>
                       <div class="mymessageNAME">用户名称：${users.uname!}</div>
                       <div class="mymessageEMAIL">用户邮箱：${users.uemail!}</div>
                       <div class="mymessagePHONE">用户绑定手机号：${users.uphonenumber!}</div>
                       <#if users.ustatus== 0 >
                           <div class="mymessageSTATUS">用户状态： 正常</div>
                       <#else>
                           <div class="mymessageSTATUS">用户状态： 已被注销</div>
                       </#if>
                   <#--                <div>入站时间： ${users.uregistertime!}</div>-->
                       <div class="ID" id="mymessageID" style="display: none">${users.uid?c! }</div>
                       <div class="ID" id="mymessageEMAIL" style="display: none">${users.uemail!}</div>
                   </#list>

                   <button onclick="userupdata()">修改邮箱</button>
                   <button onclick="nameupdata()">修改昵称</button>
               </div>
                <#--               <form  action="${request.contextPath}/user/login" method="post"> &lt;#&ndash; 不用ajax&ndash;&gt;-->
                <form onsubmit="return false" action="##" id="userupdata">
                    <h2>修改信息</h2>
                    <input type="email" name="uname"  id ="uname" placeholder="邮箱" onblur="updataEmail()">

                    <br/><br/>
                     <button type="button"  id="surebutton" onclick="sureupdata()" style="margin-left: 20%;">确认修改</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;

                    <button onclick="noupdata()">取消</button>
                </form>
                <form onsubmit="return false" action="##" id="nameupdata">
                    <h2>修改信息</h2>
                    <input type="email" name="uname"  id ="name" placeholder="昵称" onblur="updataName()">

                    <br/><br/>
                    <button type="button"  id="surebutton" onclick="namesure()" style="margin-left: 20%;">确认修改</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;

                    <button onclick="noupdata2()" >取消</button>
                </form>



                <#--               中间主内容-->
                <div class="row">




                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright © 心海电影 2020 by晏江海</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Sidebar -->
</div>
    <!-- Content Wrapper -->

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
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>



</body>


</html>
