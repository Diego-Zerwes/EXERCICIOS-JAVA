package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import model.Cadastro;

     
public class CadastroDao implements DaoGenerica<Cadastro>{

    private ConexaoBanco conexao;
    
    public CadastroDao()
    {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Cadastro usuario) {
        String sql = "INSERT INTO login (nome, email, senha) VALUES (?,?,?)";
       
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1,usuario.getNome()); 
                sentenca.setString(2,usuario.getEmail());
                sentenca.setString(3, usuario.getSenha());     
                sentenca.execute(); 
                System.out.println(sentenca);
                sentenca.close(); 
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(Cadastro usuario) {
         String sql = "UPDATE login SET nome = ?, email = ?, senha = ? where idProduto = ?";
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                        
                sentenca.setString(1,usuario.getNome()); 
                sentenca.setString(2,usuario.getEmail());
                sentenca.setString(4,usuario.getSenha());
                sentenca.setInt(5, usuario.getIdLogin());
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
       String sql = "DELETE FROM login";
        
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
    String sql = "DELETE FROM login WHERE idLogin = ?";
        
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
    public ArrayList<Cadastro> consultar() {
        ArrayList<Cadastro> listaCadastros = new ArrayList<Cadastro>();
        String sql = "SELECT c.idLogin, c.nome, c.email, c.senha " +
                    "fROM login as c " + 
                    "ORDER BY c.idLogin ";
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while(resultadoSentenca.next()){
                    Cadastro cadastro = new Cadastro();
                    cadastro.setIdLogin(resultadoSentenca.getInt("idLogin"));
                    cadastro.setNome(resultadoSentenca.getString("nome"));
                    cadastro.setEmail(resultadoSentenca.getString("email"));
                    cadastro.setSenha(resultadoSentenca.getString("senha"));

                    
                    listaCadastros.add(cadastro);
                }
            }
            return listaCadastros;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }    
    }
    
    

    @Override
    public ArrayList<Cadastro> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
