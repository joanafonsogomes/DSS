package DAO;


import BLogic.Biblioteca;
import BLogic.Media;
import BLogic.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static DAO.Connect.connect;

public class MediaDAO{

    private Connection con;

    public MediaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Media get(int id){
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Media where idMedia=?");
                pStm.setInt(1, id);
                ResultSet rs = pStm.executeQuery();
                int idMedia=0;
                String nome=null;
                String cat=null;
                String link=null;
                String artista=null;
                int biblioteca=0;
                if (rs.next()) {
                    idMedia = rs.getInt("idMedia");
                    nome = rs.getString("nome");
                    cat = rs.getString("cat");
                    link = rs.getString("nome");
                    artista = rs.getString("artista");
                    biblioteca=rs.getInt("biblioteca");
                }
                return new Media(idMedia,nome,cat,link,artista,biblioteca);
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
        List<Media> medias = new ArrayList<>();
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Media");
                ResultSet rs = pStm.executeQuery();
                while(rs.next()) {
                    medias.add(new Media(rs.getInt("idMedia"),rs.getString("nome"),rs.getString("cat"),rs.getString("link"),rs.getString("artista"),rs.getInt("biblioteca")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
        return medias;
    }


    public void save (Media t,int b) {
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("insert into Media(idMedia,nome,artista,cat,biblioteca,link) values (?,?,?,?,?,?) ");
                pStm.setInt(1, t.getIdMedia());
                pStm.setString(2, t.getNome());
                pStm.setString(3, t.getArtista());
                pStm.setString(4, t.getCat());
                pStm.setInt(5, b);
                pStm.setString(6, t.getLink());
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
            PreparedStatement pStm = con.prepareStatement("select idMedia FROM Media");
            ResultSet rs = pStm.executeQuery();
            for (;rs.next();i++);
            return i;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    public void update (Media t){

    }
    public void delete (Media t){
        try {
            con = Connect.connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("delete from Media where idMedia=?");
                pStm.setInt(1,t.getIdMedia());
                pStm.execute();
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
    }

}

