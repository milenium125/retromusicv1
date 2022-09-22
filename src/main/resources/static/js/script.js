var click = 0;
let sub_pagina = "http://localhost:8080/cancion_form";
let sub_pagina_canciones = "http://localhost:8080/recientes"; 
let validar_blur;
let validar_click;
let url_cancion;
let id_anterior;
let id_actual;
let pag_home ='<div class="contenido-home bg-white">'+
'<div class="space-artist">'+
  '<div class="title-artist">'+
    '<h2>Artistas</h2>'+
  '</div>'+
  '<div class="artist-content p-2" id="contenido-artistas">'+
    '<!--'+ 
    '<div class="card-artist m-4">'+
      '<div class="imagen-artista">'+
        '<img src="./images/vita-libre.jfif" alt="conteo" class="imagen rounded-circle">'+
      '</div>'+
      '<div class="info-song">'+
        '<span>Franco de Vita</span><br>'+
        '<span>1,967,187 fans</span>'+
      '</div>'+
    '</div> -->'+
  '</div>'+
  '<div class="ver-mas d-flex justify-content-end">'+
    '<a class="pe-5 text-decoration-none text-black" onclick="mostrar_todos_artistas()" style="cursor:pointer;">Ver más...</a>'+
  '</div>'+
'</div>'+
'<div class="space-genre">'+
  '<div class="title-genre">'+
    '<h2>Generos</h2>'+
  '</div>'+
  '<div class="genre-content">'+
    '<div class="card-genre m-4">'+
      '<div class="imagen-musical-genre">'+
        '<img src="./images/reggaeton.jpg" alt="" srcset="" class="img-genre" onclick="listar_genero(\'Reggaeton\')">'+
      '</div>'+
      '<div class="info-genre">'+
        '<span>Reggaeton</span><br>'+
      '</div>'+
    '</div>'+
    '<div class="card-genre m-4">'+
      '<div class="imagen-musical-genre">'+
        '<img src="./images/salsa.jpg" alt="" srcset="" class="img-genre" onclick="listar_genero(\'Salsa\')">'+
      '</div>'+
      '<div class="info-genre">'+
        '<span>Salsa</span><br>'+
      '</div>'+
    '</div>'+
    '<div class="card-genre m-4">'+
      '<div class="imagen-song-artista">'+
        '<img src="./images/balada.jpg" alt="" srcset="" class="img-genre" onclick="listar_genero(\'Balada\')">'+
      '</div>'+
      '<div class="info-genre">'+
        '<span>Baladas</span><br>'+
      '</div>'+
    '</div>'+
  '</div>'+
'</div>'+
'<div class="space-genre">'+
  '<div class="title-genre">'+
    '<h2>Mas reproducidas</h2>'+
  '</div>'+
  '<div class="genre-content">'+
    '<div class="songs-content">'+
      '<div class="card-song m-4">'+
        '<div class="play"><i class="fa-solid fa-circle-play" style="color: red"></i></div>'+
        '<div class="imagen-song-artista">'+
          '<img src="./images/donomar-dile.jfif" alt="" srcset="" class="rounded-circle">'+
        '</div>'+
        '<div class="info-song">'+
          '<span>Dile</span><br>'+
          '<span>Don Omar</span><br>'+
          '<span>523,227 Reproducciones</span>'+
        '</div>'+
      '</div>'+
      '<div class="card-song m-4">'+
        '<div class="play"><i class="fa-solid fa-circle-play" style="color: red"></i></div>'+
        '<div class="imagen-song-artista">'+
          '<img src="./images/cepeda-diatrasdia.jfif" alt="" srcset="" class="rounded-circle">'+
        '</div>'+
        '<div class="info-song">'+
          '<span>Dia tras dia</span><br>'+
          '<span>Andres Cepeda</span><br>'+
          '<span>324,822 Reproducciones</span>'+
        '</div>'+
      '</div>'+
      '<div class="card-song m-4">'+
        '<div class="play"><i class="fa-solid fa-circle-play" style="color: red"></i></div>'+
        '<div class="imagen-song-artista">'+
          '<img src="./images/eros-cosamasbella.jfif" alt="" srcset="" class="rounded-circle">'+
        '</div>'+
        '<div class="info-song">'+
          '<span>Cosa mas bella</span><br>'+
          '<span>Eros Ramazzotti</span><br>'+
          '<span>523,227 Reproducciones</span>'+
        '</div>'+
      '</div>'+
      '<div class="card-song m-4">'+
        '<div class="play"><i class="fa-solid fa-circle-play" style="color: red"></i></div>'+
        '<div class="imagen-song-artista">'+
          '<img src="./images/vita-nobasta.jfif" alt="" srcset="" class="rounded-circle">'+
        '</div>'+
        '<div class="info-song">'+
          '<span>No Basta</span><br>'+
          '<span>Franco de Vita</span><br>'+
          '<span>523,227 Reproducciones</span>'+
        '</div>'+
        
      '</div>'+
    '</div>'+
  '</div>'+
