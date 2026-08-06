package br.com.senai.sistema_notificacoes.service;

import br.com.senai.sistema_notificacoes.interfaces.Notificacao;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService implements Notificacao {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public String enviar(String destinatario, String mensagem){

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(destinatario);
        email.setSubject("Nova notificação");
        email.setText(mensagem);

        mailSender.send(email);

        return "Email enviado com sucesso para " + destinatario;
    }
}
