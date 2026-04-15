package service;

import model.Funcionario;
import util.Formatador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Serviço responsável por toda a lógica de negócio relacionada aos funcionários.
 */
public class FuncionarioService {

    private static final BigDecimal PERCENTUAL_AUMENTO = new BigDecimal("0.10");
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    private final List<Funcionario> funcionarios;

    public FuncionarioService(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    // ------------------------------------------------------------------
    // 3.2 – Remover funcionário pelo nome
    // ------------------------------------------------------------------
    public void removerPorNome(String nome) {
        funcionarios.removeIf(f -> f.getNome().equals(nome));
    }

    // ------------------------------------------------------------------
    // 3.3 – Imprimir todos os funcionários
    // ------------------------------------------------------------------
    public void imprimirTodos() {
        System.out.println("============================================================");
        System.out.println("  LISTA DE FUNCIONÁRIOS");
        System.out.println("============================================================");
        funcionarios.forEach(this::imprimirFuncionario);
    }

    // ------------------------------------------------------------------
    // 3.4 – Aplicar aumento percentual nos salários
    // ------------------------------------------------------------------
    public void aplicarAumento() {
        funcionarios.forEach(f -> {
            BigDecimal novoSalario = f.getSalario()
                    .add(f.getSalario().multiply(PERCENTUAL_AUMENTO))
                    .setScale(2, RoundingMode.HALF_UP);
            f.setSalario(novoSalario);
        });
    }

    // ------------------------------------------------------------------
    // 3.5 – Agrupar funcionários por função
    // ------------------------------------------------------------------
    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    // ------------------------------------------------------------------
    // 3.6 – Imprimir funcionários agrupados por função
    // ------------------------------------------------------------------
    public void imprimirAgrupadosPorFuncao() {
        System.out.println("============================================================");
        System.out.println("  FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO");
        System.out.println("============================================================");

        agruparPorFuncao().forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(f -> System.out.printf("  - %-10s | Nascimento: %s | Salário: R$ %s%n",
                    f.getNome(),
                    Formatador.formatarData(f.getDataNascimento()),
                    Formatador.formatarSalario(f.getSalario())));
        });
    }

    // ------------------------------------------------------------------
    // 3.8 – Imprimir aniversariantes de meses específicos
    // ------------------------------------------------------------------
    public void imprimirAniversariantesDos(int... meses) {
        Set<Integer> mesesFiltro = new HashSet<>();
        for (int m : meses) mesesFiltro.add(m);

        System.out.println("============================================================");
        System.out.printf("  ANIVERSARIANTES DOS MESES: %s%n", mesesFiltro);
        System.out.println("============================================================");

        funcionarios.stream()
                .filter(f -> mesesFiltro.contains(f.getDataNascimento().getMonthValue()))
                .forEach(f -> System.out.printf("Nome: %-10s | Nascimento: %s%n",
                        f.getNome(),
                        Formatador.formatarData(f.getDataNascimento())));
    }

    // ------------------------------------------------------------------
    // 3.9 – Imprimir o funcionário mais velho
    // ------------------------------------------------------------------
    public void imprimirMaisVelho() {
        System.out.println("============================================================");
        System.out.println("  FUNCIONÁRIO MAIS VELHO");
        System.out.println("============================================================");

        funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .ifPresent(f -> {
                    int idade = Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
                    System.out.printf("Nome: %s | Idade: %d anos%n", f.getNome(), idade);
                });
    }

    // ------------------------------------------------------------------
    // 3.10 – Imprimir funcionários em ordem alfabética
    // ------------------------------------------------------------------
    public void imprimirEmOrdemAlfabetica() {
        System.out.println("============================================================");
        System.out.println("  FUNCIONÁRIOS EM ORDEM ALFABÉTICA");
        System.out.println("============================================================");

        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.printf("Nome: %-10s | Função: %s%n",
                        f.getNome(), f.getFuncao()));
    }

    // ------------------------------------------------------------------
    // 3.11 – Imprimir total dos salários
    // ------------------------------------------------------------------
    public void imprimirTotalSalarios() {
        System.out.println("============================================================");
        System.out.println("  TOTAL DOS SALÁRIOS");
        System.out.println("============================================================");

        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total: R$ " + Formatador.formatarSalario(total));
    }

    // ------------------------------------------------------------------
    // 3.12 – Imprimir quantos salários mínimos cada funcionário ganha
    // ------------------------------------------------------------------
    public void imprimirSalariosMinimos() {
        System.out.println("============================================================");
        System.out.println("  SALÁRIOS MÍNIMOS POR FUNCIONÁRIO");
        System.out.println("============================================================");

        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
            System.out.printf("Nome: %-10s | Salários mínimos: %s%n",
                    f.getNome(), Formatador.formatarQuantidade(qtd));
        });
    }

    // ------------------------------------------------------------------
    // Imprime um único funcionário formatado
    // ------------------------------------------------------------------
    private void imprimirFuncionario(Funcionario f) {
        System.out.printf("Nome: %-10s | Nascimento: %s | Salário: R$ %s | Função: %s%n",
                f.getNome(),
                Formatador.formatarData(f.getDataNascimento()),
                Formatador.formatarSalario(f.getSalario()),
                f.getFuncao());
    }
}