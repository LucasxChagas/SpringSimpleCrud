package com.lucasxchagas.poo_av3.models.fornecedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired private FornecedorRepository repo;

    public List<Fornecedor> listFornecedores()
    {
        return (List<Fornecedor>) repo.findAll();
    }

    public void save(Fornecedor fornecedor) {
        repo.save(fornecedor);
    }

    public Fornecedor get(Integer id) throws FornecedorNotFoundException {
        Optional<Fornecedor> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new FornecedorNotFoundException("Não foi encontrado nenhum fornecedor com o ID" + id);

    }

    public void delete(Integer id) throws FornecedorNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0)
        {
            throw new FornecedorNotFoundException("Não foi encontrado nenhum fornecedor com o ID" + id);
        }
        repo.deleteById(id);
    }
}
