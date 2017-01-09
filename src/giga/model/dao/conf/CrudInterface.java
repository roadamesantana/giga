package giga.model.dao.conf;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public interface CrudInterface {
    public Object criar(ResultSet rs);
    public void salvar(Object obj);
    public void editar(Object obj);
    public void apagar(int id);
    public ArrayList<Object> listar();
    public Object getByID(int id);
}
