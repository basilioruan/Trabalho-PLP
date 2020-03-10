/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import Model.Servico;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public class ServicoDAO implements ProdutoDAOInterface, ServicoDAOInterface {

    @Override
    public <T> boolean insertProduto(ArrayList<T> array_generico, T produto) throws ServicoDAOException {
        try{
            return array_generico.add(produto);
        } catch (Exception e) {
            throw new ServicoDAOException(e.getMessage() + " // Erro em Servico - insertProduto(array, produto) ");
        }
    }

    @Override
    public <T> boolean deleteProduto(ArrayList<T> array_generico, int id) throws ServicoDAOException {
        try{
            Object p = returnByID(array_generico, id);
            
            return array_generico.remove((T) p);
        } catch (Exception e) {
            throw new ServicoDAOException(e.getMessage() + " // Erro em Servico - deleteProduto(array, id) ");
        }
    }

    @Override
    public <T> Produto retrieveByNome(ArrayList<T> array_generico, String nome) throws ServicoDAOException {
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
            throw new ServicoDAOException(e.getMessage() + " // Erro em Servico - retrieveByNome(array, nome) ");          
        }
    }

    @Override
    public <T> boolean updateServico(ArrayList<Servico> array_generico, int id, String op, T update) throws ServicoDAOException {
        
        boolean rFlag = true;
        
        try{
            Servico temp = (Servico) array_generico.get(id);

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
                    temp.setPreco_((float) update);
                    break;
                }

                case "duração":{
                    temp.setDuracao_((float) update);
                    break;
                }

                default:
                    rFlag = false;
                    break;
            }
            
            return rFlag;
        } catch (Exception e){
            throw new ServicoDAOException(e.getMessage() + " // Erro em Servico - updateProduto ");
        }
    }

    @Override
    public <T> Produto returnByID(ArrayList<T> array_generico, int id) throws Exception {
        try{
            Produto p = null;
            
            for(Object t : array_generico){
                if(t instanceof Produto){
                    Servico temp = (Servico) t;
                    if (temp.getId_() == id){
                        p = temp;
                        break;
                    }
                }
            }
            
            return p;
        
        } catch (Exception e){
            throw new ServicoDAOException(e.getMessage() + " // Erro em Servico - returnByID(array, nome) ");          
        }
    }
    
}
