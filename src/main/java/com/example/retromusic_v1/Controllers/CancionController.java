package com.example.retromusic_v1.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.retromusic_v1.Entities.Cancion;
import com.example.retromusic_v1.Services.CancionService;

@RestController
@RequestMapping("/api")
public class CancionController {
    @Autowired
    private CancionService cService;

    public CancionController(CancionService cService){
        this.cService = cService;
    }
    @PostMapping("/cancion")
    public ResponseEntity<Cancion> saveCancion(@RequestBody Cancion cancion){
        return cService.saveCanciones(cancion);
    }
    @GetMapping("/cancion")
    public List<Cancion> listCanciones(){
        return cService.listarCanciones();
    }
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @GetMapping("/cancion/{id}")
    public ResponseEntity<Optional<Cancion>> findCancionbyId(@PathVariable Long id){
        return cService.findCancionById(id);
    }
    @GetMapping("/disco/{disco}")
    public List<Cancion> findCancionbyId(@PathVariable String disco){
        return cService.findByDisco(disco);
    }
    @GetMapping("/canciones/{fecha}")
    public List<Cancion> findCancionbyFecha(@PathVariable String fecha){
        return cService.findByFecha(fecha);
    }
    @GetMapping("/cancion/autor/{id}")
    public List<Cancion> findCancionbyIdAutor(@PathVariable Long id){
        return cService.findByIdAutor(id);
    }
    @GetMapping("/cancion/genero/{genero}")
    public List<Cancion> findCancionbyGenero(@PathVariable String genero){
        return cService.findByGenero(genero);
    }
    @PutMapping("/cancion")
    public ResponseEntity<Cancion> updateCancion(@RequestBody Cancion cancion){
        return cService.updateCancion(cancion);
    }
    @DeleteMapping("/cancion/{id}")
    public ResponseEntity<Cancion> deleteCancionById(@PathVariable Long id){
        return cService.deleteCancionById(id);
    }
}