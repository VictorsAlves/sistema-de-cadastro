package br.senac.sp.exceptions;

//Indica uma exceção de produto
public class ProdutoException extends Exception {

    //Construtor de exceções que permite informar uma mensagem  
    public ProdutoException(String message) {
        super(message);
    }

}
