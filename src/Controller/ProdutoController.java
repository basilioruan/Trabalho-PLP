/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PecaDAO;
import DAO.PecaDAOException;
import DAO.ServicoDAO;
import DAO.ServicoDAOException;
import Model.Peca;
import Model.Produto;
import Model.Servico;
import java.util.ArrayList;

/**
 *
 * @author ruanbasilio
 */
public class ProdutoController {
    
    
    public boolean insertion_peca(ArrayList<Peca> array_pecas, Peca peca) throws Exception {
        try{
            PecaDAO peca_dao = new PecaDAO();
            return peca_dao.insertProduto(array_pecas, peca);
        } catch (PecaDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto Controller - insertion peca");
        }
    }
    
    public boolean insertion_servico(ArrayList<Servico> array_servicos, Servico servico) throws Exception {
        try{
            ServicoDAO servico_dao = new ServicoDAO();
            return servico_dao.insertProduto(array_servicos, servico);
        } catch (ServicoDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto Controller - insertion servico ");
        }
    }
   
    public boolean deletion_peca(ArrayList<Peca> array_pecas, int id) throws Exception {
        try{
            PecaDAO peca_dao = new PecaDAO();
            return peca_dao.deleteProduto(array_pecas, id);
        } catch (PecaDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto Controller - insertion peca");
        }
    }
    
    public boolean deletion_servico(ArrayList<Peca> array_servicos, int id) throws Exception {
        try{
            ServicoDAO servico_dao = new ServicoDAO();
            return servico_dao.deleteProduto(array_servicos, id);
        } catch (ServicoDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto Controller - insertion peca");
        }
    }
    
    public Peca read_peca(ArrayList<Peca> array_pecas, String nome) throws Exception{
        try{
            PecaDAO peca_dao = new PecaDAO();
            return (Peca) peca_dao.retrieveByNome(array_pecas, nome);
        }catch (PecaDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto Controller - read peca ");
       }   
    }
    
    public Servico read_servico(ArrayList<Servico> array_servico, String nome) throws Exception{
        try{
            ServicoDAO servico_dao = new ServicoDAO();
            return (Servico) servico_dao.retrieveByNome(array_servico, nome);
        }catch (ServicoDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto Controller - read servico ");
       }   
    }
    
    public <T> boolean update_peca(ArrayList<Peca> array_pecas, int id, String op, T update) throws Exception{
       try{
          PecaDAO peca_dao = new PecaDAO();
          return peca_dao.updatePeca(array_pecas, id, op, update);
       } catch (PecaDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto Controller - update peca ");
       }
   }
    
    public <T> boolean update_servico(ArrayList<Servico> array_servico, int id, String op, T update) throws Exception{
       try{
          ServicoDAO servico_dao = new ServicoDAO();
          return servico_dao.updateServico(array_servico, id, op, update);
       } catch (ServicoDAOException e){
           throw new Exception(e.getMessage() + " // Erro em Produto Controller - update servico ");
       }
   }
    
    public boolean update_estoque(ArrayList<Peca> array_peca, int id, int venda) throws Exception{
        try{
            PecaDAO peca_dao = new PecaDAO();
            return peca_dao.updateEstoque(array_peca, id, venda);
        } catch (PecaDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Produto Controller - update_estoque ");
        }
            
    }
    
    public Produto returnByID_peca(ArrayList<Peca> array_peca, int id) throws Exception{
        try{
            PecaDAO peca_dao = new PecaDAO();
            return peca_dao.returnByID(array_peca, id);
        } catch (PecaDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Produto Controller - returnByID_peca ");
        }
    }
    
    public Produto returnByID_servico(ArrayList<Servico> array_servico, int id) throws Exception{
        try{
            ServicoDAO servico_dao = new ServicoDAO();
            return servico_dao.returnByID(array_servico, id);
        } catch (PecaDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Produto Controller - returnByID_servico ");
        }
    }
}
 