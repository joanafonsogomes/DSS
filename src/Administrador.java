import java.util.HashMap;

public class Administrador extends Utilizador {

    public Administrador(){
        super();
    }

    public Administrador(HashMap<Integer,Playlist> listaPlaylists, String nome, String email, String pass){
        super(listaPlaylists,nome,email,pass);
    }

    public Administrador(Administrador a){
        super(a);
    }

}
