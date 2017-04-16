package hospitalveterinario.cliente;

import hospitalveterinario.cliente.exames.Exame;
import hospitalveterinario.Conta;
import hospitalveterinario.Data;
import hospitalveterinario.funcionarios.Bolsista;
import hospitalveterinario.funcionarios.Medico;
import hospitalveterinario.funcionarios.Pessoa;
import hospitalveterinario.sistemas.SistemaTratamentoErro;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Classe de Atendimento 
 */

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class Atendimento {
    private Medico medicoResponsavel;
    private final Data dataAtendimento;
    private Bolsista bolsistaResponsavel;
    private Data dataRetorno;
    private Exame exame = new Exame();
    private boolean atendimentoAberto = true;
    private Conta conta;
    private String especializacao;

    public Atendimento(Medico medicoResponsavel) {
        this.dataAtendimento = new Data();
        this.conta = new Conta();
        this.medicoResponsavel = medicoResponsavel;
    }

    public void setDataRetorno(int dia, int mes, int ano) {
        this.dataRetorno = new Data(dia,mes,ano);
    }
        
    
    public Atendimento(Bolsista bolsistaResponsavel )
    {
        this.conta = new Conta();
        this.dataAtendimento = new Data();
        this.bolsistaResponsavel = bolsistaResponsavel;
    }
    
    public boolean isAtendimentoAberto() {
        return atendimentoAberto;
    }

    public void fecharAtendimento() {
        atendimentoAberto = false;
    }
    
    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(Medico medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public Bolsista getBolsistaResponsavel() {
        return bolsistaResponsavel;
    }

    public void setBolsistaResponsavel(Bolsista bolsistaResponsavel) {
        this.bolsistaResponsavel = bolsistaResponsavel;
    }
        
    public double getValorTotal()
    {
        return conta.getValorTotal();
    }

    public Data getDataAtendimento() {
        return dataAtendimento;
    }

    public Data getDataRetorno() {
        return dataRetorno;
    }

    public Conta getConta() {
        return conta;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    
    public static void listarRetorno(ArrayList<Pessoa> arrPessoa)
    {
        String retorno = "Retornos do dia:\n";
        int dia = SistemaTratamentoErro.tratamentoErro(0, "Digite o dia");
        int mes = SistemaTratamentoErro.tratamentoErro(0, "Digite o número do mês");
        int ano = SistemaTratamentoErro.tratamentoErro(0, "Digite o ano");
        Data data = new Data(dia,mes,ano);
        for(Pessoa p : arrPessoa)
        {
            if(p instanceof Cliente)
            {
                Cliente temporario = (Cliente)p;
                for(Animal a : temporario.getArrAnimal())
                {
                    for(Atendimento at: a.getArrAtendimento())
                    {
                        if(at.getDataRetorno() == data)
                            retorno += "Cliente: "+p.getNome()+" Animal:"+a.getNome()+"\n";
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null,retorno);
    }
    
    public static Atendimento getAtendimento(Cliente cliente, String nomeAnimal, Medico medico)
    {
        Atendimento atendimento = null;
        Animal animal = Animal.getAnimal(cliente, nomeAnimal);
        for(Atendimento a : animal.getArrAtendimento())
        {
            if(a.getEspecializacao().equals(medico.getEspecializacao()) && a.isAtendimentoAberto())
            {
                if(a.getMedicoResponsavel() == null)
                {
                    a.setMedicoResponsavel(medico);
                }    
                atendimento = a;
            }
        }
        return atendimento;
    
    }
    
}
