/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Peca;
import Model.Produto;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public class PecaDAO implements ProdutoDAOInterface, PecaDAOInterface{


    @Override
    public <T> boolean insertProduto(ArrayList<T> array_generico, T produto) throws PecaDAOException {
        try{
            return array_generico.add(produto);
        } catch (Exception e) {
            throw new PecaDAOException(e.getMessage() + " // Erro em Peca - insertProduto(array, produto) ");
        }
    }

    @Override
    public <T> boolean deleteProduto(ArrayList<T> array_generico, int id) throws PecaDAOException {
        try{
            Object p = returnByID(array_generico, id);
            
            return array_generico.remove((T) p);
        } catch (Exception e) {
            throw new PecaDAOException(e.getMessage() + " // Erro em Peca - deleteProduto(array, id) ");
        }
    }

    @Override
    public <T> Produto retrieveByNome(ArrayList<T> array_generico, String nome) throws PecaDAOException {
        try{
            Produto p = null;
            
            for(Object t : array_generico){
                if(t instanceof Produto){
                    Produto temp = (Produto) t;
                    if (temp.getNome_().equals(nome)){
                        p = temp;
                        break;
                    }
                }
            }
            
            return p;
        
        } catch (Exception e){
            throw new PecaDAOException(e.getMessage() + " // Erro em Peca - retrieveByNome(array, nome) ");          
        }
    }

    @Override
    public <T> boolean updatePeca(ArrayList<Peca> array_generico, int id, String op, T update) throws PecaDAOException {
        boolean rFlag = true;
        
        try{
            Peca temp = (Peca) array_generico.get(id);

            switch (op.toLowerCase()){

                case "nome":{
                    temp.setNome_((String) update);
                    break;
                }

                case "descrição":{
                    temp.setDesc_((String) update);
                    break;
                }

                case "preço":{
                    temp.setPreco_((double) update);
                    break;
                }

                case "quantidade":{
                    temp.setQtd_((int) update);
                    break;
                }

                case "fornecedor":{
                    temp.setId_fornecedor_((int) update);
                    break;
                }

                default:
                    rFlag = false;
                    break;
            }
            
            return rFlag;
        } catch (Exception e){
            throw new PecaDAOException(e.getMessage() + " // Erro em Servico - updateProduto ");
        }
    
    }

    @Override
    public boolean updateEstoque(ArrayList<Peca> array_peca, int id, int venda) throws Exception {
        try{
            boolean rFlag = false;
            
            for(Peca t : array_peca){
                if (t.getId_() == id){
                    if ((t.getQtd_() - venda) >= 0){
                        t.setQtd_(t.getQtd_() - venda);
                        rFlag = true;
                        break;
                    }
                }
   
            }
            
            return rFlag;
        } catch (Exception e){
            throw new PecaDAOException(e.getMessage() + " // Erro em Servico - updateEstoque ");
        }
            
    }

    @Override
    public <T> Produto returnByID(ArrayList<T> array_generico, int id) throws Exception {
        try{
            Produto p = null;
            
            for(Object t : array_generico){
                if(t instanceof Produto){
                    Peca temp = (Peca) t;
                    if (temp.getId_() == id){
                        p = temp;
                        break;
                    }
                }
            }
            return p;
        
        } catch (Exception e){
            throw new ServicoDAOException(e.getMessage() + " // Erro em Peca - returnByID(array, nome) ");          
        }
    }
    
}
