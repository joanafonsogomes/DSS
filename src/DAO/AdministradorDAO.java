package DAO;

import BLogic.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Administrador get(int id)
    {
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Administrador where email=?");
                pStm.setInt(1, id);
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

        return new Administrador();
    }

    public List<Administrador> getAll () {
        return null;
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

