package it.epicode.W6_D5_U2.controller;


import it.epicode.W6_D5_U2.model.Prenotazione;
import it.epicode.W6_D5_U2.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    public ResponseEntity<?> createPrenotazione(@RequestParam Long dipendenteId,
                                                @RequestParam Long viaggioId,
                                                @RequestBody Prenotazione prenotazione) {
        Prenotazione created = prenotazioneService.assignDipendenteToViaggio(dipendenteId, viaggioId, prenotazione);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
