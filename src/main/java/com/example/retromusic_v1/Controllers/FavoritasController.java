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

import com.example.retromusic_v1.Entities.Favoritas;
import com.example.retromusic_v1.Services.FavoritasService;

@RestController
@RequestMapping("/api")
public class FavoritasController {
    private FavoritasService fService;

    public FavoritasController(FavoritasService fService){
        this.fService = fService;
    }
    @PostMapping("/favoritas")
    public ResponseEntity<Favoritas> crearFavorita(@RequestBody Favoritas favorita){
        return fService.saveFavoritas(favorita);
    }
    @GetMapping("/favoritas")
    public List<Favoritas> listFavoritas(){
        return fService.listarFavoritas();
    }
    @GetMapping("/favoritas/{id}")
    public ResponseEntity<Optional<Favoritas>> findFavoritaById(@PathVariable Long id){
        return fService.findfavoritaById(id);
    }
    @PutMapping("/favoritas")
    public ResponseEntity<Favoritas> updateFavorita(@RequestBody Favoritas cancion){
        return fService.updateFavorita(cancion);
    }
    @DeleteMapping("/favoritas/{id}")
    public ResponseEntity<Favoritas> deleteFavoritaById(@PathVariable Long id){
        return fService.deleteFavoritaById(id);
    }
}