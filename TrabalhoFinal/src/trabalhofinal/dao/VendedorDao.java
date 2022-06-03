package trabalhofinal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalhofinal.modelo.Vendedor;

public class VendedorDao implements Dao {
    @Override
    public void insert(Object obj) {
        Vendedor v = (Vendedor) obj;
        //sql para inserção
        String sql = "insert into vendedor (nome,cpf,salario) values (?,?,?)";
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, v.getNome());
            ps.setString(2, v.getCpf());
            ps.setString(3, v.getSalario());
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
        Vendedor v = (Vendedor) obj;
        //sql para atualizaçao
        String sql = "update vendedor set nome = ?, cpf = ?, salario = ? where id = ? ";
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, v.getNome());
            ps.setString(2, v.getCpf());
            ps.setString(3, v.getSalario());
            ps.setInt(4, v.getId());
            //executa a query
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Object obj) {
        Vendedor v = (Vendedor) obj;
        //sql para excluir a linha do id passado
        String sql = "delete from vendedor where id=?";
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, v.getId());
            //executa a exclusão
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object select(int id) {
        //sql para selecionar a linha do id passado
        String sql = "select * from vendedor where id=?";
        Vendedor v = new Vendedor() ;
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            //executa a query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Laço de repetição para preencher com os 
                //dados do banco o objeto Pessoa;
                v.setNome(rs.getString("nome"));
                v.setCpf(rs.getString("cpf"));
                v.setSalario(rs.getString("salario"));
                v.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    @Override
    public List select() {
        //sql para selecionar as Pessoas
        String sql = "select * from vendedor";
        //Cria uma lista para preencher com as pessoas do banco
        List<Vendedor> lista = new ArrayList<>();
        try {
            //PreparedStatement - prepara os dados para envio ao SGDB
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            //executa a query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Laço de repetição para preencher com os 
                //dados do banco o objeto Pessoa;
                Vendedor v = new Vendedor();
                v.setNome(rs.getString("nome"));
                v.setCpf(rs.getString("cpf"));
                v.setSalario(rs.getString("salario"));
                v.setId(rs.getInt("id"));
                //Armazena a nova pessoa na lista
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Retorna a lista
        return lista;
    }
}
