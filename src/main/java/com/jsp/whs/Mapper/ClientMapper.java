package com.jsp.whs.Mapper;

import org.springframework.stereotype.Component;

import com.jsp.whs.entity.Client;
import com.jsp.whs.requestdto.ClientRequest;
import com.jsp.whs.responsedto.ApiKeyResponse;
import com.jsp.whs.responsedto.ClientResponse;

@Component
public class ClientMapper {
	

	public Client mapToClientRequest( ClientRequest clientRequest, Client client) {
		client.setBusinessName(clientRequest.getBusinessName());
		client.setEmail(clientRequest.getEmail());
		client.setContactNumber(clientRequest.getContactNumber());

		return client;
	}

	public ApiKeyResponse mapToApiKeyResponse(Client client) {
		return ApiKeyResponse.builder()
				.apiKey(client.getApikey())
				.message("created")
				.build();

	}

	public ClientResponse mapClientResponse(Client client) {
		return ClientResponse.builder()
				.clientId(client.getClientId())
				.businessName(client.getBusinessName())
				.email(client.getEmail())
				.contactNumber(client.getContactNumber())
				.build();
	}
	}

