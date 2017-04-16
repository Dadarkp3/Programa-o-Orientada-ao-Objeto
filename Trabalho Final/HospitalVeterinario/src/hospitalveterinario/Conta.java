/*
 * Classe que organiza os procedimentos e produtos usados no atendimento
 */
package hospitalveterinario;
import hospitalveterinario.estoque.ProdutoAtendimento;
import hospitalveterinario.estoque.Produto;
import java.util.ArrayList;
/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class Conta {
    
    private ArrayList<ProdutoAtendimento> arrProdutoAtendimento = new ArrayList<>();
    private ArrayList<Procedimento> arrProcedimento = new ArrayList<>();
    private double ValorTotal;
    private boolean contaAberta = true;

    //Construtor de Conta, inicializa a conta em 0;
    public Conta() {
        this.ValorTotal = 0.0;
    }
    
    public ArrayList<ProdutoAtendimento> getArrProdutoAtendimento() {
        return arrProdutoAtendimento;
    }
    
    public ArrayList<Procedimento> getArrProcedimento() {
        return arrProcedimento;
    }
    
    /*Adiciona o produto e a quantidade do produto a um ArrayList para saber o que
    foi usado e a quantidade
    */
    public void addProduto(Produto produto, int quantidade)
    {
        this.arrProdutoAtendimento.add(new ProdutoAtendimento(produto,quantidade));
    }
    
    public void addProcedimento(Procedimento procedimento)
    {
        this.arrProcedimento.add(procedimento);
    }
    
    public boolean isContaAberta() {
        return contaAberta;
    }
    public void setContaAberta(boolean contaAberta) {
        this.contaAberta = contaAberta;
    }
    
    //Retorna o valor total da conta
    public double getValorTotal() {
        double valor = 0;
        for(Procedimento p : this.arrProcedimento)
        {
            valor += p.getValor();
        }
        for(ProdutoAtendimento a : this.arrProdutoAtendimento)
        {
            valor+= a.getQuantidade()*a.getProduto().getValor();
        }
        return valor;        
    }
    
    public String ResumoConta()
    {
        String resumo = "";
        for(Procedimento p : this.arrProcedimento)
        {
            resumo += "Procedimento:"+p.getNome()+" Valor:"+p.getValor()+"\n";
        }
        for(ProdutoAtendimento pa: this.arrProdutoAtendimento)
        {
            resumo += "Produto:"+pa.getProduto().getNome()+" Quantidade:"+pa.getQuantidade()+" Valor:"+pa.getProduto().getValor()+"\n";
        }
        return resumo+="Valor Total:"+this.getValorTotal()+"\n======================================\n";
    }
}
