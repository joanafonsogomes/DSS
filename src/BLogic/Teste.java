package BLogic;

import DAO.MediaDAO;
import DAO.UtilizadorDAO;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        Model m = new Model();
        UtilizadorDAO u = new UtilizadorDAO();
        List<Utilizador> l = u.getAll();
        System.out.println(l.size());
    }
}
