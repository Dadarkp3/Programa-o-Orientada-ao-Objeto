/*
 * Sistema Interno - Login
 */
package hospitalveterinario.sistemas;
import hospitalveterinario.funcionarios.Administrador;
import hospitalveterinario.funcionarios.Bolsista;
import hospitalveterinario.funcionarios.Financeiro;
import hospitalveterinario.funcionarios.Funcionario;
import hospitalveterinario.HospitalVeterinario;
import hospitalveterinario.funcionarios.Medico;
import hospitalveterinario.funcionarios.Recepcao;
import hospitalveterinario.funcionarios.ValidarFuncionario;
import javax.swing.JOptionPane;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class SistemaLogin {
    public static void main(HospitalVeterinario h)
    {
        JOptionPane.showMessageDialog(null,"\n - SISTEMA LOGIN - \n");
        String login = JOptionPane.showInputDialog(null,"Login:" );
        String senha = JOptionPane.showInputDialog(null,"Senha:");
        Funcionario funcionario;
        //Polimorfismo
        funcionario = ValidarFuncionario.validarFuncionario(h.getArrPessoa(), login, senha);
        if(funcionario != null)
        {
            //Polimorfismo com o uso do Instaceof
            if(funcionario instanceof Administrador)
            {
                SistemaAdministrativo.main(h,funcionario);
            }
            if(funcionario instanceof Medico)
            {
                SistemaMedico.main(h, funcionario);
            }
            if(funcionario instanceof Bolsista)
            {
                SistemaBolsista.main(h, funcionario);
            }
            if(funcionario instanceof Recepcao)
            {
                SistemaRecepcao.main(h, funcionario);
            }
            if(funcionario instanceof Financeiro)
            { 
              SistemaFinanceiro.main(h,funcionario);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"\nFuncionario não Encontrado.\n");
            SistemaInterno.main(h);
        }
    }
}
