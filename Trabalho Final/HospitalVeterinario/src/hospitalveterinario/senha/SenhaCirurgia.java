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
public class SenhaCirurgia implements ISenha{
    private static int senha;
    private static int senhaEmergencia;
    private static int qtdNormal;
    private static int qtdEmergencial;
    char c = 'C';

    public SenhaCirurgia() {
        SenhaCirurgia.senha = 0;
        SenhaCirurgia.senhaEmergencia = 0;
        SenhaCirurgia.qtdNormal = 0;
        SenhaCirurgia.qtdEmergencial = 0;
    }
    
    
    
    @Override
    public void chamarSenha() {
        if(qtdEmergencial > 0)
        {
            SenhaCirurgia.senhaEmergencia++;
            SenhaCirurgia.qtdEmergencial--;
            JOptionPane.showMessageDialog(null, "SEC"+SenhaCirurgia.senhaEmergencia,"Chamar Senha", -1);     
        }else if(qtdNormal > 0)
        {
            SenhaCirurgia.senha++;
            SenhaCirurgia.qtdNormal--;
            JOptionPane.showMessageDialog(null, "SNC"+SenhaCirurgia.senha,"Chamar Senha", -1);
        }
    }

    @Override
    public void zerarSenhas() {
        SenhaCirurgia.senha = 0;
        SenhaCirurgia.senhaEmergencia = 0;
        SenhaCirurgia.qtdNormal = 0;
        SenhaCirurgia.qtdEmergencial = 0;
    }

    @Override
    public void adicionarSenha() {
        int entrada;
        entrada = Integer.parseInt(JOptionPane.showInputDialog(null,"1.Senha Emergencial\n2.Senha Normal.\n"));
        if(entrada == 1)
        {
            SenhaCirurgia.qtdNormal++;
            JOptionPane.showMessageDialog(null, "SNC"+SenhaCirurgia.qtdNormal,"Adicionar Senha", -1);
        }
        else
        {
            SenhaCirurgia.qtdEmergencial++;
            JOptionPane.showMessageDialog(null, "SEC"+SenhaCirurgia.qtdEmergencial,"Adicionar Senha", -1);
        }
    }
    
}
