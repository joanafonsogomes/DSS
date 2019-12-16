package DAO;

import BLogic.Media;
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
                PreparedStatement pStm3 = con.prepareStatement("select m.idMedia, m.nome, m.cat,m.artista,m.link from Media m, Utilizador_has_Media u where email=? and u.email=email and u.idMedia=m.idMedia");
                pStm3.setString(1,email);
                ResultSet rs3 = pStm3.executeQuery();
                HashMap<Integer, Media> map2 = new HashMap<>();
                while (rs3.next()) {
                    int idMedia = rs3.getInt("idMedia");
                    String nome = rs3.getString("nome");
                    String artista = rs3.getString("artista");
                    String cat = rs3.getString("cat");
                    String link = rs3.getString("link");
                    Media media = new Media(idMedia, nome, cat, link, artista);
                    map2.put(idMedia, media);
                }
                return new Utilizador(map,user,e,pass,map2);
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
        UtilizadorDAO d = new UtilizadorDAO();
        Utilizador u = new Utilizador("nome", "email", "pass");
        d.save(u);
    }

}

