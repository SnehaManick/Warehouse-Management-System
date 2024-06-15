package com.jsp.whs.service;

import org.springframework.http.ResponseEntity;

import com.jsp.whs.requestdto.ClientRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.responsedto.ClientResponse;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface ClientService {

	ResponseEntity<ResponseStructure<ClientResponse>> addClient(@Valid ClientRequest clientRequest);

	ResponseEntity<ResponseStructure<ClientResponse>> updateClient(int clientId, @Valid ClientRequest clientRequest);

}
