package trabalhofinal;

import java.util.Date;
import java.util.List;

public class Venda {
    private int numVenda;
    private Vendedor vendedor;
    private Cliente cliente;
    private Date dataVenda;
    private MetodoPagamento formPag;
    private List<ItemVenda> itensVenda;

    public Venda() {
    }

    public double getValorTotal(){
        double calc = 0;
        for(ItemVenda itemVenda: itensVenda){
            calc = itemVenda.getQuantidade() * itemVenda.getItem().getValor();
        }
        return calc;
    }
    
    public void getEndEntrega(){
        System.out.println("Endereço de Entrega: " + cliente.getEnd());  
    }
    
    public void getQtdItens(){
        
    }
    
    public void pagar(){
        
    }
    
    
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getClient() {
        return cliente;
    }

    public void setClient(Cliente client) {
        this.cliente = client;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public MetodoPagamento getFormPag() {
        return formPag;
    }

    public void setFormPag(MetodoPagamento formPag) {
        this.formPag = formPag;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    
    
}