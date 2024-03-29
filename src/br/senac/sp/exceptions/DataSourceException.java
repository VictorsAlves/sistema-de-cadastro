package br.senac.sp.exceptions;

//Indica uma exceção direta com a fonte de dados
public class DataSourceException extends Exception {

    //Construtor que permite informar uma mensagem de erro
    public DataSourceException(String message) {
        super(message);
    }

    //Construtor que permite informar uma mensagem de erro e uma exception base
    public DataSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    //Construtor que permite informar uma exception base
    public DataSourceException(Throwable cause) {
        super(cause);
    }
}
