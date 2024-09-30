package academia;

class Funcionariof extends Usuario {
    private String tipoDefuncionario;
    private String senha;
    Funcionariof(int numeroDeRegitro, String nome,String tipoDefuncionario , String senha )
    {
        super(numeroDeRegitro, nome);
        this.tipoDefuncionario = tipoDefuncionario;
        this.senha = senha;
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
    public void add(Funcionariof arrayFucionario) {
    }
    
}
