package Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AdminController {
    @PutMapping("/api/admin/user-update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User existUser = userService.findByUsername(user.getUsername());
        if (existUser != null && !existUser.getId().equals(user.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
    }


    @DeleteMapping("/api/admin/user-delete")
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        userService.DeleteUserByID(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-all")
    public ResponseEntity<?> findAllUsers(){
        return new ResponseEntity<>(userService.ListAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-number")
    public ResponseEntity<?> numberOfUsers(){
        Long number = userService.numberOfUsers();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        //to return it, we will use String Response because long is not a suitable response for rest api
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/api/admin/agreement-create")
    public ResponseEntity<?> createAgreement(@RequestBody Agreement agreement){
        return new ResponseEntity<>(agreementService.SaveAgreement(agreement), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/agreement-update")
    public ResponseEntity<?> updateAgreement(@RequestBody Agreement agreement){
        return new ResponseEntity<>(agreementService.SaveAgreement(agreement), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/api/admin/product-delete")
    public ResponseEntity<?> deleteProduct(@RequestBody Agreement agreement){
        agreementService.DeleteAgrementByID(agreement.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/product-all")
    public ResponseEntity<?> findAllAgreement(){
        return new ResponseEntity<>(agreementService.ListAllAgreement(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/product-number")
    public ResponseEntity<?> numberOfAgreement(){
        Long number = agreementService.numberOfAgrements();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/admin/UserAgreements-all")
    public ResponseEntity<?> findAllUserAgreements(){
        return new ResponseEntity<>(userAgreementService.findAllUserAgreements(), HttpStatus.OK);
    }

    @GetMapping("api/admin/UserAgreements-number")
    public ResponseEntity<?> numberOfUserAgreements(){
        Long number = userAgreementService.numberOfUserAgreements();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
