package it.epicode.W6_D5_U2.controller;

import it.epicode.W6_D5_U2.model.Dipendente;
import it.epicode.W6_D5_U2.service.DipendenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    DipendenteService dipendenteService;

    @GetMapping
    public ResponseEntity<?> getAllDipendenti(){
        return ResponseEntity.ok(dipendenteService.getAllDipendenti());
    }

    @GetMapping
    public ResponseEntity<?> getDipendenteById(@PathVariable Long id){
        return ResponseEntity.ok(dipendenteService.getDipendenteById(id));
    }

    @PostMapping
    public ResponseEntity<?> createDipendente(@Valid @RequestBody Dipendente dipendente){
        Dipendente created = dipendenteService.createDipendente(dipendente);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDipendente(@PathVariable Long id, @Valid @RequestBody Dipendente dipendente){
        return ResponseEntity.ok(dipendenteService.updateDipendente(id,dipendente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDipendente(@PathVariable Long id){
        dipendenteService.deleteDipendente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping("/{id}/uploadImage")
//    public ResponseEntity<?> uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
//        try {
//            String imageUrl = dipendenteService.uploadProfileImage(id, file);
//            return ResponseEntity.ok(imageUrl);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Errore durante l'upload dell'immagine.");
//        }
//    }



}
