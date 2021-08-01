package br.com.zupacademy.lucaslacerda.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private TransacaoRepository transacaoRepository;

    @Autowired
    public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void escutaTopicoTransacao(TransactionMessage transactionMessage) {


        transacaoRepository.save(transactionMessage);
        //1°Persistir no banco as mensagens
        //2°Criar um enpoint para visualizar as mensagens
        //3°Retornar apenas as 10 ultimas mensagens (definir na hora da busca)



        System.out.println("ID Transcation: "+transactionMessage.getId());
        System.out.println("Value Transcation: "+transactionMessage.getValor());
        System.out.println("Transcation Location: "+transactionMessage.getEstabelecimento().getNome());
        System.out.println("Card account: "+transactionMessage.getCartao().getEmail());
        System.out.println("Transcation Date: "+transactionMessage.getEfetivadaEm());
    }

}