package br.com.zupacademy.lucaslacerda.transacao;



import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionMessage {

    private String id;

    private BigDecimal valor;

    private Estabelecimento estabelecimento;

    private Card cartao;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransactionMessage() {

    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Card getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
