package acadinioBox.academia;

import java.util.Scanner;
import acadinioBox.modolodeCanecção.ModulloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            int telefone = sc.nextInt();
            System.out.println("Insira o endereço:");
            String endereco = sc.nextLine();
            System.out.println("Insira uma senha (exatamente 6 dígitos):");
            String senha = sc.nextLine();

            if (senha.length() != 6) {
                System.out.println("Senha inválida! A senha deve conter exatamente 6 caracteres.");
                return null; // Interrompe a criação
            }

            try (Connection conn = ModulloConexao.getConnection()) {
                String sql = "INSERT INTO funcionarios (nome, data_nascimento, cargo, telefone, endereco, senha) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, nome);
                    stmt.setString(2, dataNascimento);
                    stmt.setString(3, cargo);
                    stmt.setInt(4, telefone);
                    stmt.setString(5, endereco);
                    stmt.setString(6, senha);

                    int rowsInserted = stmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Funcionário cadastrado com sucesso!");
                        // Criação do objeto Funcionario
                        return new Funcionario(1, nome, dataNascimento, endereco, cargo, senha);
                    } else {
                        System.out.println("Falha ao cadastrar funcionário.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erro ao tentar cadastrar funcionário.");
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao tentar cadastrar funcionário.");
        }
        // Se o cadastro falhar ou for interrompido, retornamos null
        return null; 
    }
    public static void consultarFuncionario()
    {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Digite o númere de registro de funcionario  que deseja consultar?");
            int numeroDeRegistro =  sc.nextInt();
            try(Connection conn = ModulloConexao.getConnection()){
                String sql =  "SELECT * FROM funcionarios WHERE numeroDeRegistro = ?";
                try(PreparedStatement stmt = conn.prepareStatement(sql))
                {
                    stmt.setInt(0, numeroDeRegistro);
                    try(ResultSet rs = stmt.executeQuery()){
                        if(rs.next())
                        {
                            System.out.println("Nome: " + rs.getString("nome"));
                        System.out.println("Data de Nascimento: " + rs.getString("data_nascimento"));
                        System.out.println("Cargo: " + rs.getString("cargo"));
                        System.out.println("Telefone: " + rs.getString("numeroDeRegistro"));
                        System.out.println("Endereço: " + rs.getString("endereco"));

                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erro ao consultar funcionário.");
            }
        }
    }
    public static boolean atualizarFuncionario() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Digite o número de registro do funcionário que deseja atualizar:");
            int numeroRegistro = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha

            System.out.println("Digite o novo nome do funcionário:");
            String novoNome = sc.nextLine();

            System.out.println("Digite o novo cargo:");
            String novoCargo = sc.nextLine();

            System.out.println("Digite o novo telefone:");
            String novoTelefone = sc.nextLine();

            System.out.println("Digite o novo endereço:");
            String novoEndereco = sc.nextLine();

            try (Connection conn = ModulloConexao.getConnection()) {
                String sql = "UPDATE funcionarios SET nome = ?, cargo = ?, telefone = ?, endereco = ? WHERE numero_registro = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, novoNome);
                    stmt.setString(2, novoCargo);
                    stmt.setString(3, novoTelefone);
                    stmt.setString(4, novoEndereco);
                    stmt.setInt(5, numeroRegistro);

                    int rowsUpdated = stmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Funcionário atualizado com sucesso!");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erro ao atualizar funcionário.");
            }
        }
        if (atualizarFuncionario()) {
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Falha ao atualizar funcionário.");
        }
        
     return false;
    }
    public static boolean excluirFuncionario() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Digite o número de registro do funcionário que deseja excluir:");
            int numeroRegistro = sc.nextInt();
    
            try (Connection conn = ModulloConexao.getConnection()) {
                String sql = "DELETE FROM funcionarios WHERE numero_registro = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, numeroRegistro);
    
                    int rowsDeleted = stmt.executeUpdate();
                    return rowsDeleted > 0; // Retorna true se pelo menos uma linha foi excluída
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retorna false em caso de erro ou nenhuma linha excluída
    }
    

}
