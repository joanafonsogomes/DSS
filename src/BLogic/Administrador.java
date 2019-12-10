package BLogic;

import DAO.AdministradorDAO;
import DAO.UtilizadorDAO;
import Exceptions.ContaNaoExisteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
//ol
public class Administrador{

    private String email;
    private String password;
    private HashMap<String,Utilizador> utilizadores;

    public Administrador(){
        this.email="";
        this.password="";
        this.utilizadores = new HashMap<String, Utilizador>();
        (new AdministradorDAO()).save(this);
    }

    public Administrador(String email,String password,HashMap<String,Utilizador> utilizadores){
        this.email = email;
        this.password = password;
        this.utilizadores = utilizadores;
    }

    public void criarConta(String email, String nome, String password, HashMap<Integer, Playlist> listaPlaylists){
        if(!utilizadores.containsKey(email)) {
            Utilizador u = new Utilizador(listaPlaylists, email, nome, password);
            utilizadores.put(email,u.clone());
            (new UtilizadorDAO()).save(u);
        }
    }

    public void pretendeEliminar(String email) throws ContaNaoExisteException {
        if(utilizadores.containsKey(email)){
            Utilizador u = utilizadores.get(email);
            utilizadores.remove(email);
            (new UtilizadorDAO()).delete(u);
        }
        else throw new ContaNaoExisteException("A conta inserida não existe no sistema");
    }

    public Administrador(String email,String password){
        this.email = email;
        this.password = password;
        this.utilizadores = new HashMap<>();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(HashMap<String, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(utilizadores, that.utilizadores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, utilizadores);
    }
}
