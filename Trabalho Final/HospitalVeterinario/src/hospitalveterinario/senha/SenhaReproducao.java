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
public class SenhaReproducao extends SenhaEspecializacao implements ISenha {
    private static int senha;
    private static int senhaEmergencia;
    private static int qtdNormal;
    private static int qtdEmergencial;

    public SenhaReproducao() {
        SenhaReproducao.senha = 0;
        SenhaReproducao.senhaEmergencia = 0;
        SenhaReproducao.qtdNormal = 0;
        SenhaReproducao.qtdEmergencial = 0;
    }
    
    
    
    @Override
    public void chamarSenha() {
        if(qtdEmergencial > 0)
        {
            SenhaReproducao.senhaEmergencia++;
            SenhaReproducao.qtdEmergencial--;
            JOptionPane.showMessageDialog(null,"SER"+SenhaReproducao.senhaEmergencia);    
        }else if(qtdNormal > 0)
        {
            SenhaReproducao.senha++;
            SenhaReproducao.qtdNormal--;
            JOptionPane.showMessageDialog(null,"SNR"+SenhaReproducao.senha);
        }
    }

    @Override
    public void zerarSenhas() {
        SenhaReproducao.senha = 0;
        SenhaReproducao.senhaEmergencia = 0;
        SenhaReproducao.qtdNormal = 0;
        SenhaReproducao.qtdEmergencial = 0;
    }

    @Override
    public void adicionarSenha() {
        int entrada = Integer.parseInt(JOptionPane.showInputDialog(null,"1.Senha Emergencial\n2.Senha Normal.\n"));
        if(entrada == 1)
        {
            SenhaReproducao.qtdEmergencial++;
            JOptionPane.showMessageDialog(null,"SER"+SenhaReproducao.qtdEmergencial); 
        }
        else
        {
            SenhaReproducao.qtdNormal++;
            JOptionPane.showMessageDialog(null,"SNR"+SenhaReproducao.qtdNormal);
        }
    }
}
