/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAO;
import DAO.ClienteDAOException;
import Model.Cliente;
import View.EnderecoView;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public class ClienteController {
    
    private final EnderecoView endereco_view_;
    
    public ClienteController (){
        endereco_view_ = new EnderecoView();
    }
           
    public boolean insert (ArrayList<Cliente> clientes_array_, Cliente cliente) throws Exception{
        try{
            ClienteDAO cliente_dao = new ClienteDAO();
            return cliente_dao.insertCliente(clientes_array_, cliente);
            
        } catch (ClienteDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Cliente Controller - insertion ");
        }
    }
    
    public boolean delete (ArrayList<Cliente> clientes_array_, String cpf) throws Exception {
        try{
            ClienteDAO cliente_dao = new ClienteDAO();
            EnderecoView endereco_view = new EnderecoView();
            
            endereco_view.deletion(cliente_dao.retrieveClienteByCPF(clientes_array_, cpf).getId_endereco_());
            
            return cliente_dao.deleteClienteByCPF(clientes_array_, cpf);
        } catch (ClienteDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Cliente Controller - deletion ");    
        }
    }
    
    public Cliente read (ArrayList<Cliente> clientes_array_, String cpf) throws Exception {
        
        ClienteDAO clienteDAO = new ClienteDAO();
        
        return clienteDAO.retrieveClienteByCPF(clientes_array_, cpf);

   }
    
    
    public void update(ArrayList<Cliente> clientes_array_, String cpf, String op, String _new) throws Exception{
        try{            
            ClienteDAO cliente_dao = new ClienteDAO();
            
            Cliente c = cliente_dao.retrieveClienteByCPF(clientes_array_, cpf);

            clientes_array_.remove(c);
            
            switch (op.toLowerCase()){
                
                case "cpf":{                                  
                    c.setCpf_(_new);
                    break;
                }
                
                case "nome":{
                    c.setNome_(_new);
                    break;
                }
                
                case "telefone":{
                    c.setTelefone_(_new);
                    break;
                }
                
                case "endereço":{
                    endereco_view_.update(c.getId_endereco_());
                    break;
                }
                        
            }
            
            clientes_array_.add(c);
            
            
        } catch (ClienteDAOException e){
            throw new Exception(e.getMessage() + " // Erro em Cliente Controller - update  ");    
        }
    }
    
    public boolean checkCPF (ArrayList<Cliente> clientes_array_, String cpf){
        ClienteDAO cliente_dao = new ClienteDAO();
        
        return cliente_dao.checkCPF(clientes_array_, cpf);
    }
    
}
