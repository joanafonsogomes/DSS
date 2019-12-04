import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.ComponentAdapter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    private JPanel panelMain;
    private JButton button_msg;
    private JLabel title;

    public Main() {
        Media m0 = new Media();
        m0.setIdMedia(0);
        m0.setLink("seeYouAgain.wav");
        Media m1 = new Media();
        m1.setIdMedia(1);
        m1.setLink("zombie.wav");
        Media m2 = new Media();
        m2.setIdMedia(2);
        m2.setLink("useSomebody.wav");

        Biblioteca biblioteca = new Biblioteca();
        HashMap<Integer,Media> biblio = new HashMap<Integer,Media>();
        biblio.put(0,m0);
        biblio.put(1,m1);
        biblio.put(2,m2);
        biblioteca.setListaMediaBiblioteca(biblio);

        Playlist playlist1 = new Playlist();
        HashMap<Integer,Media> pl1 = playlist1.getListaMediaPlaylist();
        pl1.put(0,m0);
        pl1.put(1,m1);
        playlist1.setListaMediaPlaylist(pl1);

        Playlist playlist2 = new Playlist();
        HashMap<Integer,Media> pl2 = playlist1.getListaMediaPlaylist();
        pl2.put(2,m2);
        playlist2.setListaMediaPlaylist(pl2);

        Utilizador user1 = new Utilizador();
        user1.setNome("Pedro Gomes");
        user1.setEmail("pedrogomes2000@gmail.com");
        user1.setPass("12345");
        HashMap<Integer,Playlist> lp1 = user1.getListaPlaylists();
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

}