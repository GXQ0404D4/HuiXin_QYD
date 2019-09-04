package com.ktcn.service;

import java.util.List;

import com.ktcn.entity.Log;

public interface TestSercice {

	List<Log> findByPage(int total, int pageSize);

}
