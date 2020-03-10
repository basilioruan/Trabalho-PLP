/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author alfarr
 */
public class Servico extends Produto{
    
    private int id_;
    private double duracao_;

    public Servico() {
    }
        
    
    public Servico(int id_, String nome_, String desc_, double preco_, double duracao_) {
        super(preco_, nome_, desc_);
        this.id_ = id_;
        this.duracao_ = duracao_;
        
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public double getDuracao_() {
        return duracao_;
    }

    public void setDuracao_(double duracao_) {
        this.duracao_ = duracao_;
    }
     
        
    @Override
    public String toString(){
        return id_ + " | " + nome_ + " | " + desc_ + " | " + duracao_ + " | " + preco_;
    }
    
}
