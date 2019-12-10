package DAO;

import BLogic.Administrador;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdministradorDAO implements DAO<Administrador> {

    private Connect con;

    private AdministradorDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Administrador get(int id){
        return null;
    }

    public List<Administrador> getAll () {
        return null;
    }
//ola
    public void save (Administrador t) {

    }

    public void update (Administrador t){

    }
    public void delete (Administrador t){

    }
}

