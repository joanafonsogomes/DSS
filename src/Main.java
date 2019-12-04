import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Main {
    private JPanel panelMain;
    private JButton button_msg;
    private JLabel title;

    public Main() {
       /*
        BLogic.Media m0 = new BLogic.Media();
        m0.setIdMedia(0);
        m0.setLink("seeYouAgain.wav");
        BLogic.Media m1 = new BLogic.Media();
        m1.setIdMedia(1);
        m1.setLink("zombie.wav");
        BLogic.Media m2 = new BLogic.Media();
        m2.setIdMedia(2);
        m2.setLink("useSomebody.wav");

        BLogic.Biblioteca biblioteca = new BLogic.Biblioteca();
        HashMap<Integer,BLogic.Media> biblio = new HashMap<Integer,BLogic.Media>();
        biblio.put(0,m0);
        biblio.put(1,m1);
        biblio.put(2,m2);
        biblioteca.setListaMediaBiblioteca(biblio);

        BLogic.Playlist playlist1 = new BLogic.Playlist();
        HashMap<Integer,BLogic.Media> pl1 = playlist1.getListaMediaPlaylist();
        pl1.put(0,m0);
        pl1.put(1,m1);
        playlist1.setListaMediaPlaylist(pl1);

        BLogic.Playlist playlist2 = new BLogic.Playlist();
        HashMap<Integer,BLogic.Media> pl2 = playlist1.getListaMediaPlaylist();
        pl2.put(2,m2);
        playlist2.setListaMediaPlaylist(pl2);

        BLogic.Utilizador user1 = new BLogic.Utilizador(listaPlaylists, email, nome, password);
        user1.setNome("Pedro Gomes");
        user1.setEmail("pedrogomes2000@gmail.com");
        user1.setPass("12345");
        HashMap<Integer,BLogic.Playlist> lp1 = user1.getListaPlaylists();
        lp1.put(1,playlist1);
        lp1.put(2,playlist2);
        user1.setListaPlaylists(lp1);

        int i = 0;
        while (i < playlist1.getListaMediaPlaylist().size()) {
            playMedia(playlist1.getListaMediaPlaylist().get(i).getLink());
            i++;
        }

        button_msg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Hello World");
                playMedia("zombie.wav");
            }
        });

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("App");
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void playMedia(String filepath){

        try {
            File media = new File(filepath);

            if (media.exists()) {
                AudioInputStream mediaInput = AudioSystem.getAudioInputStream(media);
                //InputStream url = new URL(filepath).openStream();
                //AudioInputStream mediaInput = AudioSystem.getAudioInputStream(url);
                Clip clip = AudioSystem.getClip();
                clip.open(mediaInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

                JOptionPane.showMessageDialog(null,"Press OK to pause song.");
                long clipTimePosition = clip.getMicrosecondPosition();
                clip.stop();

                JOptionPane.showMessageDialog(null,"Press OK to resume song.");
                clip.setMicrosecondPosition(clipTimePosition);
                clip.start();

                JOptionPane.showMessageDialog(null,"Press OK to listen to the next song.");
                clip.stop();
            } else {
                System.out.println("Can't found file");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

        */
    }

}