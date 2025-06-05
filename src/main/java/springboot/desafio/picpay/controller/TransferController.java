package springboot.desafio.picpay.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.desafio.picpay.dto.Response;
import springboot.desafio.picpay.dto.TransferDto;
import springboot.desafio.picpay.entity.Transfer;
import springboot.desafio.picpay.service.TransferService;

@RestController
public class TransferController {
    @Autowired
    private TransferService service;
    @PostMapping("/transfer")
    public ResponseEntity<Response<Transfer>> transfer(@Valid @RequestBody TransferDto dto){
        Transfer resp = this.service.transfer(dto);
        Response response = new Response(true, resp, "Transfer done!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
