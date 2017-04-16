/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.sistemas;
import hospitalveterinario.cliente.Cliente;
import hospitalveterinario.funcionarios.Funcionario;
import hospitalveterinario.HospitalVeterinario;
import hospitalveterinario.cliente.Animal;
import hospitalveterinario.cliente.Atendimento;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class SistemaFinanceiro {      

    
    public static void main(HospitalVeterinario h, Funcionario f)
    {
        int entrada =  SistemaTratamentoErro.tratamentoErro(0, "\n -Sistema Financeiro"+
                    "\n1. Trial"+
                    "\n2. Dinheiro em Caixa"+
                    "\n3. Fechar Conta"+
                    "\n4. Ver Lista de Clientes Inadimplentes"+
                    "\n5. Balanço do dia"+
                    "\n0. Sair");
        switch(entrada)
        {
            case 1:
                int escolha = SistemaTratamentoErro.tratamentoErro(0, "\n1.Dinheiro.\n2.Cartão\n3.Outros");
                switch (escolha)
                {
                    case 1:
                        h.setDinheiroCaixa(h.getDinheiroCaixa()+50.0);
                        h.setTotalPagamento(h.getTotalPagamento()+50.0);
                        break;
                    case 2:
                        h.setTotalPagamento(h.getTotalPagamento()+50.0);
                        break;
                    default:
                        double dinheiro = SistemaTratamentoErro.tratamentoErro(0, "Digite o valor a ser pago em dinheiro");

                        double cartao = SistemaTratamentoErro.tratamentoErro(0, "Digite o valor a ser pago no cartão");
                        h.setDinheiroCaixa(h.getDinheiroCaixa()+dinheiro);
                        h.setTotalPagamento(h.getTotalPagamento()+cartao);
                        break;
                }
                h.getSenhaTrial().adicionarSenha();
                SistemaFinanceiro.main(h,f);
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"Dinheiro em caixa:"+h.getDinheiroCaixa());
                SistemaFinanceiro.main(h,f);
                break;
            case 3:
                double valorTotal = 0.0;
                String resumoConta = "\nConta em Aberto:\n";
                String cpf = SistemaTratamentoErro.tratamentoErro(" ", "Digite o CPF do Cliente", "Erro.Valor Invalido(Somente Números)\n");
                Cliente c = Cliente.getCliente(h.getArrPessoa(),cpf);
                if(c != null)
                {
                    for(Animal animal : c.getArrAnimal())
                    {
                        for(Atendimento atendimento : animal.getArrAtendimento())
                        {
                            if(atendimento.getConta().isContaAberta())
                            {
                                resumoConta += atendimento.getConta().ResumoConta();
                                valorTotal += atendimento.getConta().getValorTotal();
                            }
                        }
                    }
                    resumoConta += "\nValor Total a Pagar: "+valorTotal;
                    JOptionPane.showMessageDialog(null,resumoConta);
                    if(valorTotal > 0)
                    {
                        int escolhas = SistemaTratamentoErro.tratamentoErro(0, "\n1.Dinheiro.\n2.Cartão\n3.Outros");

                        switch (escolhas)
                        {
                            case 1:
                                h.setDinheiroCaixa(h.getDinheiroCaixa()+valorTotal);
                                h.setTotalPagamento(h.getTotalPagamento()+valorTotal);
                                break;
                            case 2:
                                h.setTotalPagamento(h.getTotalPagamento()+valorTotal);
                                break;
                            default:
                                double dinheiro = SistemaTratamentoErro.tratamentoErro(0, "Digite o valor a ser pago em dinheiro");

                                double cartao = SistemaTratamentoErro.tratamentoErro(0, "Digite o valor a ser pago no cartão");

                                h.setDinheiroCaixa(h.getDinheiroCaixa()+dinheiro);
                                h.setTotalPagamento(h.getTotalPagamento()+cartao);
                                break;
                        }
                        c.setInadimplente(false);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Usuário não encontrado");
                }
                SistemaFinanceiro.main(h,f);
                break;
            case 4:
                JOptionPane.showMessageDialog(null,Cliente.CLientesInadimplentes(h.getArrPessoa()));
                SistemaFinanceiro.main(h,f);
                break;
            case 5:
                JOptionPane.showMessageDialog(null,h.getTotalPagamento());
                SistemaFinanceiro.main(h,f);
                break;
            case 0:
                JOptionPane.showMessageDialog(null,"LogOff");
                SistemaInterno.main(h);
                break;
            default:
                SistemaFinanceiro.main(h, f);
                break;
        }
    }
}
