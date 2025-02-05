package com.DesafioPicPay.DesafioPicPay.Servicos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DesafioPicPay.DesafioPicPay.Dtos.TransacaoDTO;
import com.DesafioPicPay.DesafioPicPay.dominio.transacao.Transacao;
import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.Usuario;
import com.DesafioPicPay.DesafioPicPay.repositorios.repositorioTransacao;

@Service
public class ServicoTransacao {

    @Autowired
    private ServicoUsuario servicousuario;

    @Autowired
    private repositorioTransacao repositorio;

    @Autowired
    private RestTemplate restTemplate; 

    @Autowired
    private ServicoNotificacao servicoNotificacao;

    public Transacao criarTransacao(TransacaoDTO transacaoo) throws Exception {
        // Adicionando logs para verificar os valores de ID
        System.out.println("Emissor ID: " + transacaoo.emissorId());
        System.out.println("Receptor ID: " + transacaoo.recptorId());
    
        Usuario emissor = this.servicousuario.findById(transacaoo.emissorId());
        Usuario receptor = this.servicousuario.findById(transacaoo.recptorId());  // Corrigido
    
        servicousuario.validarTransacao(emissor, transacaoo.valor());
    
        if (!this.autorizarTransacao(emissor, transacaoo.valor())) {
            throw new Exception("Transação não autorizada");
        }
    
        Transacao transacao = new Transacao();
        transacao.setValor(transacaoo.valor());
        transacao.setEmissor(emissor);
        transacao.setReceptor(receptor);
        transacao.setHorario(LocalDateTime.now());
    
        emissor.setSaldo(emissor.getSaldo().subtract(transacaoo.valor()));
        receptor.setSaldo(receptor.getSaldo().add(transacaoo.valor()));
    
        this.repositorio.save(transacao);
        this.servicousuario.salvarUsuario(emissor);
        this.servicousuario.salvarUsuario(receptor);
    
        // Tentando notificar o emissor, e tratando a falha, se necessário
        try {
            this.servicoNotificacao.notificar(emissor, "FEITOOOO");
        } catch (Exception e) {
            System.out.println("Falha ao enviar notificação para o emissor: " + e.getMessage());
        }
    
        // Tentando notificar o receptor, e tratando a falha, se necessário
        try {
            this.servicoNotificacao.notificar(receptor, "RECEBIDOOO");
        } catch (Exception e) {
            System.out.println("Falha ao enviar notificação para o receptor: " + e.getMessage());
        }
    
        return transacao;
    }
    
    

    public boolean autorizarTransacao(Usuario emissor, BigDecimal valor) {
       /* ResponseEntity<Map<String, Object>> autorizarResponse = restTemplate.exchange(
            "https://util.devi.tools/api/v2/authorize",
            HttpMethod.GET,
            null, 
            new ParameterizedTypeReference<Map<String, Object>>() {}
        );
    
        if (autorizarResponse.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> responseBody = autorizarResponse.getBody();
    
            if (responseBody != null && responseBody.containsKey("message")) {
                String message = responseBody.get("message").toString();
                return "Autorizado".equalsIgnoreCase(message);
            }
        }*/
        return true;
    }
}
