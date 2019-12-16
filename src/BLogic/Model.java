package BLogic;

import DAO.*;

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
/*
    public void upload(Media s){
        Media m = mediaDAO.get(s.getIdMedia());
        if(m!=null && !(s.equals(m.getIdMedia()))){
            mediaDAO.save(s);
        }
    }*/

    public void alteraCategoria(Integer media, String novCategoria, String email){
        Utilizador user = userDAO.get(email);
        Media med = mediaDAO.get(media);
        if(user.getListaMediaUtilizadores().containsKey(med.getIdMedia())) {
           Media inser = new Media(mediaDAO.size(),med.getNome(),novCategoria,med.getLink(),med.getArtista());
           Biblioteca a = biblioDAO.get(2);
           mediaDAO.save(med,a);
        }
    }



    public void reproduzir(Integer idmedia){
        Media media = mediaDAO.get(idmedia);
        //metodo de reprodução
    }






}

