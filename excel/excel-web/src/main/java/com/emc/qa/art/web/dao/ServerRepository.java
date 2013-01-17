package com.emc.qa.art.web.dao;

import org.springframework.data.repository.CrudRepository;

import com.emc.qa.art.web.model.Server;

public interface ServerRepository extends CrudRepository<Server, String> {

}
