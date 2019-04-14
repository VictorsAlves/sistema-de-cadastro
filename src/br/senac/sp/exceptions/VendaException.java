package br.senac.sp.exceptions;

//Indica uma exceção de venda
public class VendaException extends Exception{
    
    //Construtor de exceções que permite informar uma mensagem  qualquer
    public VendaException(String message) {
        super(message);
    }
}
