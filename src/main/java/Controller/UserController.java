package Controller;


import Model.HayvanHayvanSahibi;
import Model.HayvanSahibi;
import Model.Role;
import Service.HayvanHayvanSahibiService;
import Service.HayvanSahibiService;
import Service.HayvanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class UserController {
    private final HayvanSahibiService hayvanSahibiService;
    private final HayvanService hayvanService;
    private final HayvanHayvanSahibiService hayvanHayvanSahibiService;

/*private final değerlerimiz için bir yapıcı metod lazım*/
    public UserController(HayvanSahibiService hayvanSahibiService, HayvanService hayvanService, HayvanHayvanSahibiService hayvanHayvanSahibiService) {
        this.hayvanSahibiService = hayvanSahibiService;
        this.hayvanService = hayvanService;
        this.hayvanHayvanSahibiService = hayvanHayvanSahibiService;
    }
    @GetMapping("/")
    String greetingPage(ModelMap map, @RequestParam(required = false) String name) {
        name = name == null || name.trim().equals("") ? "Thymeleaf" : name;
        String message = String.format("Merhaba %s!", name);
        map.put("message", message);
        return "index";
    }

    /* Hayvan SAhibi*/
    @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody HayvanSahibi hayvanSahibi){
        if(hayvanSahibiService.findByNameHayvanSahibi(hayvanSahibi.getUsername())!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //default role.
        hayvanSahibi.setRole(Role.USER);
        return new ResponseEntity<>(hayvanSahibiService.SaveHayvanSahibi(hayvanSahibi), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> getUser(Principal principal){
        //principal = httpServletRequest.getUserPrincipal.
        if(principal == null){
            //logout will also use here so we should return ok http status.
            return ResponseEntity.ok(principal);
        }

        HayvanSahibi hayvanSahibi = hayvanSahibiService.findByNameHayvanSahibi(principal.getName());
               return new ResponseEntity<>(hayvanSahibi, HttpStatus.OK);
    }
    @PostMapping("/api/user/purchase")
    public ResponseEntity<?> AddAnimal(@RequestBody HayvanHayvanSahibi hayvanHayvanSahibi){
        hayvanHayvanSahibi.setAcceptance_date(LocalDateTime.now());
        hayvanHayvanSahibiService.saveHayvanHayvanSahibi(hayvanHayvanSahibi);
        return new ResponseEntity<>(hayvanHayvanSahibi, HttpStatus.CREATED);
    }

    @GetMapping("/api/user/products")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(hayvanHayvanSahibiService.findAllHayvanHayvanSahibi(), HttpStatus.OK);
    }



}
