package br.com.senai.sistema_notificacoes.service;

import br.com.senai.sistema_notificacoes.interfaces.Notificacao;

public class WhatsappService implements Notificacao {

    public String enviar (String destinatario, String mensagem){

        return "Whatsapp enviado para " + destinatario + " Mensagem " + mensagem;
    }
}
