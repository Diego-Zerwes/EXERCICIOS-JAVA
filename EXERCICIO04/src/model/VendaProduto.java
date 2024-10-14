
package model;

public class VendaProduto {
    private int idVendaProduto;
    private int quantVendida;
    private double valorTotal;
    private int idProduto;

    public VendaProduto() {
        
    }

    public VendaProduto(int quantVendida, double valorTotal, int idProduto) {
        this.quantVendida = quantVendida;
        this.valorTotal = valorTotal;
        this.idProduto = idProduto;
    }

    public VendaProduto(int idVendaProduto, int quantVendida, double valorTotal, int idProduto) {
        this.idVendaProduto = idVendaProduto;
        this.quantVendida = quantVendida;
        this.valorTotal = valorTotal;
        this.idProduto = idProduto;
    }

    public int getIdVendaProduto() {
        return idVendaProduto;
    }

    public void setIdVendaProduto(int idVendaProduto) {
        this.idVendaProduto = idVendaProduto;
    }

    public int getQuantVendida() {
        return quantVendida;
    }

    public void setQuantVendida(int quantVendida) {
        this.quantVendida = quantVendida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    
}
