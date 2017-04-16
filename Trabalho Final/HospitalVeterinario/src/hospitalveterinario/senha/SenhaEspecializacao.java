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
public class SenhaEspecializacao implements ISenha {
    private static int senha;
    private static int senhaEmergencia;
    private static int qtdNormal;
    private static int qtdEmergencial;
    char c = 'E';

    public SenhaEspecializacao() {
        SenhaEspecializacao.senha = 0;
        SenhaEspecializacao.senhaEmergencia = 0;
        SenhaEspecializacao.qtdNormal = 0;
        SenhaEspecializacao.qtdEmergencial = 0;
    }
    
    
    
    @Override
    public void chamarSenha() {
        if(qtdEmergencial > 0)
        {
            SenhaEspecializacao.senhaEmergencia++;
            SenhaEspecializacao.qtdEmergencial--;
            JOptionPane.showMessageDialog(null, "SEG"+SenhaEspecializacao.senhaEmergencia,"Chamar Senha", -1); 
        }else if(qtdNormal > 0)
        {
            SenhaEspecializacao.senha++;
            SenhaEspecializacao.qtdNormal--;
            JOptionPane.showMessageDialog(null, "SNG"+SenhaEspecializacao.senha,"Chamar Senha", -1);
        }
    }

    @Override
    public void zerarSenhas() {
        SenhaEspecializacao.senha = 0;
        SenhaEspecializacao.senhaEmergencia = 0;
        SenhaEspecializacao.qtdNormal = 0;
        SenhaEspecializacao.qtdEmergencial = 0;
    }

    @Override
    public void adicionarSenha() {
        int entrada = Integer.parseInt(JOptionPane.showInputDialog(null,"1.Senha Emergencial\n2.Senha Normal.\n"));
        if(entrada == 1)
        {
            SenhaEspecializacao.qtdEmergencial++;
            JOptionPane.showMessageDialog(null, "SEG"+SenhaEspecializacao.qtdEmergencial,"Adicionar Senha", -1);
        }
        else
        {
            SenhaEspecializacao.qtdNormal++;
            JOptionPane.showMessageDialog(null, "SNG"+SenhaEspecializacao.qtdNormal,"Adicionar Senha", -1);
        }
    }
    
    
    
}
