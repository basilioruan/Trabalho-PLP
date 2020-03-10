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
public interface VendaDAOInterface {

    /**
     *
     * @param array_vendas_
     * @param venda
     * @return 
     * @throws VendaDAOException
     */
    public boolean insertVenda (ArrayList<Venda> array_vendas_, Venda venda) throws VendaDAOException;
}
