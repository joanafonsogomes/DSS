package DAO;

import BLogic.Utilizador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DAO.Connect.connect;

public class UtilizadorDAO implements DAO<Utilizador> {

    private Connection con;

    public UtilizadorDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Utilizador get(int id){
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Utilizador where email=?");
                pStm.setInt(1, id);
                ResultSet rs = pStm.executeQuery();
                if (rs.next()) {
                    return new Utilizador(rs.getString("nome"),rs.getString("email") ,rs.getString("pass"));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            Connect.close(con);
        }

        return new Utilizador();
    }

    public List<Utilizador> getAll () {
        List<Utilizador> users = new ArrayList<>();
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Utilizador");
                ResultSet rs = pStm.executeQuery();
                while(rs.next()) {
                    users.add(new Utilizador(rs.getString("nome"),rs.getString("email"),rs.getString("pass")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
        return users;
    }

    //cria um novo utilizador
    public void save (Utilizador user) {
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("insert into Utilizador(nome,email,pass) values (?,?,?) ");
                pStm.setString(1, user.getNome());
                pStm.setString(2, user.getEmail());
                pStm.setString(3, user.getPass());
                pStm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }

    }

    public void update (Utilizador user){

    }

    //elimina um utilizador
    public void delete (Utilizador user){
        try {
            con = Connect.connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("delete from Utilizador where email=?");
                pStm.setString(1,user.getEmail());
                pStm.execute();
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
    }
}

