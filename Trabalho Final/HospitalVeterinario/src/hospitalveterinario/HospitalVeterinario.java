/*
 * Classe de Aplicação do Projeto de Programação Orientada ao Objeto
Um programa para gerênciar o atendimento do Hospital Veterinário da UFBA
 */
package hospitalveterinario;
import hospitalveterinario.cliente.Cliente;
import hospitalveterinario.funcionarios.Pessoa;
import hospitalveterinario.funcionarios.Administrador;
import hospitalveterinario.estoque.Estoque;
import hospitalveterinario.estoque.Produto;
import hospitalveterinario.funcionarios.Bolsista;
import hospitalveterinario.funcionarios.Financeiro;
import hospitalveterinario.funcionarios.Medico;
import hospitalveterinario.funcionarios.Recepcao;
import hospitalveterinario.sistemas.SistemaInterno;
import hospitalveterinario.senha.SenhaOdonto;
import hospitalveterinario.senha.SenhaReproducao;
import hospitalveterinario.senha.SenhaTrial;
import hospitalveterinario.senha.SenhaInicial;
import hospitalveterinario.senha.SenhaOftalmo;
import hospitalveterinario.senha.SenhaCirurgia;
import hospitalveterinario.senha.SenhaGeral;
import java.util.ArrayList;
/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class HospitalVeterinario {
    private ArrayList<Estoque> arrEstoque = new ArrayList<>();
    private ArrayList<Produto> arrProduto = new ArrayList<>();
    private ArrayList<Pessoa> arrPessoa = new ArrayList<>();
    private ArrayList<Procedimento> arrProcedimento = new ArrayList<>();
    private SenhaInicial senha = new SenhaInicial();
    private SenhaTrial senhaTrial = new SenhaTrial();
    private SenhaCirurgia senhaCirurgia = new SenhaCirurgia();
    private SenhaOftalmo senhaOftalmo = new SenhaOftalmo();
    private SenhaGeral senhaGeral = new SenhaGeral();
    private SenhaOdonto senhaOdonto = new SenhaOdonto();
    private SenhaReproducao senhaReproducao = new SenhaReproducao();
    private static double DinheiroCaixa, totalPagamento;

    public double getDinheiroCaixa() {
        return DinheiroCaixa;
    }

    public void setDinheiroCaixa(double DinheiroCaixa) {
        HospitalVeterinario.DinheiroCaixa = DinheiroCaixa;
    }

    public double getTotalPagamento() {
        return totalPagamento;
    }

    public void setTotalPagamento(double totalPagamento) {
        HospitalVeterinario.totalPagamento = totalPagamento;
    }
    
    

    public ArrayList<Estoque> getArrEstoque() {
        return arrEstoque;
    }

    public ArrayList<Produto> getArrProduto() {
        return arrProduto;
    }

    public ArrayList<Procedimento> getArrProcedimento() {
        return arrProcedimento;
    }

    public SenhaInicial getSenha() {
        return senha;
    }

    public SenhaTrial getSenhaTrial() {
        return senhaTrial;
    }

    public SenhaCirurgia getSenhaCirurgia() {
        return senhaCirurgia;
    }

    public SenhaOftalmo getSenhaOftalmo() {
        return senhaOftalmo;
    }

    public SenhaGeral getSenhaGeral() {
        return senhaGeral;
    }

    public SenhaOdonto getSenhaOdonto() {
        return senhaOdonto;
    }

    public SenhaReproducao getSenhaReproducao() {
        return senhaReproducao;
    }
    
     
    public SenhaInicial getSenhaInicial()
    {
        return this.senha;
    }

    public ArrayList<Pessoa> getArrPessoa() {
        return arrPessoa;
    }

    public void setArrPessoa(ArrayList<Pessoa> arrPessoa) {
        this.arrPessoa = arrPessoa;
    }
    
    public HospitalVeterinario(String nome, String cpf, String login, String senha) {
        this.arrPessoa.add(new Administrador(nome,cpf,login,senha));
    } 
    
    public static void main(String[] args) {
            HospitalVeterinario h = new HospitalVeterinario("Silvinho","cpf","login","senha");
            h.arrPessoa.add(new Financeiro("Dai", "122", "login1", "senha1"));
            h.arrPessoa.add(new Financeiro("Dai", "122", "login1", "senha1"));
            h.arrPessoa.add(new Bolsista("we","wert","er","srg","ser","srgd","we","login2","senha2",12.90));
            h.arrPessoa.add(new Recepcao("we","wert","er","srg","ser","srgd","we","login3","senha3",12.90));
            h.arrPessoa.add(new Medico("we","wert","er","srg","ser","srgd","we","login4","senha4",12.90,"crmv","geral"));
            h.arrProcedimento.add(new Procedimento("castrar","castrar",200));
            h.arrProcedimento.add(new Procedimento("Exame de Sangue","examinar sangue animal",250));
            h.arrPessoa.add(new Cliente("Daiane","1234","Lola"));
            SistemaInterno.main(h);
    }    
}
