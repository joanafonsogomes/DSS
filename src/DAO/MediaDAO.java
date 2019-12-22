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

public class MediaDAO {

    private Connection con;

    public MediaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Media get(int id,String email) {
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select m.idMedia, m.nome, u.cat,m.artista,m.link,m.biblioteca from Media m, Utilizador_has_Media u,utilizador ut  where m.idMedia=? and ut.email=? and u.idMedia = m.idMedia and u.email=ut.email");
                pStm.setInt(1, id);
                pStm.setString(2,email);
                ResultSet rs = pStm.executeQuery();
                int idMedia = 0;
                String nome = null;
                String cat = null;
                String link = null;
                String artista = null;
                int biblioteca = 0;
                if (rs.next()) {
                    idMedia = rs.getInt("idMedia");
                    nome = rs.getString("nome");
                    cat = rs.getString("cat");
                    link = rs.getString("nome");
                    artista = rs.getString("artista");
                    biblioteca = rs.getInt("biblioteca");
                }
                return new Media(idMedia, nome, cat, link, artista, biblioteca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }

        return null;
    }
    public Media getNome(String nome) {
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select m.idMedia, m.nome, u.cat,m.artista,m.link ,m.biblioteca from Media m, Utilizador_has_Media u where m.idMedia=u.idMedia and m.nome=? and u.idMedia = m.idMedia");
                pStm.setString(1,nome);
                ResultSet rs = pStm.executeQuery();
                int idMedia = 0;
                String nomeM = null;
                String cat = null;
                String link = null;
                String artista = null;
                int biblioteca = 0;
                if (rs.next()) {
                    idMedia = rs.getInt("idMedia");
                    nomeM = rs.getString("nome");
                    cat = rs.getString("cat");
                    link = rs.getString("nome");
                    artista = rs.getString("artista");
                    biblioteca = rs.getInt("biblioteca");
                }
                return new Media(idMedia, nomeM, cat, link, artista, biblioteca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }

        return null;
    }

    public List<Media> getAll() {
        List<Media> medias = new ArrayList<>();
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from media");
                ResultSet rs = pStm.executeQuery();
                while (rs.next()) {
                    medias.add(new Media(rs.getInt("idMedia"), rs.getString("nome"), rs.getString("link"), rs.getString("artista"), rs.getInt("biblioteca")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
        return medias;
    }


    public void save(Media t, int b) {
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("insert into Media(idMedia,nome,link,artista,biblioteca) values (?,?,?,?,?,?) ");
                pStm.setInt(1, t.getIdMedia());
                pStm.setString(2, t.getNome());
                pStm.setString(3, t.getLink());
                pStm.setString(4, t.getArtista());
                pStm.setInt(5, b);
                pStm.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
    }

    public void saveOne(String em,int i, String catss) {
        try {

            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("insert into Utilizador_has_Media(email,idMedia,cat) values (?,?,?) ");
                pStm.setString(1, em);
                pStm.setInt(2, i);
                pStm.setString(3, catss);
                pStm.execute();
            }
        }catch(SQLException e)
    {
        e.printStackTrace();
    } finally

    {
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

    /*
    public static void main(String[] args) {
        MediaDAO m = new MediaDAO();
        m.saveOne("coconutreplay@gmail.com",10,"Keep");
        System.out.println("done");
    }

     */

}

