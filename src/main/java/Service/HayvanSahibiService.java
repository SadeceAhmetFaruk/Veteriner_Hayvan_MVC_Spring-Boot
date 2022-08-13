package Service;

import Model.Hayvan;
import Model.HayvanHayvanSahibi;
import Model.HayvanSahibi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HayvanSahibiService {

    //Update  HayvanSahibi
    HayvanSahibi updateHayvanSahibi(HayvanSahibi hayvanSahibi);

    //List ALL HayvanSahibi
    List<HayvanSahibi> ListAllHayvanSahibi();

    //find by name HayvanSahibi


    HayvanSahibi findByNameHayvanSahibi(String name);

    //Number of HayvanSahibi
    Long numberOfHayvanSahibi();

    //Create and update HayvanSahibi
    HayvanSahibi SaveHayvanSahibi(HayvanSahibi hayvanSahibi);

    //Delete By ID
    void DeleteHayvanSahibiByID(Long hayvan_sahibi_id);

    //Delete By Name
    void DeleteHayvanSahibiByName(HayvanSahibi hayvanSahibi);

}
