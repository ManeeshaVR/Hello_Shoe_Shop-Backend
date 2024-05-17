package software.vimukthirajapaksha.shoe_shop_project.util;

import java.util.Base64;

public class UtilMatters {

    public static String convertBase64(String data){
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

}
