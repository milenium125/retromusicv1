package com.example.retromusic_v1.Controllers;

import com.example.retromusic_v1.Entities.Autor;
import com.example.retromusic_v1.Services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
@RequestMapping("/api")
public class AutorController {
    @Autowired
    private AutorService Aservice;
    
    public AutorController(AutorService Aservice){
        this.Aservice = Aservice;
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @PostMapping("/autor")
    public ResponseEntity<Autor> saveAutor(@RequestBody Autor autor){
        return Aservice.saveAutor(autor);
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/autor/consulta")
    public List<Autor> listAutor(){
        return Aservice.listarAutores();
    }
    @CrossOrigin(origins= "*")
    @GetMapping("/autor/{id}")
    public ResponseEntity<Optional<Autor>> findById(@PathVariable Long id){
        return Aservice.findAutorById(id);
    }
    @CrossOrigin(origins= "*")
    @PutMapping("/autor")
    public ResponseEntity<Autor> update(@RequestBody Autor autor){
        return Aservice.updateAutor(autor);
    }
    @CrossOrigin(origins= "*")
    @DeleteMapping("/autor/{id}")
    public ResponseEntity<Autor> deleteById(@PathVariable Long id){
        return Aservice.deleteAutorById(id);
    }
}
