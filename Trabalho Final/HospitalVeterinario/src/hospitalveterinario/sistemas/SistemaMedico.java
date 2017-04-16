/*
 * Sistema Interno - Medico
 */
package hospitalveterinario.sistemas;

import hospitalveterinario.Conta;
import hospitalveterinario.funcionarios.Funcionario;
import hospitalveterinario.HospitalVeterinario;
import hospitalveterinario.Procedimento;
import hospitalveterinario.cliente.Animal;
import hospitalveterinario.cliente.Atendimento;
import hospitalveterinario.cliente.Cliente;
import hospitalveterinario.estoque.Estoque;
import hospitalveterinario.funcionarios.Medico;
import javax.swing.JOptionPane;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 * 
 */

public class SistemaMedico {
    public static void main(HospitalVeterinario h, Funcionario f)
    {
        Conta conta = null;
        Medico temporario = (Medico)f;
        int entrada = 0;
        entrada = SistemaTratamentoErro.tratamentoErro(entrada,"- Sistema Médico -\n"+
                        "\n1. Chamar senha."+
                        "\n2. Criar Animal."+
                        "\n3. Atendimento."+
                        "\n0. Sair.");
        
        switch(entrada)
        {
            case 1:
                if(temporario.getEspecializacao().equals("cirurgia"))
                {
                    h.getSenhaCirurgia().chamarSenha();
                }
                if(temporario.getEspecializacao().equals("odonto"))
                {
                    h.getSenhaOdonto().chamarSenha();
                }
                if(temporario.getEspecializacao().equals("oftalmo"))
                {
                    h.getSenhaOftalmo().chamarSenha();
                }
                if(temporario.getEspecializacao().equals("geral"))
                {
                    h.getSenhaGeral().chamarSenha();
                }
                if(temporario.getEspecializacao().equals("reproducao"))
                {
                    h.getSenhaReproducao().chamarSenha();
                }
                SistemaMedico.main(h, f);
                break;
            case 2:
                String cpf = SistemaTratamentoErro.tratamentoErro("","Digite o CPF\n");
                Cliente cliente = Cliente.getCliente(h.getArrPessoa(), cpf);
                if(cliente ==  null)
                {
                    JOptionPane.showMessageDialog(null,"Cliente não existe");
                }
                else
                {
                    Animal.adicionarInformacoes(cliente);
                }
                SistemaMedico.main(h, f);
                break;
            case 3:
                cpf = SistemaTratamentoErro.tratamentoErro("","Digite o CPF\n");
                cliente = Cliente.getCliente(h.getArrPessoa(), cpf);
                if(cliente ==  null)
                {
                    JOptionPane.showMessageDialog(null,"Cliente não existe");
                }
                else
                {
                    String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal");
                    Animal animal = Animal.getAnimal(cliente, nomeAnimal);
                    if(animal == null)
                    {
                        JOptionPane.showMessageDialog(null,"Animal não encontrado.");
                    }
                    else
                    {    
                        Atendimento atendimento = Atendimento.getAtendimento(cliente, nomeAnimal, temporario);
                        if(atendimento == null)
                        {
                            JOptionPane.showMessageDialog(null,"Nenhum atendimento marcado para esse especialista");
                        }
                        else
                        {
                            boolean sair = false;
                            while(!sair)
                            {
                                int atend = SistemaTratamentoErro.tratamentoErro(atend = 0,"1. Adicionar Procedimento\n"+
                                "2. Adicionar Produto\n"+
                                "3. Adicionar Data de Retorno\n"+
                                        "4.Fechar Atendimento\n"+
                                        "5.Valor Total\n"+
                                        "0. Sair");
                                switch(atend)
                                {
                                    case 1:
                                        int prop = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do procedimento desejado, 0 caso não tenha nenhum\n."+Procedimento.imprimeProcedimento(h.getArrProcedimento())));
                                        if(prop > 0)
                                        {
                                            atendimento.getConta().getArrProcedimento().add(h.getArrProcedimento().get(prop-1));   
                                        }    
                                        break;
                                    case 2:
                                        prop = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do produto desejado ou 0 para sair.\n"+Estoque.listarProdutos(h.getArrEstoque())));
                                        if(prop > 0)
                                        {
                                            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade:"));
                                            if(quantidade <= h.getArrEstoque().get(prop-1).getQuantidade())
                                            {
                                                atendimento.getConta().addProduto(h.getArrProduto().get(prop-1), quantidade);
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null,"Não temos estoque suficiente");
                                            } 
                                        }    
                                        break;
                                    case 4:
                                        JOptionPane.showMessageDialog(null,"Atendimento Fechado com sucesso.");
                                        atendimento.fecharAtendimento();
                                        break;
                                    case 3:
                                        int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia"));
                                        int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes"));
                                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
                                        atendimento.setDataRetorno(dia, mes, ano);
                                        JOptionPane.showMessageDialog(null,"Data Retorno:"+dia+"/"+mes+"/"+ano);
                                        break;
                                    case 5:
                                        JOptionPane.showMessageDialog(null,atendimento.getConta().ResumoConta());
                                        break;
                                    case 0:    
                                        sair = true;
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }    
                }    
                SistemaMedico.main(h, f);
                break;
            case 0:
                JOptionPane.showMessageDialog(null,"Logoff");
                SistemaInterno.main(h);
                break;
            default:
                SistemaMedico.main(h, f);
                break;
        }
    }
}