'</div>'+
'<div class="title-genre">'+
  '<h2>Atravez del tiempo</h2>'+
'</div>'+
'<div class="genre-content">'+
  '<div class="card-genre m-4">'+
    '<div class="imagen-musical-genre">'+
      '<img src="./images/reggaeton.jpg" alt="" srcset="" class="img-genre">'+
    '</div>'+
    '<div class="info-genre">'+
      '<span>70\'s</span><br>'+
    '</div>'+
  '</div>'+
  '<div class="card-genre m-4">'+
    '<div class="imagen-musical-genre">'+
      '<img src="./images/salsa.jpg" alt="" srcset="" class="img-genre">'+
    '</div>'+
    '<div class="info-genre">'+
      '<span>80\'s</span><br>'+
    '</div>'+
  '</div>'+
  '<div class="card-genre m-4">'+
    '<div class="imagen-song-artista">'+
      '<img src="./images/balada.jpg" alt="" srcset="" class="img-genre">'+
    '</div>'+
    '<div class="info-genre">'+
      '<span>90\'s</span><br>'+
    '</div>'+
  '</div>'+
'</div>'+
'<br>'+
'<br>'+
'</div>'
let pag_añadir = '<header class="bg-white" id="header-añadir">'+
'<div class="bg-white">'+
    '<h5 class="bg-white d-inline ps-3">Añadir/</h5>'+
    '<h5 class="bg-white d-inline m-0" id="titulo-añadir">Canciones</h5>'+
'</div>'+

'<nav class="border-bottom">'+
    '<ul class="d-flex bg-white col-12 mt-2 mb-0 me-2 ">'+
        '<li class="bg-white list-unstyled col-2 text-center pb-1 subs-operario" onclick="fillFrameSubPaginas(\'canciones\')">Canciones</li>'
        '<li class="bg-white list-unstyled col-2 text-center pb-1 subs-operario" onclick="fillFrameSubPaginas(\'autores\')">Autores</li>'
        '<li class="bg-white list-unstyled col-2 text-center pb-1 subs-operario" onclick="fillFrameSubPaginas(\'admin\')">Administrador</li>'+
    '</ul>'+
'</nav>'+
'</header>'+
'<iframe class="bg-white w-100" src="http://localhost:8080/cancion_form" style="height: 115vh;" id="añadir-frame"></iframe>'















