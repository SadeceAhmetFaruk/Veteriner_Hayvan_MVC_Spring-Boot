package Service;

import Model.HayvanHayvanSahibi;
import org.springframework.stereotype.Service;

import java.util.List;


/* Hayvan ve Hayvan Sahipleri arasındaki ilişkinin Servisidir.*/
@Service
public interface HayvanHayvanSahibiService {
    HayvanHayvanSahibi saveHayvanHayvanSahibi(HayvanHayvanSahibi hayvanHayvanSahibi);

    Long numberOfHayvanHayvanSahibi();

    List<HayvanHayvanSahibi> findAllHayvanHayvanSahibi();

}
