package br.com.zupacademy.lucaslacerda.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {

    @Id
    private String id;

    private String email;

    @Deprecated
    public Cartao() {

    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
