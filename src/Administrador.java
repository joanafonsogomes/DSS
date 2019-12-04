import java.util.ArrayList;
import java.util.Objects;

public class Administrador{

    private String email;
    private String password;
    private ArrayList<Utilizador> utilizadores;

    public Administrador(){
        this.email="";
        this.password="";
        this.utilizadores = new ArrayList<Utilizador>();
    }

    public Administrador(String email,String password,ArrayList<Utilizador> utilizadores){
        this.email = email;
        this.password = password;
        this.utilizadores = utilizadores;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(ArrayList<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(utilizadores, that.utilizadores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, utilizadores);
    }
}
