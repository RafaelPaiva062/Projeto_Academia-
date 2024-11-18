package academia;

abstract class Usuario {
 private int numeroDeRegitro;
 private String nome;
 private String dataNascimento;

 private String  endereco;
 
   public Usuario(int numeroDeRegitro, String nome, String dataNascimento,  String endereco )
   {
       this.numeroDeRegitro = numeroDeRegitro;
       this.nome =nome;
       this.dataNascimento =dataNascimento;
     
       this.endereco = endereco;
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
    public String getDataNascimento() {
        return dataNascimento;
    }


    public String getEndereco() {
        return endereco;
    }
    public String mostrarDetalhes() {
        System.out.println("Número de dias Registrado:"+ getNumeroDeRegitro());
        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Telefone: " + getNumeroDeRegitro());
        System.out.println("Endereço: " + getEndereco());
        return null;
    }
    
}
