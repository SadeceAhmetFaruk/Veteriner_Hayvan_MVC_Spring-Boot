package Service;

import Model.Hayvan;
import Model.HayvanSahibi;

import java.util.List;

public interface HayvanService {

    //Update  Hayvan
    Hayvan updateHayvan(Hayvan hayvan);

    //List ALL Hayvan
    List<Hayvan> ListAllHayvan();

    //Number of Hayvan
    Long numberOfHayvan();

    //find By name
    List<Hayvan> findByNameHayvan(String name);

    //Create and update Hayvan
    Hayvan SaveHayvan(HayvanSahibi hayvanSahibi);

    //Delete By ID
    void DeleteHayvanByID(Long hayvan_id);

    //Delete By Name
    void DeleteHayvanByName(Hayvan hayvan);
}
