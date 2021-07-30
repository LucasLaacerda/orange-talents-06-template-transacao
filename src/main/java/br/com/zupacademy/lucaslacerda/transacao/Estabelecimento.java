package br.com.zupacademy.lucaslacerda.transacao;

public class Estabelecimento {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public Estabelecimento() {

    }

    public String getNome() {
        return nome;
    }

}
