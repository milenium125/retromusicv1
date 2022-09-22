package com.example.retromusic_v1.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.retromusic_v1.Entities.Favoritas;
import com.example.retromusic_v1.InterfacesServices.FavoritasServiceInterface;
import com.example.retromusic_v1.Repositories.FavoritasRepository;

@Service
public class FavoritasService implements FavoritasServiceInterface{
    private FavoritasRepository fRepository;
    private final Logger log = LoggerFactory.getLogger(FavoritasService.class);

    public FavoritasService(FavoritasRepository fRepository){
        this.fRepository = fRepository;
    }

    @Override
    public ResponseEntity<Favoritas> saveFavoritas(Favoritas favorita) {
        if(favorita.getIdFavorita() == null){
            Favoritas result = fRepository.save(favorita);
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<Favoritas> listarFavoritas() {
        return fRepository.findAll();
    }

    @Override
    public ResponseEntity<Optional<Favoritas>> findfavoritaById(Long idCancion) {
        if(fRepository.existsById(idCancion)){
            Optional<Favoritas> result = fRepository.findById(idCancion);
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Favoritas> updateFavorita(Favoritas cancion) {
        if(cancion.getIdFavorita() != null){
            if(fRepository.existsById(cancion.getIdFavorita())){
                Favoritas result = fRepository.save(cancion);
                return ResponseEntity.ok(result);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Favoritas> deleteFavoritaById(Long idCancion) {
        if(fRepository.existsById(idCancion)){
            fRepository.deleteById(idCancion);
            return ResponseEntity.noContent().build();
        }
        else{
            log.warn("favorite with this id not found");
            return ResponseEntity.notFound().build();
        }
    }
        
    

    
}