package BLogic;

import Exceptions.ArtistaNaoExisteException;
import Exceptions.CategoriaNaoExisteException;
import Exceptions.MediaNaoExisteException;

import java.util.*;

public class Biblioteca{

    /**
     *
     * Variáveis de instância
     */
    //private Collection<BLogic.Media> listaMediaBiblioteca;
    private HashMap<Integer,Media> listaMediaBiblioteca;
    private int idBiblioteca;
    private String nome;

    /**
     *
     * Construtores
     */
    public Biblioteca() {
        this.listaMediaBiblioteca = new HashMap<Integer, Media>();
    }

    public Biblioteca(HashMap<Integer,Media> listaMediaBiblioteca){
        this.listaMediaBiblioteca = listaMediaBiblioteca;
    }

    public Biblioteca(Biblioteca outraBiblioteca) {
    }

    public Biblioteca(int idBiblioteca, String nome,HashMap<Integer,Media> listaMediaBiblioteca) {
        this.idBiblioteca = idBiblioteca;
        this.nome = nome;
        this.listaMediaBiblioteca = listaMediaBiblioteca;
    }

    public Biblioteca(int idBiblioteca, String nome) {
        this.idBiblioteca = idBiblioteca;
        this.nome = nome;
    }

    /**
     *
     * Getters e Setters
     */
    public HashMap<Integer, Media> getListaMediaBiblioteca() {
        return listaMediaBiblioteca;
    }

    public void setListaMediaBiblioteca(HashMap<Integer, Media> listaMediaBiblioteca) {
        this.listaMediaBiblioteca = listaMediaBiblioteca;
    }

    public void adiciona(Media m){
        this.listaMediaBiblioteca.put(m.getIdMedia(),m.clone());
    }
    /**
     *
     * @param artista_nome
     */
    public Media getMediaPorArtista(String artista_nome) throws ArtistaNaoExisteException {
        for(Media m : listaMediaBiblioteca.values()){
            if(m.getArtista().equals(artista_nome))
                return m;
        }
        throw new ArtistaNaoExisteException("O Artista não existe no sistema");
    }

    /**
     *
     * @param cat_name
     */
    public Media getMediaPorCat(String cat_name) throws CategoriaNaoExisteException {
        for(Media m : listaMediaBiblioteca.values()){
            if(m.getCat().equals(cat_name))
                return m;
        }
        throw new CategoriaNaoExisteException("A categria não existe no sistema");
    }

    /**
     *
     * @param media_name
     */
    public Media findMedia(int media_name) throws MediaNaoExisteException {
            if(listaMediaBiblioteca.containsKey(media_name))
                return listaMediaBiblioteca.get(media_name);
            else throw new MediaNaoExisteException("BLogic.Media não existe no sistema");
    }

    /**
     *
     * @param media_name
     */
    public void removeMedia(int media_name) throws MediaNaoExisteException {
        if(listaMediaBiblioteca.containsKey(media_name)){
            listaMediaBiblioteca.remove(media_name);
        }
        else throw new MediaNaoExisteException("BLogic.Media não existe no sistema");
    }

    /**
     *
     * @param idMedia
     */
    //retorna 1 caso o conteudo já exita, 0 caso contrário
    public boolean verificaConteudo(int idMedia) {
        return (listaMediaBiblioteca.containsKey(idMedia));
    }

    /**
     *
     * @param m
     */
    public void updateMedia(Media m) throws MediaNaoExisteException {
        if(listaMediaBiblioteca.containsKey(m.getIdMedia())){
            listaMediaBiblioteca.put(m.getIdMedia(),m);
        }
        else throw new MediaNaoExisteException("BLogic.Media não existe no sistema");
    }

    public List<Media> makeTempL() {
        // TODO - implement BLogic.Biblioteca.makeTempL
        throw new UnsupportedOperationException();
    }

    /**
     *
     * To String
     */
    @Override
    public String toString() {
        return "BLogic.Biblioteca{" +
                "listaMediaBiblioteca=" + listaMediaBiblioteca +
                '}';
    }

    /**
     *
     * Clone
     */
    public Biblioteca clone() {
        return new Biblioteca(this);
    }

    public int getIdBiblioteca() {
        return this.idBiblioteca;
    }

    public String getNome() {
        return this.nome;
    }
}