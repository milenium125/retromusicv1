package com.example.retromusic_v1.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.retromusic_v1.Entities.Usuario;
import com.example.retromusic_v1.Services.UsuarioServices;


@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
//@RequestMapping("/api")
public class UsuarioController {
    private UsuarioServices uService;

    public UsuarioController(UsuarioServices uService){
        this.uService = uService;
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        //Usuario usuario = new Usuario();
        //modelo.addAttribute("usuario", usuario)
        System.out.println(usuario);
        uService.saveLista(usuario);
        return ResponseEntity.ok(usuario);
    }
    
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @PostMapping("/admin")
    public ResponseEntity<Usuario> createAdmin(@RequestBody Usuario admin){
        //Usuario usuario = new Usuario();
        //modelo.addAttribute("usuario", usuario)
        System.out.println(admin);
        uService.saveLista(admin);
        return ResponseEntity.ok(admin);
    }
    
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/usuarios")
    public List<Usuario> listUsuarios(){
        return uService.listarListas();
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/usuario/nombre/{user}")
    public List<Usuario> findUser(@PathVariable String user){
        return uService.usuarioLogin(user);
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Optional<Usuario>> findUsuarioById(@PathVariable Long id){
        return uService.findListaById(id);
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> deleteUsuarioById(@PathVariable Long id){
        return uService.deleteListaById(id);
    }

}
