package kg.easy.shop.controllers;

import kg.easy.shop.models.entities.*;
import kg.easy.shop.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/user_status/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveUserStatus(@RequestBody UserStatus userStatus) {

        return new ResponseEntity<>(adminService.saveUserStatus(userStatus), HttpStatus.OK);
    }

    @RequestMapping(value = "/user_status/all", method = RequestMethod.GET)
    public ResponseEntity<?> getUserStatusList() {

        return new ResponseEntity<>(adminService.getUserStatusList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) {

        return new ResponseEntity<>(adminService.saveUser(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public ResponseEntity<?> getUserList() {

        return new ResponseEntity<>(adminService.getUserList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/supplier/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveSupplier(@RequestBody Supplier supplier) {
        return new ResponseEntity<>(adminService.saveSupplier(supplier), HttpStatus.OK);
    }

    @RequestMapping(value = "/supplier/all", method = RequestMethod.GET)
    public ResponseEntity<?> getSupplierList() {

        return new ResponseEntity<>(adminService.getSupplierList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(adminService.saveCustomer(customer), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/all", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerList() {

        return new ResponseEntity<>(adminService.getCustomerList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user_phone/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserPhoneList(@PathVariable Long id) {

        return new ResponseEntity<>(adminService.getUserPhoneList(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(adminService.saveProduct(product), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/all", method = RequestMethod.GET)
    public ResponseEntity<?> getProductList() {

        return new ResponseEntity<>(adminService.getProductList(), HttpStatus.OK);
    }

}
