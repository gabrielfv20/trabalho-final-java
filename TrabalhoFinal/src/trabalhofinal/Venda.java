
package trabalhofinal;

import java.util.Date;
import java.util.List;


public class Venda implements MetodoPagamento{
    private int numVenda;
    private MetodoPagamento formapagamento;
    private Vendedor vendedor;
    private Cliente cliente;
    private List<ItemVenda> itensVenda;
    private Date data;
    

    public Venda() {
        
    }

    public MetodoPagamento getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(MetodoPagamento formapagamento) {
        this.formapagamento = formapagamento;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itensVenda;
    }

     public void setItens(List<ItemVenda> itens) {
        this.itensVenda = itensVenda;
    }
    
    public Date getData() {
        return data;
    }

    public double getValorTotal(){
        double calc =0;
        for(ItemVenda itemVenda : itensVenda){
            calc = itemVenda.getQuantidade()*itemVenda.getItem().getValor();
        }
        return calc;
    }
    
    public void getEndEntrega(){
        System.out.println("Endereco de Entrega: " + cliente.getEndereco());
    }
    
    public void getQtdItens(){
        double qtd=0;
        //qtd = itensVenda.size();
        for(ItemVenda itemV : itensVenda){
            qtd= itemV.getQuantidade();
        }
        System.out.println("Quantidade total de itens no pedido: " + qtd);
        
    }
    
    public void pagar(double valor, formaPagamento formapagamento ){
        if(formapagamento == formapagamento.DINHEIRO){
            pagarDinheiro(valor);
        }if(formapagamento == formapagamento.CARTAO){
            pagarCartao(valor);
            
        }else{
            pagarPix(valor);
        }
       
            
       
    }

    @Override
    public void pagarCartao(double valor) {
        formaPagamento formPag = formaPagamento.CARTAO;
        double conta = 0;
        conta = valor - getValorTotal();
        System.out.println("Compra finalizada");
    }

    @Override
    public void pagarDinheiro(double dinheiro) {
        formaPagamento formPag = formaPagamento.DINHEIRO;
        double conta = 0;
        conta = dinheiro - getValorTotal();
        double troco = conta;
        System.out.println("Troco: R$" + troco);
    }

    @Override
    public void pagarPix(double valor) {
        formaPagamento formPag = formaPagamento.PIX;
        double conta = 0;
        conta = valor - getValorTotal();
        System.out.println("Compra finalizada");
        
    }
    
    
    
}
