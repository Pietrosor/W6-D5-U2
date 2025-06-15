package it.epicode.W6_D5_U2.controller;

import it.epicode.W6_D5_U2.model.Stato;
import it.epicode.W6_D5_U2.model.Viaggio;
import it.epicode.W6_D5_U2.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @GetMapping
    public ResponseEntity<?> getAllViaggi(){
        return ResponseEntity.ok(ViaggioService.getAllViaggi());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getViaggioById(@PathVariable Long id){
        return ResponseEntity.ok(ViaggioService.getViaggioById(id));
    }

    @PostMapping
    public ResponseEntity<?> createViaggio(@RequestBody Viaggio viaggio) {
        Viaggio created = viaggioService.createViaggio(viaggio);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateViaggio(@PathVariable Long id, @RequestBody Viaggio viaggio) {
        return ResponseEntity.ok(viaggioService.updateViaggio(id, viaggio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteViaggio(@PathVariable Long id) {
        viaggioService.deleteViaggio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/stato")
    public ResponseEntity<?> updateStato(@PathVariable Long id, @RequestParam Stato stato) {
        return ResponseEntity.ok(viaggioService.updateStatoViaggio(id, stato));
    }



}
