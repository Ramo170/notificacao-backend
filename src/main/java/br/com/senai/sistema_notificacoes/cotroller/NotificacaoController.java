package br.com.senai.sistema_notificacoes.cotroller;

import br.com.senai.sistema_notificacoes.factory.NotificacaoFactory;
import br.com.senai.sistema_notificacoes.interfaces.Notificacao;
import br.com.senai.sistema_notificacoes.model.NotificacaoRequest;
import br.com.senai.sistema_notificacoes.model.NotificacaoResponse;
import br.com.senai.sistema_notificacoes.service.EmailService;
import br.com.senai.sistema_notificacoes.service.SmsService;
import br.com.senai.sistema_notificacoes.service.WhatsappService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificacoes")
@CrossOrigin(origins = "http://localhost:3000/")
public class NotificacaoController {

    private final JavaMailSender mailSender;

    public NotificacaoController(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }
    
    @PostMapping
    public NotificacaoResponse enviar(@RequestBody NotificacaoRequest request){

        Notificacao notificacao = NotificacaoFactory.criar(request.getTipo(),mailSender);

        String resultado = notificacao.enviar(request.getDestinatario(),
                request.getMensagem());

        return new NotificacaoResponse(resultado);
    }
}
