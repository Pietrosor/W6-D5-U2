package it.epicode.W6_D5_U2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "viaggi")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinazione;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Stato stato;

}

public enum Stato {
    IN_PROGRAMMA,
    COMPLETATO
}
