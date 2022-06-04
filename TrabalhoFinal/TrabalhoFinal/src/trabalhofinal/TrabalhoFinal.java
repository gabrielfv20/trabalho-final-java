
package trabalhofinal;

import java.util.Scanner;


public class TrabalhoFinal {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Cliente c1 = new Cliente();
        
            System.out.println("Digite 1 para cadastrar"
                    + "\nDigite 2 para listar"
                    + "\nDigite 3 para editar"
                    + "\nDigite 4 para excluir"
                    + "\nDigite 0 para sair");
                    
            int op = sc.nextInt();
            switch(op){
                case 0:
                    return;
                case 1:
                    System.out.println("Cadastrando...");
                    menuCadastro();
                    break;
                case 2: 
                    System.out.println("Listando...");
                    
                    break;
                case 3:
                    System.out.println("Editando...");
                    break;
                case 4:
                    System.out.println("Excluindo...");
                    
                    break;
                default:
                    System.out.println("Opcao invalida");
            
        }
     
         
     } 
    public static void menuCadastro(){
         System.out.println("Digite 1 para vendedor"
                 + "\nDigite 2 para Cliente"
                 + "\nDigite 3 para Item"
                 + "\nDigite 4 para venda");
}
    public static void cadastroCliente(){
        System.out.println("Digite o nome: ");
        
        System.out.println("Digite o CPF: ");
        
        System.out.println("Digite o endereco: ");
        
    }
    
        
    }

