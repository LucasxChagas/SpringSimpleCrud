package com.lucasxchagas.poo_av3.models.sorvete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SorveteService {
    @Autowired private SorveteRepository repo;

    public List<Sorvete> listSorvetes() { return (List<Sorvete>) repo.findAll(); }

    public void save(Sorvete sorvete) {
        repo.save(sorvete);
    }

    public Sorvete get(Integer id) throws SorveteNotFoundException {
        Optional<Sorvete> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new SorveteNotFoundException("Não foi encontrado nenhum sorvete com o ID" + id);

    }

}
