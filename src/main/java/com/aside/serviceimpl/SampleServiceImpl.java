package com.aside.serviceimpl;

import org.springframework.stereotype.Service;

import com.aside.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{

/*	@Resource
	SampleDao sampleDao;
	
	@Override
	public List<SampleCP> testApi(ModelMap model, SampleCP cp) {
		System.out.println("service input  :::ss: ");
		return sampleDao.testApi(cp);
	}

	@Override
	public String testlogin(ModelMap model, SampleCP sampleCP) {
		String result = "";
		List<SampleSP> lsp = sampleDao.testlogin(sampleCP);
		
		if(lsp.size() == 0){
			result = "N";
		}else if(lsp.size() == 1){
			result = "Y";
		}else if(lsp.size() > 1){
			result = "ERR";
		}
		
		return result;
	}*/

}
