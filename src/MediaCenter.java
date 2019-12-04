import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Exceptions.ContaNaoExisteException;
import Exceptions.PassErradaException;

public class MediaCenter {

    /**
     *
     * Variáveis de instância
     */
    private Biblioteca biblioteca;
    private HashMap<String,Utilizador> utilizadores;
    private Administrador admin;

    public void logout() {
        // TODO - implement MediaCenter.logout
        throw new UnsupportedOperationException();
    }

    /**
     *
     * Construtores
     */
    public MediaCenter() {
        this.biblioteca = new Biblioteca();
        this.utilizadores = new HashMap<String,Utilizador>();
    }

    public MediaCenter(Biblioteca biblioteca,HashMap<String,Utilizador> utilizadores){
        this.biblioteca= biblioteca;
        this.utilizadores = utilizadores; //clone
    }

    public MediaCenter(MediaCenter outroMediaCenter) {
        this.biblioteca = outroMediaCenter.getBiblioteca();
        this.utilizadores = outroMediaCenter.getUtilizadores();
    }


    /**
     *
     * Getters e Setters
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public HashMap<String, Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(HashMap<String, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    //apenas o admin consegue criar conta
    public void criarConta(String email,String nome,String password,HashMap<Integer,Playlist> listaPlaylists){
        if(!utilizadores.containsKey(email)) {
            Utilizador u = new Utilizador(listaPlaylists, email, nome, password);
            utilizadores.put(email,u.clone());
        }
    }

    /**
     *apenas o admin consegue elimar conta
     * @param email
     */
    public void pretendeEliminar(String email) throws ContaNaoExisteException {
        if(utilizadores.containsKey(email)){
            utilizadores.remove(email);
        }
        else throw new ContaNaoExisteException("A conta inserida não existe no sistema");
    }


    /**
     *
     * @param email
     * @param nome
     * @param pass
     */
    public int validaRegisto(String email, String nome, String pass) throws ContaNaoExisteException,PassErradaException{
        int r=0;
        if(utilizadores.containsKey(email)){
            if(utilizadores.get(email).getPass().equals(pass)) r=1;
            else throw new PassErradaException("A password inserida não corresponde ao email de utilizador");
        }
        else throw new ContaNaoExisteException("A conta inserida não existe no sistema");
        return r;
    }


    /**
     *
     * @param m
     */
    public void updateMedia(Media m) {
        // TODO - implement MediaCenter.updateMedia
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param listaMedia
     */
    public void upload(List<Media> listaMedia) {
        // TODO - implement MediaCenter.upload
        throw new UnsupportedOperationException();
    }





    /**
     *
     * @param cat_name
     */
    public void categoriaMedia(String cat_name) {
        // TODO - implement MediaCenter.categoriaMedia
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param tipo_name
     */
    public int validaTipo(String tipo_name) {
        // TODO - implement MediaCenter.validaTipo
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param artista_name
     */
    public String artistaMedia(String artista_name) {
        // TODO - implement MediaCenter.artistaMedia
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param escolha
     */
    public void acedePlaylist(int escolha) {
        // TODO - implement MediaCenter.acedePlaylist
        throw new UnsupportedOperationException();
    }

    public void randomMedia() {
        // TODO - implement MediaCenter.randomMedia
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param cat_name
     */
    public String findCategoria(String cat_name) {
        // TODO - implement MediaCenter.findCategoria
        throw new UnsupportedOperationException();
    }

    public void entrarComoConvidado() {
        // TODO - implement MediaCenter.entrarComoConvidado
        throw new UnsupportedOperationException();
    }

    /**
     *
     * To String
     */
    @Override
    public String toString() {
        return "MediaCenter{" +
                "biblioteca=" + biblioteca +
                ", utilizadores=" + utilizadores +
                '}';
    }

    /**
     *
     * Clone
     */
    public MediaCenter clone() {
        return new MediaCenter(this);
    }

}