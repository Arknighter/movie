function sureUpmovie(id) {
       let title =  $('#title').val();
        let url =  $('#url').val();
        let textarea =  $('#textarea').val();
        let uptime =  $('#uptime').val();
        let director =  $('#director').val();
       // alert(title+url+textarea+uptime+director);
        $.ajax({
                url:"/movie/update",
                type:"POST",
                data:{"id":id,"story":textarea,"url":url,"title":title,"uptime":uptime,"director":director,},
                success: function (data) {
                        if (data.toString() == "ok") {
                               alert("更新成功");
                                window.location.href="/movie/toMAINmoive/page/1";

                        } else {
                                alert("更新失败");
                                window.location.href="/movie/toMAINmoive/page/1";
                        }
                }

        })
}


function userSerch() {
    //alert($('#adminUserSeachText').val());
    //console.log("/user/likepage/"+$('#adminUserSeachText').val()+"/1");
    if($('#adminUserSeachText').val()!=""){
        window.location.href="/user/likepage/"+$('#adminUserSeachText').val()+"/1";
    }

}

function movieseach() {
    if($('#Movieseachtext').val()!=""){
        window.location.href="/movie/likemoive/"+$('#Movieseachtext').val()+"/1";
    }
}

function addmovie() {
   let movietitle= $('#movietitle').val();
   let moviedirector=$('#moviedirector').val();
   let movieaction=$('#movieaction').val();
   let movieimgurl= $('#movieimgurl').val();
   let movietime= $('#movietime').val();
   let movieuptime= $('#movieuptime').val();
   let moviestory= $('#moviestory').val();
    $.ajax({
        url:"/movie/addmovies",
        type:"POST",
        data:{"movietitle":movietitle,"moviedirector":moviedirector,"movieaction":movieaction
            ,"movieimgurl":movieimgurl,"movietime":movietime,"movieuptime":movieuptime,"moviestory":moviestory},
        success: function (data) {
            if (data.toString() == "ok") {
                alert("添加成功");

                window.location.href="/movie/toMAINmoive/page/1";
            } else {
               alert("添加失败");
                window.location.href="/movie/toMAINmoive/page/1";
            }
        }

    })
   // alert(movietitle+moviedirector+movieaction+movieimgurl+movietime+movieuptime+moviestory);
}