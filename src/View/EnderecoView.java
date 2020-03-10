/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EnderecoController;
import FileUtils.FileIO;
import Model.Endereco;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alfarr
 */
public class EnderecoView {
    private final Scanner scanner;
    private static ArrayList<Endereco> enderecos_array_ = new ArrayList();
    private final EnderecoController endereco_controller_; 


    public EnderecoView() {
        this.scanner = new Scanner(System.in);
        endereco_controller_ = new EnderecoController();

    }   
    
    public int insertion () throws Exception {
        try{
            Endereco aux = new Endereco();
            System.out.print("CEP: ");
            aux.setCep_(scanner.nextLine());
            System.out.print("Rua: ");
            aux.setRua_(scanner.nextLine());
            System.out.print("Numero: ");
            aux.setNumero_(scanner.nextLine());
            System.out.print("Bairro: ");
            aux.setBairro_(scanner.nextLine());
            System.out.print("Cidade: ");
            aux.setCidade_(scanner.nextLine());
            System.out.print("Estado: ");
            aux.setEstado_(scanner.nextLine());
            
            aux.setId_(enderecos_array_.size());
            
            return endereco_controller_.insert (enderecos_array_, aux);
            
        } catch (Exception e){
            throw new Exception(e.getMessage() + " // Erro em Endereço View - insertion ");
        }
            
    }
    
    public void deletion (int id) throws Exception {
        try{
            endereco_controller_.delete(enderecos_array_, id);
        } catch (Exception e){
            throw new Exception(e.getMessage() + " // Erro em Endereço View - deletion ");
        }
    }
    
    public void read (int id) throws Exception {
        try{
            Endereco end;
            end = endereco_controller_.read(enderecos_array_, id);
            System.out.println(end.toString());
        } catch (Exception e){
            throw new Exception(e.getMessage() + " // Erro em Endereço View - read ");
        }
    }
    
    public void update (int id) throws Exception {
        try{
            String vetor[] = new String[6];

            
            System.out.println("Digite o novo endereco");
            System.out.print("CEP: ");
            vetor[0] = scanner.nextLine();
            System.out.print("Rua: ");
            vetor[1] = scanner.nextLine();
            System.out.print("Numero: ");
            vetor[2] = scanner.nextLine();
            System.out.print("Bairro: ");
            vetor[3] = scanner.nextLine();
            System.out.print("Cidade: ");
            vetor[4] = scanner.nextLine();
            System.out.print("Estado: ");
            vetor[5] = scanner.nextLine();
            
            endereco_controller_.update(enderecos_array_, id, vetor);
        } catch (Exception e){
            throw new Exception(e.getMessage() + " // Erro em Endereço View - update ");
        }
        
        
    }
     public void save() throws Exception{
        FileIO.saveToFile(enderecos_array_, "enderecos");
    }
    
     public static void load() throws Exception{
        try{
            enderecos_array_ = (ArrayList<Endereco>) FileIO.loadFromFile("enderecos");
        }catch (ClassCastException e){
            System.out.println("Class cast error");
        }
    }

}
