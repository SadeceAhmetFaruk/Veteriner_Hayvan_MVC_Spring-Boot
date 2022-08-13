package Service.ServiceIMP;

import Model.HayvanHayvanSahibi;
import Repository.HayvanHayvanSahibiRepository;
import Service.HayvanHayvanSahibiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HayvanHayvanSahibiServiceImp implements HayvanHayvanSahibiService {

    private final HayvanHayvanSahibiRepository hayvanHayvanSahibiRepository ;

    public HayvanHayvanSahibiServiceImp(HayvanHayvanSahibiRepository hayvanHayvanSahibiRepository) {
        this.hayvanHayvanSahibiRepository = hayvanHayvanSahibiRepository;
    }


    @Override
    public HayvanHayvanSahibi saveHayvanHayvanSahibi(HayvanHayvanSahibi hayvanHayvanSahibi) {
        return hayvanHayvanSahibiRepository.save(hayvanHayvanSahibi);
    }

    @Override
    public Long numberOfHayvanHayvanSahibi() {
       return hayvanHayvanSahibiRepository.count();
    }

    @Override
    public List<HayvanHayvanSahibi> findAllHayvanHayvanSahibi() {
       return hayvanHayvanSahibiRepository.findAll();
    }
}
