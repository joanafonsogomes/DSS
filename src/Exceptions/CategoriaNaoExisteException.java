package Exceptions;

public class CategoriaNaoExisteException extends Exception{

    public CategoriaNaoExisteException(String mario){
        super(mario);
    }
}
