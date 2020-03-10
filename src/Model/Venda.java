/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author alfarr
 */
public class Venda implements Serializable {
    private int id_;
    private HashMap<Produto, Integer> produtos;
    private double total_;

    public Venda() {
        this.produtos = new HashMap();
        this.total_ = 0;
    }

    public Venda(int id_, HashMap<Produto, Integer> produtos, double total_) {
        this.id_ = id_;
        this.produtos = produtos;
        this.total_ = total_;
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<Produto, Integer> produtos) {
        this.produtos = produtos;
    }
    
    public void putProduto(Produto produto, int qtd){
        
        if (produto instanceof Peca){
            produtos.put(produto, qtd);
        } else {
            produtos.put(produto, 1);
        }
    }
    
    public void calcTotal(){
        this.total_ = 0;
        
        this.produtos.entrySet().forEach((pair) -> {
            this.total_ += ((double) pair.getValue()) * (((Produto) pair.getKey()).getPreco_());
        });
    }

    public double getTotal_(){
        return this.total_;
    }
    
    
    
}
