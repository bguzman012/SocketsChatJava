/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaschat;

import chat.frames.Chat;
import chat.frames.Chat2;

/**
 *
 * @author Usuario
 */
public class SistemasChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chat chat = new Chat();
        chat.setVisible(true);
        Chat2 chat2 = new Chat2();
        chat2.setVisible(true);
        Server servidor = new Server();
    }
    
}
