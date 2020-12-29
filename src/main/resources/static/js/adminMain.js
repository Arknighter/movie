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