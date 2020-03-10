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
public class Produto implements Serializable {
    protected double preco_;
    protected String nome_;
    protected String desc_;

    public Produto(double preco_, String nome_, String desc_) {
        this.preco_ = preco_;
        this.nome_ = nome_;
        this.desc_ = desc_;
    }

    public Produto() {
    }

    public double getPreco_() {
        return preco_;
    }

    public void setPreco_(double preco_) {
        this.preco_ = preco_;
    }

    public String getNome_() {
        return nome_;
    }

    public void setNome_(String nome_) {
        this.nome_ = nome_;
    }

    public String getDesc_() {
        return desc_;
    }

    public void setDesc_(String desc_) {
        this.desc_ = desc_;
    }
       
}
