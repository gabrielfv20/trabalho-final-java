
package dao;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trabalhofinal.Vendedor;


public class VendedorDao implements  Dao{

    @Override
    public void insert(Object o) {
    Vendedor v = (Vendedor) o;
    String sql = "insert into vendedor (nomevendedor,cpfvendedor,salario) values (?,?,?)";
    
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, v.getNome());
            ps.setString(2, v.getCpf());
            ps.setFloat(3, v.getSalario());
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
        Vendedor v = (Vendedor) o;
        String sql = "update vendedor set nomevendedor = ?, cpfvendedor = ?, salario = ? where id = ? ";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, v.getNome());
            ps.setString(2, v.getCpf());
            ps.setFloat(3, v.getSalario());
            ps.setInt(4, v.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Atualizado com sucesso");
    }

    @Override
    public void delete(Object o) {
        Vendedor v = (Vendedor) o;
        String sql = "delete from vendedor where id=?";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, v.getId());
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
        String sql = "select * from vendedor";
        List<Vendedor> listaVendedor = new ArrayList<>();
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vendedor p = new Vendedor();
                p.setNome(rs.getString("nomevendedor"));
                p.setCpf(rs.getString("cpfvendedor"));
                p.setSalario(rs.getFloat("salario"));
                p.setId(rs.getInt("id"));
                listaVendedor.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaVendedor;
        
    }
    
}
    

