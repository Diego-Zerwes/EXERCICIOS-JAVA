
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Tarefas;
import dao.ConexaoBanco;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class TarefasDao implements DaoGenerica<Tarefas> {

       private ConexaoBanco conexao;
    
    public TarefasDao()
    {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Tarefas tarefa) {
        String sql = "INSERT INTO tarefa (nome, descricao, dataVencimento, situacao) VALUES (?,?,?,?)";
   
    try {
        if(this.conexao.conectar()){
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            
            sentenca.setString(1, tarefa.getNome()); 
            sentenca.setString(2, tarefa.getDescricao());
            
            // Definindo a data corretamente
            java.sql.Date dataSql = new java.sql.Date(tarefa.getDataVencimento().getTime());
            sentenca.setDate(3, dataSql);  // Use o setDate aqui para passar a data corretamente
            
            sentenca.setString(4, tarefa.getSituacao());     
            
            sentenca.execute(); 
            System.out.println("Dados inseridos: " + sentenca);
            
            sentenca.close(); 
            this.conexao.getConnection().close();
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
    }


    @Override
    public void alterar(Tarefas tarefa) {
        String sql = "UPDATE tarefa SET nome = ?, descricao = ?, dataVencimento = ?, situacao = ?  where idTarefa = ?";
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                        
                sentenca.setString(1,tarefa.getNome()); 
                sentenca.setString(2,tarefa.getDescricao());
                sentenca.setDate(3, (Date)tarefa.getDataVencimento()); 
                sentenca.setString(4,tarefa.getDescricao());
                sentenca.setInt(5, tarefa.getIdTarefa());
                sentenca.execute(); 
                sentenca.close(); 
                this.conexao.getConnection().close();
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir() {
        String sql = "DELETE FROM tarefa";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
   
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }
    
    public void excluirId(int id){
    String sql = "DELETE FROM tarefa WHERE idTarefa = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(1, id);
                
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    @Override
    public ArrayList<Tarefas> consultar() {
       ArrayList<Tarefas> listaCadastros = new ArrayList<>();
    String sql = "SELECT c.idTarefa, c.nome, c.descricao, c.dataVencimento, c.situacao " +
                 "FROM tarefa as c " +
                 "ORDER BY c.idTarefa";

    try {
        if (this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultadoSentenca = sentenca.executeQuery();

            while (resultadoSentenca.next()) {
                Tarefas cadastro = new Tarefas();
                cadastro.setIdTarefa(resultadoSentenca.getInt("idTarefa"));
                cadastro.setNome(resultadoSentenca.getString("nome"));
                cadastro.setDescricao(resultadoSentenca.getString("descricao"));

                // Recupera a data diretamente
                cadastro.setDataVencimento(resultadoSentenca.getDate("dataVencimento"));

                cadastro.setSituacao(resultadoSentenca.getString("situacao"));

                // Adiciona o objeto à lista
                listaCadastros.add(cadastro);
            }

            // Fecha a sentença e a conexão após a consulta
            sentenca.close();
            this.conexao.getConnection().close();
        }
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao consultar tarefas: " + ex.getMessage(), ex);
    }

    return listaCadastros;
    }

    @Override
    public ArrayList<Tarefas> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
