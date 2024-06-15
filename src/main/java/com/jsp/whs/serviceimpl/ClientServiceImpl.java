package com.jsp.whs.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.ClientType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jsp.whs.Mapper.AdminMapper;
import com.jsp.whs.Mapper.ClientMapper;
import com.jsp.whs.entity.Admin;
import com.jsp.whs.entity.Client;
import com.jsp.whs.enums.AdminType;
import com.jsp.whs.exception.AdminNotFoundByEmailException;
import com.jsp.whs.exception.ClientNotFoundByIdException;
import com.jsp.whs.exception.SuperAdminAlreadyExistException;
import com.jsp.whs.repository.AdminRepository;
import com.jsp.whs.repository.ClientRepository;
import com.jsp.whs.repository.WarehouseRepository;
import com.jsp.whs.requestdto.ClientRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.responsedto.ClientResponse;
import com.jsp.whs.service.ClientService;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class ClientServiceImpl  implements ClientService{

	@Autowired
	private ClientMapper clientMapper;
	@Autowired
	private ClientRepository clientRepo;
	@Override
	public ResponseEntity<ResponseStructure<ClientResponse>> addClient(@Valid ClientRequest clientRequest) {
		
		String apikey = UUID.randomUUID().toString();
		
		 Client client = clientMapper.mapToClientRequest(clientRequest, new Client());
		 client.setApikey(apikey);
		 client = clientRepo.save(client);
		 
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseStructure<ClientResponse>()
							.setStatuscode(HttpStatus.CREATED.value())
							.setMessage("Client Created")
							.setData(clientMapper.mapClientResponse(client)));
	}
    public ResponseEntity<ResponseStructure<ClientResponse>> updateClient(int clientId, @Valid ClientRequest clientRequest){

		return clientRepo.findById(clientId).map(existingClient -> {
			existingClient = clientRepo.save(clientMapper.mapToClientRequest(clientRequest, existingClient));


			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<ClientResponse>()
							.setStatuscode(HttpStatus.OK.value())
							.setMessage("Client Updated")
							.setData(clientMapper.mapClientResponse(existingClient)));

		}).orElseThrow(() -> new ClientNotFoundByIdException("client Not found "));
	}


	
}


