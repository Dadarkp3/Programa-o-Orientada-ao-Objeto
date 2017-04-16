/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.senha;

import javax.swing.JOptionPane;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */

//Herança Multipla de SenhaEspecialização e a Interface ISenha
public class SenhaGeral extends SenhaEspecializacao implements ISenha{
    //Atributos Estáticos
    private static int senha;
    private static int senhaEmergencia;
    private static int qtdNormal;
    private static int qtdEmergencial;

    public SenhaGeral() {
        SenhaGeral.senha = 0;
        SenhaGeral.senhaEmergencia = 0;
        SenhaGeral.qtdNormal = 0;
        SenhaGeral.qtdEmergencial = 0;
    }
    
    
    
    @Override
    public void chamarSenha() {
        if(qtdEmergencial > 0)
        {
            SenhaGeral.senhaEmergencia++;
            SenhaGeral.qtdEmergencial--;
            JOptionPane.showMessageDialog(null, "SEG"+SenhaGeral.senhaEmergencia,"Chamar Senha", -1); 
        }else if(qtdNormal > 0)
        {
            SenhaGeral.senha++;
            SenhaGeral.qtdNormal--;
            JOptionPane.showMessageDialog(null, "SNG"+SenhaGeral.senha,"Chamar Senha", -1);
        }
    }

    @Override
    public void zerarSenhas() {
        SenhaGeral.senha = 0;
        SenhaGeral.senhaEmergencia = 0;
        SenhaGeral.qtdNormal = 0;
        SenhaGeral.qtdEmergencial = 0;
    }

    @Override
    public void adicionarSenha() {
        int entrada = Integer.parseInt(JOptionPane.showInputDialog(null,"1.Senha Emergencial\n2.Senha Normal.\n"));
        if(entrada == 1)
        {
            SenhaGeral.qtdEmergencial++;
            JOptionPane.showMessageDialog(null, "SEG"+SenhaGeral.qtdEmergencial,"Adicionar Senha", -1);
        }
        else
        {
            SenhaGeral.qtdNormal++;
            JOptionPane.showMessageDialog(null, "SNG"+SenhaGeral.qtdNormal,"Adicionar Senha", -1);
        }
    }
    
    
}
