package model;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {

    private final String nome;

    private final LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        Objects.requireNonNull(nome, "Nome é obrigatório");
        Objects.requireNonNull(dataNascimento, "Data de nascimento é obrigatória");

        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }

        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}