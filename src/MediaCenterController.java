import Exceptions.MediaJaExisteException;

import java.util.ArrayList;

public class MediaCenterController {

    MediaCenter mC = new MediaCenter();

   public void eliminaMedia(String idUtilizador, int idMedia ){
       mC.eliminaMedia(idUtilizador,idMedia);
   }

   public void upload (String mediaUpload,String artista, String emailUtilizador) throws MediaJaExisteException {
       mC.addMedia(mediaUpload,artista,emailUtilizador);
   }

}
