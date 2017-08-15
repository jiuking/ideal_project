$(function() {
    $("#register_btn").click(function() {
        $(".register_board").show();
        $(".login_board").hide();
    });
    $("#back_btn").click(function() {
        $(".register_board").hide();
        $(".login_board").show();
    });
});
$(function(){
    $("#login").click(function () {
        $.ajax({
            url:'/menuManage/login',
            data:$('#login_form').serialize(),
            type:'post',
            success:function (data) {
                // alert("成功"+data)
                window.location.href ="success"
            }
        })
    });
});