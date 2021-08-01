package br.com.zupacademy.lucaslacerda.transacao;


import br.com.zupacademy.lucaslacerda.transacao.cartao.Cartao;
import br.com.zupacademy.lucaslacerda.transacao.estabelecimento.Estabelecimento;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class TransactionMessage {

    @Id
    private String id;

    private BigDecimal valor;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransactionMessage() {

    }

    public TransactionMessage(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
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

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
