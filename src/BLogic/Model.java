package BLogic;

import DAO.*;

import java.util.HashMap;
import java.util.Map;

public class Model {

    UtilizadorDAO userDAO;
    BibliotecaDAO biblioDAO;
    AdministradorDAO adminDAO;
    PlaylistDAO playlistDAO;
    MediaDAO mediaDAO;

    public Model() {
        UtilizadorDAO userDAO = new UtilizadorDAO();
        userDAO.getAll();
        BibliotecaDAO biblioDAO = new BibliotecaDAO();
        biblioDAO.getAll();
        AdministradorDAO adminDAO = new AdministradorDAO();
        adminDAO.getAll();
        PlaylistDAO playlistDAO = new PlaylistDAO();
        playlistDAO.getAll();
        MediaDAO mediaDAO = new MediaDAO();
        mediaDAO.getAll();
    }

    public Utilizador entraUtilizador(String email, String pass) {
        Utilizador u = userDAO.get(email);
        if (u != null && u.getPass().equals(pass)) {
            return u;
        } else return null;
    }

    public void upload(Media s){
        Media m = mediaDAO.get(s.getIdMedia());
        if(m!=null && !(s.equals(m.getIdMedia()))){
            mediaDAO.save(s);
        }
    }




}

