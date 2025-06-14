package it.epicode.W6_D5_U2.repository;

import it.epicode.W6_D5_U2.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    Optional<Prenotazione> findByDipendenteIdAndDataRichiesta(Long dipendenteId, LocalDate dataRichiesta);
}
