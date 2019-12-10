package DAO;


import BLogic.Media;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MediaDAO implements DAO<Media> {

    private Connect con;

    private MediaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Media get(int id){
        return null;
    }

    public List<Media> getAll () {
        return null;
    }
    //olao
    public void save (Media t) {

    }

    public void update (Media t){

    }
    public void delete (Media t){

    }
}

