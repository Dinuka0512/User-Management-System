///////////////////////////////////
///## FORM CONTAINER OPEN AND CLOSE
///////////////////////////////////

var formContainer = $("#formContainer");
var saveUser = $("#saveUser");
var isformNotSeen = true;
saveUser.on("click", function () {
    if(isformNotSeen === true){
        formContainer.css("display", "block");
        isformNotSeen = false;
    }else{
        formContainer.css("display", "none");
        isformNotSeen = true;
    }
})