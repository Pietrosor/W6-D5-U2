package it.epicode.W6_D5_U2.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrenotazioneDto {
    private Long id;
    private Long viaggioId;
    private Long dipendenteId;
    private LocalDate dataRichiesta;
    private String note;

}