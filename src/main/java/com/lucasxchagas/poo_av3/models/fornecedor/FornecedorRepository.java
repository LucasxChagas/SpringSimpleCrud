package com.lucasxchagas.poo_av3.models.fornecedor;

import org.springframework.data.repository.CrudRepository;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer> {
    public Long countById(Integer id);
}
