package com.projeto_inicial.projeto_inicial.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Talhao {

    @Id
    private String id;
    private String nome;
    private int area;

    @DBRef
    private String idFazenda;

    public Talhao(String nome, int area, String idFazenda) {
        this.nome = nome;
        this.area = area;
        this.idFazenda = idFazenda;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getIdFazenda() {
        return idFazenda;
    }

    public void setIdFazenda(String idFazenda) {
        this.idFazenda = idFazenda;
    }

    @Override
    public String toString() {
        return "Talhao{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", area=" + area +
                ", idFazenda='" + idFazenda + '\'' +
                '}';
    }
}
