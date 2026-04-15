package model;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {

    private String nome;

    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = validarNome(nome);
        this.dataNascimento = validarDataNascimento(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = validarNome(nome);
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = validarDataNascimento(dataNascimento);
    }

    private String validarNome(String nome) {
        Objects.requireNonNull(nome, "Nome é obrigatório");

        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        return nome;
    }

    private LocalDate validarDataNascimento(LocalDate dataNascimento) {
        Objects.requireNonNull(dataNascimento, "Data de nascimento é obrigatória");

        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }

        return dataNascimento;
    }
}