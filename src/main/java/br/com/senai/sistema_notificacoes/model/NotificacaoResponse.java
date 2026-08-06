package br.com.senai.sistema_notificacoes.model;

public class NotificacaoResponse {

    private String status;

    public NotificacaoResponse(){

    }

    public NotificacaoResponse(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
