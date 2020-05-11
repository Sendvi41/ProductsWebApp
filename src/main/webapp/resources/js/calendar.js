$( document ).ready(function() {
    //Validate the numbers
    $("input").on('keypress', function(){
        // Add dash after 2 characters
        if ($(this).val().length == 2) {
            $(this).val($(this).val() + '-');
        }
        // Add dash after 5 characters
        if ($(this).val().length == 5) {
            $(this).val($(this).val() + '-');
        }
        // Delete everything after 10 characters
        if ($(this).val().length == 10) {
            $(this).val($(this).val().slice(0, -1));
        }

    });
    // Remove special characters
    $("input").on('keyup', function(){
        $(this).val($(this).val()
            .replace(/[a-zA-Z&\/\\#,+()$~%.'":*?<>{}]/g,''));
    });
});

// Insert the code above below if you want it to appear in safari

var is_safari = /^((?!chrome|android).)*safari/i.test(navigator.userAgent);
if (is_safari){
    //insert the code above here // except the document ready
}