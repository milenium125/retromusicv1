var btn_play = document.getElementById("play");
var btn_pause = document.getElementById("pause");
var medio_audio = document.getElementById("audio");
var barra_audio = document.getElementById("progress-bar");
var volumen = document.getElementById("volumen");
var mute_volumen = document.getElementById("mute");
var control_volume = document.getElementById("control-volume");
var click = 0;
function fillFrame(boton){
    content_frame = document.getElementById("content-frame");
    if(boton == "home"){
        content_frame.setAttribute("src","./home.html");
        document.getElementById("contenido").style.height = "1500px";
        document.getElementById("aside-dash").style.height = "1500px";
    }
    if(boton == "music") {
        content_frame.setAttribute("src","./music.html");
        document.getElementById("contenido").style.height = "1710px";
        document.getElementById("aside-dash").style.height = "1500px";
    } 
}

function play_pause(){
    medio_audio = document.getElementById("audio");
    var btn_play = document.getElementById("play");
    var btn_pause = document.getElementById("pause");
    if(!medio_audio.paused && !medio_audio.ended){
        btn_play.style.display = "inline";
        btn_pause.style.display = "none";
        medio_audio.pause();
    }
    else{       
        btn_play.style.display = "none";
        btn_pause.style.display = "inline";
        medio_audio.play();
        bucle = setInterval(estado, 1000);
    }
}

function estado(){
    var barra_audio = document.getElementById("progress-bar");
    time_in = document.getElementById("time-in");
    time_out = document.getElementById("time-out");
    if(!medio_audio.ended){
        total = parseInt((medio_audio.currentTime*100)/medio_audio.duration);
        barra_audio.value = total+1;
        tiempo_restante = medio_audio.duration - medio_audio.currentTime;
        time_in.innerHTML = ofSecondsToMinutes(medio_audio.currentTime);
        time_out.innerHTML = ofSecondsToMinutes(tiempo_restante);
    }
    /*
    while(medio_audio.play() == true){
        total = parseInt(medio_audio.currentTime);
        barra_audio.style.width = total;
    }*/
}
function ofSecondsToMinutes(seconds){
    var minutos = Math.floor((seconds/60));
    minutos = (minutos < 10)? "0" + minutos : minutos
    var segundos = Math.floor(seconds % 60);
    segundos = (segundos < 10)? "0"+segundos: segundos;
    return minutos+":"+segundos
}
function mostrarRange(){  
    var control_volume = document.getElementById("control-volume"); 
    if(click == 0){
        control_volume.style.display = "inline";
        click = 1;
    }
    else{
        control_volume.style.display = "none";
        click = 0; 
    }  
}
function ajustarVolume(){
    var volumen = document.getElementById("volumen");
    var mute_volumen = document.getElementById("mute");
    valor_volumen = document.getElementById("range-volume").value;
    medio_audio.volume = valor_volumen/100;
    if(valor_volumen == 0){
        volumen.style.display = "none";
        mute_volumen.style.display = "inline";
    }
    if(valor_volumen > 0){
        volumen.style.display = "inline";
        mute_volumen.style.display = "none";
    }
}
function ajustarTiempoReproduccion(){
    var barra_audio = document.getElementById("progress-bar");
    medio_audio = document.getElementById("audio");
    tiempo = (barra_audio.value * medio_audio.duration)/100;
    medio_audio.currentTime = tiempo;
}