package BLogic;

import DAO.MediaDAO;
import DAO.UtilizadorDAO;

import java.util.Objects;

public class Media {

    /**
     *
     * Variáveis de instância
     */
    private int idMedia;
    private String nome;
    private String cat;
    private String link;
    private String artista;
    private int biblioteca;


    /**
     *
     * Construtores
     */
    public Media(){
        this.idMedia = 0;
        this.nome = "n/a";
        this.artista = "n/a";
        this.cat = "n/a";
        this.link = "n/a";


    }

    public Media(int idMedia, String artista) {
        this.idMedia = idMedia++;
        this.nome = "";
        this.cat = "";
        this.link = "";
        this.artista = artista;
    }

    public Media(int idMedia,String nome ,String cat,String link, String artista,int b){
        this.idMedia = idMedia;
        this.nome= nome;
        this.cat= cat; //clone
        this.link = link;
        this.artista = artista;
        this.biblioteca=b;
        //(new MediaDAO()).save(this,b);
    }

    public Media(Media outraMedia,int b) {
        this.idMedia = outraMedia.getIdMedia();
        this.nome = outraMedia.getNome();
        this.cat = outraMedia.getCat();
        this.link = outraMedia.getLink();
        this.artista = outraMedia.getArtista();
        //(new MediaDAO()).save(this,b);
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    /**
     *
     * Getters e Setters
     */


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return nome == media.nome &&
                Objects.equals(cat, media.cat) &&
                Objects.equals(link, media.link) &&
                Objects.equals(artista, media.artista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cat,link, artista);
    }

    /**
     *
     * @param artista_name
     */
    public boolean comparaArtista(String artista_name) {
        return (this.artista.equals(artista_name));
    }

    /**
     *
     * @param cat_name
     */
    public boolean comparaCategoria(String cat_name) {
        return (this.artista.equals(cat_name));
    }

    /**
     *
     * To String
     */
    @Override
    public String toString() {
        return "Media{" +
                "idMedia=" + idMedia +
                ", nome='" + nome + '\'' +
                ", cat='" + cat + '\'' +
                ", link='" + link + '\'' +
                ", artista='" + artista + '\'' +
                '}';
    }

    /**
     *
     * Clone
     */
   public Media clone() { return new Media(this,1); }

}