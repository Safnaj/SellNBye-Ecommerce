//Login
$(document).on("click","#OrderSubmit",function(event){
    event.preventDefault();
    var result = isValidFormLogin();
    if(result=="true"){
        $("#MakeOrder").submit();
        $("#msgLogin").hide();
    }
    else{
        //alert(result);
        $("#msgLogin").show().html(result);
    }
});

function isValidFormLogin(){
    if(($.trim($("#items").val())=="")&&($.trim($("#total").val())=="")&&($.trim($("#date").val())=="")&&($.trim($("#payement").val())=="")){
        return "Please Enter Fill the Form..!";
    }
    if($.trim($("#items").val())==""){
        return "Pls Enter Number of Items..!";
    }
    if($.trim($("#total").val())==""){
        return "Pls Enter the Total Amount..!";
    }
    if($.trim($("#date").val())==""){
        return "Pls Enter the Date..!";
    }
    if($.trim($("#payement").val())==""){
        return "Pls Enter Payement Status..!";
    }

    return "true";
}
