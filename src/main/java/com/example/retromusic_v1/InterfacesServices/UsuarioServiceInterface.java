package com.example.retromusic_v1.InterfacesServices;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.retromusic_v1.Entities.Usuario;

public interface UsuarioServiceInterface {
    public ResponseEntity<Usuario> saveLista(Usuario favorita);
    public List<Usuario> listarListas();
    public List<Usuario> usuarioLogin(String nombreUsuario);
    public ResponseEntity<Optional<Usuario>> findListaById(Long idCancion);
    public ResponseEntity<Usuario> updateLista(Usuario cancion);
    public ResponseEntity<Usuario> deleteListaById(Long idCancion);
}
