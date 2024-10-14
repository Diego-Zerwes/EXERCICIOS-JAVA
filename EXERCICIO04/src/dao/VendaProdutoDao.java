
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CadastroProduto;
import model.VendaProduto;


public class VendaProdutoDao implements DaoGenerica<VendaProduto>{
    private ConexaoBanco conexao;
    
    public VendaProdutoDao()
    {
        this.conexao = new ConexaoBanco();
    }
    @Override
    public void inserir(VendaProduto venda) {
       String sql = "INSERT INTO vendaProduto (quantVendida, valorTotal, idProduto) VALUES (?,?,?)";
       
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                sentenca.setInt(1,(venda.getQuantVendida()));
                sentenca.setDouble(2, venda.getValorTotal()); 
                sentenca.setInt(3,venda.getIdProduto());
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
    public void alterar(VendaProduto venda) {
        String sql = "UPDATE produto SET nome = ?, quantidade = ?, valor = ?, where idProduto = ? ";
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                        
                sentenca.setInt(1,(venda.getQuantVendida()));
                sentenca.setDouble(2, venda.getValorTotal()); 
                sentenca.setInt(3,venda.getIdProduto());
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
         String sql = "DELETE FROM vendaProduto";
        
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

    @Override
    public ArrayList<VendaProduto> consultar() {
        ArrayList<VendaProduto> listaCadastros = new ArrayList<VendaProduto>();
        String sql = "SELECT c.idVendaProduto, c.quantVendida, c.valorTotal, c.idProduto " +
                    "fROM VendaProduto as c " + 
                    "ORDER BY c.idVendaProduto ";
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while(resultadoSentenca.next()){
                    VendaProduto cadastro = new VendaProduto();
                    cadastro.setIdVendaProduto(resultadoSentenca.getInt("idVendaProduto"));
                    cadastro.setQuantVendida(resultadoSentenca.getInt("quantVendida"));
                    cadastro.setValorTotal(resultadoSentenca.getDouble("valor"));
                    cadastro.setIdProduto(resultadoSentenca.getInt("idProduto"));
                    
                    
                    listaCadastros.add(cadastro);
                }
            }
            return listaCadastros;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } 
    }

    @Override
    public ArrayList<VendaProduto> dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
