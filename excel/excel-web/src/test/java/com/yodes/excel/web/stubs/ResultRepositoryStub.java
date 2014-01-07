package com.yodes.excel.web.stubs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yodes.excel.api.model.Result;
import com.yodes.excel.api.model.dao.ResultRepository;

@Service
public class ResultRepositoryStub implements ResultRepository {

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void delete(String arg0) {

	}

	@Override
	public void delete(Result arg0) {

	}

	@Override
	public void delete(Iterable<? extends Result> arg0) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean exists(String arg0) {
		return false;
	}

	@Override
	public Iterable<Result> findAll(Iterable<String> arg0) {
		return null;
	}

	@Override
	public Result findOne(String arg0) {
		return null;
	}

	@Override
	public <S extends Result> S save(S arg0) {
		return null;
	}

	@Override
	public <S extends Result> Iterable<S> save(Iterable<S> arg0) {
		return null;
	}

	@Override
	public List<Result> findAll() {
		return null;
	}

	@Override
	public List<Result> findByLabel(String arg0) {
		return null;
	}

}
