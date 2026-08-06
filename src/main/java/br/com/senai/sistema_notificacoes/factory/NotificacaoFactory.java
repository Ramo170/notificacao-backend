package br.com.senai.sistema_notificacoes.factory;

import br.com.senai.sistema_notificacoes.interfaces.Notificacao;
import br.com.senai.sistema_notificacoes.service.EmailService;
import br.com.senai.sistema_notificacoes.service.SmsService;
import br.com.senai.sistema_notificacoes.service.WhatsappService;
import org.springframework.mail.javamail.JavaMailSender;

public class NotificacaoFactory {

    public static Notificacao criar(String tipo, JavaMailSender mailSender){
        if (tipo.equalsIgnoreCase("EMAIL")){
            return new EmailService(mailSender);
        }
        if (tipo.equalsIgnoreCase("SMS")){
            return new SmsService();
        }
        if (tipo.equalsIgnoreCase("WHATSAPP")){
            return new WhatsappService();
        }
        throw new IllegalArgumentException("Tipo de notificação invalido");
    }
}
