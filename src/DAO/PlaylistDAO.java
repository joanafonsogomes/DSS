package DAO;


import BLogic.Playlist;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlaylistDAO implements DAO<Playlist> {

    private Connect con;

    private PlaylistDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Playlist get(int id){
        return null;
    }

    public List<Playlist> getAll () {
        return null;
    }
    //olao
    public void save (Playlist t) {

    }

    public void update (Playlist t){

    }
    public void delete (Playlist t){

    }
}

