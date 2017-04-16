/*
 * Estoque de todos os produtos do Hospital Veterinario e suas respectivas quantidades;
 */
package hospitalveterinario.estoque;

import java.util.ArrayList;

/**
 *
 * @author Daiane Silva e João Felipe Freitas
 */

public class Estoque {

    public static String listarProdutos(ArrayList<Estoque> arrEstoque) {
        String produto = "Lista de Produtos\n";
        int i = 1;
        for(Estoque e : arrEstoque)
        {
            produto += "\n"+i+". "+e.getProduto().getNome()+"| Quantidade Disponível: "+e.getQuantidade()+" | Valor: R$"+e.getProduto().getValor();
            i++;
        }
        return produto;
    }
    private Produto produto;
    static private int quantidade;

    public Estoque(Produto produto, int quantidade) {
        this.produto = produto;
        Estoque.quantidade = quantidade;
    }
    
    public Estoque(Produto produto)
    {
        this.produto = produto;
        Estoque.quantidade = 0;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        Estoque.quantidade = quantidade;
    }
}