async function cargar_cancion(id,objeto,boton){
    console.log("llego id: "+id);
    url = "http://localhost:8080/api/cancion/"+id;
    objeto_cancion = await axios.get(url);
    url_cancion = objeto_cancion.data.audio;
    medio_audio = document.getElementById("audio-ope");
    if(medio_audio.src != "http://localhost:8080"+url_cancion){
        medio_audio.setAttribute("src",url_cancion);
        id_anterior = id_actual
    }
    id_actual = id;
    play_pause_pistas(objeto,boton);
    ajustarVolume();
}
async function fillFrame(boton, opcion){
    content_frame = document.getElementById("content-frame");
    sub_frame = document.getElementById("sub-frame");
    var url1 = pag_home;
    var url2 = pag_home;
    if(boton == "home"){
        sub_frame.innerHTML = pag_home;
        // document.getElementById("contenido").style.height = "1500px";
        document.getElementById("aside-dash").style.height = "100vh";
    }
    if(boton == "canciones"){
      console.log("prueba1")
      url = "http://localhost:8080/api/cancion";
      pistas = await axios.get(url);
      // document.getElementById("contenido").style.height = "1500px";
      document.getElementById("aside-dash").style.height = "100vh";
      sub_frame.innerHTML = "<h5 class='text-start' onclick=\"fillFrame('dash-operario')\" style='cursor:pointer;'>volver</h5><br><h4 class='text-center'>Todas las canciones.</h4>";
      sub_frame.innerHTML += '<table class="table table-dark"><thead><tr><th scope="col">#</th><th scope="col">Nombre</th><th scope="col">Autor</th>'+
      '<th scope="col">Disco</th><th scope="col">Categoria</th><th scope="col">Genero</th><th scope="col">Escuchar</th></tr></thead><tbody id="body-lista-autor">'+
      '</tbody></table>';
      registros = document.getElementById("body-lista-autor");
      for (let i = 0; i < pistas.data.length; i++) {
        pista = pistas.data[i]
        url_autor = "http://localhost:8080/api/autor/"+pista.idAutor;
        autor = await axios.get(url_autor);
        registros.innerHTML += '<tr><td>'+pista.idCancion+'</td><td>'+pista.nombre+'</td><td>'+autor.data.nombre+'</td><td>'+pista.disco+'</td><td>'+pista.categoria+'</td><td>'+pista.genero+'</td><td><div class="ms-3 me-3" id="play'+pista.idCancion+'" onclick="cargar_cancion('+pista.idCancion+',\'pistas\',\'play\')">'+
        '<i class="fa-solid fa-play w-100" ></i></div><div class="ms-3 me-3 pause" id="pause'+pista.idCancion+'" onclick="cargar_cancion('+pista.idCancion+',\'pistas\',\'pause\')">'+
        '<i class="fa-solid fa-pause w-100" ></i></div></td><tr>';
      }
  }
    if(boton == "music") {
        url1 = "http://localhost:8080/canciones-operario";
        // document.getElementById("contenido").style.height = "1710px";
        document.getElementById("aside-dash").style.height = "100vh";
    }
    if(boton == "añadir"){
        url2 ="http://localhost:8080/añadir";
        url1 = "http://localhost:8080/cancion_form";
        // document.getElementById("sub-frame").style.height = "850px";
        // document.getElementById("contenido-operario").style.height = "850px";
        document.getElementById("aside-operario").style.height = "160vh";
        sub_frame.innerHTML = pag_añadir;
    }
    if(boton == "dash-operario"){
        url2 ="http://localhost:8080/home";
        // document.getElementById("sub-frame").style.height = "1500px";
        // document.getElementById("contenido-operario").style.height = "1500px";
        aside = document.getElementById("aside-operario");
        if(aside == null){
          aside = document.getElementById("aside-dash");
          aside.style.height = "300% !important";
        }
        else{
          aside = document.getElementById("aside-operario")
          aside.style.height = "270vh";
        }
        
        sub_frame.innerHTML = pag_home;
        
    }
    if(boton == "music-operario"){
        url2 = "http://localhost:8080/canciones-operario";
        // document.getElementById("sub-frame").style.height = "850px";
        // document.getElementById("contenido-operario").style.height = "850px";
        document.getElementById("aside-operario").style.height = "190vh";
    }
    if(content_frame != null){
        // codigo_html1 = await axios.get(url1);
        content_frame.innerHTML = codigo_html1.data;
    }
    if(sub_frame != null & boton != 'dash-operario' & boton != 'home' & boton != 'canciones'){
        codigo_html2 = await axios.get(url2);
        sub_frame.innerHTML = codigo_html2.data;
    }
    if(boton == "music-operario"){
        if(opcion == 0 | opcion == 1){
            fillFrameSubPaginasCanciones('recientes');
        }
        if(opcion == 2){
            fillFrameSubPaginasCanciones('pistas');
        }
        if(opcion == 3){
            fillFrameSubPaginasCanciones('artistas');
        }
    }
    if(boton == "dash-operario" | boton == "home"){
        cargar_artistas();
    }
    
}

