/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.sistemas;

import hospitalveterinario.HospitalVeterinario;
import hospitalveterinario.cliente.Animal;
import hospitalveterinario.cliente.Cliente;
import hospitalveterinario.cliente.Atendimento;
import hospitalveterinario.funcionarios.Funcionario;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author queenregina
 */
public class SistemaRecepcao {
    public static void main(HospitalVeterinario h, Funcionario f)
    {
        int entrada = SistemaTratamentoErro.tratamentoErro(0, "\n - Sistema Recepção -\n"+
                    "\n1. Chamar Senha Recepção."+
                    "\n2. Zerar Senha Recepção."+
                    "\n3. Criar novo Cliente."+
                    "\n4. Adicionar informações ao Cliente."+
                    "\n5. Adicionar informações sobre animal."+
                    "\n6. Ver lista de retornos."+
                    "\n0. Sair");
        switch(entrada)
        {
            case 1:
                h.getSenhaInicial().chamarSenha();
                SistemaRecepcao.main(h,f);
                break;
            case 2:
                h.getSenhaInicial().zerarSenhas();
                SistemaRecepcao.main(h,f);
                break;
            case 3:
                Cliente.criarCliente(h.getArrPessoa());
                SistemaRecepcao.main(h,f);
                break;
            case 4:
                String cpf = SistemaTratamentoErro.tratamentoErro(" ", "Digite o numero do CPF", "Erro: \nSomente Números devem ser adicionados.\nEscreva o CPF sem pontos,hífen ou espaço");
                Cliente cliente = Cliente.getCliente(h.getArrPessoa(),cpf);
                if(cliente != null)
                {
                    JOptionPane.showMessageDialog(null, cliente);
                    boolean sair = true;
                    while(sair)
                    {
                        int escolha = SistemaTratamentoErro.tratamentoErro(0, "Menu Adição:\n"+
                                "\n1. E-mail"+
                                "\n2. Celular"+
                                "\n3. Endereço"+
                                "\n4. RG"+
                                "\n5. Telefone"+
                                "\n6. Outras Informações"+
                                "\n7. Aluno/Funcionario UFBA"+
                                "\n0. Sair");
                        switch(escolha)
                        {
                            case 3:
                                cliente.setEndereco(JOptionPane.showInputDialog("Digite o Endereço:"));
                                break;
                            case 4:
                                cliente.setRg(JOptionPane.showInputDialog("Digite o RG:"));
                                break;
                            case 5:   
                                cliente.setTelefone(JOptionPane.showInputDialog("Digite o telefone:"));
                                break;
                            case 2:    
                                cliente.setCelular(JOptionPane.showInputDialog("Digite o celular:"));
                                break;
                            case 1:    
                                cliente.setEmail(JOptionPane.showInputDialog("Digite o e-mail:"));
                            case 6:
                                String outrasInformacoes = JOptionPane.showInputDialog("Digite o outras Informações:");
                                break;
                            case 7:    
                                int ufba = SistemaTratamentoErro.tratamentoErro(0, "Estudande ou Funcionário da UFBA?\n1.Sim\n2.Não");
                                boolean uf = false;
                                if(ufba == 1) uf = true;
                                cliente.setUfba(uf);
                                break;
                            case 8:
                                sair = false;
                                SistemaRecepcao.main(h,f);
                                break;
                        }
                    }    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Usuário não encontrado\n");
                }
                SistemaRecepcao.main(h,f);
                break;
            case 5:
                cpf = SistemaTratamentoErro.tratamentoErro(" ", "-Adicionar informação Animal -\nDigite o numero do CPF", "Erro: \nSomente Números devem ser adicionados.\nEscreva o CPF sem pontos,hífen ou espaço");
                cliente = Cliente.getCliente(h.getArrPessoa(),cpf);
                Animal.adicionarInformacoes(cliente);
                break;
            case 6:
                Atendimento.listarRetorno(h.getArrPessoa());
                break;
            case 0:
                JOptionPane.showMessageDialog(null,"Logoff");
                SistemaInterno.main(h);
                break;
            default:
                SistemaRecepcao.main(h, f);
                break;
        }
        
    }
}
