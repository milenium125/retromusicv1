package com.example.retromusic_v1.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.retromusic_v1.Entities.Usuario;
import com.example.retromusic_v1.InterfacesServices.UsuarioServiceInterface;
import com.example.retromusic_v1.Repositories.UsuarioRepository;

@Service
public class UsuarioServices implements UsuarioServiceInterface{
    private UsuarioRepository uRepository;
    private final Logger log = LoggerFactory.getLogger(UsuarioServices.class);

    public UsuarioServices(UsuarioRepository uRepository){
        this.uRepository = uRepository;
    }

    @Override
    public ResponseEntity<Usuario> saveLista(Usuario usuario) {
        if(usuario.getIdUsuario() == null){
            Usuario result = uRepository.save(usuario);
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<Usuario> listarListas() {
        return uRepository.findAll();
    }

    @Override
    public ResponseEntity<Optional<Usuario>> findListaById(Long idUsuario) {
        if(uRepository.existsById(idUsuario)){
            Optional<Usuario> result = uRepository.findById(idUsuario);
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
        
    }

    @Override
    public ResponseEntity<Usuario> updateLista(Usuario usuario) {
        if(usuario.getIdUsuario() != null){
            if(uRepository.existsById(usuario.getIdUsuario())){
                Usuario result = uRepository.save(usuario);
                return ResponseEntity.ok(result);
            }
            else{
                return ResponseEntity.notFound().build();
            }
            
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Usuario> deleteListaById(Long idCancion) {
        if(uRepository.existsById(idCancion)){
            uRepository.deleteById(idCancion);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<Usuario> usuarioLogin(String nombreUsuario) {
        return uRepository.findByNombreUsuario(nombreUsuario);
    }
    

}