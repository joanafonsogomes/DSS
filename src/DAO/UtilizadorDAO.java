package DAO;
import BLogic.Utilizador;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.sql.*;
import java.sql.Statement;



public class UtilizadorDAO implements Map<String, Utilizador> {
    private static UtilizadorDAO inst=null;

    private UtilizadorDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public static UtilizadorDAO getInstance(){
        if(inst == null) {
            inst = new UtilizadorDAO();
        }
        return inst;
}


    public int size() {
        try {
            Connection conn = Connect.connect();
            int i = 0;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nome FROM TAlunos");
            for (; rs.next(); i++) ;
            return i;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public boolean isEmpty() {
        throw new NullPointerException("Not implemented!");
    }


    public boolean containsKey(Object o) {
        throw new NullPointerException("Not implemented!");
    }

    public boolean containsValue(Object o) {
        throw new NullPointerException("Not implemented!");
    }

    public Utilizador get(Object o) {
        throw new NullPointerException("Not implemented!");
    }

    public Utilizador put(String s, Utilizador utilizador) {
        throw new NullPointerException("Not implemented!");
    }

    public Utilizador remove(Object o) {
        throw new NullPointerException("Not implemented!");
}

    public void putAll(Map<? extends String, ? extends Utilizador> map) {
        throw new NullPointerException("Not implemented!");
    }

    public void clear() {
        throw new NullPointerException("Not implemented!");
    }

    public Set<String> keySet() {
        throw new NullPointerException("Not implemented!");
    }

    public Collection<Utilizador> values() {
        throw new NullPointerException("Not implemented!");
    }

    public Set<Entry<String, Utilizador>> entrySet() {
        throw new NullPointerException("Not implemented!");
    }
}
