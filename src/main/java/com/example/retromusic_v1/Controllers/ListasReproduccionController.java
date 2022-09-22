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

import com.example.retromusic_v1.Entities.ListasReproduccion;
import com.example.retromusic_v1.Services.ListasReproduccionService;

@RestController
@RequestMapping("/api")
public class ListasReproduccionController {
    private ListasReproduccionService lService;

    public ListasReproduccionController(ListasReproduccionService lService){
        this.lService = lService;
    }

    @PostMapping("/listasReproduccion")
    public ResponseEntity<ListasReproduccion> createListaReproduccion(@RequestBody ListasReproduccion lista){
        return lService.saveLista(lista);
    }
    @GetMapping("/listasReproduccion")
    public List<ListasReproduccion> listarListasReproduccion(){
        return lService.listarListas();
    }
    @GetMapping("/listasReproduccion/{id}")
    public ResponseEntity<Optional<ListasReproduccion>> findListaById(@PathVariable Long id){
        return lService.findListaById(id);
    }
    @PutMapping("/listaReproduccion")
    public ResponseEntity<ListasReproduccion> updateLista(@RequestBody ListasReproduccion lista){
        return lService.updateLista(lista);
    }
    @DeleteMapping("/listaReproduccion/{id}")
    public ResponseEntity<ListasReproduccion> deleteListaById(@PathVariable Long id){
        return lService.deleteListaById(id);
    }
}   
