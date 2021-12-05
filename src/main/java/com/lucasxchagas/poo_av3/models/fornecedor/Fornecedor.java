package com.lucasxchagas.poo_av3.models.fornecedor;

import com.lucasxchagas.poo_av3.models.sorvete.Sorvete;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 191)
    private String endereco;

    @Column(nullable = false, length = 20, unique = true)
    private String cnpj;

    @Column(nullable = false, length = 191, unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private String telefone;

    @OneToMany
    private List<Sorvete> sorvete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
