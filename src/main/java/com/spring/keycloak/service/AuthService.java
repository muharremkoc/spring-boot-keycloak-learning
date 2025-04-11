package com.spring.keycloak.service;
import com.spring.keycloak.exception.AuthenticationException;
import com.spring.keycloak.model.AuthRequest;
import com.spring.keycloak.model.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private final TokenServiceImpl tokenService;

    public AuthService(TokenServiceImpl tokenService) {
        this.tokenService = tokenService;
    }


    public AuthResponse login(AuthRequest authRequest) {
        String keyCloakToken = tokenService.keyCloakClientCredentialsConnect(authRequest);
        if (keyCloakToken != null && !keyCloakToken.isEmpty()) {
            return new AuthResponse(keyCloakToken);
        }else throw new AuthenticationException("Invalid token");
    }
}
