/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.senha;

import javax.swing.JOptionPane;

/**
 *
 * @author queenregina
 */
public class SenhaOdonto extends SenhaEspecializacao implements ISenha{
    private static int senha;
    private static int senhaEmergencia;
    private static int qtdNormal;
    private static int qtdEmergencial;

    public SenhaOdonto() {
        SenhaOdonto.senha = 0;
        SenhaOdonto.senhaEmergencia = 0;
        SenhaOdonto.qtdNormal = 0;
        SenhaOdonto.qtdEmergencial = 0;
    }
    
    
    
    @Override
    public void chamarSenha() {
        if(qtdEmergencial > 0)
        {
            SenhaOdonto.senhaEmergencia++;
            SenhaOdonto.qtdEmergencial--;
            JOptionPane.showMessageDialog(null, "SEOd"+SenhaOdonto.senhaEmergencia);     
        }else if(qtdNormal > 0)
        {
            SenhaOdonto.senha++;
            SenhaOdonto.qtdNormal--;
            JOptionPane.showMessageDialog(null, "SNOd"+SenhaOdonto.senha); 
        }
    }

    @Override
    public void zerarSenhas() {
        SenhaOdonto.senha = 0;
        SenhaOdonto.senhaEmergencia = 0;
        SenhaOdonto.qtdNormal = 0;
        SenhaOdonto.qtdEmergencial = 0;
    }

    @Override
    public void adicionarSenha() {
        int entrada = Integer.parseInt(JOptionPane.showInputDialog(null,"1.Senha Emergencial\n2.Senha Normal.\n"));
        if(entrada == 1)
        {
            SenhaOdonto.qtdEmergencial++;
            JOptionPane.showMessageDialog(null,"SEOd"+SenhaOdonto.qtdEmergencial);
        }
        else
        {
            SenhaOdonto.qtdNormal++;
            JOptionPane.showMessageDialog(null,"SNOd"+SenhaOdonto.qtdNormal);
        }
    }
    

}
