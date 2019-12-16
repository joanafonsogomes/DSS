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

public class PlaylistDAO{

    private Connection con;

    public PlaylistDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Playlist get(int id){
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Playlist where idPlaylist=?");
                pStm.setInt(1, id);
                ResultSet rs = pStm.executeQuery();
                Playlist p;
                int idPlaylist = 0;
                String nomeP = null;
                if (rs.next()) {
                    idPlaylist=rs.getInt("idPlaylist");
                    nomeP = rs.getString("nome");
                }
                PreparedStatement pStm2 = con.prepareStatement("select m.idMedia, m.nome, m.cat,m.artista,m.link from Media m, Playlist_has_Media p where idPlaylist=? and idPlaylist=p.idPlaylist and p.idMedia = m.idMedia");
                pStm2.setInt(1, id);
                ResultSet rs2 = pStm2.executeQuery();
                HashMap<Integer, Media> map = new HashMap<>();
                while (rs2.next()) {
                    int idMedia = rs2.getInt("idMedia");
                    String nome = rs2.getString("nome");
                    String artista = rs2.getString("artista");
                    String cat = rs2.getString("cat");
                    String link = rs2.getString("link");
                    Media media = new Media(idMedia, nome, cat, link, artista);
                    map.put(idMedia, media);
                }
                return new Playlist(map, idPlaylist,nomeP);
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

    public void save (Playlist playlist,Utilizador u) {
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("insert into Playlist(idPlaylist,nome,emailUtilizador) values (?,?,?) ");
                pStm.setInt(1, playlist.getIdPlaylist());
                pStm.setString(2, playlist.getNome());
                pStm.setString(3, u.getEmail());
                pStm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
    }

    public int size() {
        try {
            con = connect();
            int i = 0;
            PreparedStatement pStm = con.prepareStatement("select idPlaylist FROM Playlist");
            ResultSet rs = pStm.executeQuery();
            for (;rs.next();i++);
            return i;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
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

