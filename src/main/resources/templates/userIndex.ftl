<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="referrer" content="no-referrer"><#--    解决图片403xx不显示等问题-->
    <title>电影主界面</title>
    <link rel="stylesheet" href="${request.contextPath}/css/other.css">
    <link rel="stylesheet" href="${request.contextPath}/css/moviemaim.css">
</head>
<script src="/webjars/jquery/jquery.min.js "></script>
<script src="${request.contextPath}/js/flexible.js"></script>
<script src="${request.contextPath}/js/main.js"></script>
<body onload="Mainlogin()" >

<#--<div class="TIME">-->
<#--    <div class="notlogin" onclick="notlogin()" id="notlogin">notlogin</div>-->
<#--    <div class="loginBAS" onclick="loginBAS()" id="loginBAS">loginBAS</div>-->
<#--    <div class="loginMAIN" onclick="unloginMAIN()">unloginMAIN</div>-->
<#--    <div class="loginMAIN" onclick="loginMAIN()" id="loginMAIN">loginMAIN</div>-->
<#--</div>-->
<div class="Main"  >
    <!-- 顶部模块 -->
    <section class="top">
        <a href="${request.contextPath}/movie/findallbypage/1"><div class="logo"></div></a>
        <div class="seach"></div>
        <div class="unloginuserBox" id="unloginuserBox">
            <div class="unloginuser">不限时效的节目和电影</div>
            <a href="${request.contextPath}/welcome/login"><div class="register">立刻加入</div></a>
            <a href="${request.contextPath}/welcome/login"><div class="login">登录</div></a>
        </div>

        <div class="loginuserBox" id="loginuserBox">
            <#list users! as users>
                <div id="usersid" name="usersid" style="display: none">${users.uid?c!}</div>
            <div class="username" id="username">欢迎你,${users.uname!}</div>

            <div class="loginuser"  onclick="userConter()" onclick="ConterDie()"></div>
        </div>
        <div class="userConter" id="userConter" onMouseOver="userConter()" onMouseOut="ConterDie()" >
            <a href="${request.contextPath}/user/findemailpro/${users.uemail!}"><div class="userSpace">个人中心</div></a>
            </#list>
<#--            <a href="${request.contextPath}/tousermain"><div class="userSpace">个人中心</div></a>-->
            <a href="${request.contextPath}/user/logout"><div class="loginOut">切换登录</div></a>
        </div>
    </section>

    <!-- 影片详情模块 -->
    <#list movies! as movies>
    <section class="bodymain" id="bodymain">
        <div class="movieimg" id="movieimg" >
            <div class="bgfilter">
                <div id="mname" style="display:none;">${movies.movietitle!}</div>
                <div class="moviename" id="moviename">   <h6>电影</h6>  ${movies.movietitle!}</div>
                <div class="movieMsg">
                    <div class="movieYear" id="movieYear">${movies.movieuptime!}</div>
                    <div class="movieTime">${movies.movietime!}</div>
