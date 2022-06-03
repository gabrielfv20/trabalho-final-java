package trabalhofinal;

import java.util.Scanner;

public class TrabalhoFinal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite 1 para cadastrar");
        System.out.println("Digite 2 para listar");
        System.out.println("Digite 3 para editar");
        System.out.println("Digite 4 para excluir");
        System.out.println("Digite 0 para sair");

        int op = sc.nextInt();
        switch(op){
            case 0:
                return;
            case 1:             
                System.out.println("----------------------Cadastrar----------------------");
                menu();
                break;
            case 2:    
                System.out.println("----------------------Listar----------------------");
                menu();
                break;
            case 3:
                System.out.println("----------------------Editar----------------------");
                menu();
                break;
            case 4:
                System.out.println("----------------------Excluir----------------------");
                menu();
                break;
                
        }
    }
    public static void menu(){
        System.out.println("Digite 1 para Vendedor");
        System.out.println("Digite 2 para Cliente");
        System.out.println("Digite 3 para Item");
        System.out.println("Digite 4 para Venda");
    }
    
}
