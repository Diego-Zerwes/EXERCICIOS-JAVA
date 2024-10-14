
package model;

public class Cadastro {
    private int idLogin;
    private String nome;
    private String email;
    private String senha;

    public Cadastro() {
        
    }

    public Cadastro(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Cadastro(int idLogin, String nome, String email, String senha) {
        this.idLogin = idLogin;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
