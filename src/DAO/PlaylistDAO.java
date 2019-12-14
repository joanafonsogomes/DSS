package DAO;


import BLogic.Administrador;
import BLogic.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static DAO.Connect.connect;

public class PlaylistDAO implements DAO<Playlist> {

    private Connection con;

    private PlaylistDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Playlist get(String id) {
        return null;
    }

    public Playlist get(int id){
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Playlist where emailUtilizador=?");
                pStm.setInt(1, id);
                ResultSet rs = pStm.executeQuery();
                if (rs.next()) {
                    return new Playlist(rs.getInt("idPlaylist"),rs.getString("nome"));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            Connect.close(con);
        }

        return new Playlist();
    }

    public List<Playlist> getAll () {
        List<Playlist> playlists = new ArrayList<>();
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Playlist");
                ResultSet rs = pStm.executeQuery();
                while(rs.next()) {
                    playlists.add(new Playlist(rs.getInt("idPlaylist"),rs.getString("nome")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
        return playlists;
    }

    public void save (Playlist playlist) {
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("insert into Playlist(idPlaylist,nome) values (?,?,?) ");
                pStm.setInt(1, playlist.getIdPlaylist());
                pStm.setString(2, playlist.getNome());
                pStm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
    }

    public void update (Playlist t){

    }
    public void delete (Playlist playlist){
        try {
            con = Connect.connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("delete from Playlist where idPlaylist=?");
                pStm.setInt(1,playlist.getIdPlaylist());
                pStm.execute();
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
    }
}

