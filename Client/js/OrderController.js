function makeOrder() {
    jQuery.ajax({
        url : "localhost:8080/shopping/orders" + $("#items").val() + "/" + $("#total").val() + "/" + $("#date").val()+ "/" + $("#payement").val(),
        type : "POST",
        contentType : "application/json",
        dataType : 'json',
        success : function(data, textStatus, errorThrown) {
            // here is your json.
            // process it
           // $("#infoMsg").text("Book added sucessfully");
            alert("Book Added Successfully..!")
        },
        error : function(jqXHR, textStatus, errorThrown) {
            //$("#infoMsg").text("Sorry! Book not added!");
            alert("There is an Error in Making Order..!")
        },
        timeout : 120000,
    });
};