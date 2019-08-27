package com.ktcn.utils;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ktcn.dao.DataMasterTable;

public class OPCAddressInsert {
	
    @Autowired
    DataMasterTable DataMasterTable;
	
	public void GetOPCInsert(ArrayList<Boolean> sl, ArrayList<Float> fl){
		System.out.println("######################################################################################################################");
		DataMasterTable.OpcDataMasterInsert(sl,fl);
		
	}

}
