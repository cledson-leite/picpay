package springboot.desafio.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.desafio.picpay.client.AuthorizationClient;
import springboot.desafio.picpay.entity.Transfer;
import springboot.desafio.picpay.exception.InternalServeErrorException;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationClient authClient;

    public boolean isAuthorizated(Transfer transfer){
        var resp = this.authClient.isAuthorized();
        if(resp.getStatusCode().isError()){
            throw new InternalServeErrorException();
        }
        return resp.getBody().authorized;
    }
}
