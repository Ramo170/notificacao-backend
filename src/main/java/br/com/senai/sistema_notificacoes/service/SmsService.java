package br.com.senai.sistema_notificacoes.service;

import br.com.senai.sistema_notificacoes.interfaces.Notificacao;

public class SmsService implements Notificacao {

    public String enviar(String destinatario, String mensagem){

        return "Sms enviado para " + destinatario + " Mensagem " + mensagem;
    }
}
