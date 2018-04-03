$(document).ready(function(){
    $("#btn1").click(function(){
        $("p").append(" <b>Ahoy jQuery World!</b>.");
        });
        $("#btn2").click(function(){
        $("p").html("<b>Everyone walk ye plank!</b>");
    }); 
});