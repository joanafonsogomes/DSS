import java.util.Objects;

public class Media {

    /**
     *
     * Variáveis de instância
     */
    private String idMedia;
    private String cat;
    private Reprodutor rep;
    //para um primeiro teste:
    private String link;
    private String artista;

    /**
     *
     * Construtores
     */
    public Media(String idMedia, String artista) {
        this.idMedia = idMedia;
        this.cat = "";
        this.rep = new Reprodutor();
        this.link = "";
        this.artista = artista;
    }

    public Media(String idMedia ,String cat,Reprodutor rep, String link, String artista){
        this.idMedia= idMedia;
        this.cat= cat; //clone
        this.rep= rep; //clone
        this.link = link;
        this.artista = artista;
    }

    public Media(Media outraMedia) {
        this.idMedia = outraMedia.getIdMedia();
        this.cat = outraMedia.getCat();
        this.rep = outraMedia.getRep();
        this.link = outraMedia.getLink();
        this.artista = outraMedia.getArtista();
    }

    /**
     *
     * Getters e Setters
     */
    public String getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(String idMedia) {
        this.idMedia = idMedia;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Reprodutor getRep() {
        return rep;
    }

    public void setRep(Reprodutor rep) {
        this.rep = rep;
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
        return idMedia == media.idMedia &&
                Objects.equals(cat, media.cat) &&
                Objects.equals(rep, media.rep) &&
                Objects.equals(link, media.link) &&
                Objects.equals(artista, media.artista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedia, cat, rep, link, artista);
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
                ", cat='" + cat + '\'' +
                ", rep=" + rep +
                ", link='" + link + '\'' +
                '}';
    }

    /**
     *
     * Clone
     */
    public Media clone() {
        return new Media(this);
    }

}