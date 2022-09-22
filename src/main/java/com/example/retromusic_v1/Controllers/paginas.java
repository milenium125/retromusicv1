package com.example.retromusic_v1.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.retromusic_v1.Entities.Autor;
import com.example.retromusic_v1.Entities.Cancion;
import com.example.retromusic_v1.Entities.Usuario;
import com.example.retromusic_v1.Services.AutorService;
import com.example.retromusic_v1.Services.CancionService;

@Controller
@CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
public class paginas {

    @Autowired
    AutorService Aservice;
    @Autowired
    CancionService Cservice;

    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/añadir")
    public String paginaAñadir(Model modelo){
        Autor autor = new Autor();
        Usuario usuario = new Usuario();
        Cancion cancion = new Cancion();
        modelo.addAttribute("autor", autor);
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("cancion", cancion);
        return "añadir";
    }

    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/admin_form")
    public String mostrarFormAdmin(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "admin_form";
    }

    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/cancion_form")
    public String registroCancion(Model modelo){
        Cancion cancion = new Cancion();
        modelo.addAttribute("cancion", cancion);
        return "cancion_form";
    }

    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/autores_form")
    public String registroAutor(Model modelo){
        Autor autor = new Autor();
        modelo.addAttribute("autor", autor);
        return "autores_form";
    }

    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/admin/registro")
    public String pagRegistroAdmin(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "admin_form";
    }

    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/usuarios/registro")
    public String dashboardOperario(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "newaccount2";
    }

    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/panelOpe")
    public String pagRegistroUser(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "panel-operario";
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/home")
    public String pagHome(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "home";
    }

    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/canciones-operario")
    public String pagCancionesOperario(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "canciones-operario";
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/recientes")
    public String pagRecientes(Model modelo){
        Cancion cancion = new Cancion();
        modelo.addAttribute("cancion", cancion);
        return "recientes";
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/albumes")
    public String pagAlbumes(Model modelo){
        Cancion cancion = new Cancion();
        modelo.addAttribute("cancion", cancion);
        return "albumes";
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/pistas")
    public String pagPistas(Model modelo){
        Cancion cancion = new Cancion();
        modelo.addAttribute("cancion", cancion);
        return "pistas";
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/listar/autores")
    public String listarAutores(Model modelo){
        List<Autor> autores = Aservice.listarAutores();
        modelo.addAttribute("autoreslista", autores);
        return "autores";
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/listar/canciones")
    public String listarCanciones(Model modelo){
        List<Cancion> canciones = Cservice.listarCanciones();
        modelo.addAttribute("canciones", canciones);
        return "pistas";
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/dashboard")
    public String pagDashUsuario(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "dashboard";
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/")
    public String pagInicio(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "index";
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/login")
    public String pagLogin(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "login";
    }
    
}