/*
 * Classe para trabalhar com Datas.
 */
package hospitalveterinario;
import java.util.Calendar;
/**
 *
 * @author Daiane Silva e João Felipe Freitas.
 */
public class Data {
    private int dia;
    private int mes;
    private int ano;
    protected Calendar c = Calendar.getInstance();

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public Data()
    {
        this.ano = c.get(Calendar.YEAR);
        this.dia = c.get(Calendar.DAY_OF_MONTH);
        this.mes = c.get(Calendar.MONTH);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public String getDiaMesAno()
    {
        return dia+"/"+mes+"/"+ano+"/";
    }
    
}
