
package trabalhofinal;


public class ItemVenda {
    private Item item;
    private int quantidade;
    private Venda venda;

    public ItemVenda(int quantidade) {
        this.quantidade = quantidade;
        item = new Item();
        venda = new Venda();
    }
    public ItemVenda(){
        
    }
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "item=" + item + ", quantidade=" + quantidade + ", venda=" + venda + '}';
    }
    
    
}
