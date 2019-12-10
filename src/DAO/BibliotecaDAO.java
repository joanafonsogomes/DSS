package DAO;


import BLogic.Biblioteca;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BibliotecaDAO implements DAO<Biblioteca> {

    private Connect con;

    private BibliotecaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Biblioteca get(int id){
        return null;
    }

    public List<Biblioteca> getAll () {
        return null;
    }
    //olao
    public void save (Biblioteca t) {

    }

    public void update (Biblioteca t){

    }
    public void delete (Biblioteca t){

    }
}

