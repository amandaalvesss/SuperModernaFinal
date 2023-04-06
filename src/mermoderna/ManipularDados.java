package mermoderna;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class ManipularDados {

        public static void deletarProduto() throws Exception {

            Scanner scanner = new Scanner(System.in);
            Connection connection = FarmDeConexao.getConnection();

            System.out.println("informe o id da produto a ser deletada");
            String sql = "DELETE FROM produto_tb WHERE id_produto = ?";
            int idpessoa = scanner.nextInt();

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idpessoa);

            if (statement.executeUpdate() > 0) {
                System.out.println("deletado com sucesso");

            } else {
                System.out.println("Nenhum elemento encontrato ");
            }

        }

        public void alterarProduto() throws SQLException {

            Scanner scanner = new Scanner(System.in);
            String sql = "UPDATE produto_tb set valor = ? where id_produto = ?";
            System.out.println("Informe o id do produto a ser alterado ");
            int idProduto = scanner.nextInt();
            scanner.nextLine();
            System.out.println("infome o valor a ser alterado");
            BigDecimal valor = scanner.nextBigDecimal();
            scanner.nextLine();

            Connection connection = FarmDeConexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idProduto);
            statement.setBigDecimal(2, valor);

            if (statement.executeUpdate() > 0) {
                System.out.println("Valor  Alterado com sucesso");
            } else {
                System.out.println("Valor n�o alteado, produto n�o existe ou id iv�lido");
            }
        }
        public static void atualizarSecao () throws SQLException{
            Scanner scanner = new Scanner(System.in);
            String sql = "UPDATE secao_tb set nome = ? WHERE id_secao = ? ";
            System.out.println("Informe o novo nome da Seção");
            String nome = scanner.nextLine();
            System.out.println("Informe o Id da Seção que deseja altarar o nome");
            int idSecao = scanner.nextInt();

            Connection connection = FarmDeConexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,nome);
            statement.setInt(2,idSecao);

            if(statement.executeUpdate() > 0){
                System.out.println("Seção  Alterado com sucesso");
            }
            else{
                System.out.println("Seçao não existe ou id iválido");
            }

        }
        public static void deletarSecao() throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informa o Id da sec��o a ser exclu�da");
            String sql = "DELETE  FROM secao_tb WHERE id_secao = ?";
            int idsecao = scanner.nextInt();
            scanner.nextLine();

            Connection connection = FarmDeConexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idsecao);
            if (statement.executeUpdate() > 0) {
                System.out.println("Secao deletada com sucesso");
            } else {
                System.out.println("Secao n�o encontrata , ou n�o existe");
            }
        }

        public static void inserirSecao() throws SQLException {

            System.out.println(" informa o nome da sess�o");
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.nextLine();
            String inserirSecao = "Insert into " + "secao_tb" + "(nome)" + "values" + "(?)";
            Connection connection = FarmDeConexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(inserirSecao);
            statement.setString(1, nome);
            statement.execute();
            statement.close();
            System.out.println("Sess�o criada com sucesso");

        }

        public void inserirProduto() throws SQLException {
            System.out.println("informe os dados do Produto");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nome do produto");
            String nome = scanner.nextLine();

            System.out.println("Valor do produto");
            BigDecimal valor = scanner.nextBigDecimal();
            scanner.nextLine();

            System.out.println("id da secao");
            int idSecao = scanner.nextInt();
            scanner.nextLine();

            String inserirProduto = "insert into  " + "produto_tb" + "(nome,valor,id_secao)" + "values" + "(?,?,?)";
            Connection connection = FarmDeConexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(inserirProduto);
            statement.setString(1, nome);
            statement.setBigDecimal(2, valor);
            statement.setInt(3, idSecao);

            statement.execute();
            statement.close();
            System.out.println("Produto inserido com sucesso");
        }

        public static void consultarTbSecao() throws SQLException {
            List<Secao> secao = new ArrayList<>();
            String consulta = "SELECT * FROM secao_tb";

            Connection connection = FarmDeConexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);

            while (resultado.next()) {
                final String nome = resultado.getString("nome");
                final int idSecao = resultado.getInt("id_secao");
                secao.add(new Secao(nome, idSecao));

            }
            for (int i = 0; i < secao.size(); i++) {
                System.out.println(secao.get(i));
            }
            statement.close();
            connection.close();
        }

        public static void consultarTbProduto() throws SQLException {
            String consulta = "SELECT * FROM produto_tb";
            List<Produto> produto = new ArrayList<>();

            Connection connection = FarmDeConexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                int idProduto = resultSet.getInt("id_produto");
                String nome = resultSet.getString("nome");
                BigDecimal valor = resultSet.getBigDecimal("valor");
                int idsecao = resultSet.getInt("id_secao");

                produto.add(new Produto(idProduto, nome, valor, idsecao));
            }
            for (int i = 0; i < produto.size(); i++) {
                System.out.println(produto.get(i));
            }
            connection.close();
            statement.close();
        }

    }

