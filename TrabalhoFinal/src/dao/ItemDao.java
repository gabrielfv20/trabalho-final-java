
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalhofinal.Cliente;
import trabalhofinal.Item;
import trabalhofinal.Vendedor;


public class ItemDao implements  Dao{

    @Override
    public void insert(Object o) {
    Item i = (Item) o;
    String sql = "insert into item (nomeitem,unidade,valor) values (?,?,?)";
    
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, i.getNome());
            ps.setFloat(2, i.getUnidade());
            ps.setFloat(3, i.getValor());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Vendedor inserido com sucesso");
    }

    @Override
    public void update(Object o) {
        Item i = (Item) o;
        String sql = "update item set nomeitem = ?, unidade = ?, valor = ? where id = ? ";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, i.getNome());
            ps.setFloat(2, i.getUnidade());
            ps.setFloat(3, i.getValor());
            ps.setInt(4, i.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Atualizado com sucesso");
    }

    @Override
    public void delete(Object o) {
        Item i = (Item) o;
        String sql = "delete from item where id=?";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, i.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Deletado com sucesso");
    }

    @Override
    public Object select(int i) {
        
        return null;
        
    }

    @Override
    public List select() {
        String sql = "select * from item";
        List<Item> listaItem = new ArrayList<>();
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item i = new Item();
                i.setNome(rs.getString("nomeitem"));
                i.setUnidade(rs.getFloat("unidade"));
                i.setValor(rs.getFloat("valor"));
                i.setId(rs.getInt("id"));
                listaItem.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaItem;
        
    }
    
}
