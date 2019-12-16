package DAO;


import BLogic.Biblioteca;
import BLogic.Media;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static DAO.Connect.connect;

public class BibliotecaDAO{

    private Connection con;

    public BibliotecaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public Biblioteca get(int id){
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Biblioteca where idBiblioteca=?");
                pStm.setInt(1, id);
                ResultSet rs = pStm.executeQuery();
                int idBiblioteca = 0;
                String nomeB = null;
                if (rs.next()) {
                    idBiblioteca=rs.getInt("idBiblioteca");
                    nomeB = rs.getString("nome");
                }
                PreparedStatement pStm3 = con.prepareStatement("select m.idMedia, m.nome, m.cat,m.artista,m.link from Media m where idBiblioteca=? and idBiblioteca=m.biblioteca");
                pStm3.setInt(1,id);
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
                return new Biblioteca(idBiblioteca,nomeB,map2);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            Connect.close((Connection) con);
        }

        return null;
    }

    public List<Biblioteca> getAll () {
        List<Biblioteca> bib = new ArrayList<>();
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Biblioteca");
                ResultSet rs = pStm.executeQuery();
                while(rs.next()) {
                    bib.add(new Biblioteca(rs.getInt("idBiblioteca"),rs.getString("nome")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
        return bib;
    }

    public void save (Biblioteca bib) {
        try {
            con = connect();
            if(con != null) {
                PreparedStatement pStm = con.prepareStatement("insert into Biblioteca(idBiblioteca,nome) values (?,?) ");
                pStm.setInt(1, bib.getIdBiblioteca());
                pStm.setString(2, bib.getNome());
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
            PreparedStatement pStm = con.prepareStatement("select idBiblioteca FROM Biblioteca");
            ResultSet rs = pStm.executeQuery();
            for (;rs.next();i++);
            return i;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public void update (Biblioteca bib){

    }
    public void delete (Biblioteca bib){
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("delete from Biblioteca where idBiblioteca=?");
                pStm.setInt(1,bib.getIdBiblioteca());
                pStm.execute();
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            Connect.close(con);
        }
    }

}

