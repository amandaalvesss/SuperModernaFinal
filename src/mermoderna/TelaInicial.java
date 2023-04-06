package mermoderna;

import mermoderna.CadastrarProduto;

import java.sql.SQLException;
import java.util.Scanner;

public class TelaInicial {
    public static void main(String[] args) throws Exception {

        // Instanciando Scanner para capturar o que for digitado na tela
        Scanner scn = new Scanner(System.in);

        // Menu de Opcoes
        System.out.println("=================================");
        System.out.println("ESCOLHA UMA OPÇÃO ABAIXO:");
        System.out.println("=================================");
        System.out.println("1 -  Cadastrar Produto");
        System.out.println("2 -  Atualizar Produto");
        System.out.println("3 -  Excluir Produto");
        System.out.println("4 -  Cadastrar Seção");
        System.out.println("5 -  Atualizar Seção");
        System.out.println("6 -  Excluir Seção");
        System.out.println("7 -  Listar Produtos");
        System.out.println("8 -  Listar Seções");
        System.out.println("---------------------------------");

        int num1 = scn.nextInt();
        scn.nextLine();



        // Garantir que recebera um numero valido
        // Enquanto nao receber ficara solicitando uma opcao valida
        while (num1 <= 8) {

            if (num1 == 1) {
                CadastrarProduto.InserirProduto();
            }

            if (num1 == 2) {
                AtualizarProduto.atualizarProduto();
            }

            if (num1 == 3) {
                ExcluirProduto.excluirProduto();
            }
            if (num1 == 4) {
                ManipularDados.inserirSecao();
            }
            if (num1 == 5) {
                ManipularDados.atualizarSecao();
            }
            if (num1 == 6) {
                ManipularDados.deletarSecao();
            }
            if (num1 == 7) {
                ManipularDados.consultarTbProduto();
            }
            if (num1 == 8) {
                ManipularDados.consultarTbSecao();
            }

            System.out.println("=================================");
            System.out.println("ESCOLHA UMA OPÇÃO ABAIXO:");
            System.out.println("=================================");
            System.out.println("1 -  Cadastrar Produto");
            System.out.println("2 -  Atualizar Produto");
            System.out.println("3 -  Excluir Produto");
            System.out.println("4 -  Cadastrar Secao");
            System.out.println("5 -  Atualizar Secao");
            System.out.println("6 -  Excluir Secao");
            System.out.println("7 -  Buscar Produto");
            System.out.println("8 -  Buscar Secao");
            System.out.println("---------------------------------");
            num1 = scn.nextInt();
            scn.nextLine();

            }

            if (num1 > 8) {
                System.out.println("Escolha um numero de 1 a 8");
            }

            // fecha o scanner
            scn.close();


    }
}
