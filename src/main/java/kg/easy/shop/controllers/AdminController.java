package kg.easy.shop.controllers;

import kg.easy.shop.mappers.ClassMapper;
import kg.easy.shop.models.dto.*;
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
    public ResponseEntity<?> saveUserStatus(@RequestBody UserStatusDto userStatusDto) {

        return new ResponseEntity<>(adminService.saveUserStatus(userStatusDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/user_status/all", method = RequestMethod.GET)
    public ResponseEntity<?> getUserStatusList() {

        return new ResponseEntity<>(adminService.getUserStatusList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {

        return new ResponseEntity<>(adminService.saveUser(userDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public ResponseEntity<?> getUserList() {

        return new ResponseEntity<>(adminService.getUserList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/supplier/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveSupplier(@RequestBody SupplierDto supplierDto) {
        return new ResponseEntity<>(adminService.saveSupplier(supplierDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/supplier/all", method = RequestMethod.GET)
    public ResponseEntity<?> getSupplierList() {

        return new ResponseEntity<>(adminService.getSupplierList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(adminService.saveCustomer(customerDto), HttpStatus.OK);
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
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(adminService.saveProduct(productDto), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/all", method = RequestMethod.GET)
    public ResponseEntity<?> getProductList() {

        return new ResponseEntity<>(adminService.getProductList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/income/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveIncome(@RequestBody IncomeDto incomeDto){
        return new ResponseEntity<>(adminService.saveIncome(incomeDto), HttpStatus.OK);
    }

    @GetMapping(value = "/income/getall")
    public ResponseEntity<?> getIncomeList(){
        return new ResponseEntity<>(adminService.getIncomeList(), HttpStatus.OK);
    }

}
