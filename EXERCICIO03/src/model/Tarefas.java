
package model;

import java.util.Date;

public class Tarefas {
    private int idTarefa;
    private String nome;
    private String descricao;
    private Date dataVencimento;
    private String situacao;

    public Tarefas() {
        
    }

    public Tarefas(String nome, String descricao, Date  dataVencimento, String situacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.situacao = situacao;
    }

    public Tarefas(int idTarefa, String nome, String descricao, Date  dataVencimento, String situacao) {
        this.idTarefa = idTarefa;
        this.nome = nome;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.situacao = situacao;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date  getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    
}
