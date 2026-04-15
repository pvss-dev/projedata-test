package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    private static final Set<String> FUNCOES_VALIDAS = Set.of(
            "Operador", "Coordenador", "Diretor", "Recepcionista",
            "Contador", "Gerente", "Eletricista"
    );


    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = validarSalario(salario);
        this.funcao = validarFuncao(funcao);
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = validarSalario(salario);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = validarFuncao(funcao);
    }

    private BigDecimal validarSalario(BigDecimal salario) {
        Objects.requireNonNull(salario, "Salário é obrigatório");

        if (salario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que zero");
        }

        return salario;
    }

    private String validarFuncao(String funcao) {
        Objects.requireNonNull(funcao, "Função deve ser informada");

        if (funcao.isBlank()) {
            throw new IllegalArgumentException("Função não pode ser vazia");
        }

        if (!FUNCOES_VALIDAS.contains(funcao)) {
            throw new IllegalArgumentException("Função inválida");
        }

        return funcao;
    }
}