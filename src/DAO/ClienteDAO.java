/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public class ClienteDAO implements ClienteDAOInterface{
    
    @Override
    public boolean insertCliente(Cliente cliente) throws ClienteDAOException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public boolean insertCliente(ArrayList<Cliente> clientes_array, Cliente cliente) throws ClienteDAOException {
       try{
           if (!checkCPF(clientes_array, cliente.getCpf_()))
               return clientes_array.add(cliente);
           else{
               System.out.println("CPF repetido!");
               return false;
           }
       } catch (Exception e){
           throw new ClienteDAOException(e.getMessage() + " // Erro em insertCliente(array,cliente) ");
       }
    }

    @Override
    public boolean deleteClienteByID(int id) throws ClienteDAOException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean deleteClienteByCPF(ArrayList<Cliente> clientes_array, String cpf) throws ClienteDAOException {
        try{
            Cliente c = retrieveClienteByCPF(clientes_array, cpf);
            
            return clientes_array.remove(c);
            
        }catch(ClienteDAOException e){
            throw new ClienteDAOException(e.getMessage() + " // Erro em deleteClienteByCPF(array, cpf) ");
        }
    }


    @Override
    public ArrayList<Cliente> retrieveAll() throws ClienteDAOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente retrieveClienteByCPF(ArrayList<Cliente> clientes_array, String cpf) throws ClienteDAOException {
        try{
            Cliente rCliente = null;
            
            for(Cliente c : clientes_array){
                if (c.getCpf_().equals(cpf)){
                    rCliente = c;
                    break;
                }
            }
            
            return rCliente;
                
        }catch (Exception e){
            throw new ClienteDAOException(e.getMessage() + " // Erro em retrieveClienteByCPF");
        }
            
            
    }

    @Override
    public boolean checkCPF(ArrayList<Cliente> clientes_array, String cpf){
        boolean rFlag = false;
        for(Cliente c : clientes_array){
            if (c.getCpf_().equals(cpf)){
                rFlag = true;
                break;
            }
        }
        return rFlag;
        
    }  

}
