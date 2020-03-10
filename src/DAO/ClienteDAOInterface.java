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
public interface ClienteDAOInterface {
    
    public boolean insertCliente(Cliente cliente) throws ClienteDAOException;
    public boolean insertCliente(ArrayList<Cliente> array_clientes, Cliente cliente) throws ClienteDAOException;
    public boolean deleteClienteByID(int id) throws ClienteDAOException;
    public boolean deleteClienteByCPF (ArrayList<Cliente> array_clientes, String cpf) throws ClienteDAOException;
    
    public Cliente retrieveClienteByCPF(ArrayList<Cliente> array_clientes, String cpf) throws ClienteDAOException;
    
    public ArrayList<Cliente> retrieveAll() throws ClienteDAOException;
    
    public boolean checkCPF(ArrayList<Cliente> clientes_array, String cpf);
    
    
    
}
