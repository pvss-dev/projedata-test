import model.Funcionario;
import service.FuncionarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        List<Funcionario> funcionarios = criarFuncionarios();

        FuncionarioService service = new FuncionarioService(funcionarios);

        // 3.2 – Remover "João"
        service.removerPorNome("João");

        // 3.3 – Imprimir todos os funcionários
        service.imprimirTodos();

        // 3.4 – Aplicar aumento de 10%
        service.aplicarAumento();
        System.out.println("\n>> Aumento de 10% aplicado.");
        System.out.println(">> Imprimindo a lista de funcionários com o salário atualizado.\n");
        service.imprimirTodos();
        System.out.println();

        // 3.6 – Imprimir agrupados por função
        service.imprimirAgrupadosPorFuncao();

        // 3.8 – Aniversariantes dos meses 10 e 12
        System.out.println();
        service.imprimirAniversariantesDos(10, 12);

        // 3.9 – Funcionário mais velho
        System.out.println();
        service.imprimirMaisVelho();

        // 3.10 – Ordem alfabética
        System.out.println();
        service.imprimirEmOrdemAlfabetica();

        // 3.11 – Total dos salários
        System.out.println();
        service.imprimirTotalSalarios();

        // 3.12 – Salários mínimos por funcionário
        System.out.println();
        service.imprimirSalariosMinimos();
    }

    // 3.1 – Inserir todos os funcionários
    private static List<Funcionario> criarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(
                new Funcionario(
                        "Maria",
                        LocalDate.of(2000, 10, 18),
                        new BigDecimal("2009.44"), "Operador"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "João",
                        LocalDate.of(1990, 5, 12),
                        new BigDecimal("2284.38"), "Operador"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Caio",
                        LocalDate.of(1961, 5, 2),
                        new BigDecimal("9836.14"), "Coordenador"
                )
        );

        funcionarios.add(
                new Funcionario("Miguel",
                        LocalDate.of(1988, 10, 14),
                        new BigDecimal("19119.88"), "Diretor"
                )
        );

        funcionarios.add(
                new Funcionario("Alice",
                        LocalDate.of(1995, 1, 5),
                        new BigDecimal("2234.68"), "Recepcionista"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Heitor",
                        LocalDate.of(1999, 11, 19),
                        new BigDecimal("1582.72"), "Operador"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Arthur",
                        LocalDate.of(1993, 3, 31),
                        new BigDecimal("4071.84"), "Contador"
                )
        );

        funcionarios.add(new Funcionario(
                        "Laura",
                        LocalDate.of(1994, 7, 8),
                        new BigDecimal("3017.45"), "Gerente"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Heloísa",
                        LocalDate.of(2003, 5, 24),
                        new BigDecimal("1606.85"), "Eletricista"
                )
        );

        funcionarios.add(
                new Funcionario(
                        "Helena",
                        LocalDate.of(1996, 9, 2),
                        new BigDecimal("2799.93"), "Gerente"
                )
        );

        return funcionarios;
    }
}