async function play_pause_pistas(objeto, boton){
    
    if(objeto == 'pistas'){
        medio_audio = document.getElementById("audio-ope");
        var btn_play_actual = document.getElementById("play"+id_actual);
        var btn_pause_actual = document.getElementById("pause"+id_actual);
        var btn_play_footer = document.getElementById("play");
        var btn_pause_footer = document.getElementById("pause");
        var btn_play_anterior = document.getElementById("play"+id_anterior);
        var btn_pause_anterior = document.getElementById("pause"+id_anterior);
        var titulo_pista = document.getElementById("titulo-pista");
        var img_pista = document.getElementById("img-pista");
        if(boton == "pause"){
            btn_play_actual.style.display = "inline";
            btn_pause_actual.style.display = "none";
            btn_play_footer.style.display = "inline";
            btn_pause_footer.style.display = "none";
            medio_audio.pause();
        }
        else{       
            btn_play_actual.style.display = "none";
            btn_pause_actual.style.display = "inline";
            btn_play_footer.style.display = "none";
            btn_pause_footer.style.display = "inline";

            if(btn_pause_anterior != null & btn_play_anterior != null){
                btn_play_anterior.style.display = "inline";
                btn_pause_anterior.style.display = "none";
            }
            url_cancion = "http://localhost:8080/api/cancion/"+id_actual;
            objeto_cancion = await axios.get(url_cancion);
            url_autor = "http://localhost:8080/api/autor/"+objeto_cancion.data.idAutor;
            nombre_autor = await axios.get(url_autor)
            titulo_pista.innerHTML = objeto_cancion.data.nombre+" - "+nombre_autor.data.nombre;
            titulo_pista.style.color = "#000";
            img_pista.setAttribute("src",objeto_cancion.data.imagen);
            medio_audio.play();
            bucle = setInterval(estado, 1000);
        }
    }
}
function play_pause(){
    medio_audio = document.getElementById("audio-ope");
    var btn_play_footer = document.getElementById("play");
    var btn_pause_footer = document.getElementById("pause");
    var btn_play_actual = document.getElementById("play"+id_actual);
    var btn_pause_actual = document.getElementById("pause"+id_actual);

    if(!medio_audio.paused & !medio_audio.ended){
        btn_play_footer.style.display = "inline";
        btn_pause_footer.style.display = "none";
        if(btn_play_actual != null & btn_pause_actual != null){
          btn_play_actual.style.display = "inline";
          btn_pause_actual.style.display = "none";
        }
        medio_audio.pause();
    }
    else{       
        btn_play_footer.style.display = "none";
        btn_pause_footer.style.display = "inline";
        if(btn_play_actual & btn_pause_actual){
          btn_play_actual.style.display = "none";
          btn_pause_actual.style.display = "inline";
        }
        medio_audio.play();
        bucle = setInterval(estado, 1000);
    }

}


function estado(){
    medio_audio = document.getElementById("audio-ope");
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
        medio_audio = document.getElementById("audio-ope");
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
    medio_audio = document.getElementById("audio-ope");
    var barra_audio = document.getElementById("progress-bar");
    tiempo = (barra_audio.value * medio_audio.duration)/100;
    medio_audio.currentTime = tiempo;
}
async function fillFrameSubPaginas(boton){
    añadir_frame = document.getElementById("añadir-frame");
    titulo = document.getElementById("titulo-añadir");
    if(boton == 'canciones'){
        sub_pagina = "http://localhost:8080/cancion_form";
        titulo.innerHTML = "Canciones";
    }
    if(boton == 'autores'){
        titulo.innerHTML = "Autores";
        sub_pagina = "http://localhost:8080/autores_form";
    }
    if(boton == 'admin'){ 
        titulo.innerHTML = "Administradores";
        sub_pagina = "http://localhost:8080/admin_form";
    }
    añadir_frame.setAttribute("src", sub_pagina);
    
}

async function fillFrameSubPaginasCanciones(boton){
    canciones_frame = document.getElementById("canciones-frame");
    titulo = document.getElementById("titulo-añadir");
    frame_cancioes = document.getElementById("añadir-frame");
    if(boton == 'recientes'){
        url = "http://localhost:8080/recientes";
        titulo.innerHTML = "Recientes";
    }
    if(boton == 'pistas'){
        titulo.innerHTML = "Pistas";
        url = "http://localhost:8080/listar/canciones";
    }
    if(boton == 'artistas'){ 
        titulo.innerHTML = "Artistas";
        url = "http://localhost:8080/listar/autores";
    }
    sub_pagina = await axios.get(url);
    canciones_frame.innerHTML = sub_pagina.data;
    
}


