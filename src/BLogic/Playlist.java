package BLogic;

import Exceptions.MediaNaoExisteException;

import java.util.*;

public class Playlist {

    /**
     *
     * Variáveis de instância
     */
    private HashMap<Integer, Media> listaMediaPlaylist;
    private int idPlaylist;
    private String nome;
    //private BLogic.Media atual;

    /**
     *
     * Construtores
     */
    public Playlist() {
        this.listaMediaPlaylist = new HashMap<Integer, Media>();
        this.idPlaylist = 0;
        this.nome="";
    }

    public Playlist(HashMap<Integer, Media> l, int idPlaylist, String nome){
        this.listaMediaPlaylist= l;
        this.idPlaylist = idPlaylist; //clone
        this.nome = nome;
    }

    public Playlist(Playlist outraPlaylist) {
        this.listaMediaPlaylist = outraPlaylist.getListaMediaPlaylist();
        this.idPlaylist = outraPlaylist.getIdPlaylist();
        this.nome = outraPlaylist.getNome();
    }

    public Playlist(int idPlaylist, String nome) {
        this.idPlaylist = idPlaylist;
        this.nome = nome;
    }

    /**
     *
     * Getters e Setters
     */
    public HashMap<Integer, Media> getListaMediaPlaylist() {
        return listaMediaPlaylist;
    }

    public void setListaMediaPlaylist(HashMap<Integer, Media> listaMediaPlaylist) {
        this.listaMediaPlaylist = listaMediaPlaylist;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "Playlist{" +
                "listaMediaPlaylist=" + listaMediaPlaylist +
                ", idPlaylist=" + idPlaylist +
                ", nome='" + nome + '\'' +
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