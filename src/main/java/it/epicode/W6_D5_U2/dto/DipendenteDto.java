package it.epicode.W6_D5_U2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DipendenteDto {
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String imageUrl;

}