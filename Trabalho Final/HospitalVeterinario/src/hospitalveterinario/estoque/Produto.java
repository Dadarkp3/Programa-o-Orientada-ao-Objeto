/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalveterinario.estoque;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Daiane Silva e João Felipe Freitas
 */
public class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    
    

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static boolean validarProduto(ArrayList<Produto> arrProduto, String nome)
    {
        boolean resposta = false;
        for(Produto p : arrProduto)
        {
            resposta = p.getNome().equals(nome);
        }
        if(resposta == true)
            JOptionPane.showMessageDialog(null,"Produto já cadastrado.");
        return resposta;
    }
    
    public static String listarProdutos(ArrayList<Estoque> arrEstoque)
    {
        int i = 1;
        String lista = "----Lista de Produtos ----";
        for(Estoque e : arrEstoque)
        {
            lista+="\n"+i+". Nome:"+e.getProduto().getNome()+" | Quantidade: "+e.getQuantidade()+" | Valor: R$"+e.getProduto().getValor();
            i++;
        }
        return lista;
    }
}
