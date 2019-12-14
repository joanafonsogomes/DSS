package DAO;

import BLogic.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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

    public Administrador get(String id)
    {
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Administrador where email=?");
                pStm.setString(1, id);
                ResultSet rs = pStm.executeQuery();
                if (rs.next()) {
                    return new Administrador(rs.getString("email"), rs.getString("pass"));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
                    Connect.close(con);
                }

        return null;
    }

    @Override
    public Administrador get(int id) {
        return null;
    }

    public List<Administrador> getAll () {
        List<Administrador> administradors = new ArrayList<>();
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Administrador");
                ResultSet rs = pStm.executeQuery();
                while(rs.next()) {
                    administradors.add(new Administrador(rs.getString("email"),rs.getString("pass")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
        return administradors;
    }

    //cria um administrador novo
    public void save (Administrador t) {

    }

    //atualiza valores
    public void update (Administrador t){

    }

    //elimina administrador
    public void delete (Administrador t){

    }
}

