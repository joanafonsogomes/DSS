package BLogic;

import DAO.*;
import net.sourceforge.jffmpeg.codecs.audio.vorbis.Mode;

import javax.print.attribute.HashDocAttributeSet;
import java.lang.management.PlatformLoggingMXBean;
import java.util.HashMap;
import java.util.List;

public class Teste {

    public static void main(String[] str){
        Model model=new Model();
        UtilizadorDAO userDAO=new UtilizadorDAO();
        HashMap<String,Utilizador> listu =userDAO.getAll();

        BibliotecaDAO biblioDAO = new BibliotecaDAO();
        List<Biblioteca>lBilio=biblioDAO.getAll();

        AdministradorDAO adminDAO = new AdministradorDAO();
        List<Administrador>lAdmin= adminDAO.getAll();

        PlaylistDAO playlistDAO = new PlaylistDAO();
        HashMap<Integer,Playlist> pp=playlistDAO.getAll();
        Playlist newp =playlistDAO.get(1);
        //System.out.println(newp.getListaMediaPlaylist().size());
        MediaDAO mediaDAO = new MediaDAO();
        List<Media> lMedia=mediaDAO.getAll();

        Media m = userDAO.get("tiaravalley@gmail.com").getListaPlaylists().get(1).getListaMediaPlaylist().get(2);
        //Utilizador u = userDAO.get("tiaravalley@gmail.com");

        //Playlist p = userDAO.get("tiaravalley@gmail.com").getListaPlaylists().get(1);
        //Playlist c = playlistDAO.get(1);
        Playlist p= model.getPlaylist("tiaravalley@gmail.com").get(0);
        int i =model.getPlaylist("coconutreplay@gmail.com").size();

        model.getPlaylist("coconutreplay@gmail.com").get(0).getNome();
        //System.out.println(i);
        }

    }


