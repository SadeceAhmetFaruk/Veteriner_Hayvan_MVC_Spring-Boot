package Service.ServiceIMP;

import Model.Hayvan;
import Model.HayvanSahibi;
import Repository.HayvanRepository;
import Service.HayvanService;

import java.util.List;

public class HayvanServiceImp implements HayvanService {


    private final HayvanRepository hayvanRepository;

    public HayvanServiceImp(HayvanRepository hayvanRepository) {
        this.hayvanRepository = hayvanRepository;
    }

    @Override
    public Hayvan updateHayvan(Hayvan hayvan) {
        return hayvanRepository.save(hayvan);
    }

    @Override
    public List<Hayvan> ListAllHayvan() {
        return hayvanRepository.findAll();
    }

    @Override
    public Long numberOfHayvan() {
        return hayvanRepository.count();
    }

    @Override
    public List<Hayvan> findByNameHayvan(String name) {
        return hayvanRepository.findByNameHayvan(name);
    }

    @Override
    public Hayvan SaveHayvan(Hayvan hayvan) {
        return null;
    }

    @Override
    public void DeleteHayvanByID(Long hayvan_id) {

    }

    @Override
    public void DeleteHayvanByName(Hayvan hayvan) {

    }
}
