package it.epicode.W6_D5_U2.service;


import it.epicode.W6_D5_U2.exception.ResourceNotFoundException;
import it.epicode.W6_D5_U2.model.Stato;
import it.epicode.W6_D5_U2.model.Viaggio;
import it.epicode.W6_D5_U2.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    public static List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    public static Viaggio getViaggioById(Long id) {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Viaggio non trovato con id " + id));
    }

    public Viaggio createViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public Viaggio updateViaggio(Long id, Viaggio viaggioDetails) {
        Viaggio viaggio = getViaggioById(id);
        viaggio.setDestinazione(viaggioDetails.getDestinazione());
        viaggio.setData(viaggioDetails.getData());
        viaggio.setStato(viaggioDetails.getStato());
        return viaggioRepository.save(viaggio);
    }

    public void deleteViaggio(Long id) {
        Viaggio viaggio = getViaggioById(id);
        viaggioRepository.delete(viaggio);
    }

    public Viaggio updateStatoViaggio(Long id, Stato nuovoStato) {
        Viaggio viaggio = getViaggioById(id);
        viaggio.setStato(nuovoStato);
        return viaggioRepository.save(viaggio);
    }
}
