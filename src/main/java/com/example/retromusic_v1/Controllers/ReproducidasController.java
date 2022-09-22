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

import com.example.retromusic_v1.Entities.Reproducidas;
import com.example.retromusic_v1.Services.ReproducidasServices;

@RestController
@RequestMapping("/api")
public class ReproducidasController {
    private ReproducidasServices rService;

    public ReproducidasController(ReproducidasServices rServices){
        this.rService = rServices;
    }
    @PostMapping("/reproducidas")
    public ResponseEntity<Reproducidas> createReproducida(@RequestBody Reproducidas cancion){
        return rService.saveLista(cancion);
    }
    @GetMapping("/reproducidas")
    public List<Reproducidas> listReproducidas(){
        return rService.listarListas();
    }
    @GetMapping("/reproducidas/{id}")
    public ResponseEntity<Optional<Reproducidas>> findReproducidaByid(@PathVariable Long id){
        return rService.findListaById(id);
    }
    @PutMapping("/reproducidas")
    public ResponseEntity<Reproducidas> updateReproducida(@RequestBody Reproducidas cancion){
        return rService.updateLista(cancion);
    }
    @DeleteMapping("/reproducidas/{id}")
    public ResponseEntity<Reproducidas> deleteReproducidaById(@PathVariable Long id){
        return rService.deleteListaById(id);
    }
}