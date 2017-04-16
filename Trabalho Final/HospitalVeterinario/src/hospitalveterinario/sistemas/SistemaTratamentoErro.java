/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.sistemas;

import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daiane Mascarenhas Lauro da Silva e João Felipe Melo de Freitas Santos
 */
public class SistemaTratamentoErro {
    public static String tratamentoErro(String texto,String mensagem1,String mensagem2)//criado somente para checar se a string passada para cpf virá num formato valido(sem espaços,pontos ou hifen
    {
        String tratamento = texto;
        tratamento = " ";
        boolean bomFormatoTratamento = false;
        while(!bomFormatoTratamento)
        {
            try
            {
                tratamento = JOptionPane.showInputDialog(mensagem1);
                int testaTratamento = Integer.parseInt(tratamento);
                bomFormatoTratamento = true;
            }catch(InputMismatchException | NumberFormatException e){
                JOptionPane.showMessageDialog(null,mensagem2);
                bomFormatoTratamento = false;
            }    
        }
        return tratamento;
    }
    
    public static String tratamentoErro(String texto,String mensagem)//criado somente para checar se a string passada para cpf virá num formato valido(sem espaços,pontos ou hifen
    {
        String tratamento = texto;
        tratamento = " ";
        boolean bomFormatoTratamento = false;
        while(!bomFormatoTratamento)
        {
            try
            {
                tratamento = JOptionPane.showInputDialog(mensagem);
                int testaTratamento = Integer.parseInt(tratamento);
                bomFormatoTratamento = true;
            }catch(InputMismatchException | NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Valor Invalido.\nErro: " + e);
                bomFormatoTratamento = false;
            }    
        }
        return tratamento;
    }
    
        public static int tratamentoErro(int numero, String mensagem)
    {
        int tratamento = numero;
        tratamento = 0;
        boolean bomFormatoTratamento = false;
        while(!bomFormatoTratamento)
        {
            try
            {
                tratamento = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
                String testeTratamento = Integer.toString(tratamento);
                bomFormatoTratamento = true;
            }catch(InputMismatchException | NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Valor Inválido" + "\nErro: " + e);
                bomFormatoTratamento = false;
            }
        }
        return tratamento;
    }
    
    public static double tratamentoErro(double numero, String mensagem)
    {
        double tratamento = numero;
        tratamento = 0;
        boolean bomFormatoTratamento = false;
        while(!bomFormatoTratamento)
        {
            try
            {
                tratamento = Double.parseDouble(JOptionPane.showInputDialog(mensagem));
                String testeTratamento = Double.toString(tratamento);
                bomFormatoTratamento = true;
            }catch(InputMismatchException | NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Valor Inválido" + "\nErro: " + e);
                bomFormatoTratamento = false;
            }
        }
        return tratamento;
    }
    
    public static float tratamentoErro(float numero, String mensagem)
    {
        float tratamento = numero;
        tratamento = 0;
        boolean bomFormatoTratamento = false;
        while(!bomFormatoTratamento)
        {
            try
            {
                tratamento = Float.parseFloat(JOptionPane.showInputDialog(mensagem));
                String testeTratamento = Float.toString(tratamento);
                bomFormatoTratamento = true;
            }catch(InputMismatchException | NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Valor Inválido" + "\nErro: " + e);
                bomFormatoTratamento = false;
            }
        }
        return tratamento;
    }
}
