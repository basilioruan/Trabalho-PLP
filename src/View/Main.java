/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author ruanbasilio
 */
public class Main {
    
    public static void main (String[] args) throws Exception{
        Scanner ler = new Scanner(System.in);
        ClienteView cliente_view = new ClienteView();
        FornecedorView fornecedor_view = new FornecedorView();
        ProdutoView produto_view = new ProdutoView();
        EnderecoView endereco_view = new EnderecoView();
        
        int opc = -1, opc2 = -1;
        
        
        while(opc != 0 & opc2 != 0){
            System.out.println("======== MENU ========");
            System.out.println("1 - Cliente");
            System.out.println("2 - Fornecedor");
            System.out.println("3 - Produto");
            System.out.println("4 - Vendas");
            System.out.println("0 - Fechar");
            System.out.print("Escolha a opção desejada: ");
            opc2 = ler.nextInt();
            ler.nextLine();
            if(opc2 != 0 & opc2 != 4){
                System.out.println(" ");

                System.out.println("1 - Cadastrar");
                System.out.println("2 - Alterar");
                System.out.println("3 - Remover");
                System.out.println("4 - Listar");
                System.out.println("5 - Listar Todos");
                System.out.println("6 - Salvar");
                System.out.println("7 - Carregar");
                System.out.println("0 - Fechar");
                System.out.println("======================");
                System.out.print("Escolha a opção desejada: ");
                opc = ler.nextInt();
                ler.nextLine();
                System.out.println(" ");

                switch (opc) {
                    case 1:
                        //CADASTRO
                        switch (opc2) {
                            case 1:
                                cliente_view.insertion();
                                break;
                            case 2:
                                fornecedor_view.insertion();
                                break;
                            case 3:
                                produto_view.insertion();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        //ALTERAR
                        switch (opc2) {
                            case 1:
                                cliente_view.update();
                                break;
                            case 2:
                                fornecedor_view.update();
                                break;
                            case 3:
                                produto_view.update();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        //REMOVER
                        switch (opc2) {
                            case 1:
                                cliente_view.deletion();
                                break;
                            case 2:
                                fornecedor_view.deletion();
                                break;
                            case 3:
                                produto_view.deletion();
                                break;
                            default:
                                break;
                        } break;
                    case 4:
                        //READ
                        switch (opc2) {
                            case 1:
                                cliente_view.read();
                                break;
                            case 2:
                                fornecedor_view.read();
                                break;
                            case 3:
                                produto_view.read();
                                break;
                            default:
                                break;
                        } 
                        break;
                    case 5:
                        //READALL
                        switch (opc2) {
                            case 1:
                                cliente_view.readAll();
                                break;
                            case 2:
                                fornecedor_view.readAll();
                                break;
                            case 3:
                                produto_view.readAll();
                                break;
                            default:
                                break;
                        }
                        
                    case 6:
                        switch (opc2) {
                            case 1:
                                cliente_view.save();
                                endereco_view.save();
                                break;
                            case 2:
                                fornecedor_view.save();
                                endereco_view.save();
                                break;
                            case 3:
                                produto_view.save();
                                break;
                            default:
                                break;
                        }
                        
                    case 7:
                        switch (opc2) {
                            case 1:
                                ClienteView.load();
                                EnderecoView.load();
                                break;
                            case 2:
                                FornecedorView.load();
                                EnderecoView.load();
                                break;
                            case 3:
                                ProdutoView.load();
                                break;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            } else if (opc2 == 4){
                System.out.println("1 - Realizar venda");
                System.out.println("2 - Imprimir vendas");
                System.out.println("3 - Salvar");
                System.out.println("4 - Carregar");
                System.out.print("Escolha a opção desejada: ");
                opc = ler.nextInt();
                ler.nextLine();
                
                switch (opc){
                    case 1:
                        produto_view.venda();
                        break;
                    case 2:
                        produto_view.readVendas();
                        break;
                    case 3:
                        produto_view.save();
                        break;
                    case 4:
                        ProdutoView.load();
                        break;
                }
            }
        }
        
        System.out.println("Programa encerrado. Ate mais!");
        
    }
}
    

