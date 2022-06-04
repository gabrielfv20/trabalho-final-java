/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalhofinal.Cliente;

public class ClienteDao implements Dao{
    
      

    @Override
    public void insert(Object o) {
    Cliente p = (Cliente) o;
    String sql = "INSERT INTO cliente (nomecliente,cpfcliente,endereco) VALUES (?,?,?)";
    
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getEndereco());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Cliente inserido com sucesso");
    }

    @Override
    public void update(Object o) {
        Cliente p = (Cliente) o;
        String sql = "update cliente set nomecliente = ?, cpfcliente = ?, endereco = ? where id = ? ";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getEndereco());         
            ps.setInt(4, p.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Atualizado com sucesso");
    }

    @Override
    public void delete(Object o) {
        Cliente p = (Cliente) o;
        String sql = "delete from cliente where id=?";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, p.getId());
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
        String sql = "select * from cliente";
        List<Cliente> listaCliente = new ArrayList<>();
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente p = new Cliente();
                p.setNome(rs.getString("nomecliente"));
                p.setCpf(rs.getString("cpfcliente"));
                p.setEndereco(rs.getString("endereco"));
                p.setId(rs.getInt("id"));
                listaCliente.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaCliente;
        
    }
    
}
