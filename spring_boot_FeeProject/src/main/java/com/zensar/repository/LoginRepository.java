package com.zensar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zensar.beans.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, String>{

}
