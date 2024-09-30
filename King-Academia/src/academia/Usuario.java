package academia;

abstract class Usuario {
 private int numeroDeRegitro;
  private String nome;
   public Usuario(int numeroDeRegitro, String nome)
   {
       this.numeroDeRegitro = numeroDeRegitro;
       this.nome =nome;
   }
public int getNumeroDeRegitro() {
    return numeroDeRegitro;
}
public void setNumeroDeRegitro(int numeroDeRegitro) {
    this.numeroDeRegitro = numeroDeRegitro;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
}
