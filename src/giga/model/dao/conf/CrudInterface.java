package giga.model.dao.conf;

import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public interface CrudInterface {
    public void salvar(Object obj);
    public void editar(Object obj);
    public void apagar(int id);
    public ArrayList<Object> listar();
    public Object getByID(int ID);
}
