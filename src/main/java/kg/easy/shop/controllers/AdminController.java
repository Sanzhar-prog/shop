package kg.easy.shop.controllers;

import kg.easy.shop.models.Supplier;
import kg.easy.shop.models.UserStatus;
import kg.easy.shop.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/userstatus/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveUserStatus(@RequestBody UserStatus userStatus){
        return new ResponseEntity<>(adminService.saveUserStatus(userStatus), HttpStatus.OK);
    }

    @RequestMapping(value = "/userstatus/all", method = RequestMethod.GET)
    public ResponseEntity<?> getUserStatusList(){
        return new ResponseEntity<>(adminService.getAllUserStatuses(), HttpStatus.OK);
    }

    @RequestMapping(value = "/supplier/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveSupllier(@RequestBody Supplier supplier){
        return new ResponseEntity<>(adminService.saveSupllier(supplier), HttpStatus.OK);
    }

    @RequestMapping(value = "/supplier/all", method = RequestMethod.GET)
    public ResponseEntity<?> getSuplliers(){
        return new ResponseEntity<>(adminService.getAllSuppliers(), HttpStatus.OK);
    }
}