<#--                    <div class="movieTag">爱情</div>-->
                </div>
                <!-- 电影详情 -->
                <div class="movieDetails">${movies.moviestory!}</div>
                <div class="movielead">人员：
                    <h6>导演：${movies.moviedirector!}</h6>
                </div>
            </div>
            <div class="moviebg" ></div>
            <div class="imgBottuon" id="imgBotton" style="position: absolute;
  bottom: -1.325rem;
  width: 86%;
  height: 0.7rem;
  margin-left: 7%;
  margin-right: 7%;
  background-image: -webkit-gradient(linear, left top, right top, color-stop(5%, #333), color-stop(95%, #181818));">
                    <h6 id="imgBottonMSG1" style="display: inline-block;
  text-align: left;
  margin-left: 2%;
  line-height: 0.7rem;
  font-size: 0.3rem;
  color: white;">即刻观看</h6>
                    <a href="${request.contextPath}/welcome/login"><div class="register" id="imgBottonMSG2" style="position: absolute;
  height: 0.45rem;
  width: 1.25rem;
  right: 5%;
  top: 0;
  margin-top: 0.6%;
  text-align: center;
  line-height: 0.45rem;
  color: white;
  background-color: #e50914;">立刻加入</div></a>

            </div>
            <div class="imgBotton2" style="display: none" id="imgBotton2">
                <#if users??>
                    <#if collectList??&&(collectList?size>0)>
                        <#list collectList as collectList>
                            <#list users! as users>
                                <#if collectList.uid?c ==users.uid?c>
                                    <h6 id="imgBottonMSG1">立刻收藏</h6>
                                    <div class="register" id="imgBottonMSG2" onclick="delc(${movies.movieid})">取消收藏</div>

                                </#if>
                            </#list>
                        </#list>
                        <#else >
                            <h6 id="imgBottonMSG1">立刻收藏</h6>
                            <div class="register" id="imgBottonMSG2" onclick="addc(${movies.movieid})">收藏</div>
                    </#if>


                </#if>


<#--                <#if users?? >-->
<#--                    <#list collectList as collectList>-->
<#--                        <#if collectList.uid == Session.users.uid>-->
<#--                            <div class="register" id="imgBottonMSG2" >已收藏</div>-->
<#--                            <#else >-->
<#--                                <div class="register" id="imgBottonMSG2" onclick="addc(${movies.movieid})">收藏</div>-->
<#--                        </#if>-->
<#--                    </#list>-->
<#--                </#if>-->

            </div>
        </div>

        <!-- 图片详情下面的模块 -->
        <div class="aboutMovie">
            <div class="msg">
                <p>资讯 ｜ </p>
                <p class="msgMovieName">${movies.movietitle!}</p>
                <span class="msgMovie">
                        * NO MASSAGE
                    </span>
            </div>

        </div>
    </section>
    </#list>


<#--    <!-- 影片详情模块备份 &ndash;&gt;-->
<#--    <section class="bodymain" id="bodymain">-->
<#--        <div class="movieimg" id="movieimg" >-->
<#--            <div class="bgfilter">-->

<#--                <div class="moviename" id="moviename">   <h6>电影</h6>  想哭的我戴上了猫的面具</div>-->
<#--                <div class="movieMsg">-->
<#--                    <div class="movieYear">2020</div>-->
<#--                    <div class="movieTime">1小时32分</div>-->
<#--                    <div class="movieTag">爱情</div>-->
<#--                </div>-->
<#--                <!-- 电影详情 &ndash;&gt;-->
<#--                <div class="movieDetails">一名古怪的女孩為了吸引心儀對象的目光，居然變成了一隻貓！但在不知不覺間，人類與動物之間的界線卻開始越來越模糊。</div>-->
<#--                <div class="movielead">主演：-->
<#--                    <h6>主演A</h6> ，-->
<#--                    <h6>主演B</h6> ，-->
<#--                </div>-->
<#--            </div>-->
<#--            <div class="moviebg"></div>-->
<#--            <div class="imgBotton">-->
<#--                <h6 id="imgBottonMSG1">即刻观看</h6>-->
<#--                <a href="${request.contextPath}/welcome/login"><div class="register" id="imgBottonMSG2">立刻加入</div></a>-->
<#--            </div>-->
<#--        </div>-->

<#--        <!-- 图片详情下面的模块 &ndash;&gt;-->
<#--        <div class="aboutMovie">-->
<#--            <div class="msg">-->
<#--                <p>资讯 ｜ </p>-->
<#--                <p class="msgMovieName">想哭的我戴上了猫的面具</p>-->
<#--                <span class="msgMovie">-->
<#--                        * NO MASSAGE-->
<#--                    </span>-->
<#--            </div>-->

<#--        </div>-->
<#--    </section>-->

    <!-- 主界面模块 -->
    <section class="moviesBody" id="moviesBody">
<#--        <!-- 轮播图 &ndash;&gt;-->
<#--        <div class="autoimg"></div>-->
        <!-- 主体全部影片展示  30个-->
        <div class="moviesmain">

            <#list movielist! as movielist>
            <span>
                    <a href="${request.contextPath}/movie/main/${movielist.movieid!}" ><div class="moviesMainImg" style=" background-size: 100%; background-image: url('https://${movielist.movieimgurl}') "></div></a>
                    <div class="moviesMainName">${movielist.movietitle!}</div>
                    <div id="movieid" style="display: none">${movielist.movieid!}</div>
            </span>
            </#list>

<#--                <#assign x=0 />-->
<#--                <#list movielist as movielist>-->
<#--                <span>-->
<#--                    <a href="#"><div class="moviesMainImg" style=" background-size: 100%; background-image: url('https://${movielist.movieimgurl}') "></div></a>-->
<#--                    <div class="moviesMainName">${movielist.movietitle}</div>-->
<#--                    <div id="movieid" style="display: none">${movielist.movieid}</div>-->
<#--                <#assign x=x+1 />-->
<#--                </span><#if x == 30> <#break> </#if>-->
<#--                </#list>-->



        </div>
        <div style="position:relative;bottom: 30%;" id="pagediv">
            <#if nowpage?? >
                <#if nowpage! == 1>
                    <a  id="leftpage" href="#" style="float: left;color: white;font-size: 80px;text-decoration: none;" > < </a>
                    <#else >
                        <a id="leftpage" href="${request.contextPath}/movie/findallbypage/${nowpage-1}" style="float: left;color: white;font-size: 80px;text-decoration: none; " > < </a>
                </#if>
                <#if nowpage! == num>
                    <a href="#" id="rightpage" style="float: right; color: white;font-size: 80px;text-decoration: none;"> ></a>
                <#else >
                    <a href="${request.contextPath}/movie/findallbypage/${nowpage+1}" id="rightpage" style="float: right; color: white;font-size: 80px;text-decoration: none;"> ></a>
                </#if>
            </#if>
<#--            <a href="${request.contextPath}/movie/findallbypage/1" style="float: left;color: white;font-size: 60px;text-decoration: none;"> < </a>-->
<#--            <a href="${request.contextPath}/movie/findallbypage/2" style="float: right; color: white;font-size: 60px;text-decoration: none;"> ></a>-->
        </div>

    </section>


    <div class="aboutme">
        Copyright © 心海电影 2020 by晏江海
    </div>
</div>

<script>
    // document.getElementById('moviename').innerHTML=('<h6>电影</h6>  狼的孩子雨和雪');
    function addc(mid) {
        let uid =$('#usersid').html();
        let mname =$('#mname').html();
        //console.log(uid);
        $.ajax({
            url:"/ucollect/addc/"+mid+"/"+uid+"/"+mname,
            type:"POST",
            success: function (data) {
                if (data.toString() == "ok") {
                        alert("收藏成功");
                    window.location.href="/movie/main/"+mid;

                } else {
                    alert("请登录");
                }
            }

        })
    }

    function delc(mid) {
        $.ajax({
            url:"/ucollect/delc/"+mid,
            type:"POST",
            success: function (data) {
                if (data.toString() == "ok") {
                    alert("取消收藏成功");
                    window.location.href="/movie/main/"+mid;

                } else {
                    alert("请登录");
                }
            }

        })

    }
</script>
</body>

</html>