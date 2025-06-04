package springboot.desafio.picpay.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.desafio.picpay.dto.CreateWalletDto;
import springboot.desafio.picpay.dto.Response;
import springboot.desafio.picpay.entity.Wallet;
import springboot.desafio.picpay.service.WalletService;

@RestController
public class WalletController {
    @Autowired
    private WalletService service;


    @PostMapping("/wallets")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Wallet>> createWallet(@Valid @RequestBody CreateWalletDto dto){
        Wallet result = this.service.save(dto);
        Response<Wallet> response = new Response<>(true, result, "Wallet created success");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
