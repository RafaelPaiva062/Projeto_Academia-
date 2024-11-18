package academia;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Funcionario extends Usuario {
    private String tipoDefuncionario;
    private String senha;
    protected  String  tipocategoria;

    Funcionario( String tipocategoria,int numeroDeRegitro, String nome, String dataNascimento, String endereco, String tipoDefuncionario , String senha,int diasRegistrado)
    {
        
        super(numeroDeRegitro, nome, dataNascimento , endereco );
        this.tipocategoria = tipocategoria;
        this.tipoDefuncionario =tipoDefuncionario;

    }
    public String getTipoDefuncionario() {
        return tipoDefuncionario;
    }
    public void setTipoDefuncionario(String tipoDefuncionario) {
        this.tipoDefuncionario = tipoDefuncionario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
   
    public static boolean validarDataNascimento(String dataStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascimento;

        try {
            dataNascimento = LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        LocalDate hoje = LocalDate.now();
        if (dataNascimento.isAfter(hoje)) {
            return false;
        }        
        LocalDate dezoitoAnosAtras;
        dezoitoAnosAtras = hoje.minusYears(16);
        return !dataNascimento.isAfter(dezoitoAnosAtras);
    }
    public static Funcionario inseFuncionario() {
      Scanner sc =  new Scanner(System.in);
          
      
      
      return;
    }
    
}
