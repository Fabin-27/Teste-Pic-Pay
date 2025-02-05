package com.DesafioPicPay.DesafioPicPay.Servicos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.DesafioPicPay.DesafioPicPay.Dtos.NotificarDTO;
import com.DesafioPicPay.DesafioPicPay.dominio.usuarios.Usuario;

@Service
public class ServicoNotificacao {

    private final RestTemplate restTemplate;

    public ServicoNotificacao(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void notificar(Usuario usuario, String mensagem) throws Exception {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }

        String email = usuario.getEmail();
        NotificarDTO notificarRequisicao = new NotificarDTO(email, mensagem);

        ResponseEntity<String> notificarResposta = restTemplate.postForEntity(
            "https://util.devi.tools/api/v1/notify", 
            notificarRequisicao, 
            String.class
        );

        if (notificarResposta.getStatusCode() != HttpStatus.OK) {
            throw new Exception("Serviço de notificação está fora do ar");
        }
    }
}
