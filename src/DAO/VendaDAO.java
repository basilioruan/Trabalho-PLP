/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Venda;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public class VendaDAO implements VendaDAOInterface{

    @Override
    public boolean insertVenda(ArrayList<Venda> array_vendas_, Venda venda) throws VendaDAOException {
        try{
            return array_vendas_.add(venda);
        } catch (Exception e){
            throw new VendaDAOException (e.getMessage() + " // Erro em insertVenda (array venda)");
        }
    }
    
}
