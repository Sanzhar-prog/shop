package kg.easy.shop.controllers;

import kg.easy.shop.models.data.SellOperation;
import kg.easy.shop.services.common.OperationService;
import kg.easy.shop.services.common.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OperationService operationService;


    @RequestMapping(value = "/sell-operation/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveSellOperation(@RequestBody SellOperation sellOperation) {
        return new ResponseEntity<>(operationService.saveOperation(sellOperation), HttpStatus.OK );
    }

    @RequestMapping(value = "/operation/all", method = RequestMethod.GET)
    public ResponseEntity<?> getSellOperations(@RequestBody SellOperation sellOperation) {
        return new ResponseEntity<>(operationService.getOperations(), HttpStatus.OK );
    }

    @RequestMapping(value = "/operation/operation-details/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOperationDetails(@PathVariable Long id) {
        return new ResponseEntity<>(operationService.getOperationDetails(id), HttpStatus.OK );
    }
}
