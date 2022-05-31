package trabalhofinal;

import java.util.Date;
import java.util.List;

public class Venda implements MetodoPagamento{
    private int numVenda;
    private Vendedor vendedor;
    private Cliente cliente;
    private Date dataVenda;
    private MetodoPagamento metoPag;
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
        float qtd = 0;
        for(ItemVenda itemV: itensVenda){
            qtd = itemV.getQuantidade();
        }
        System.out.println("A quantidade total e de: " + qtd + " produtos.");
    }
    
    public void pagar(double valor, FormaPagamento formPag){
        if(formPag == formPag.DINHEIRO){
            pagarDinheiro(valor);
        } if(formPag == formPag.PIX){
            pagarPix(valor);
        } else{
            pagarCartao(valor);
        }
        
    }
    
    @Override
    public void pagarDinheiro(double dinheiro) {
        FormaPagamento formPag = FormaPagamento.DINHEIRO;
        double conta =0;
        double troco;
        conta = dinheiro - getValorTotal();
        troco = conta;
        System.out.println("Você receberá o troco de: R$" + troco);
    }

    @Override
    public void pagarPix(double valor) {
        FormaPagamento formPag = FormaPagamento.PIX;
        double conta =0;
        conta = valor - getValorTotal();
        System.out.println("Item comprado com sucesso!");
    }

    @Override
    public void pagarCartao(double valor) {
        FormaPagamento formPag = FormaPagamento.CARTAO;
        double conta =0;
        conta = valor - getValorTotal();
        System.out.println("Item comprado com sucesso!");
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

    public MetodoPagamento getMetoPag() {
        return metoPag;
    }

    public void setMetoPag(MetodoPagamento metoPag) {
        this.metoPag = metoPag;
    }

    public int getNumVenda() {
        return numVenda;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }   
}