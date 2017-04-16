/*
 * Classe de Procedimentos do Hospital com a sua descrição e valor
 */
package hospitalveterinario;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Daiane Silva e João Felipe Freitas
 */
public class Procedimento {

    public static String imprimeProcedimento(ArrayList<Procedimento> arrProcedimento) {
       String procedimento = "\n----- Procedimento ------";
       int i = 1;
       for(Procedimento p : arrProcedimento)
       {
           procedimento += "\n"+(i)+"."+p.getNome()+" | Valor: R$"+p.getValor();
           i++;
       }
       return procedimento;
    }
    private String nome;
    private String descricao;
    private double valor;

    public Procedimento(String nome, String descricao,double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public static boolean validarProcedimento(ArrayList<Procedimento> arrProcedimento, String nome)
    {
        boolean resposta = false;
        for(Procedimento p : arrProcedimento)
        {
            resposta = p.getNome().equals(nome);
        }
        if(resposta == true)
            JOptionPane.showMessageDialog(null,"Procedimento já cadastrado.");
        return resposta;
    }
    
}
