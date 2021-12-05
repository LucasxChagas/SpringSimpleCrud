package com.lucasxchagas.poo_av3.models.sorvete;

import com.lucasxchagas.poo_av3.models.fornecedor.Fornecedor;

import javax.persistence.*;

@Entity
@Table(name = "sorvetes")
public class Sorvete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String sabor;

    @Column(nullable = false, length = 100)
    private String cobertura;

    @Column(nullable = false, length = 100)
    private String recipiente;

    @Column(nullable = false, length = 100)
    private String complemento;

    @ManyToOne
    private Fornecedor fornecedor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(String recipiente) {
        this.recipiente = recipiente;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }


}
