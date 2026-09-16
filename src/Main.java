import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import java.time.Period;

public class Main {

    private static String formatarData(LocalDate data) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatoData); }

    private static String formatarSalario(BigDecimal salario) {
        NumberFormat formatoSalario = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));
        formatoSalario.setMinimumFractionDigits(2);
        formatoSalario.setMaximumFractionDigits(2);
        return formatoSalario.format(salario); }

    private static List<Funcionario> criarFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();

        for (String[] dados : DadosFuncionarios.dados) {

            funcionarios.add(
                    new Funcionario(
                            dados[0],
                            LocalDate.parse(dados[1]),
                            new BigDecimal(dados[2]),
                            dados[3]
                    ));

        }
        return funcionarios;
    }

    private static void removerFuncionario
            (List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(funcionario ->
                funcionario.nome.equals(nome)
        );
    }


    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {


        for (Funcionario funcionario : funcionarios) {

            System.out.println(
                    "Nome: " + funcionario.nome +
                            " | Data de nascimento: " + formatarData(funcionario.dataNascimento) +
                            " | Salário: R$ " + formatarSalario(funcionario.salario) +
                            " | Função: " + funcionario.funcao
            );
        }
    }

    private static void aumentarSalarios(List<Funcionario> funcionarios) {

        for (Funcionario funcionario : funcionarios) {
            funcionario.salario = funcionario.salario.multiply(
                    new BigDecimal("1.10")
            );
        }
    }

    private static Map<String, List<Funcionario>> agruparPorFuncao(
            List<Funcionario> funcionarios) {

        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {

            funcionariosPorFuncao
                    .computeIfAbsent(funcionario.funcao, chave -> new ArrayList<>())
                    .add(funcionario);
        }

        return funcionariosPorFuncao;
    }


    private static void imprimirFuncionariosPorFuncao(
            Map<String, List<Funcionario>> funcionariosPorFuncao) {

        for (String funcao : funcionariosPorFuncao.keySet()) {

            System.out.println("Função: " + funcao);

            for (Funcionario funcionario : funcionariosPorFuncao.get(funcao)) {
                System.out.println(
                        "Nome: " + funcionario.nome +
                                " | Data de nascimento: " + formatarData(funcionario.dataNascimento) +
                                " | Salário: R$ " + formatarSalario(funcionario.salario) 
                );
            }
            System.out.print("\n");
        }
    }

    private static void imprimirAniversariantes(
            List<Funcionario> funcionarios,
            List<Integer> meses) {

        for (Funcionario funcionario : funcionarios) {

            int mes = funcionario.dataNascimento.getMonthValue();

            if (meses.contains(mes)) {
                System.out.println(
                        "Nome: " + funcionario.nome +
                                " | Data de nascimento: " + formatarData(funcionario.dataNascimento) +
                                " | Salário: R$ " + formatarSalario(funcionario.salario) +
                                " | Função: " + funcionario.funcao
                );
            }
        }
    }

    private static void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {

        Funcionario maisVelho = funcionarios.get(0);

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.dataNascimento.isBefore(maisVelho.dataNascimento)) {
                maisVelho = funcionario;
            }
        }

        int idade = Period.between(
                maisVelho.dataNascimento,
                LocalDate.now()
        ).getYears();

        System.out.println(
                "Nome: " + maisVelho.nome +
                        " | Idade: " + idade
        );
    }

    private static void ordenarFuncionariosPorNome(List<Funcionario> funcionarios) {

        funcionarios.sort(
                (funcionario1, funcionario2) ->
                        funcionario1.nome.compareToIgnoreCase(funcionario2.nome)
        );
    }


    private static void imprimirTotalSalarios(List<Funcionario> funcionarios) {

        BigDecimal total = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {
            total = total.add(funcionario.salario);
        }



        System.out.println(
                "Total dos salários: R$ " + formatarSalario(total)
        );
    }

    private static void imprimirSalariosMinimos(List<Funcionario> funcionarios) {

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        for (Funcionario funcionario : funcionarios) {

            BigDecimal quantidade = funcionario.salario.divide(
                    salarioMinimo,
                    2,
                    RoundingMode.HALF_UP
            );

            System.out.println(
                    "Nome: " + funcionario.nome +
                            " | Salários mínimos: " + quantidade
            );
        }
    }


    public static void main(String[] args) {
    	
    	System.out.println("TESTE TÉCNICO PROTHERA GUPY");
    	System.out.println("Desenvolvedor: William Queiroz de Oliveira Souza");
    	
    	System.out.println("\n------ 3.1  INSERIR LISTA DE FUNCIONÁRIOS");
        List<Funcionario> funcionarios = criarFuncionarios();
        imprimirFuncionarios(funcionarios);

        System.out.println("\n------ 3.2  REMOVER JOÃO");
        removerFuncionario(funcionarios, "João");

        System.out.println("\n------ 3.3 IMPRIMIR FUNCIONÁRIOS");
        imprimirFuncionarios(funcionarios);

        System.out.println("\n------ 3.4 AUMENTAR SALÁRIOS EM 10%");
        aumentarSalarios(funcionarios);
        imprimirFuncionarios(funcionarios);

        System.out.println("\n------ 3.5 AGRUPAR FUNCIONÁRIOS POR FUNÇÃO");
        Map<String, List<Funcionario>> funcionariosPorFuncao =
                agruparPorFuncao(funcionarios);

        System.out.println("\n------ 3.6 IMPRIMIR FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO");
        imprimirFuncionariosPorFuncao(funcionariosPorFuncao);

        System.out.println("\n------ 3.8 IMPRIMIR ANIVERSARIANTES DOS MESES 10 E 12");
        imprimirAniversariantes(funcionarios, List.of(10, 12));

        System.out.println("\n------ 3.9 IMPRIMIR FUNCIONÁRIO MAIS VELHO");
        imprimirFuncionarioMaisVelho(funcionarios);

        System.out.println("\n------ 3.10 IMPRIMIR FUNCIONÁRIOS POR ORDEM ALFABÉTICA");
        ordenarFuncionariosPorNome(funcionarios);
        imprimirFuncionarios(funcionarios);

        System.out.println("\n------ 3.11 IMPRIMIR TOTAL DOS SALÁRIOS");
        imprimirTotalSalarios(funcionarios);

        System.out.println("\n------ 3.12 IMPRIMIR QUANTIDADE DE SALÁRIOS MÍNIMOS");
        imprimirSalariosMinimos(funcionarios);
    }}