package com.jsp.whs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.whs.entity.Address;
import com.jsp.whs.entity.Storage;

public interface StorageRepository  extends JpaRepository<Storage, Integer>  {

}
