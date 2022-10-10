
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William Lau
 */
public class accountService implements Serializable {
    
     user a = new user("abe", "password");
    user b = new user("barb", "password");

    public accountService() {
    }

    public user login(String username, String password) {

        if (username.equals("abe") && password.equals("password")) {
            return a;
        } else if (username.equals("barb") && password.equals("password")) {
            return b;
        } else {
            return null;
        }

    }
    
}
