var username =document.getElementById("username");
var email =document.getElementById("email");
var password =document.getElementById("password");
var btn =document.getElementById("button");

btn.addEventListene('click', function(evt){
    if(password.value === ''){
        evt.preventDefault();
        return false;

    }else if(email.value === ''){
        evt.preventDefault();
        return false;
    
    }else if(username.value === ''){
        evt.preventDefault();
        return false;
    }
});