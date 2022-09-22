package com.example.retromusic_v1.Controllers;

import com.example.retromusic_v1.Entities.Autor;
import com.example.retromusic_v1.Entities.Cancion;
import com.example.retromusic_v1.Services.AutorService;
import com.example.retromusic_v1.Services.CancionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
public class PostArchivos {
    
    @Autowired
    private AutorService Aservice;
    private CancionService Cservice;

    public PostArchivos(AutorService Aservice, CancionService Cservice){
        this.Aservice = Aservice;
        this.Cservice = Cservice;
    }

    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @PostMapping("/saveAutor")
    public String saveAutor(@ModelAttribute Autor autor, Model modelo, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        if(!file.isEmpty()){
            Path directorioImagenes = Paths.get("src//main//resources//static/imagen");
        String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

        try {
            byte[] bytesImg = file.getBytes();
            Path rutaCompleta = Paths.get(rutaAbsoluta+"//"+file.getOriginalFilename());
            Files.write(rutaCompleta, bytesImg);
            autor.setImagen("/imagen/"+file.getOriginalFilename());
            Aservice.saveAutor(autor);
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
        return "autores_form";
    }
    
    @CrossOrigin(origins= "*", methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    @PostMapping("/saveCancion")
    public String saveCancion(@ModelAttribute Cancion cancion, Model modelo, @RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes){
        System.out.println("Numero 1: "+files[0]+"Numero 2: "+files[1]);
        if(!files[0].isEmpty() & !files[1].isEmpty()){
            Path directorioImagenes = Paths.get("src//main//resources//static/imagen");
            String rutaAbsolutaImg = directorioImagenes.toFile().getAbsolutePath();

            Path directorioPistas = Paths.get("src//main//resources//static/audios");
            String rutaAbsolutaPista = directorioPistas.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = files[0].getBytes();
                byte[] bytesPista = files[1].getBytes();
                Path rutaCompletaImg = Paths.get(rutaAbsolutaImg+"//"+files[0].getOriginalFilename());
                Path rutaCompletaPista = Paths.get(rutaAbsolutaPista+"//"+files[1].getOriginalFilename());
                Files.write(rutaCompletaImg, bytesImg);
                Files.write(rutaCompletaPista, bytesPista);
                cancion.setImagen("/imagen/"+files[0].getOriginalFilename());
                cancion.setAudio("/audios/"+files[1].getOriginalFilename());
                Cservice.saveCanciones(cancion);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "cancion_form";
    }
    
}