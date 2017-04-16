/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.sistemas;

import hospitalveterinario.HospitalVeterinario;
import hospitalveterinario.cliente.Animal;
import hospitalveterinario.cliente.Atendimento;
import hospitalveterinario.cliente.Cliente;
import hospitalveterinario.funcionarios.Bolsista;
import hospitalveterinario.funcionarios.Funcionario;
import javax.swing.JOptionPane;

/**
 *
 * @author Daiane Silva e João Felipe 
 */
public class SistemaBolsista {
    public static void main(HospitalVeterinario h, Funcionario f)
    {
        int entrada = 0;
        entrada = Integer.parseInt(JOptionPane.showInputDialog("\n- Sistema Bolsista -\n"+
                    "\n1. Chamar Senha Trial."+
                    "\n2. Adicionar Informação a Animal"+
                    "\n3. Criar novo Animal"+
                    "\n4. Iniciar Atendimento"+
                    "\n0. Sair."));
        switch(entrada)
        {
            case 1:
                h.getSenhaTrial().chamarSenha();
                SistemaBolsista.main(h,f);
                break;
            case 2:
                String cpf = SistemaTratamentoErro.tratamentoErro("","Digite o CPF:\n");
                Cliente cliente = Cliente.getCliente(h.getArrPessoa(), cpf);
                Animal.adicionarInformacoes(cliente);
                SistemaBolsista.main(h,f);
                break;
            case 4:
                int escolha = 0;
                cpf = SistemaTratamentoErro.tratamentoErro("","Digite o CPF:\n");
                cliente = Cliente.getCliente(h.getArrPessoa(), cpf);
                if(cliente == null)
                {
                    JOptionPane.showMessageDialog(null,"Cliente não cadastrado.\n");
                }
                else
                {
                    String nomeA = JOptionPane.showInputDialog("Digite o nome do Animal");
                    Bolsista temp = (Bolsista)f;
                    Atendimento atendimento = new Atendimento(temp);
                    Animal animal = Animal.getAnimal(cliente, nomeA);
                    if(animal == null)
                    {
                        JOptionPane.showMessageDialog(null,"Animal não cadastrado.\n");
                    }
                    else
                    {
                        animal.getArrAtendimento().add(atendimento);
                        boolean sair = false;
                        while(!sair)
                        {
                            escolha = SistemaTratamentoErro.tratamentoErro(escolha,"- Sistema Atendimento -\n"+
                                        "\n1. Adicionar Informações a Animal"+
                                        "\n2. Senha Especialização"+
                                            "\n0. Sair");
                            switch(escolha)   
                            {
                                    case 1:
                                        Animal.adicionarInformacoes(cliente);
                                        break;
                                    case 2:
                                        animal = Animal.getAnimal(cliente, nomeA);
                                        String especializacao = JOptionPane.showInputDialog("Digite a especialização");
                                        if(especializacao.equals("cirurgia"))
                                        {
                                            h.getSenhaCirurgia().adicionarSenha();
                                        }
                                        if(especializacao.equals("oftalmo"))
                                        {
                                            h.getSenhaOftalmo().adicionarSenha();
                                        }
                                        if(especializacao.equals("geral"))
                                        {
                                            h.getSenhaGeral().adicionarSenha();
                                        }
                                        if(especializacao.equals("odonto"))
                                        {
                                            h.getSenhaOdonto().adicionarSenha();
                                        }
                                        if(especializacao.equals("reproducao"))
                                        {
                                            h.getSenhaReproducao().adicionarSenha();
                                        }
                                        atendimento.setEspecializacao(especializacao);
                                        SistemaBolsista.main(h, f);
                                        break;
                                    case 0:
                                        sair = true;
                                        break;
                                    default:
                                        SistemaBolsista.main(h, f);
                                        break;                   
                            }
                        }    
                    }    
                }    
                SistemaBolsista.main(h,f);
                break;
            case 3:
                cpf = SistemaTratamentoErro.tratamentoErro("","Digite o CPF:\n");
                cliente = Cliente.getCliente(h.getArrPessoa(), cpf);
                if(cliente == null)
                {
                    JOptionPane.showMessageDialog(null,"Cliente não cadastrado.\n");
                }
                else
                {
                    String nomeA = JOptionPane.showInputDialog("Digite o nome do Animal");
                    Animal animal = Animal.getAnimal(cliente, nomeA);
                    if(animal != null)
                    {
                        JOptionPane.showMessageDialog(null,"Animal já existe.");
                    }
                    else
                    {
                        cliente.getArrAnimal().add(new Animal(nomeA));
                        JOptionPane.showMessageDialog(null, "Animal criado com sucesso.\n");
                    }
                }    
                SistemaBolsista.main(h,f);
                break;
            case 0:
                JOptionPane.showMessageDialog(null, "Logoff\n");
                SistemaInterno.main(h);
                break;
            default:
                SistemaBolsista.main(h,f);
                break;
        }

    }

}    
