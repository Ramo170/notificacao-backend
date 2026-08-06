package br.com.senai.sistema_notificacoes.model;

public class NotificacaoRequest {

    private String tipo;
    private String destinatario;
    private String mensagem;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public  NotificacaoRequest(){

    }
}
