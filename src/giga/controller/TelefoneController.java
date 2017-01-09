package giga.controller;

import giga.model.Telefone;
import giga.view.reg.RegistrarTelefoneView;
import java.awt.Frame;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ronald
 */
public class TelefoneController {
    private DefaultListModel modelTelefones;
    
    public DefaultListModel getTelefonesListModel() {
        if ( null == modelTelefones ){
            modelTelefones = new DefaultListModel();
        }
        
        return modelTelefones;
    }
    
    public Telefone getTelefone(){
        RegistrarTelefoneView view = new RegistrarTelefoneView(new Frame(), true);
        view.setVisible(true);
        Telefone tel = view.getTelefone();
        
        if ( tel.getDdd().isEmpty() || tel.getNumero().isEmpty() ) {
            return null;
        }
        
        return tel;
    }
}
