package DAO;

import BLogic.Administrador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static DAO.Connect.connect;

public class AdministradorDAO implements DAO<Administrador> {

    private Connection con;

    public AdministradorDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }


    public Administrador get(int id){
            try {
                con=connect();
                if(con!=null){
                    System.out.println("já deu!!!!!");
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
            return null;


    }


    public List<Administrador> getAll () {
        return null;
    }
//olao
    public void save (Administrador t) {

    }

    public void update (Administrador t){

    }
    public void delete (Administrador t){

    }
}

