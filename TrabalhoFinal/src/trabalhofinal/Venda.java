
package trabalhofinal;

import java.util.ArrayList;
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
        vendedor = new Vendedor();
        cliente = new Cliente();
        itensVenda = new ArrayList<>();
//        itemvenda = new ItemVenda();
        data = new Date();
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

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
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
    
    public void pagar(double valorPago, formaPagamento formapagamento ){
        if(formapagamento == formapagamento.DINHEIRO){
            pagarDinheiro(valorPago);
        }if(formapagamento == formapagamento.CARTAO){
            pagarCartao(valorPago);
            
        }else{
            pagarPix(valorPago);
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

    @Override
    public String toString() {
        return "Venda{" + "numVenda=" + numVenda + ", formapagamento=" + formapagamento + ", vendedor=" + vendedor + ", cliente=" + cliente + ", itensVenda=" + itensVenda + ", data=" + data + '}';
    }
    
    
    
}
