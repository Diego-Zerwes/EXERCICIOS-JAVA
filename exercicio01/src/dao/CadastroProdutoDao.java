
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import model.CadastroProduto;


public class CadastroProdutoDao implements DaoGenerica<CadastroProduto>{
     private ConexaoBanco conexao;
    
    public CadastroProdutoDao()
    {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(CadastroProduto produto) {
       String sql = "INSERT INTO cadProdutos (nome, preco, quantidade, descricao) VALUES (?,?,?,?)";
       
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setString(1,produto.getNome()); 
                sentenca.setString(2,Double.toString(produto.getPreco()));
                sentenca.setInt(3, produto.getQuantidade()); 
                sentenca.setString(4,produto.getDescricao());     
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
    public void alterar(CadastroProduto produto) {
        String sql = "UPDATE cadProdutos SET nome = ?, preco = ?, quantidade = ?, descricao = ?  where idProduto = ?";
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                        
                sentenca.setString(1,produto.getNome()); 
                sentenca.setString(2,Double.toString(produto.getPreco()));
                sentenca.setString(3,String.valueOf(produto.getQuantidade())); 
                sentenca.setString(4,produto.getDescricao());
                sentenca.setInt(5, produto.getIdProduto());
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
       String sql = "DELETE FROM cadProdutos";
        
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
    String sql = "DELETE FROM cadProdutos WHERE idProduto = ?";
        
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
    public ArrayList<CadastroProduto> consultar() {
        
        ArrayList<CadastroProduto> listaCadastros = new ArrayList<CadastroProduto>();
        String sql = "SELECT c.idProduto, c.nome, c.preco, c.quantidade, c.descricao " +
                    "fROM cadProdutos as c " + 
                    "ORDER BY c.idProduto ";
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while(resultadoSentenca.next()){
                    CadastroProduto cadastro = new CadastroProduto();
                    cadastro.setIdProduto(resultadoSentenca.getInt("idProduto"));
                    cadastro.setNome(resultadoSentenca.getString("nome"));
                    cadastro.setQuantidade(resultadoSentenca.getInt("quantidade"));
                    cadastro.setPreco(resultadoSentenca.getDouble("preco"));
                    cadastro.setDescricao(resultadoSentenca.getString("descricao"));
                    
                    listaCadastros.add(cadastro);
                }
            }
            return listaCadastros;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }    
    }

    public ArrayList<CadastroProduto> consultar(String str) {
        ArrayList<CadastroProduto> listaCadastrosStr = new ArrayList<CadastroProduto>();
        String sql = "SELECT c.idProduto, c.nome, c.preco, c.quantidade, c.descricao " +
                     "FROM cadProdutos as c " +
                     "WHERE ( UPPER(c.nome like UPPER(?))) "+
                     "ORDER BY c.nome";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                sentenca.setString(1, "%"+str+"%");
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    CadastroProduto cadastro = new CadastroProduto();
                    cadastro.setIdProduto(resultadoSentenca.getInt("idProduto"));
                    cadastro.setNome(resultadoSentenca.getString("nome"));
                    cadastro.setQuantidade(resultadoSentenca.getInt("quantidade"));
                    cadastro.setPreco(resultadoSentenca.getDouble("preco"));
                    cadastro.setDescricao(resultadoSentenca.getString("descricao"));
                    
                    listaCadastrosStr.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return listaCadastrosStr;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        } 
    }  

    @Override
    public ArrayList<CadastroProduto> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
