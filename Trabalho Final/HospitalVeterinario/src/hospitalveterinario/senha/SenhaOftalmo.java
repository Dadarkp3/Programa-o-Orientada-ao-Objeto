/*
 * Classe geradora de senha da Especialização Oftalmo
 */
package hospitalveterinario.senha;
import javax.swing.JOptionPane;

/**
 *
 * @author queenregina
 */
public class SenhaOftalmo extends SenhaEspecializacao implements ISenha {
    private static int senha;
    private static int senhaEmergencia;
    private static int qtdNormal;
    private static int qtdEmergencial;

    public SenhaOftalmo() {
        SenhaOftalmo.senha = 0;
        SenhaOftalmo.senhaEmergencia = 0;
        SenhaOftalmo.qtdNormal = 0;
        SenhaOftalmo.qtdEmergencial = 0;
    }
    
    
    
    @Override
    public void chamarSenha() {
        if(qtdEmergencial > 0)
        {
            SenhaOftalmo.senhaEmergencia++;
            SenhaOftalmo.qtdEmergencial--;
            JOptionPane.showMessageDialog(null,"SEO"+SenhaOftalmo.senhaEmergencia);      
        }else if(qtdNormal > 0)
        {
            SenhaOftalmo.senha++;
            SenhaOftalmo.qtdNormal--;
            JOptionPane.showMessageDialog(null,"SNO"+SenhaOftalmo.senha);  
        }
    }

    @Override
    public void zerarSenhas() {
        SenhaOftalmo.senha = 0;
        SenhaOftalmo.senhaEmergencia = 0;
        SenhaOftalmo.qtdNormal = 0;
        SenhaOftalmo.qtdEmergencial = 0;
    }

    @Override
    public void adicionarSenha() {
        int entrada = Integer.parseInt(JOptionPane.showInputDialog(null,"1.Senha Emergencial\n2.Senha Normal.\n"));
        if(entrada == 1)
        {
            SenhaOftalmo.qtdEmergencial++;
            JOptionPane.showMessageDialog(null,"SEO"+SenhaOftalmo.qtdEmergencial);     
        }
        else
        {
            SenhaOftalmo.qtdNormal++;
            JOptionPane.showMessageDialog(null,"SNO"+SenhaOftalmo.qtdNormal);
        }
    }
}
