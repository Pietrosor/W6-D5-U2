package it.epicode.W6_D5_U2.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioDto {
    private Long id;
    private String destinazione;
    private LocalDate data;
    private String stato;

}
