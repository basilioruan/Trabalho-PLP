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
public class Cliente implements Serializable {
    
    private int id_;
    private String nome_;
    private String cpf_;
    private String telefone_;
    private String email_;
    private int id_endereco_;

    public Cliente() {
    }

    public Cliente(int id_, String nome_, String cpf_, String telefone_, String email_, int id_endereco_) {
        this.id_ = id_;
        this.nome_ = nome_;
        this.cpf_ = cpf_;
        this.telefone_ = telefone_;
        this.email_ = email_;
        this.id_endereco_ = id_endereco_;
    }

    public Cliente(int id_, String nome_, String cpf_, String telefone_) {
        this.id_ = id_;
        this.nome_ = nome_;
        this.cpf_ = cpf_;
        this.telefone_ = telefone_;
        this.email_ = null;
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public String getNome_() {
        return nome_;
    }

    public void setNome_(String nome_) {
        this.nome_ = nome_;
    }

    public String getCpf_() {
        return cpf_;
    }

    public void setCpf_(String cpf_) {
        this.cpf_ = cpf_;
    }

    public String getTelefone_() {
        return telefone_;
    }

    public void setTelefone_(String telefone_) {
        this.telefone_ = telefone_;
    }

    public String getEmail_() {
        return email_;
    }

    public void setEmail_(String email_) {
        this.email_ = email_;
    }

    public int getId_endereco_() {
        return id_endereco_;
    }

    public void setId_endereco_(int id_endereco_) {
        this.id_endereco_ = id_endereco_;
    }
    
   
        
    
}
