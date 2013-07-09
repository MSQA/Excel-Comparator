package com.yodes.excel.web.stubs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yodes.excel.web.security.MongoUser;
import com.yodes.excel.web.security.MongoUserRepository;

@Service
public class MongoUserRepositoryStub implements MongoUserRepository {

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void delete(String arg0) {

	}

	@Override
	public void delete(MongoUser arg0) {

	}

	@Override
	public void delete(Iterable<? extends MongoUser> arg0) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean exists(String arg0) {
		return false;
	}

	@Override
	public Iterable<MongoUser> findAll(Iterable<String> arg0) {
		return null;
	}

	@Override
	public MongoUser findOne(String arg0) {
		return null;
	}

	@Override
	public <S extends MongoUser> S save(S arg0) {
		return null;
	}

	@Override
	public <S extends MongoUser> Iterable<S> save(Iterable<S> arg0) {
		return null;
	}

	@Override
	public MongoUser findByUsername(String username) {
		return null;
	}

	@Override
	public List<MongoUser> findAll() {
		return null;
	}

}
