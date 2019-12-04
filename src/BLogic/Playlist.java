package BLogic;

import Exceptions.MediaNaoExisteException;

import java.util.*;

public class Playlist {

    /**
     *
     * Variáveis de instância
     */
    private HashMap<String, Media> listaMediaPlaylist;
    private int idPlaylist;
    //private BLogic.Media atual;

    /**
     *
     * Construtores
     */
    public Playlist() {
        this.listaMediaPlaylist = new HashMap<String, Media>();
        this.idPlaylist = 0;
    }

    public Playlist(HashMap<String, Media> listaMediaPlaylist, int idPlaylist){
        this.listaMediaPlaylist= listaMediaPlaylist;
        this.idPlaylist = idPlaylist; //clone
    }

    public Playlist(Playlist outraPlaylist) {
        this.listaMediaPlaylist = outraPlaylist.getListaMediaPlaylist();
        this.idPlaylist = outraPlaylist.getIdPlaylist();
    }

    /**
     *
     * Getters e Setters
     */
    public HashMap<String, Media> getListaMediaPlaylist() {
        return listaMediaPlaylist;
    }

    public void setListaMediaPlaylist(HashMap<String, Media> listaMediaPlaylist) {
        this.listaMediaPlaylist = listaMediaPlaylist;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    /**
     *
     * @param idMedia
     */
    public Media findMedia(int idMedia) throws MediaNaoExisteException {
        if(listaMediaPlaylist.containsKey(idMedia)){
            return listaMediaPlaylist.get(idMedia);
        }
        else throw new MediaNaoExisteException("BLogic.Media não se encontra no sistema");
    }

    /**
     *
     * @param idMedia
     */
    public void remove(int idMedia) throws MediaNaoExisteException{
        if(listaMediaPlaylist.containsKey(idMedia)){
            listaMediaPlaylist.remove(idMedia);
        }
        throw new MediaNaoExisteException("BLogic.Media não se encontra no sistema");
    }

    /**
     *
     * To String
     */
    @Override
    public String toString() {
        return "BLogic.Playlist{" +
                "listaMediaPlaylist=" + listaMediaPlaylist +
                ", idPlaylist=" + idPlaylist +
                '}';
    }

    /**
     *
     * Clone
     */
    public Playlist clone() {
        return new Playlist(this);
    }
}