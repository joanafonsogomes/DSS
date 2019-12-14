package DAO;


import BLogic.Media;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static DAO.Connect.connect;

public class MediaDAO implements DAO<Media> {

    private Connection con;

    private MediaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Media get(String id) {
        return null;
    }

    public Media get(int id){
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Media where nome=?");
                pStm.setInt(1, id);
                ResultSet rs = pStm.executeQuery();
                if (rs.next()) {
                    //return new Media(rs.getString("nome"),rs.getString("email") ,rs.getString("pass"));
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

