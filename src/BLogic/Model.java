package BLogic;

import DAO.*;

import javax.swing.*;
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
    public HashMap<Integer, Playlist> getPlaylist(String email) {
        HashMap<Integer, Playlist> lp = new HashMap<>();
        HashMap<Integer, Playlist> ppp = userDAO.get(email).getListaPlaylists();
        int j = 0;
        for(Playlist p: ppp.values()){
            int i = 0;
            HashMap<Integer, Media> newM = new HashMap<>();
                for (Media m : p.getListaMediaPlaylist().values()) {
                    newM.put(i, m);
                    System.out.println(i);
                    i++;
                }
            p.setListaMediaPlaylist(newM);
            lp.put(j,p);
            j++;
        }
        for(int p : lp.keySet()){
            for(int m : lp.get(p).getListaMediaPlaylist().keySet() ){
                System.out.println( p+ " "+ m+" "+lp.get(p).getListaMediaPlaylist().get(m).getNome());
            }
        }
        return lp;
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

    public void upload(Media s,String user,String cat){
        Utilizador u= userDAO.get(user);
        Media m = mediaDAO.get(s.getIdMedia(),user);
        if(m!=null){
            Media newM = new Media(s,1);
            mediaDAO.saveOne(user,m.getIdMedia(),cat);
        }
        else if( !u.getListaMediaUtilizadores().containsKey(s.getIdMedia()) ) mediaDAO.saveOne(user,m.getIdMedia(),cat);
    }
    public Playlist getPlayl (String email, int pos){
        return null;

    }

    public void alteraCategoria(String media, String novCategoria, String email){
        MediaDAO m=new MediaDAO();
        Media n=m.getNome(media);
        MediaDAO m2=new MediaDAO();
        Media mt = m2.get(n.getIdMedia(),email);
        if(userDAO.get(email).getListaMediaUtilizadores().containsKey(mt.getIdMedia())) {
           userDAO.alteraCategoria(n.getIdMedia(),email,novCategoria);
        }
    }




    }