/**
 * Funcion para validar que todos los campos hayan sido diligenciados
 * y que ninguno contenga datos nulos para evitar errores
 * ademas valida si la variable verification tiene el valor de true
 * la  variable verification el valor de esta variable es asignado por la funcion
 * dataCorrect() la cual le indicara que cada uno de los campos cumple con
 * los requisitos para ser enviados a la base de datos y que no generen error
 */
function validar_registro(){
    var user = document.getElementById("user").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    
    console.log(user);
    if(user != null & email != null & password != null){
        validar_click = true;
        alerta_usuario = document.getElementById("alerta-user").style.display="none";
        alerta_usuario = document.getElementById("alerta-user").style.display="none";
        alerta_usuario = document.getElementById("alerta-user").style.display="none";
    }
    else{
      if(user == null){
        alerta_usuario = document.getElementById("alerta-user").style.display="block";
      }
      if(email == null){
        alerta_email = document.getElementById("alerta-email").style.display="block";
      }
      if(password == null){
        alerta_password = document.getElementById("alerta-password").style.display="block";
      }
      if(user != null){
        alerta_usuario = document.getElementById("alerta-user").style.display="none";
      }
      if(email != null){
        alerta_email = document.getElementById("alerta-email").style.display="none";
      }
      if(password != null){
        alerta_password = document.getElementById("alerta-password").style.display="none";
      }
        validar_click = false;
    }
}
/**
 * 
 * user variable de tipo string proveniente del input con id user
 * email variable de tipo string proveniente del input con id email
 * password variable de tipo string proveniente del input con id password
 * funcion para guardar los datos del formulario en la base de datos haciendo una
 * peticion HTTP a la url http://localhost:8080/api/usuarios, 
 * importante no enviar el dato idusuario
 */
async function createUser(tipo){
    //const axios = require('axios');
    var date = new Date();
    if(tipo ==1){
        var url = 'http://localhost:8080/admin';
        var user = document.getElementById("user1").value;
        var email = document.getElementById("email1").value;
        var password = document.getElementById("password1").value;
        var tipoUsuario = "Admin";
    }
    if(tipo==0){
      if(validar_blur & validar_click){
        var url = 'http://localhost:8080/usuarios';
        var user = document.getElementById("user").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var tipoUsuario = "Cliente";

        document.cookie = "usuario_creado=true; max-age=60; path=/";
      }  
    }
    
    var fecha = date.toLocaleDateString();
    //console.log(user+" "+typeof(user)+email+" "+typeof(email)+ password+" "+typeof(password)+ fecha+" "+typeof(fecha));
    console.log(user, email, password, fecha, url);
    let objeto = {};
    objeto.usuario = {
        correoElectronico: email, 
        nombreUsuario: user, 
        contrasena: password,
        fechaRegistro: fecha,
        tipoUsuario: tipoUsuario
    };
        console.log("hola: "+ objeto.usuario);
        const respuesta = await axios.post(url, objeto.usuario);
        console.log(respuesta);
        mensaje_satisfactorio = document.getElementById("creacion-correcta").style.display = "block"
    }

/**
 * 
 * @param {Long} id variable de tipo long proveniente de la llamada desde el html
 * se debe pasar este parametro con relacion al id de usuario que se desea consultar
 * y regresara el objeto en formato JSON
 */
function obtenerUsuario(id){
    var url = 'http://localhost:8080/api/usuarios/'+id;
    axios.get(url)
    .then(function(res){
        console.log(res.data);
    })
    .catch(function (error) {
        console.log("Catch error:");
        console.log(error);
    });
}

