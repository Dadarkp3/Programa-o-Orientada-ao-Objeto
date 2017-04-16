/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.sistemas;

import hospitalveterinario.HospitalVeterinario;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daiane Silva
 */
public class SistemaInterno {
    public static void main(HospitalVeterinario h)
    {
        int entrada = SistemaTratamentoErro.tratamentoErro(0, "Por favor digite a Opção Desejada:\n1.Senha\n2.Login.\n0.Sair.\n");
        switch (entrada) {
            case 1:
                SistemaSenha.main(h);
                SistemaInterno.main(h);
                break;
            case 2:
                SistemaLogin.main(h);
                break;
            case 0:
                break;
            default:
                SistemaInterno.main(h);
                break;
        }
    }
}
