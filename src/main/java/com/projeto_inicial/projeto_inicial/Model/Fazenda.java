package com.projeto_inicial.projeto_inicial.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Fazenda {

    @Id
    private String idFazenda;
    private String nome;

    public String getIdFazenda() {
        return idFazenda;
    }

    public void setIdFazenda(String idFazenda) {
        this.idFazenda = idFazenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fazenda(String idFazenda, String nome) {
        this.idFazenda = idFazenda;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Fazenda{" +
                "id=" + idFazenda +
                ", nome='" + nome + '\'' +
                '}';
    }
}
