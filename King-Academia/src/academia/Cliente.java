package academia;

public class Cliente extends Usuario  {
    private String senhaC;
    private String sexo;
    private double altura;
    private float peso;
Cliente(String senhaC, int numeroDeRegitro, String nome,String sexo, double altura, float peso)
{  
    super(numeroDeRegitro, nome);
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
public void add(Cliente arrayCliente) {
}
public String getSenhaC() {
    return senhaC;
}
public void setSenhaC(String senhaC) {
    this.senhaC = senhaC;
}
    
}
