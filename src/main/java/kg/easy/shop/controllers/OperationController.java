package kg.easy.shop.controllers;

import kg.easy.shop.mappers.ClassMapper;
import kg.easy.shop.models.dto.OperationDto;
import kg.easy.shop.models.entities.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/operation")
public class OperationController {


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveOperation(@RequestBody OperationDto operationDto) {

        Operation operation = ClassMapper.INSTANCE.OperationDtoToOperation(operationDto);

        System.out.println(operation);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }
}
