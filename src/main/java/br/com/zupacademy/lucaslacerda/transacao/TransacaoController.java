package br.com.zupacademy.lucaslacerda.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/{id}/transacoes")
public class TransacaoController {

    private TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;

    }


    @PostMapping(value = "/busca")
    @Transactional
    public ResponseEntity<?> buscaUltimasTransacoes(@PathVariable("id") String id,
                                                    @PageableDefault(sort="efetivadaEm",
                                                                            direction = Sort.Direction.DESC,page=0,size=10)
                                                                   Pageable paginacao){

        Page<TransactionMessage> transacoes = transacaoRepository.findByCartaoId(id,paginacao);

        if(transacoes.isEmpty()) return ResponseEntity.notFound().build();//404

        return ResponseEntity.ok(transacoes);//200
    }


}
