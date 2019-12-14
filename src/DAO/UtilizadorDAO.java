package DAO;

import BLogic.Playlist;
import BLogic.Utilizador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

    public Utilizador get(String email){
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Utilizador where email=?");
                pStm.setString(1, email);
                ResultSet rs = pStm.executeQuery();
                Utilizador u;
                String user = null;
                String e = null;
                String pass = null;
                if (rs.next()) {
                    user = rs.getString("nome");
                    e = rs.getString("email");
                    pass= rs.getString("pass");
                }
                PreparedStatement pStm2 = con.prepareStatement("select * from Playlist where emailUtilizador=?");
                pStm2.setString(1, email);
                ResultSet rs2 = pStm2.executeQuery();
                HashMap<Integer, Playlist> map = new HashMap<>();
                while (rs2.next()){
                    int idPlayList = rs2.getInt("idPlaylist");
                    String nome = rs2.getString("nome");
                    Playlist p = new Playlist(idPlayList,nome);
                    map.put(idPlayList,p);
                 //   rs2.next();
                }
                return new Utilizador(map,user,e,pass);
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

    @Override
    public Utilizador get(int id) {
        return null;
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

    public static void main(String[] args) {
        Utilizador u = new Utilizador("Ana Margarida","mags@email.com","123");
        UtilizadorDAO d = new UtilizadorDAO();
        d.save(u);
        System.out.println("done");
    }
}

