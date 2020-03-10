/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author alfarr
 */
public class Endereco implements Serializable  {
    private int id_;
    private String rua_;
    private String numero_;
    private String bairro_;
    private String cidade_;
    private String estado_;
    private String cep_;

    public Endereco() {
    }

    public Endereco(int id_, String rua_, String numero_, String bairro_, String cidade_, String estado_, String cep_) {
        this.id_ = id_;
        this.rua_ = rua_;
        this.numero_ = numero_;
        this.bairro_ = bairro_;
        this.estado_ = estado_;
        this.cep_ = cep_;
        this.cidade_ = cidade_;
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public String getRua_() {
        return rua_;
    }

    public void setRua_(String rua_) {
        this.rua_ = rua_;
    }

    public String getNumero_() {
        return numero_;
    }

    public void setNumero_(String numero_) {
        this.numero_ = numero_;
    }

    public String getBairro_() {
        return bairro_;
    }

    public void setBairro_(String bairro_) {
        this.bairro_ = bairro_;
    }

    public String getEstado_() {
        return estado_;
    }

    public void setEstado_(String estado_) {
        this.estado_ = estado_;
    }

    public String getCep_() {
        return cep_;
    }

    public void setCep_(String cep_) {
        this.cep_ = cep_;
    }

    public String getCidade_() {
        return cidade_;
    }

    public void setCidade_(String cidade_) {
        this.cidade_ = cidade_;
    }
    
    @Override
    public String toString(){
        return "Endereço: \nCEP: " + cep_ + "\nRua: " + rua_ + "\nNúmero: " + numero_ + 
                "\nBairro: " + bairro_ + "\nCidade: " + cidade_ + "\nEstado: " + estado_;
    }
    
}
