package DAO;


import BLogic.Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static DAO.Connect.connect;

public class BibliotecaDAO implements DAO<Biblioteca> {

    private Connection con;

    private BibliotecaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Biblioteca get(String id) {
        return null;
    }

    public Biblioteca get(int id){
        try {
            con = connect();
            if (con != null) {
                PreparedStatement pStm = con.prepareStatement("select * from Biblioteca where idBiblioteca=?");
                pStm.setInt(1, id);
                ResultSet rs = pStm.executeQuery();
                if (((ResultSet) rs).next()) {
                    return new Biblioteca(rs.getInt("idBiblioteca"), rs.getString("nome"));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            Connect.close((Connection) con);
        }

        return new Biblioteca();
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

