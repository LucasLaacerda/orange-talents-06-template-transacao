package br.com.zupacademy.lucaslacerda.transacao;

import java.util.UUID;

public class Card {

    private UUID id;
    private String email;

    @Deprecated
    public Card() {

    }

    public String getEmail() {
        return email;
    }
}
