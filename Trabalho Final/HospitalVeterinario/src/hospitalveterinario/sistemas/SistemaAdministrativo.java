/*
 * Sistema Interno - Administrativo
 */
package hospitalveterinario.sistemas;

import hospitalveterinario.funcionarios.Administrador;


import hospitalveterinario.funcionarios.Bolsista;

import hospitalveterinario.estoque.Estoque;
import hospitalveterinario.funcionarios.Financeiro;
import hospitalveterinario.funcionarios.Funcionario;
import hospitalveterinario.HospitalVeterinario;
import hospitalveterinario.Procedimento;
import hospitalveterinario.cliente.Animal;
import hospitalveterinario.cliente.Atendimento;
import hospitalveterinario.cliente.Cliente;
import hospitalveterinario.funcionarios.Medico;
import hospitalveterinario.funcionarios.Pessoa;
import hospitalveterinario.estoque.Produto;
import hospitalveterinario.funcionarios.Recepcao;
import javax.swing.JOptionPane;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class SistemaAdministrativo {
    
    
    public static void main(HospitalVeterinario h, Funcionario f)
    {
        int entrada = SistemaTratamentoErro.tratamentoErro(0, "\n- Bem vindo ao Sistema Administrativo -\n"+
                    "1.  Adicionar Funcionario.\n"+
                    "2.  Adiconar Produto.\n"+
                    "3.  Adicionar Procedimento.\n"+
                    "4.  Adicionar mais estoque ao Produto.\n"+
                    "5.  Criar novo Cliente.\n"+
                    "6.  Ver lista de Clientes.\n"+
                    "7.  Ver lista de Produtos.\n"+
                    "8.  Ver lista de Procedimento.\n"+
                    "9.  Adicionar novo Animal.\n"+
                    "10. Ver lista de Funcionarios.\n"+
                    "11. Ver Lista de Retorno.\n"+
                    "0. Sair.\n");
        switch (entrada) 
        {
            case 1:
                JOptionPane.showMessageDialog(null,"\n- Criação de Funcionario -\n");
                String cpf = SistemaTratamentoErro.tratamentoErro(" ", "Digite o cpf", "Erro: \nSomente Números devem ser adicionados.\nEscreva o CPF sem pontos,hífen ou espaço");
                if(Pessoa.validarPessoa(h.getArrPessoa(), cpf))
                {
                    JOptionPane.showMessageDialog(null,"Funcionario já cadastrado.\n");
                    SistemaAdministrativo.main(h,f);
                    break;
                }
                else
                {                          
                    String nome = JOptionPane.showInputDialog("Digite o Nome:");
                    String endereco = JOptionPane.showInputDialog("Digite o Endereço:");
                    String rg = JOptionPane.showInputDialog("Digite o RG:");
                    String telefone = JOptionPane.showInputDialog("Digite o telefone:");
                    String celular = JOptionPane.showInputDialog("Digite o celular:");
                    String email = JOptionPane.showInputDialog("Digite o e-mail:");
                    String login;
                    //do
                    //{
                        login = JOptionPane.showInputDialog("Digite o login:");
                    //}
                    //while();
                    String senha = JOptionPane.showInputDialog("Digite a senha:");
                    double salario = SistemaTratamentoErro.tratamentoErro(0, "Digite o valor do Salário:");
                    
                    
                    int profissao = SistemaTratamentoErro.tratamentoErro(0, "Escolha o tipo de Funcionário\n"+
                                        "1. Administrador.\n"+
                                        "2. Médico.\n"+
                                        "3. Bolsista.\n"+
                                        "4. Recepcionista.\n"+
                                        "5. Financeiro.\n");
                    switch (profissao) 
                    {
                        case 1:
                            h.getArrPessoa().add(new Administrador(nome, endereco, cpf, rg, telefone, celular, email,login,senha,salario));
                            break;
                        case 2:
                            String crmv = JOptionPane.showInputDialog("Digite o CRMV:");
                            String especializacao = JOptionPane.showInputDialog("Digite a especialização:");
                            h.getArrPessoa().add(new Medico(nome, endereco, cpf, rg, telefone, celular, email, login, senha, salario,crmv,especializacao));
                            break;
                        case 3:
                            h.getArrPessoa().add(new Bolsista(nome, endereco, cpf, rg, telefone, celular, email, login, senha, salario));
                            break;
                        case 4:
                            h.getArrPessoa().add(new Recepcao(nome, endereco, cpf, rg, telefone, celular, email, login, senha, salario));
                            break;
                        case 5:
                            h.getArrPessoa().add(new Financeiro(nome, endereco, cpf, rg, telefone, celular, email, login, senha, salario));
                            break;
                        default:
                            break;
                    }
                }
                        JOptionPane.showMessageDialog(null,"Funcionario adicionado com sucesso");
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,"\n- Adicionando novo Produto -");
                        
                        String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
                        if(Produto.validarProduto(h.getArrProduto(), nome));
                        else
                        {
                            double valor = SistemaTratamentoErro.tratamentoErro(0 ,"Digite o valor do produto:" );
                            int quantidade =  SistemaTratamentoErro.tratamentoErro(-1, "Adicione uma quantidade ao produto\n(0 se não houver):");
                            h.getArrProduto().add(new Produto(nome,valor));
                            int i = h.getArrProduto().size()-1;
                            h.getArrEstoque().add(new Estoque(h.getArrProduto().get(i),quantidade));
                            JOptionPane.showMessageDialog(null,"Produto adicionado com sucesso.");
                        }
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,"\n- Adicionando novo Procedimento -");
                        
                        nome = JOptionPane.showInputDialog("Digite o nome do Procedimento:");
                        if(Procedimento.validarProcedimento(h.getArrProcedimento(), nome));
                        else
                        {
                            double valor =  SistemaTratamentoErro.tratamentoErro(0, "Digite o valor do procedimento:" );
                            String descricao =JOptionPane.showInputDialog("Digite a descrição do procedimento");
                            h.getArrProcedimento().add(new Procedimento(nome,descricao,valor));
                            JOptionPane.showMessageDialog(null,"Procedimento adicionado com sucesso.");
                        }
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 4:
                        nome = JOptionPane.showInputDialog(Produto.listarProdutos(h.getArrEstoque())+"\n\nDigite o nome do Produto\n");
                        for(Estoque e : h.getArrEstoque())
                        {
                            System.out.println(e.getProduto().getNome());
                        }
                        Estoque estoque = null;
                        for(Estoque e : h.getArrEstoque())
                        {
                            if(e.getProduto().getNome().equals(nome))
                                estoque = e;
                        }
                        if(estoque != null)
                        {
                            
                            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade"));
                            estoque.setQuantidade(estoque.getQuantidade()+quantidade);
                        }    
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 5:
                        Cliente.criarCliente(h.getArrPessoa());
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 6:
                        String clientes = "";
                        for(Pessoa c : h.getArrPessoa())
                        {
                            if(c instanceof Cliente)
                                clientes+= c.getNome()+"\n";
                        }
                        JOptionPane.showMessageDialog(null, clientes);
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, Produto.listarProdutos(h.getArrEstoque()));
                        break;
                    case 8:
                        String procedimento = "\n - Procedimentos -\n";
                        for(Procedimento p : h.getArrProcedimento())
                        {
                            procedimento += "\nProcedimento: "+p.getNome()+" | Valor:"+p.getValor();
                        }
                        JOptionPane.showMessageDialog(null,procedimento);
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 9:
                        cpf =  SistemaTratamentoErro.tratamentoErro(" ", "Digite o CPF do Dono", "Erro.Valor Invalido(Somente Números)\n");
                        Cliente cliente = Cliente.getCliente(h.getArrPessoa(), cpf);
                        nome = JOptionPane.showInputDialog("Digite o nome do animal");
                        boolean resposta = false;
                        for(Animal a : cliente.getArrAnimal())
                        {
                            if(a.getNome().equals(nome))
                                resposta = true;
                        }
                        if(resposta)
                            JOptionPane.showMessageDialog(null,"Animal já cadastrado");
                        else
                        {
                            String especie = JOptionPane.showInputDialog("Digite a especie do animal:");
                            String raca = JOptionPane.showInputDialog("Digite a raça do animal:");
                            String pelagem = JOptionPane.showInputDialog("Digite a pelagem do animal:");
                            char sexo = (JOptionPane.showInputDialog("Sexo\n1.Fêmea.\n2.Macho.\n")).charAt(0);
                            String esterilizacao = JOptionPane.showInputDialog("Esterelização\n1.Sim.\n2.Não.");
                            String infoComplementar = JOptionPane.showInputDialog("Informação Complementar:");
                            
                            float peso = SistemaTratamentoErro.tratamentoErro(peso = 0,"Digite o peso");
                            int temPedigree = SistemaTratamentoErro.tratamentoErro(0, "Pedrigree\n1.Sim.\n2.Não.");
                            boolean Pedigree = false;
                            if (temPedigree == 1)
                                    Pedigree = true;
                            int dia =  SistemaTratamentoErro.tratamentoErro(0, "Digite o dia do Nascimento");
                            int mes =  SistemaTratamentoErro.tratamentoErro(0, "Digite o mês do Nascimento");
                            int ano =  SistemaTratamentoErro.tratamentoErro(0, "Digite o ano do Nascimento");

                            cliente.getArrAnimal().add(new Animal(nome, peso,especie, raca, pelagem,esterilizacao,infoComplementar, Pedigree, sexo,dia, mes,ano));
                            JOptionPane.showMessageDialog(null,"Animal criado com sucesso.\n");
                        }
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 10:
                        for(Pessoa p : h.getArrPessoa())
                            if(p instanceof Funcionario)
                            {
                                JOptionPane.showMessageDialog(null,p);
                            }    
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 11:
                        Atendimento.listarRetorno(h.getArrPessoa());
                        SistemaAdministrativo.main(h,f);
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null,"LogOff.\n");
                        SistemaInterno.main(h);
                        break;
                    default:
                        SistemaAdministrativo.main(h,f);
                        break;
            }
    }
}
