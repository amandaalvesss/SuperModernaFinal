package mermoderna;

import java.math.BigDecimal;

    public class Produto {

        int idProduto;
        String nome;
        BigDecimal valor;
        int idsecao;



        public Produto(int idProduto, String nome, BigDecimal valor, int idsecao) {
            super();
            this.idProduto = idProduto;
            this.nome = nome;
            this.valor = valor;
            this.idsecao = idsecao;
        }



        public int getIdProduto() {
            return idProduto;
        }



        public void setIdProduto(int idProduto) {
            this.idProduto = idProduto;
        }



        public String getNome() {
            return nome;
        }



        public void setNome(String nome) {
            this.nome = nome;
        }



        public BigDecimal getValor() {
            return valor;
        }



        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }



        public int getIdsecao() {
            return idsecao;
        }



        public void setIdsecao(int idsecao) {
            this.idsecao = idsecao;
        }



        @Override
        public String toString() {
            return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", valor=" + valor + ", idsecao=" + idsecao + "]";
        }



    }


