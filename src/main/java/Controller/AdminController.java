package Controller;

import Model.Hayvan;
import Model.HayvanSahibi;
import Service.HayvanHayvanSahibiService;
import Service.HayvanSahibiService;
import Service.HayvanService;
import config.StringResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
public class AdminController {

    private final HayvanHayvanSahibiService hayvanHayvanSahibiService;
    private final HayvanService hayvanService;
    private final HayvanSahibiService hayvanSahibiService;

    public AdminController(HayvanHayvanSahibiService hayvanHayvanSahibiService, HayvanService hayvanService, HayvanSahibiService hayvanSahibiService) {
        this.hayvanHayvanSahibiService = hayvanHayvanSahibiService;
        this.hayvanService = hayvanService;
        this.hayvanSahibiService = hayvanSahibiService;
    }

    @GetMapping("/")
    String greetingPage(ModelMap map, @RequestParam(required = false) String name) {
        name = name == null || name.trim().equals("") ? "Thymeleaf" : name;
        String message = String.format("Merhaba %s!", name);
        map.put("message", message);
        return "index";
    }

    @PutMapping("/api/admin/user-update")
    public ResponseEntity<?> updateHayvanSahibi(@RequestBody HayvanSahibi hayvanSahibi) {
        HayvanSahibi existUser = hayvanSahibiService.findByNameHayvanSahibi(hayvanSahibi.getUsername());
        if (existUser != null && !existUser.getId().equals(hayvanSahibi.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(hayvanSahibiService.updateHayvanSahibi(hayvanSahibi), HttpStatus.CREATED);
    }


    @DeleteMapping("/api/admin/user-delete")
    public ResponseEntity<?> deleteUser(@RequestBody HayvanSahibi hayvanSahibi){
        hayvanSahibiService.DeleteHayvanSahibiByID(hayvanSahibi.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-all")
    public ResponseEntity<?> findAllHayvanSahibi(){
        return new ResponseEntity<>(hayvanSahibiService.ListAllHayvanSahibi(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-number")
    public ResponseEntity<?> numberOfHayvanSahibi(){
        Long number = hayvanSahibiService.numberOfHayvanSahibi();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        //to return it, we will use String Response because long is not a suitable response for rest api
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/api/admin/HayvanAlımı-create")
    public ResponseEntity<?> createHayvanAlımı(@RequestBody Hayvan hayvan){
        return new ResponseEntity<>(hayvanService.SaveHayvan(hayvan), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/HayvanAlımı-update")
    public ResponseEntity<?> updateHayvan(@RequestBody Hayvan hayvan){
        return new ResponseEntity<>(hayvanService.SaveHayvan(hayvan), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/api/admin/hayvan-delete")
    public ResponseEntity<?> deleteHayvan(@RequestBody Hayvan hayvan){
        hayvanService.DeleteHayvanByID(hayvan.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/hayvan-all")
    public ResponseEntity<?> findAllHayvan(){
        return new ResponseEntity<>(hayvanService.ListAllHayvan(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/HayvanAlımı-number")
    public ResponseEntity<?> numberOfHayvanAlımı(){
        Long number = hayvanService.numberOfHayvan();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/admin/HayvanAlımı-all")
    public ResponseEntity<?> findAllUserAgreements(){
        return new ResponseEntity<>(hayvanHayvanSahibiService.findAllHayvanHayvanSahibi(), HttpStatus.OK);
    }

    @GetMapping("api/admin/HayvanAlımı-number")
    public ResponseEntity<?> numberOfHayvanAlımıtotal(){
        Long number = hayvanHayvanSahibiService.numberOfHayvanHayvanSahibi();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
