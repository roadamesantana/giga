package giga.controller;

import giga.model.Email;
import giga.view.reg.RegistrarEmailView;
import java.awt.Frame;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ronald
 */
public class EmailController {
    private DefaultListModel modelEmails;
    
    public DefaultListModel getEmailsListModel() {
        if ( null == modelEmails ){
            modelEmails = new DefaultListModel();
        }
        
        return modelEmails;
    }
    
    public Email getEmail(){
        RegistrarEmailView view = new RegistrarEmailView(new Frame(), true);
        view.setVisible(true);
        Email mail = view.getEmail();
        
        if ( mail.getEmail().isEmpty() ) {
            return null;
        }
        
        return mail;
    }
}
