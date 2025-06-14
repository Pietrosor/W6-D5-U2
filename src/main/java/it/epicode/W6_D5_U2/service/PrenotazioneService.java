package it.epicode.W6_D5_U2.service;

import it.epicode.W6_D5_U2.exception.DuplicateBookingException;
import it.epicode.W6_D5_U2.exception.ResourceNotFoundException;
import it.epicode.W6_D5_U2.model.Dipendente;
import it.epicode.W6_D5_U2.model.Prenotazione;
import it.epicode.W6_D5_U2.model.Viaggio;
import it.epicode.W6_D5_U2.repository.DipendenteRepository;
import it.epicode.W6_D5_U2.repository.PrenotazioneRepository;
import it.epicode.W6_D5_U2.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    public Prenotazione assignDipendenteToViaggio(Long dipendenteId, Long viaggioId, Prenotazione prenotazioneDetails) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new ResourceNotFoundException("Dipendente non trovato con id " + dipendenteId));
        Viaggio viaggio = viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new ResourceNotFoundException("Viaggio non trovato con id " + viaggioId));

        // Controlla che per la data richiesta il dipendente non abbia già prenotazioni
        LocalDate dataRichiesta = prenotazioneDetails.getDataRichiesta();
        prenotazioneRepository.findByDipendenteIdAndDataRichiesta(dipendenteId, dataRichiesta)
                .ifPresent(existing -> {
                    throw new DuplicateBookingException("Il dipendente ha già una prenotazione in questa data: " + dataRichiesta);
                });

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(dataRichiesta);
        prenotazione.setNote(prenotazioneDetails.getNote());
        return prenotazioneRepository.save(prenotazione);
    }
}