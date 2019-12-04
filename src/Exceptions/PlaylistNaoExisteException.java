package Exceptions;

public class PlaylistNaoExisteException extends Exception {

    public PlaylistNaoExisteException(String mario){
        super(mario);
    }

}
