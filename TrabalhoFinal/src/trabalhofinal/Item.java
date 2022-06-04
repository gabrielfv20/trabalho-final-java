/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

/**
 *
 * @author 202002709197
 */
public class Item {
    private String nome;
    private float unidade;
    private float valor;
    private int id;

    public Item() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getUnidade() {
        return unidade;
    }

    public void setUnidade(float unidade) {
        this.unidade = unidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" + "nome=" + nome + ", unidade=" + unidade + ", valor=" + valor + ", id=" + id + '}';
    }

    

    
    
    
}
