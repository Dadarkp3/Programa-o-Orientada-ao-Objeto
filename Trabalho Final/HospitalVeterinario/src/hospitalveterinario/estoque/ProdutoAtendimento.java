/*
 * Essa classe linka o produto a uma certa quantidade que será usado no Atendimento;
 */
package hospitalveterinario.estoque;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */
public class ProdutoAtendimento {
    private Produto produto;
    private int quantidade;

    public ProdutoAtendimento(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
}
