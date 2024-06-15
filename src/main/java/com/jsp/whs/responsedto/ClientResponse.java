package com.jsp.whs.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {
	private int clientId;
	private String businessName;
	private String email;
	private long contactNumber;
}
