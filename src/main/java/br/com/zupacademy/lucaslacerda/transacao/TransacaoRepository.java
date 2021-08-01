package br.com.zupacademy.lucaslacerda.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransactionMessage,String> {
    public Page<TransactionMessage> findByCartaoId(String cartao, Pageable paginacao);
    //
}
