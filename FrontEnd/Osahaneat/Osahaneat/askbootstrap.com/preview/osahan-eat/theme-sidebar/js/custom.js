$(document).ready(function () {
    $("#btn-signin").click(function(){

        var email = $("#email").val()
        var password = $("#password").val()
        $.ajax({
            method: "POST",
            url: "http://localhost:8083/login/signin",
            data: {
                username: email,
                password: password
                 }
        })
        //msg đại diện cho giá trị backend trả ra
            .done(function (msg) {
                console.log(msg)
               if(msg.success){
                localStorage.setItem("token", msg.data)
                    window.location.href = './index.html'
               }else{          
                alert("Failure")
               }
            });
    })


}) 