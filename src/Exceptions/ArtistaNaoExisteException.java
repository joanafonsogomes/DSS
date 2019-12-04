package Exceptions;

public class ArtistaNaoExisteException extends Exception {

    public ArtistaNaoExisteException(String mario){
        super(mario);
    }
}
