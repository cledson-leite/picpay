package springboot.desafio.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springboot.desafio.picpay.client.AuthorizationClient;
import springboot.desafio.picpay.dto.AuthResponse;
import springboot.desafio.picpay.entity.Transfer;
import springboot.desafio.picpay.exception.InternalServeErrorException;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationClient authClient;

    public Boolean isAuthorizated(Transfer transfer){
        ResponseEntity<AuthResponse>  resp = this.authClient.isAuthorized();
        if(resp.getStatusCode().isError()){
            throw new InternalServeErrorException();
        }
        if("fail".equals(resp.getBody().getStatus())){
            return false;
        }
        return resp.getBody().getData().authorization;
    }
}
