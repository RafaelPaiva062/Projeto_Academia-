package acadinioBox.academia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import acadinioBox.modolodeCanecção.ModulloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Cliente extends Usuario  {
    private String senhaC;
    private String sexo;
    private double altura;
    private float peso;
    private int idade;
    private String imc;       
Cliente(String senhaC, int numeroDeRegitro, String nome, String dataNascimento, String endereco ,String sexo, double altura, float peso)
{  
    super(numeroDeRegitro, nome, dataNascimento , endereco );
    this.senhaC = senhaC;
    this.sexo = sexo;
    this.altura = altura;
    this.peso = peso;
    
}
public String getSexo() {
    return sexo;
}
public void setSexo(String sexo) {
    this.sexo = sexo;
}
public double getAltura() {
    return altura;
}
public void setAltura(double altura) {
    this.altura = altura;
}
public float getPeso() {
    return peso;
}
public void setPeso(float peso) {
    this.peso = peso;
}
public String getSenhaC() {
    return senhaC;
}
public void setSenhaC(String senhaC) {
    this.senhaC = senhaC;
}
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
 public static Cliente inteCliente(){
     try( Scanner sc = new Scanner(System.in)) {
        String dataNascimento = null;
        System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=");
        System.out.println("Insira o nome do cliente:");
        String nome= sc.nextLine();
        while (dataNascimento == null) {
        System.out.println("\nInsira a data de nascimento do cliente: (Formato: yyyy-MM-dd)");
        String entraData = sc.nextLine();
        if(validarDataNascimento(entraData)){
            System.out.println("Data de nascimento válida.");
        } else {
            System.out.println("Data de nascimento inválida. Certifique-se do cliente tenha pelo menos 16 anos.");
        }
            
        }
     } catch (Exception e) {
        
     }
 }
}
