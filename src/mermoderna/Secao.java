package mermoderna;

public class Secao {

    String nome;
    int idSecao;

    public Secao(String nome, int idSecao) {
        super();
        this.nome = nome;
        this.idSecao = idSecao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdSecao() {
        return idSecao;
    }

    public void setIdSecao(int idSecao) {
        this.idSecao = idSecao;
    }

    @Override
    public String toString() {
        return "Secao [nome=" + nome + ", idSecao=" + idSecao + "]";
    }

}


