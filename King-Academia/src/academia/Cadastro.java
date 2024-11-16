package academia;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class  Cadastro {
    private static Scanner sc = new Scanner(System.in); 
    private   List<Cliente> arrayClientes = new ArrayList<>();
    private List<Funcionariof> arrayFucionarios = new ArrayList<>();
   
    public List<Cliente> getArrayClientes() {
        return arrayClientes;
    }
    public void setArrayClientes(List<Cliente> arrayClientes) {
        this.arrayClientes = arrayClientes;
    }
    public List<Funcionariof> getArrayFucionarios() {
        return arrayFucionarios;
    }
    public void setArrayFucionarios(List<Funcionariof> arrayFucianrios) {
        this.arrayFucionarios = arrayFucianrios;
    }
    public void adicionarArrayCliente(Cliente cliente)
    {
       if(cliente != null){ arrayClientes.add(cliente);}
    }
    public void adiconarArrayFuncionario(Funcionariof fucionariof)
    {
        if(fucionariof != null){arrayFucionarios.add(fucionariof);}
    }
     public void mostraCliente()
     {
            System.out.println("\n --- Lista de Clientes ----");
            if(arrayClientes.isEmpty()){     
                System.out.println("Nenhum cleinte cadastrado.");
        }else{
            for (Cliente cliente: arrayClientes)
            {
                System.out.println(arrayClientes);
            }
        }        
     }
     public void mostraFuncionario()
     {
            System.out.println("\n --- Lista de Funcinario ----");
            if(arrayClientes.isEmpty()){     
                System.out.println("Nenhum funcionario cadastrado.");
        }else{
            for (Funcionariof funcionariof: arrayFucionarios)
            {
                System.out.println(funcionariof);
            }
        }        
        
     }
}
