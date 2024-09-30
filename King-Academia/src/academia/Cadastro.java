package academia;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class  Cadastro {
  
    
    private List<Cliente> arrayClientes = new ArrayList<>();
    private List<Funcionariof> arrayFucionarios = new ArrayList<>();
    public void getArrayCliente(Cliente cliente)
    {
        arrayClientes.add( cliente);
    }
    public void getArrayFuncionario(Funcionariof fucionariof)
    {
        arrayFucionarios.add(fucionariof);
    }
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
    
}
