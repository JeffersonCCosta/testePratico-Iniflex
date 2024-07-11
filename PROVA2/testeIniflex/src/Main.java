/**
 * Projeto: Teste Prático - Iniflex
 * Descrição: Projeto desenvolvido na ide IntelliJ, que gerencia informações de funcionários.
 * @autor Jefferson Cristino da Costa
 * @date 10/07/2024
 */

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Cria os funcionarios em um array
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria  ", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João   ", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio   ", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel ", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice  ", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor ", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur ", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura  ", LocalDate.of(1996, 7, 8), new BigDecimal(3017.45), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena ", LocalDate.of(1996, 9, 2), new BigDecimal(2799.93), "Gerente"));

        //for-each para imprimir a lista de funcionarios.
        System.out.println("TABELA FUNCIONÁRIO - REQUISITO 3.1");
        for (Funcionario funcionario : funcionarios) {
            System.out.print("Nome: " + funcionario.getNome() + " | ");
            System.out.print("Data de Nascimento: " + funcionario.getDataNascimento() + " | ");
            System.out.print("Salário: " + funcionario.getSalario() + " | ");
            System.out.println("Função: " + funcionario.getFuncao());
        }

        System.out.println("\n// -------------------------------------------------------------------------------------------------------------//");

        System.out.println("\nTABELA FUNCIONÁRIO SEM O JOÃO - REQUISITO 3.2");
        //Expressão para remover o funcionario João
        funcionarios.removeIf(funcionario -> funcionario.getNome().trim().equals("João"));

        //for-each para imprimir a lista de funcionarios.
        for (Funcionario funcionario : funcionarios) {
            System.out.print("Nome: " + funcionario.getNome() + " | ");
            System.out.print("Data de Nascimento: " + funcionario.getDataNascimento() + " | ");
            System.out.print("Salário: " + funcionario.getSalario() + " | ");
            System.out.println("Função: " + funcionario.getFuncao());
        }

        System.out.println("\n// -------------------------------------------------------------------------------------------------------------//");

        System.out.println("\nTABELA FUNCIONÁRIO COM FORMATO DATA dd/MM/yyyy E SALARIO SEPARADO COM '.' E ',' - REQUISITO 3.3");
        //formatar o valor da data para dia/mês/ano
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //formatar o valor de salário com ponto no milhar e , na casa decimal
        DecimalFormat formatoReal = new DecimalFormat("#,##0.00");

        //for-each para imprimir a lista de funcionarios.
        for (Funcionario funcionario : funcionarios) {
            System.out.print("Nome: " + funcionario.getNome() + " | ");
            System.out.print("Data de Nascimento: " + funcionario.getDataNascimento().format(formatoData) + " | ");
            System.out.print("Salário: " + formatoReal.format(funcionario.getSalario()) + " | ");
            System.out.println("Função: " + funcionario.getFuncao());
        }

        System.out.println("\n// -------------------------------------------------------------------------------------------------------------//");

        System.out.println("\nTABELA FUNCIONÁRIO COM AUMENTO SALARIAL DE 10% - REQUISITO 3.4");
        //Chamando a função aumentoSalatio para aplicar os 10% de aumento.
        for (Funcionario funcionario : funcionarios) {
            funcionario.aumentoSalario(10);
        }

        //for-each para imprimir a lista de funcionarios.
        for (Funcionario funcionario : funcionarios) {
            System.out.print("Nome: " + funcionario.getNome() + " | ");
            System.out.print("Data de Nascimento: " + funcionario.getDataNascimento().format(formatoData) + " | ");
            System.out.print("Salário: " + formatoReal.format(funcionario.getSalario()) + " | ");
            System.out.println("Função: " + funcionario.getFuncao());
        }

        System.out.println("\n// -------------------------------------------------------------------------------------------------------------//");

        // Obs: Pedi ajuda de um amigo para fazer este pedaço e me explixar.
        System.out.println("\nTABELA FUNCIONÁRIO AGRUPANDO POR FUNÇÃO E IMPRIMINDO - REQUISITO 3.5 e 3.6");

        // Utilizando o MAP em uma lista de Funcionario para com uma collect de Função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        //Pegando os funicionarios por função.
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            //for-each para imprimir a lista de funcionarios.
            for (Funcionario funcionario : entry.getValue()) {
                System.out.print("Nome: " + funcionario.getNome() + " | ");
                System.out.print("Data de Nascimento: " + funcionario.getDataNascimento().format(formatoData) + " | ");
                System.out.println("Salário: " + formatoReal.format(funcionario.getSalario()) + " | ");
            }
            System.out.println();
        }

        System.out.println("\n// -------------------------------------------------------------------------------------------------------------//");

        System.out.println("\nTABELA FUNCIONÁRIO QUE FAZEM ANIVERSÁRIO NOS MESES 10 E 12 - REQUISITO 3.8");

        //for-each para imprimir a lista de funcionarios.
        for (Funcionario funcionario : funcionarios) {
            //Obtendo o mes
            int mes10e12 = funcionario.getDataNascimento().getMonthValue();

            //Verifica se o mês é 10 ou 12.
            if (mes10e12 == 10 || mes10e12 == 12) {
                System.out.print("Nome: " + funcionario.getNome() + " | ");
                System.out.print("Data de Nascimento: " + funcionario.getDataNascimento().format(formatoData) + " | ");
                System.out.print("Salário: " + formatoReal.format(funcionario.getSalario()) + " | ");
                System.out.println("Função: " + funcionario.getFuncao());
            }
        }

        System.out.println("\n// -------------------------------------------------------------------------------------------------------------//");

        System.out.println("\nTABELA FUNCIONÁRIO COM A MAIOR IDADE - REQUISITO 3.9");
        //Encontrando o funcionado com o menor ano de nascimento
        Funcionario idadeFuncionario = funcionarios.stream().min(Comparator.comparing(Funcionario::getDataNascimento)).orElse(null);
        if (idadeFuncionario != null) {
            //Calcula a idade do mais velho
            int idade = Period.between(idadeFuncionario.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("Nome: " + idadeFuncionario.getNome());
            System.out.println("Idade: " + idade + " anos!");
        }

        System.out.println("\n// -------------------------------------------------------------------------------------------------------------//");

        System.out.println("\nTABELA FUNCIONÁRIO EM ORDEM ALFABÉTICA - REQUISITO 3.10");

        //Compara os nomes em uma lista e devolve a lista em ordem alfabética
        List<Funcionario> ordemAlfabetica = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
        //for-each para imprimir a lista de funcionarios.
        for (Funcionario funcionario : ordemAlfabetica) {
            System.out.print("Nome: " + funcionario.getNome() + " | ");
            System.out.print("Data de Nascimento: " + funcionario.getDataNascimento().format(formatoData) + " | ");
            System.out.print("Salário: " + formatoReal.format(funcionario.getSalario()) + " | ");
            System.out.println("Função: " + funcionario.getFuncao());
        }

        System.out.println("\n// -------------------------------------------------------------------------------------------------------------//");

        System.out.println("\nSALÁRIO TOTAL DOS FUNCIONÁRIOS - REQUISITO 3.11");
        //Iniciado o BigDecimal em 0 e acumulando e somando os salario no add.
        BigDecimal totalSalarios = funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos Salários: R$" + formatoReal.format(totalSalarios));

        System.out.println("\n// -------------------------------------------------------------------------------------------------------------//");

        System.out.println("\nTABELA FUNCIONÁRIO COM QUANTIDADE DE SALÁRIOS MÍNIMOS - REQUISITO 3.12");

        //Definindo o valor do Salário Mínimo
        BigDecimal valorSalarioMinimo = new BigDecimal(1212.00);

        //for-each para imprimir a lista de funcionarios.
        for (Funcionario funcionario : ordemAlfabetica) {
            //Pegando o valor do salario atual do funcionario e dividindo pelo salario minimo.
            BigDecimal quantosSalariosMinimos = funcionario.getSalario().divide(valorSalarioMinimo,2);
            System.out.print("Nome: " + funcionario.getNome() + " | ");
            System.out.println("Quantidade de Salário Mínimo: " + formatoReal.format(quantosSalariosMinimos));
        }
    }
}