function dataCorrect(data){
    if(data =='user'){
        var user = document.getElementById("user").value;
        if(user.length >= 5 && user.length < 45){
            if(user[0] % 1 != 0){
                validar_blur = true;
                alerta_usuario = document.getElementById("alerta-user").style.display="none";
            }
            else{
                validar_blur = false;
                alerta_usuario = document.getElementById("alerta-user").style.display="block";
            }
        }
        else{
            validar_blur = false;
            alerta_usuario = document.getElementById("alerta-user").style.display="block";
        }
    }
    if(data =='password'){
        var password = document.getElementById("password").value;
        if(password.length > 8 && password.length < 16){
            validar_blur = true;
            alerta_usuario = document.getElementById("alerta-password").style.display="none";
        }
        else{
            validar_blur = false;
            alerta_usuario = document.getElementById("alerta-password").style.display="block";
        }
    }
    if(data =='email'){
        var email = document.getElementById("email").value;
        var correct = 0;
        for(var i = 0; i < email.length; i++){
            if(email[i] == '@' | email[i] == '.'){
                correct = correct + 1;
                alerta_usuario = document.getElementById("alerta-email").style.display="none";
            }
        }
        if(correct == 2){
            validar_blur = true;
            alerta_usuario = document.getElementById("alerta-email").style.display="none";
        }
        else{
            validar_blur = false;
            alerta_usuario = document.getElementById("alerta-email").style.display="block";
        }
    }
}
function validar_login(){
    var user = document.getElementById("user").value;
    var password = document.getElementById("password").value;
    if(user != null & password != null){
        validar_click = true;
    }
    else{
        if(user==null){
        
        document.getElementById("alerta-user").style.display="block";
        }
        if(password==null){
          document.getElementById("alerta-password").style.display="block";
        }
        validar_click = false;
    }
}
async function login_user(){
    var user = document.getElementById("user").value;
    var password = document.getElementById("password").value;
    var url = 'http://localhost:8080/usuario/nombre/'+user;
    //console.log(user+" "+typeof(user)+email+" "+typeof(email)+ password+" "+typeof(password)+ fecha+" "+typeof(fecha));
    if(validar_blur & validar_click){
        try {
          credenciales = await axios.get(url);
          if(credenciales.data[0].contrasena == password){
            if(credenciales.data[0].tipoUsuario == "Cliente"){
              document.cookie = "usuario=Cliente; max-age=3600; path=/";
              // document.getElementById("boton-login").href = "dashboard";
              location.href = "dashboard";
            }
            if(credenciales.data[0].tipoUsuario == "Admin"){
              document.cookie = "usuario=Admin; max-age=3600; path=/";
              location.href = "panelOpe";
              // document.getElementById("boton-login").href = "panelOpe";
            }
          }
        } catch (error) {
          console.log(error);
          document.getElementById("alerta-incorrecta").style.display="block";
        }
        
    }
    else{
        alert('Ingrese los datos correctamente');
    }
}
async function recientes(){
    url="http://localhost:8080/admin/registro"
    registro_admin = await axios.get(url);
    document.getElementById("div-prueba").innerHTML=registro_admin.data; 
}

