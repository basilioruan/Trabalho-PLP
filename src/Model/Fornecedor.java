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
public class Fornecedor implements Serializable{
    
    private int id_;
    private String cnpj_;
    private String nome_fantasia;
    private int id_endereco_;

    public Fornecedor() {
    }

    public Fornecedor(int id_, String cnpj_, String nome_fantasia, int id_endereco_) {
        this.id_ = id_;
        this.cnpj_ = cnpj_;
        this.nome_fantasia = nome_fantasia;
        this.id_endereco_ = id_endereco_;
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public String getCnpj_() {
        return cnpj_;
    }

    public void setCnpj_(String cnpj_) {
        this.cnpj_ = cnpj_;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public int getId_endereco_() {
        return id_endereco_;
    }

    public void setId_endereco_(int id_endereco_) {
        this.id_endereco_ = id_endereco_;
    }
    
    
    
    
}
