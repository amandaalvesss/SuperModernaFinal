package mermoderna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

    public class ExcluirProduto {
        public static void excluirProduto() throws SQLException {

            //Instancia o Scanner
            Scanner scn = new Scanner(System.in);

            System.out.println("Informe o codigo do produto a ser excluído: ");
            int id_produto = scn.nextInt();

            //Abertura da conexao com o banco
            Connection conexao = FarmDeConexao.getConnection();

            //Comando Sql para exclusao do dado
            String sql = "DELETE FROM produto_tb WHERE id_produto = ?";

            //Preparacao da declaracao
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id_produto);

            // utilizado o IF para confirma se realmente alguma linha sofreu algum impacto
            // durante o processo de exclusao
            // o "stmt.executeUpdate()" verifica a quantidade de linhas que foram excluidas
            if (stmt.executeUpdate() > 0) {

                // Mensagem de sucesso na operacao de exclusao do carro
                System.out.println("Produto excluido(a) com sucesso");

            } else {

                // Caso nao tenha produto a ser excluida ou o codigo não existe na base irá
                // retornar a seguinte mensagem abaixo
                System.out.println("Produto não excluído: Codigo do produto inserido não existente na base");
            }


            // Fecha a conexao com o banco
            conexao.close();
            // fecha o Scanner
            scn.close();
            // fecha o PreparedStatement
            stmt.close();
        }
    }

