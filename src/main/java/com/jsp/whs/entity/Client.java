package com.jsp.whs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int clientId;
   private String businessName;
   private String email;
   private long contactNumber;
   private String apikey;
   
   
}
