package trabalhofinal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalhofinal.modelo.Item;

public class ItemDao implements Dao{
    @Override
    public void insert(Object obj) {
        Item i = (Item) obj;
        //sql para inserção
        String sql = "insert into item (nome, unidade, valor) values (?,?,?)";
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, i.getNome());
            ps.setFloat(2, i.getUnidade());
            ps.setFloat(3, i.getValor());
            //executa a query
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void update(Object obj) {
        Item i = (Item) obj;
        //sql para atualizaçao
        String sql = "update item set nome = ?, unidade = ?, valor = ? where id = ? ";
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, i.getNome());
            ps.setFloat(2, i.getUnidade());
            ps.setFloat(3, i.getValor());
            ps.setInt(4, i.getCodProduto());
            //executa a query
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Object obj) {
        Item i = (Item) obj;
        //sql para excluir a linha do id passado
        String sql = "delete from item where id=?";
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, i.getCodProduto());
            //executa a exclusão
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object select(int CodProduto) {
        //sql para selecionar a linha do id passado
        String sql = "select * from item where id=?";
        Item i = new Item();
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, CodProduto);
            //executa a query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Laço de repetição para preencher com os 
                //dados do banco o objeto Pessoa;
                i.setNome(rs.getString("nome"));
                i.setUnidade(rs.getFloat("unidade"));
                i.setValor(rs.getFloat("valor"));
                i.setCodProduto(CodProduto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List select() {
        //sql para selecionar as Pessoas
        String sql = "select * from item";
        //Cria uma lista para preencher com as pessoas do banco
        List<Item> lista = new ArrayList<>();
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            //executa a query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Laço de repetição para preencher com os 
                //dados do banco o objeto Pessoa;
                Item i = new Item();
                i.setNome(rs.getString("nome"));
                i.setUnidade(rs.getFloat("unidade"));
                i.setValor(rs.getFloat("valor"));
                i.setCodProduto(rs.getInt("CodProduto"));
                //Armazena a nova pessoa na lista
                lista.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Retorna a lista
        return lista;
    }
}
