/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Missions;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hristi
 */
@Local
public interface MissionsFacadeLocal {

    void create(Missions missions);

    void edit(Missions missions);

    void remove(Missions missions);

    Missions find(Object id);

    List<Missions> findAll();

    List<Missions> findRange(int[] range);

    int count();
    
}
