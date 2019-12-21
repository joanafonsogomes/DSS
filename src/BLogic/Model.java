package BLogic;

import DAO.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {

    UtilizadorDAO userDAO=new UtilizadorDAO();
    BibliotecaDAO biblioDAO;
    AdministradorDAO adminDAO;
    PlaylistDAO playlistDAO;
    MediaDAO mediaDAO;
    HashMap<String,Utilizador> listu ;
    HashMap<Integer,Playlist> lPlaylist;

    public Model() {
        UtilizadorDAO userDAO = new UtilizadorDAO();
        listu= userDAO.getAll();

        BibliotecaDAO biblioDAO = new BibliotecaDAO();
        List<Biblioteca>lBilio=biblioDAO.getAll();

        AdministradorDAO adminDAO = new AdministradorDAO();
        List<Administrador>lAdmin= adminDAO.getAll();

        PlaylistDAO playlistDAO = new PlaylistDAO();
        lPlaylist =playlistDAO.getAll();

        MediaDAO mediaDAO = new MediaDAO();
        //List<Media> lMedia=mediaDAO.getAll();
    }

    public Utilizador getUser(String email){
        Utilizador u= listu.get(email);
        return u;
    }
    public Playlist getPlaylist(String email){
        System.out.print(email);
        Playlist ppp = userDAO.get("tiaravalley@gmail.com").getListaPlaylists().get(1);
        PlaylistDAO pd=new PlaylistDAO();
        Playlist c = pd.get(1);
//        System.out.println(ppp.getListaMediaPlaylist().size());
        return ppp;
    }
    public Utilizador entraUtilizador(String email, String pass) {

        if (listu.containsKey(email)){
           if(listu.get(email).getNome().equals(pass)) {
               Utilizador u= listu.get(email);
               return u;
           }
           else return null;
        }
        else return null;
    }

    public Playlist playlistRespetiva(String email, int playlist){
        Playlist nov = new Playlist();
        return null;
    }

    public String[] buscaPlaylist(String email){
        Utilizador u= listu.get(email);
        HashMap<Integer, Playlist> m= u.getListaPlaylists();
        String[] dev =  new String[m.size()];
        int j=0;
        for(Playlist p: m.values()){
            dev[j]=p.getNome();
            j++;
        }
        return dev;
    }

    public String[] buscaMedia(String email){
        Utilizador u= listu.get(email);
        HashMap<Integer, Media> m= u.getListaMediaUtilizadores();
        String[] dev =  new String[m.size()];
        int j=0;
        for(Media p: m.values()){
            dev[j]=p.getNome();
            j++;
        }
        return dev;
    }

    public void upload(Media s,String user){
        Utilizador u= userDAO.get(user);
        Media m = mediaDAO.get(s.getIdMedia());
        if(m!=null){
            Media newM = new Media(s,1);
            userDAO.saveMedia(m.getIdMedia(),user);
        }
        else if(!u.getListaMediaUtilizadores().containsKey(s.getIdMedia())) userDAO.saveMedia(m.getIdMedia(),user);
    }

    public void alteraCategoria(Integer media, String novCategoria, String email){
        Utilizador user = userDAO.get(email);
        Media med = mediaDAO.get(media);
        if(user.getListaMediaUtilizadores().containsKey(med.getIdMedia())) {
           Media inser = new Media(mediaDAO.size(),med.getNome(),novCategoria,med.getLink(),med.getArtista(),2);
           mediaDAO.save(med,2);
        }
    }



    public void reproduzir(Integer idmedia){
        Media media = mediaDAO.get(idmedia);
        //metodo de reprodução
    }





}

