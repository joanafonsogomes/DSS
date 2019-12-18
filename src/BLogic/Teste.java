package BLogic;

import DAO.*;

import java.util.HashMap;
import java.util.List;

public class Teste {

    public static void main(String[] str){
        UtilizadorDAO userDAO=new UtilizadorDAO();
        HashMap<String,Utilizador> listu =userDAO.getAll();


        BibliotecaDAO biblioDAO = new BibliotecaDAO();
        List<Biblioteca>lBilio=biblioDAO.getAll();

        AdministradorDAO adminDAO = new AdministradorDAO();
        List<Administrador>lAdmin= adminDAO.getAll();

        PlaylistDAO playlistDAO = new PlaylistDAO();
        List<Playlist> lPlaylist=playlistDAO.getAll();

        MediaDAO mediaDAO = new MediaDAO();
        List<Media> lMedia=mediaDAO.getAll();


        Utilizador u = userDAO.get("tiaravalley@gmail.com");
        System.out.println(u.getListaPlaylists().get(1).getNome());

        Playlist p = userDAO.get("tiaravalley@gmail.com").getListaPlaylists().get(1);
        System.out.println(p.getNome());
        }

    }


