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

        }
    }
    public static void menuCadastro(){
        System.out.println("----------------------Cadastrar----------------------");
        System.out.println("Digite 1 para Vendedor");
        System.out.println("Digite 2 para Cliente");
        System.out.println("Digite 3 para Item");
        System.out.println("Digite 4 para Venda");
    }
    
}
