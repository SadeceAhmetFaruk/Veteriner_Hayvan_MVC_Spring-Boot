package Service.ServiceIMP;


import Model.HayvanHayvanSahibi;
import Model.HayvanSahibi;
import Repository.HayvanSahibiRepository;
import org.springframework.stereotype.Service;
import Service.HayvanSahibiService;
import java.util.List;

@Service
public class HayvanSahibiServiceImp implements HayvanSahibiService {

    private final HayvanSahibiRepository hayvanSahibiRepository;

    public HayvanSahibiServiceImp(HayvanSahibiRepository hayvanSahibiRepository) {
        this.hayvanSahibiRepository = hayvanSahibiRepository;
    }


    @Override
    public HayvanSahibi updateHayvanSahibi(HayvanSahibi hayvanSahibi) {
       return hayvanSahibiRepository.save(hayvanSahibi);
    }

    @Override
    public List<HayvanSahibi> ListAllHayvanSahibi() {
        return  hayvanSahibiRepository.findAll();
    }
    /* Burası kaldı bunu doldur*/
    @Override
    public List<HayvanSahibi> findByNameHayvanSahibi(String name) {
        return hayvanSahibiRepository.findByNameHayvan(name);
    }

    @Override
    public Long numberOfHayvanSahibi() {
        return hayvanSahibiRepository.count();
    }

    @Override
    public HayvanSahibi SaveHayvanSahibi(HayvanSahibi hayvanSahibi) {
        return hayvanSahibiRepository.save(hayvanSahibi);
    }

    @Override
    public void DeleteHayvanSahibiByID(Long hayvan_sahibi_id) {
    hayvanSahibiRepository.deleteById(hayvan_sahibi_id);
    }

    @Override
    public void DeleteHayvanSahibiByName(HayvanSahibi hayvanSahibi) {
        hayvanSahibiRepository.delete(hayvanSahibi);

    }
}
