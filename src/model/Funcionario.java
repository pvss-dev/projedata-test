package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa {

    private final BigDecimal salario;

    private final String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);

        Objects.requireNonNull(salario, "Salário é obrigatório");
        Objects.requireNonNull(funcao, "Função é obrigatória");

        if (salario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que zero");
        }

        if (funcao.isBlank()) {
            throw new IllegalArgumentException("Função não pode ser vazia");
        }

        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }
}