async function cargar_artistas(){
    url = "http://localhost:8080/api/autor/consulta";
    autores = await axios.get(url);
    contenido_artistas = document.getElementById("contenido-artistas");
    for (let i = 0; i < autores.data.length & i < 4; i++) {
        artista = autores.data[i];
        contenido_artistas.innerHTML += "<div class='card-artist mt-4 mb-4 ms-5 me-4'><div class='imagen-artista'><img src='"+artista.imagen+"' class='imagen rounded-circle' style='height:200px;width:200px;'></div><div class='info-song'><a class='text-decoration-none text-black' onclick = 'listas_pistas_autor("+artista.idAutor+")' style = 'cursor:pointer;'>"+artista.nombre+"</a><br><span>"+artista.fans+" fans</span></div></div>";
    }
    if(autores.data.length > 4){

    }
        
}
async function listas_pistas_autor(id_autor){
  url_autor = "http://localhost:8080/api/autor/"+id_autor;
  url_pista = "http://localhost:8080/api/cancion/autor/"+id_autor;
  datos_autor = await axios.get(url_autor);
  pista_autor = await axios.get(url_pista);
  sub_frame = document.getElementById("sub-frame");
  sub_frame.innerHTML = "<h5 class='text-start' onclick=\"fillFrame('dash-operario')\" style='cursor:pointer;'>volver</h5><div class='card-artist mt-4 mb-4 ms-5 me-4 '><div class='imagen-artista' style='display:flex;flex-direction:row;justify-content:center;'><img src='"+datos_autor.data.imagen+"' class='imagen rounded-circle' style='height:200px;width:200px;'></div><div class='info-song'><a class='text-decoration-none text-black'>"+datos_autor.data.nombre+"</a><br><span>"+datos_autor.data.fans+" fans</span></div></div>";
  sub_frame.innerHTML += '<table class="table table-dark"><thead><tr><th scope="col">#</th><th scope="col">Nombre</th><th scope="col">Autor</th>'+
  '<th scope="col">Disco</th><th scope="col">Categoria</th><th scope="col">Genero</th><th scope="col">Escuchar</th></tr></thead><tbody id="body-lista-autor"><tr>'+
  '</tr></tbody></table>';
  registros = document.getElementById("body-lista-autor");
  pista_autor.data.forEach(pista => {
    registros.innerHTML += '<td>'+pista.idCancion+'</td><td>'+pista.nombre+'</td><td>'+datos_autor.data.nombre+'</td><td>'+pista.disco+'</td><td>'+pista.categoria+'</td><td>'+pista.genero+'</td><td><div class="ms-3 me-3" id="play'+pista.idCancion+'" onclick="cargar_cancion('+pista.idCancion+',\'pistas\',\'play\')">'+
    '<i class="fa-solid fa-play w-100" ></i></div><div class="ms-3 me-3 pause" id="pause'+pista.idCancion+'" onclick="cargar_cancion('+pista.idCancion+',\'pistas\',\'pause\')">'+
    '<i class="fa-solid fa-pause w-100" ></i></div></td>'
  });
}
async function mostrar_todos_artistas(){
  url_autor = "http://localhost:8080/api/autor/consulta";
  datos_autor = await axios.get(url_autor);
  sub_frame = document.getElementById("sub-frame");
  sub_frame.innerHTML = "<h5 class='text-start' onclick=\"fillFrame('dash-operario')\" style='cursor:pointer;'>volver</h5><br><h4 class='text-center'>Artistas<h4><div id='todos-artistas'></div>";
  contenedor_artistas = document.getElementById("todos-artistas");
  datos_autor.data.forEach(artista => {
    contenedor_artistas.innerHTML += "<div class='card-artist mt-4 mb-4 ms-5 me-4'><div class='imagen-artista'><img src='"+artista.imagen+"' class='imagen rounded-circle' style='height:200px;width:200px;'></div><div class='info-song'><a class='text-decoration-none text-black' onclick = 'listas_pistas_autor("+artista.idAutor+")' style = 'cursor:pointer;'>"+artista.nombre+"</a><br><span>"+artista.fans+" fans</span></div></div>";
  });
}
async function listar_genero(genero){
  sub_frame = document.getElementById("sub-frame");
  url_autor = "http://localhost:8080/api/cancion/genero/"+genero;
  pistas_genero = await axios.get(url_autor);
  sub_frame.innerHTML = "<h5 class='text-start' onclick=\"fillFrame('dash-operario')\" style='cursor:pointer;'>volver</h5><br><h4 class='text-center'>"+genero+"<h4><br>"+
  '<table class="table table-dark"><thead><tr><th scope="col">#</th><th scope="col">Nombre</th><th scope="col">Autor</th>'+
  '<th scope="col">Disco</th><th scope="col">Categoria</th><th scope="col">Genero</th><th scope="col">Escuchar</th></tr></thead><tbody id="body-lista-genero"><tr>'+
  '</tr></tbody></table>';
  registros = document.getElementById("body-lista-genero");
  pistas_genero.data.forEach(async pista => {
    url_autor = "http://localhost:8080/api/autor/"+pista.idAutor;
    datos_autor = await axios.get(url_autor);
    console.log(datos_autor);
    registros.innerHTML += '<td>'+pista.idCancion+'</td><td>'+pista.nombre+'</td><td>'+datos_autor.data.nombre+'</td><td>'+pista.disco+'</td><td>'+pista.categoria+'</td><td>'+pista.genero+'</td><td><div class="ms-3 me-3" id="play'+pista.idCancion+'" onclick="cargar_cancion('+pista.idCancion+',\'pistas\',\'play\')">'+
    '<i class="fa-solid fa-play w-100" ></i></div><div class="ms-3 me-3 pause" id="pause'+pista.idCancion+'" onclick="cargar_cancion('+pista.idCancion+',\'pistas\',\'pause\')">'+
    '<i class="fa-solid fa-pause w-100" ></i></div></td>';
  });
}
function validar_cookie(dato){
  cookies = document.cookie.split(";")
  console.log(cookies[0]);
  if(cookies[0] == "usuario=Cliente"){
    if(dato == "operario"){
      location.href = "dashboard";
    }
    
  }
  if(cookies[0] == "usuario=Admin"){
    if(dato == "usuario"){
      location.href = "panelOpe";
    }
  }
  if(cookies[0] == ''){
    location.href = "login";
  }
}

