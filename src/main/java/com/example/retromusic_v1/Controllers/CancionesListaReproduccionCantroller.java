package com.example.retromusic_v1.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retromusic_v1.Entities.CancionesListaReproduccion;
import com.example.retromusic_v1.Services.CancionesListaReproduccionService;

@RestController
@RequestMapping("/api")
public class CancionesListaReproduccionCantroller {
    private CancionesListaReproduccionService cReproduccionService;

    public CancionesListaReproduccionCantroller(CancionesListaReproduccionService cReproduccionService){
        this.cReproduccionService = cReproduccionService;
    }

    @PostMapping("/cancionesReproduccion")
    public ResponseEntity<CancionesListaReproduccion> createCancionLista(@RequestBody CancionesListaReproduccion cancion){ 
        return cReproduccionService.saveCanciones(cancion);
    }
    @GetMapping("/cancionesReproduccion")
    public List<CancionesListaReproduccion> listCancionesReproduccion(){
        return cReproduccionService.listarCanciones();
    }
    @GetMapping("/cancionesReproduccion/{id}")
    public ResponseEntity<Optional<CancionesListaReproduccion>> findCancionByid(@PathVariable Long id){
        return cReproduccionService.findCancionById(id);
    }
    @PutMapping("/cancionesReproduccion")
    public ResponseEntity<CancionesListaReproduccion> updateCancion(@RequestBody CancionesListaReproduccion cancion){
        return cReproduccionService.updateCancion(cancion);
    }
    @DeleteMapping("/cancionesReproduccion/{id}")
    public ResponseEntity<CancionesListaReproduccion> deleteCancionById(@PathVariable Long id){
        return cReproduccionService.deleteCancionById(id);
    }
}