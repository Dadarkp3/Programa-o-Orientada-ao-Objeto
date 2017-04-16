/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.funcionarios;
import java.util.ArrayList;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class ValidarFuncionario {
 
    public static Funcionario validarFuncionario(ArrayList<Pessoa> arrPessoa, String login, String senha)
    {
       Funcionario funcionario = null;
       for(Pessoa p : arrPessoa)
       {
           if(p instanceof Funcionario)
           {
                Funcionario temporario = (Funcionario)p;
                if(temporario.getLogin().equals(login) && temporario.getSenha().equals(senha))
                {
                    funcionario = temporario;
                }
           }
       }
       return funcionario;
    }    
}
