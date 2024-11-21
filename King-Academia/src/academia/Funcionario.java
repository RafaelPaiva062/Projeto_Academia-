package academia;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Funcionario extends Usuario {
    private String tipoDeFuncionario;
    private String senha;

    // Construtor da classe
    public Funcionario(int numeroDeRegistro, String nome, String dataNascimento, String endereco, String tipoDeFuncionario, String senha) {
        super(numeroDeRegistro, nome, dataNascimento, endereco);
        this.tipoDeFuncionario = tipoDeFuncionario;
        this.senha = senha;
    }

    // Getters e Setters
    public String getTipoDeFuncionario() {
        return tipoDeFuncionario;
    }

    public void setTipoDeFuncionario(String tipoDeFuncionario) {
        this.tipoDeFuncionario = tipoDeFuncionario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Validação de data de nascimento
    public static boolean validarDataNascimento(String dataStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate dataNascimento = LocalDate.parse(dataStr, formatter);
            LocalDate hoje = LocalDate.now();
            return !dataNascimento.isAfter(hoje.minusYears(16)); // Pelo menos 16 anos
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Método para cadastrar funcionário
    public static Funcionario inseFuncionario() {
        try (Scanner sc = new Scanner(System.in)) { // Scanner será fechado automaticamente
            String dataNascimento = null;

            System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=");
            System.out.println("Cadastro de Funcionario(a):");
            System.out.println("Insira o nome do funcionário(a):");
            String nome = sc.nextLine();

            while (dataNascimento == null) {
                System.out.println("\nInsira a data de nascimento do funcionário(a) (Formato: yyyy-MM-dd):");
                String entradaData = sc.nextLine();
                if (validarDataNascimento(entradaData)) {
                    dataNascimento = entradaData;
                    System.out.println("Data de nascimento válida.");
                } else {
                    System.out.println("Data de nascimento inválida. Certifique-se de que o funcionário tenha pelo menos 16 anos.");
                }
            }

            System.out.println("Insira seu cargo na academia:");
            String cargo = sc.nextLine();
            System.out.println("Insira o telefone do funcionário(a):");
            String telefone = sc.nextLine();
            System.out.println("Insira o endereço:");
            String endereco = sc.nextLine();
            System.out.println("Insira uma senha (exatamente 6 dígitos):");
            String senha = sc.nextLine();

            if (senha.length() != 6) {
                System.out.println("Senha inválida! A senha deve conter exatamente 6 caracteres.");
                return null; // Interrompe a criação
            }

            // Criação do objeto Funcionario
            Funcionario novoFuncionario = new Funcionario(1, nome, dataNascimento, endereco, cargo, senha);
            System.out.println("Funcionário cadastrado com sucesso!");
            return novoFuncionario;
        }
    }
}
