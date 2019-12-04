import java.util.ArrayList;

public class MediaCenterController {

    MediaCenter mC = new MediaCenter();

   public void eliminaMedia(String idUtilizador, int idMedia ){
       mC.eliminaMedia(idUtilizador,idMedia);
   }

   public void upload (ArrayList<String> mediaUpload, String emailUtilizador){
       mC.addMedia(mediaUpload,emailUtilizador);
   }

}
