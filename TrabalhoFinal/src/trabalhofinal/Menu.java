
package trabalhofinal;

import dao.ClienteDao;
import dao.ItemDao;
import dao.VendedorDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    public static void main (String[] args){
       int op=0;
       Scanner sc = new Scanner(System.in);
        ClienteDao clienteDAO = new ClienteDao();
        VendedorDao vendedorDAO = new VendedorDao();
        ItemDao itemDAO = new ItemDao();
        Cliente cli = null;
        Vendedor ven = null;
        Item item = null;
        List<Cliente> listaCliente = new ArrayList();
        List<Vendedor> listaVendedor = new ArrayList();
        List<Item> listaItem = new ArrayList();
       String cadastro="\nDigite 1 para cadastar cliente "
               + "\nDigite 2 para cadastar vendedor"
               + "\nDigite 3 para cadastar item ";
       String deletar = "\nDigite 1 para deletar cliente"
               + "\nDigite 2 para deletar vendedor"
               + "\nDigite 3 para deletar item";
       String alterar = "\nDigite 1 para alterar cliente"
               + "\nDigite 2 para alterar vendedor"
               + "\nDigite 3 para alterar item"; 
       String pesquisar ="\nDigite 1 para pesquisar lista de clientes"
               + "\nDigite 2 para pesquisar lista de vendedores"
               + "\nDigite 3 para pesquisar lista de itens";
        do {            
            System.out.println("\nDigite 1 para cadastro"
                    + "\nDigite 2 para deletar"
                    + "\nDigite 3 para alterar"
                    + "\nDigite 4 para pesquisar"
                    + "\nDigite 0 para sair");
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println(cadastro); 
                    op = sc.nextInt();
                    if(op==1){
                        cli = new Cliente();
                        System.out.println("Digite o nome do cliente: ");
                        cli.setNome(sc.next());
                        System.out.println("Digite o CPF: ");
                        cli.setCpf(sc.next());
                        System.out.println("Digite o endereco : ");
                        cli.setEndereco(sc.next());
                        clienteDAO.insert(cli); 
                        
                    }else{
                    if(op==2){
                         ven = new Vendedor();
                        System.out.println("Digite o nome do vendedor: ");
                        ven.setNome(sc.next());
                        System.out.println("Digite o CPF: ");
                        ven.setCpf(sc.next());
                        System.out.println("Digite o salario do vendedor : ");
                        ven.setSalario(sc.nextFloat());
                        vendedorDAO.insert(ven);   
                    }else{
                        item = new Item();
                        System.out.println("Digite o nome do item : ");
                        item.setNome(sc.next());
                        System.out.println("Digite a unidade: ");
                        item.setUnidade(sc.nextFloat());
                        System.out.println("Digite o valor");
                        item.setValor(sc.nextFloat());
                        itemDAO.insert(item);
                    }
                    }
                    break;
                case 2:
                    System.out.println(deletar);
                    op = sc.nextInt();
                    if(op==1){
                        cli = new Cliente();
                        System.out.println("Digite o id do cliente a ser removido: ");
                        cli.setId(sc.nextInt());
                        clienteDAO.delete(cli);
                    }else{
                    if(op==2){
                        ven=new Vendedor();
                        System.out.println("Digite o id do vendedor a ser removido: ");
                        ven.setId(sc.nextInt());
                        vendedorDAO.delete(cli);
                    }else{
                        item=new Item();
                        System.out.println("Digite o id do item a ser removido: ");
                        item.setId(sc.nextInt());
                        itemDAO.delete(cli);
                    }   
                    }
                    break;
                case 3:
                    System.out.println(alterar);
                    op = sc.nextInt();
                    
                    if(op==1){
                        cli = new Cliente();
                        System.out.println("Digite o id do cliente a ser alterado: ");
                        cli.setId(sc.nextInt());
                        System.out.println("Digite o novo nome do cliente: ");
                        cli.setNome(sc.next());
                        System.out.println("Digite o novo CPF");
                        cli.setCpf(sc.next());
                        System.out.println("Digite o novo endereco: ");
                        cli.setEndereco(sc.next());
                        clienteDAO.update(cli);
                        
                    }else{
                    if(op==2){
                        ven = new Vendedor();
                        System.out.println("Digite o id do vendedor a ser alterado: ");
                        ven.setId(sc.nextInt());
                        System.out.println("Digite o novo nome do vendedor: ");
                        ven.setNome(sc.next());
                        System.out.println("Digite o novo CPF do vendedor: ");
                        ven.setCpf(sc.next());
                        System.out.println("Digite o novo salario do vendedor: ");
                        ven.setSalario(sc.nextFloat());
                        vendedorDAO.update(ven);
                    }else{
                        item = new Item();
                        System.out.println("Digite o id do item a ser alterado: ");
                        item.setId(sc.nextInt());
                        System.out.println("Digite o novo nome do item: ");
                        item.setNome(sc.next());
                        System.out.println("Digite o novo valor da unidade: ");
                        item.setUnidade(sc.nextFloat());
                        System.out.println("Digite o novo valor do item: ");
                        item.setValor(op);
                        itemDAO.update(item);
                        }   
                    }
                    break;
                case 4:
                    System.out.println(pesquisar);
                    op = sc.nextInt();
                    
                    if(op==1){
                       listaCliente = clienteDAO.select();
                    
                    for(Cliente cliAux : listaCliente){
                      String  pesquisaCliente = "\nId: " + cliAux.getId() + "\nNome : " + cliAux.getNome() + "\nCPF: " + cliAux.getCpf()
                                + "\nEndereco: " + cliAux.getEndereco();     
                      System.out.println(pesquisaCliente);
                    } 
                        
                    }else{
                    if(op==2){
                      listaVendedor = vendedorDAO.select();
                    
                    for(Vendedor venAux : listaVendedor){
                      String  pesquisaVendedor = "\nId: " + venAux.getId() + "\nNome : " + venAux.getNome() + "\nCPF: " + venAux.getCpf()
                                + "\nSalario: " + venAux.getSalario();
                        System.out.println(pesquisaVendedor);
                                
                    }  
                    }else{
                       listaItem = itemDAO.select();
                    
                    for(Item itemAux : listaItem){
                      String  pesquisaItem = "\nId: " + itemAux.getId() + "\nNome : " + itemAux.getNome() + "\nUnidade: " + itemAux.getUnidade()
                                + "\nValor: " + itemAux.getValor();
                                System.out.println(pesquisaItem);
                            } 
                        }   
                    }
            }
            
        } while (op!=0);
    }
    
    
    
    
}
