package mermoderna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastrarProduto {

    public static void InserirProduto() throws SQLException {

        Scanner scn = new Scanner(System.in);

        //Jeito certo (INICIO) - Desse jeito que foi criado ele bloqueará tentativa
        //de comandos SQL
        System.out.println("Informe o nome do produto");
        String nome = scn.nextLine();

        System.out.println("Informe o valor do produto");
        Double valor = scn.nextDouble();
        scn.nextLine();

        //chamada da conexão
        Connection conexao = FarmDeConexao.getConnection();

        //Comando Sql de inserção
        String sql = "Insert Into produto_tb (nome,valor) Values (?,?)";
        //String sql = "Insert Into pessoas (nome, codigo) Values (?,?)";

        //Preparo da declaracao
        PreparedStatement stmt = conexao.prepareStatement(sql);

        //Parametrizando
        stmt.setString(1, nome);
        stmt.setDouble(2, valor);
        //stmt.setInt(2, 100);

        //execucao da query
        stmt.execute();

        System.out.println("Produto inserido com sucesso!");



        //fechando scanner
        scn.close();
        //Jeito certo (FIM)


    }

}

