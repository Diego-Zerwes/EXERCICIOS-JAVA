
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.CadastroContato;


public class CadastroContatoDao implements DaoGenerica<CadastroContato>{
    private ConexaoBanco conexao;
    
    public CadastroContatoDao()
    {
        this.conexao = new ConexaoBanco();
    }
    
    @Override
    public void inserir(CadastroContato contato) {
       String sql = "INSERT INTO agenda (nome, telefone, email, endereco) VALUES (?,?,?,?)";
       String verificarSql = "SELECT COUNT(*) FROM agenda WHERE telefone = ?, email = ?";
       
      try {
        if(this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

            // Defina todos os parâmetros necessários
            sentenca.setString(1, contato.getNome()); 
            sentenca.setString(2, contato.getTelefone());
            sentenca.setString(3, contato.getEmail());
            sentenca.setString(4, contato.getEndereco());

            // Execute a inserção
            sentenca.execute(); 
            sentenca.close(); 
            this.conexao.getConnection().close();
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex.getMessage());
        throw new RuntimeException(ex);
    }
    }

    @Override
    public void alterar(CadastroContato contato) {
       String sql = "UPDATE agenda SET nome = ?,  email = ?,  endereco = ?, telefone = ? where idAgenda = ? ";
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                        
                sentenca.setString(1,contato.getNome());
                sentenca.setString(2, contato.getEmail());
                sentenca.setString(3, contato.getEndereco());
                sentenca.setString(4,contato.getTelefone());
                sentenca.setInt(5, contato.getIdAgenda());
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
        String sql = "DELETE FROM agenda";
        
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
    String sql = "DELETE FROM agenda WHERE idAgenda = ?";
        
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
    public ArrayList<CadastroContato> consultar() {
        ArrayList<CadastroContato> listaCadastros = new ArrayList<CadastroContato>();
        String sql = "SELECT c.idAgenda, c.nome, c.telefone, c.email, c.endereco " +
                    "fROM agenda as c " + 
                    "ORDER BY c.idAgenda ";
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while(resultadoSentenca.next()){
                    CadastroContato cadastro = new CadastroContato();
                    cadastro.setIdAgenda(resultadoSentenca.getInt("idAgenda"));
                    cadastro.setNome(resultadoSentenca.getString("nome"));
                    cadastro.setTelefone(resultadoSentenca.getString("telefone"));
                    cadastro.setEmail(resultadoSentenca.getString("email"));
                    cadastro.setEndereco(resultadoSentenca.getString("endereco"));
                    
                    listaCadastros.add(cadastro);
                }
            }
            return listaCadastros;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }    
    }

     public ArrayList<CadastroContato> consultar(String str) {
        ArrayList<CadastroContato> listaCadastrosStr = new ArrayList<CadastroContato>();
        String sql = "SELECT c.idAgenda, c.nome, c.telefone, c.email, c.endereco " +
                     "FROM agenda as c " +
                     "WHERE (UPPER(c.nome) LIKE UPPER(?) OR c.telefone LIKE ?) "+
                     "ORDER BY c.nome, c.telefone";
        
         try
    {
        if (this.conexao.conectar())
        {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

            // Define os parâmetros para nome e telefone
            String parametroBusca = "%" + str + "%"; // Para busca parcial
            sentenca.setString(1, parametroBusca); // Para o nome
            sentenca.setString(2, parametroBusca); // Para o telefone

            ResultSet resultadoSentenca = sentenca.executeQuery();

            while (resultadoSentenca.next()) 
            {
                CadastroContato cadastro = new CadastroContato();
                cadastro.setIdAgenda(resultadoSentenca.getInt("idAgenda"));
                cadastro.setNome(resultadoSentenca.getString("nome"));
                cadastro.setTelefone(resultadoSentenca.getString("telefone"));
                cadastro.setEmail(resultadoSentenca.getString("email"));
                cadastro.setEndereco(resultadoSentenca.getString("endereco"));

                listaCadastrosStr.add(cadastro);
            }

            sentenca.close();
            this.conexao.getConnection().close();
        }
        
        return listaCadastrosStr;
    }
    catch (SQLException ex)
    {
        throw new RuntimeException(ex);
    }
    }  
     
    @Override
    public ArrayList<CadastroContato> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
