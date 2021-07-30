package br.com.zupacademy.lucaslacerda.transacao;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransactionMessage transactionMessage) {
        System.out.println("ID Transcation: "+transactionMessage.getId());
        System.out.println("Value Transcation: "+transactionMessage.getValor());
        System.out.println("Transcation Location: "+transactionMessage.getEstabelecimento().getNome());
        System.out.println("Card account: "+transactionMessage.getCartao().getEmail());
        System.out.println("Transcation Date: "+transactionMessage.getEfetivadaEm());
    }

}