package BLogic;

import Exceptions.MediaNaoExisteException;
import Exceptions.PlaylistNaoExisteException;

import java.util.HashMap;
import java.util.List;

public class Utilizador {

    /**
     *
     * Variáveis de instância
     */
    private HashMap<Integer, Playlist> listaPlaylists;
    private String nome;
    private String email;
    private String pass;
    private HashMap<String, Media> listaMediaUtilizadores;

    /**
     *
     * Construtores
     * @param listaPlaylists
     * @param email
     * @param nome
     * @param password
     */
    public Utilizador(HashMap<Integer, Playlist> listaPlaylists, String email, String nome, String password) {
        this.listaPlaylists = new HashMap<Integer, Playlist>();
        this.nome = "";
        this.email = "";
        this.pass = "";
        this.listaMediaUtilizadores = new HashMap<String, Media>();
    }

    public Utilizador(HashMap<Integer, Playlist> listaPlaylists, String nome, String email, String pass, HashMap<String, Media>listaMediaUtilizadores){
        this.listaPlaylists= listaPlaylists;
        this.nome = nome;
        this.email = email;
        this.pass = pass;
        this.listaMediaUtilizadores = listaMediaUtilizadores;
    }

    public Utilizador(Utilizador outroUtilizador) {
        this.listaPlaylists = outroUtilizador.getListaPlaylists();
        this.nome = outroUtilizador.getNome();
        this.email = outroUtilizador.getEmail();
        this.pass = outroUtilizador.getPass();
        this.listaMediaUtilizadores = outroUtilizador.getListaMediaUtilizadores();
    }

    /**
     *
     * Getters e Setters
     */
    public HashMap<Integer, Playlist> getListaPlaylists() {
        return listaPlaylists;
    }

    public void setListaPlaylists(HashMap<Integer, Playlist> listaPlaylists) {
        this.listaPlaylists = listaPlaylists;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public HashMap<String, Media> getListaMediaUtilizadores() {
        return listaMediaUtilizadores;
    }

    public void setListaMediaUtilizadores(HashMap<String, Media> listaMediaUtilizadores) {
        this.listaMediaUtilizadores = listaMediaUtilizadores;
    }

    /**
     *
     * @param id_playlist
     * @param idMedia
     */

    //retorna um 1 se existir 0 se não
    public Playlist buscaPlaylist(int id_playlist, int idMedia) throws PlaylistNaoExisteException {
        if(listaPlaylists.containsKey(id_playlist)){
            return listaPlaylists.get(id_playlist);
        }
        else throw new PlaylistNaoExisteException("A BLogic.Playlist não existe no sistema");
    }


    /**
     *
     * @param lm
     */
    public void addPlaylist(List<Media> lm) {
        Playlist p = new Playlist();
            for (Media m : lm) {
                p.getListaMediaPlaylist().put(m.getIdMedia(), m.clone());
            }
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param cat_name
     */
    public void alterarCat(int idMedia,String cat_name) throws MediaNaoExisteException {

    }

    /**
     *
     * To String
     */
    @Override
    public String toString(
) {
        return "BLogic.Utilizador{" +
                "listaPlaylists=" + listaPlaylists +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    /**
     *
     * Clone
     */
    public Utilizador clone() {
        return new Utilizador(this);
    }



}