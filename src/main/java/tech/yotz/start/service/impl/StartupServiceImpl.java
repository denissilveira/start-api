package tech.yotz.start.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.yotz.start.repository.StartupRepository;
import tech.yotz.start.service.StartupService;

@Service
public class StartupServiceImpl implements StartupService {
	
	@Autowired
	private StartupRepository startupRepository;
}
