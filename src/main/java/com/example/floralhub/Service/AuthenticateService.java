package com.example.floralhub.Service;

import com.example.floralhub.DTO.AuthenticationRequest;
import com.example.floralhub.DTO.AuthenticationResponse;

public interface AuthenticateService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticateRequest);
}