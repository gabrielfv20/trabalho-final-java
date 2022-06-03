package trabalhofinal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalhofinal.modelo.Cliente;

public class ClienteDao implements Dao{
    @Override
    public void insert(Object obj) {
        Cliente c = (Cliente) obj;
        //sql para inserção
        String sql = "insert into pessoa (nome,cpf,endereco) values (?,?,?)";
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getEnder());
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
        Cliente c = (Cliente) obj;
        //sql para atualizaçao
        String sql = "update cliente set nome = ?, cpf = ?, endereco = ? where id = ? ";
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getEnder());
            ps.setInt(4, c.getId());
            //executa a query
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Object obj) {
        Cliente c = (Cliente) obj;
        //sql para excluir a linha do id passado
        String sql = "delete from cliente where id=?";
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, c.getId());
            //executa a exclusão
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object select(int id) {
        //sql para selecionar a linha do id passado
        String sql = "select * from cliente where id=?";
        Cliente c = new Cliente();
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            //executa a query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Laço de repetição para preencher com os 
                //dados do banco o objeto Pessoa;
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEnder(rs.getString("Endereco"));
                c.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List select() {
        //sql para selecionar as Pessoas
        String sql = "select * from cliente";
        //Cria uma lista para preencher com as pessoas do banco
        List<Cliente> lista = new ArrayList<>();
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            //executa a query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Laço de repetição para preencher com os 
                //dados do banco o objeto Pessoa;
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEnder(rs.getString("endereco"));
                c.setId(rs.getInt("id"));
                //Armazena a nova pessoa na lista
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Retorna a lista
        return lista;
    }
}