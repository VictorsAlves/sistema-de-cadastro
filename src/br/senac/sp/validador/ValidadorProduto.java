package br.senac.sp.validador;

import br.senac.sp.exceptions.ProdutoException;
import br.senac.sp.entidades.Produto;

//Validador de dados do cliente
public class ValidadorProduto {

    public static void validar(Produto produto) throws ProdutoException {
        //Realização de validações de negócio
        if (produto == null) {
            throw new ProdutoException("Não foi informado um produto");
        }
        if (produto.getNome() == null || "".equals(produto.getNome())) {
            throw new ProdutoException("É necessário informar "
                    + "o nome do produto");
        }
        if (produto.getQuantidade() <= 0 || produto.getQuantidade() == 0) {
            throw new ProdutoException("É necessário informar uma "
                    + "quantidade a ser cadastrada do produto");
        }
        if (produto.getValor() <= 0 || produto.getValor() == 0) {
            throw new ProdutoException("É necessário informar o "
                    + "valor do produto");
        }
        if (produto.getCategoria() == null || "".equals(produto.getCategoria())                
                || (!produto.getCategoria().equals("Cama"))
                && (!produto.getCategoria().equals("Mesa"))
                && !produto.getCategoria().equals("Banho")) {
            throw new ProdutoException("É necessário informar a "
                    + "categoria do produto");
        }
        if (produto.getDescricao() == null || "".equals(produto.getDescricao())) {
            throw new ProdutoException("É necessário informar a "
                    + "descrição do produto");
        }
        if (produto.getComposicao() == null || "".equals(produto.getComposicao())) {
            throw new ProdutoException("É necessário informar a "
                    + "composição do produto");
        }
        if (produto.getMarca() == null || "".equals(produto.getMarca())) {
            throw new ProdutoException("É necessário informar a "
                    + "marca do produto");
        }
        if (produto.getTamanho() == null || "".equals(produto.getTamanho())){
                throw new ProdutoException("É necessário informar o "
                    + "tamanho do produto");
        }

    }
}
