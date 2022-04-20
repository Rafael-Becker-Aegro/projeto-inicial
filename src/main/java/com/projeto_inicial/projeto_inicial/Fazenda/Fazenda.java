package com.projeto_inicial.projeto_inicial.Fazenda;

public class Fazenda {
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fazenda(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Fazenda{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
