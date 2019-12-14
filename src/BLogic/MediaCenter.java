package BLogic;

import java.util.ArrayList;
import java.util.HashMap;

import Exceptions.ContaNaoExisteException;
import Exceptions.PassErradaException;
import Exceptions.MediaJaExisteException;

public class MediaCenter {

    /**
     *
     * Variáveis de instância
     */
    private Biblioteca biblioteca;
    private HashMap<String,Utilizador> utilizadores;
    private Administrador admin;

    public void logout() {
        // TODO - implement BLogic.MediaCenter.logout
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

    public MediaCenter(Biblioteca biblioteca, HashMap<String,Utilizador> utilizadores){
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



    /**
     *apenas o admin consegue elimar conta
     * @param email
     */


    /**
     * Elimina media para um determinado utilizador e se necessário da biblioteca
     */
    public void eliminaMedia(String idUtilizador, int idMusica ){
        if (utilizadores.containsKey(idUtilizador)) {
            utilizadores.get(idUtilizador).getListaMediaUtilizadores().remove(idMusica);
            int x=0;
            for(String a : utilizadores.keySet()){
                if(utilizadores.get(a).getListaMediaUtilizadores().containsKey(idMusica)) x++;
            }
            if(x==0) biblioteca.getListaMediaBiblioteca().remove(idMusica);
        }
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




    public void addMedia(int media, String artista,String utilizador) throws MediaJaExisteException{
        if( !(biblioteca.getListaMediaBiblioteca().containsKey(media)) ) {
            Media m = new Media(media,artista);
            biblioteca.getListaMediaBiblioteca().put(media,m);
            utilizadores.get(utilizador).getListaMediaUtilizadores().put(media,m);
        }
        else throw new MediaJaExisteException("A media já existe no sistema");
    }


    /**
     *
     * @param cat_name
     */
    public void categoriaMedia(String cat_name) {
        // TODO - implement BLogic.MediaCenter.categoriaMedia
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param tipo_name
     */
    public int validaTipo(String tipo_name) {
        // TODO - implement BLogic.MediaCenter.validaTipo
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param artista_name
     */
    public String artistaMedia(String artista_name) {
        // TODO - implement BLogic.MediaCenter.artistaMedia
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param escolha
     */
    public void acedePlaylist(int escolha) {
        // TODO - implement BLogic.MediaCenter.acedePlaylist
        throw new UnsupportedOperationException();
    }

    public void randomMedia() {
        // TODO - implement BLogic.MediaCenter.randomMedia
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param cat_name
     */
    public String findCategoria(String cat_name) {
        // TODO - implement BLogic.MediaCenter.findCategoria
        throw new UnsupportedOperationException();
    }

    public void entrarComoConvidado() {
        // TODO - implement BLogic.MediaCenter.entrarComoConvidado
        throw new UnsupportedOperationException();
    }

    /**
     *
     * To String
     */
    @Override
    public String toString() {
        return "BLogic.MediaCenter{" +
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