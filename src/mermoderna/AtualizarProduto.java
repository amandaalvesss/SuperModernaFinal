package mermoderna;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

    public class AtualizarProduto {
        static Scanner scn = new Scanner(System.in);
        public static void atualizarProduto() throws SQLException {
            //(INICIO) - Desse jeito que foi criado ele bloqueará tentativa sql Injector
            System.out.print("Qual produto deseja atualizar? ");
            int id = scn.nextInt();

            System.out.print("Qual novo nome?: ");
            String nome = scn.next();

            System.out.print("Qual novo preço?: ");
            float valor = scn.nextFloat();

            Connection conexao = FarmDeConexao.getConnection();

            // Comando Sql de inserção String sql =
            String sql = "UPDATE produto_tb SET nome=?, valor=? WHERE id_produto=?";

            // Preparo da declaracao
            PreparedStatement stmt = conexao.prepareStatement(sql);

            //Passando para o Statement "stmt" os parâmetros de insercao
            stmt.setString(1, nome);
            stmt.setFloat(2, valor);
            stmt.setInt(3, id);

            //executa o statement
            stmt.execute();

            System.out.println("Produto Atualizado com sucesso!");

            //Fecha o Statement
            stmt.close();
            //fecha o scanner
            scn.close();
            //fecha conexao
            conexao.close();
            //(FIM)
        }
    }

