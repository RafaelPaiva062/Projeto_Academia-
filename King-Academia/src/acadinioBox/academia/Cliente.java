package acadinioBox.academia;

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
    
}
