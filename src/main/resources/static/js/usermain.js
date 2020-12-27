$('#surebutton').attr("disabled","disabled");
function userupdata(){
    $('#userupdata').css("display","block");
    $('#surebutton').css("background","");
    $('#surebutton').val("确认修改")


}
function noupdata(){

    $('#userupdata').css("display","none");
}




function nameupdata(){
    $('#nameupdata').css("display","block");
}

function noupdata2(){
    $('#nameupdata').css("display","none");
}

function updataEmail() {
    let email = $('#uname').val();
    //console.log(email);
    $.ajax({
        url:"/user/findemail",
        type:"POST",
        data:{"email":email},
        success: function (data) {
            if (data.toString() == "ok") {
                $('#surebutton').attr("disabled","disabled");
                //$('#surebutton').css("background","red");
                $('#surebutton').val("已被使用");


            } else {
                $('#surebutton').attr("disabled",false);
                $('#surebutton').css("background","");
                $('#surebutton').val("确认修改")

            }
        }

    })
}

function sureupdata() {
    let email = $('#uname').val();
    let id = $('#mymessageID').text();
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if(email !=null && email !="" && reg.test(email)){
        $.ajax({
            url:"/user/updataemailbyid",
            type:"POST",
            data:{"email":email,"id":id},
            success: function (data) {
                if (data.toString() == "ok") {
                    alert(" 修改成功 ，请重新登录！！！");
                    window.location.href="/welcome/login";
                } else {
                    alert(" 修改未生效");

                }
            }

        })
    }else{
        alert("请输入真确邮箱格式");
    }


}


function namesure() {
    let name = $("#name").val();
    let email = $('#mymessageEMAIL').text();
    let id = $('#mymessageID').text();

    $.ajax({
        url:"/user/updataenamebyid",
        type:"POST",
        data:{"email":email,"name":name,"id":id},
        success: function (data) {
            if (data.toString() == "ok") {
                alert("修改成功！");
                window.location.href="/user/findemailpro/"+email;
            } else {
                alert("修改失败！");
                window.location.href="/user/findemailpro/"+email;
            }
        }

    })

}