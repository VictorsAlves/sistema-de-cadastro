package br.senac.sp.exceptions;

//Indica uma exceção de cliente
public class ClienteException extends Exception {

    //Construtor de exceções que permite informar uma mensagem  qualquer
    public ClienteException(String message) {
        super(message);
    }

}
