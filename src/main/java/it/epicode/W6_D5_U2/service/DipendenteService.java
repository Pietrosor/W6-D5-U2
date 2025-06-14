package it.epicode.W6_D5_U2.service;

import it.epicode.W6_D5_U2.exception.ResourceNotFoundException;
import it.epicode.W6_D5_U2.model.Dipendente;
import it.epicode.W6_D5_U2.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.List;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

//    @Autowired
//    private Cloudinary cloudinary;

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Dipendente getDipendenteById(Long id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dipendente non trovato con id " + id));
    }

    public Dipendente createDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public Dipendente updateDipendente(Long id, Dipendente dipendenteDetails) {
        Dipendente dipendente = getDipendenteById(id);
        dipendente.setUsername(dipendenteDetails.getUsername());
        dipendente.setNome(dipendenteDetails.getNome());
        dipendente.setCognome(dipendenteDetails.getCognome());
        dipendente.setEmail(dipendenteDetails.getEmail());
        return dipendenteRepository.save(dipendente);
    }

    public void deleteDipendente(Long id) {
        Dipendente dipendente = getDipendenteById(id);
        dipendenteRepository.delete(dipendente);
    }

//    public String uploadProfileImage(Long id, MultipartFile file) throws IOException {
//        Dipendente dipendente = getDipendenteById(id);
//        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
//        String imageUrl = (String) uploadResult.get("url");
//        dipendente.setImageUrl(imageUrl);
//        dipendenteRepository.save(dipendente);
//        return imageUrl;
//    }
}
