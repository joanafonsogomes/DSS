package Exceptions;

public class ContaNaoExisteException extends Exception {

    public ContaNaoExisteException(String mario){
        super(mario);
    }
}
