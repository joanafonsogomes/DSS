package DAO;


import BLogic.Utilizador;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UtilizadorDAO implements DAO<Utilizador> {

    private Connect con;

    private UtilizadorDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Utilizador get(int id){
        return null;
    }

    public List<Utilizador> getAll () {
        return null;
    }
    //olao
    public void save (Utilizador t) {

    }

    public void update (Utilizador t){

    }
    public void delete (Utilizador t){

    }
}

