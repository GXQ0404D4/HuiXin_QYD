package com.ktcn.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ktcn.common.UtgardButton;

@RestController
public class MonitoringButtonController {
	private static String BDYC="DI-1#KYJBD/YC";	
	private static String ZDSD="DO-1#KYJZD/SD";	
	private static String KYJQD="DO-1#KYJQD";	
	private static String KYJTZ="DO-1#KYJTZ";
	
	private static String BDYC2="DI-2#KYJBD/YC";	
	private static String ZDSD2="DO-2#KYJZD/SD";	
	private static String KYJQD2="DO-2#KYJQD";	
	private static String KYJTZ2="DO-2#KYJTZ";
	
	private static String BDYC3="DI-3#KYJBD/YC";	
	private static String ZDSD3="DO-3#KYJZD/SD";	
	private static String KYJQD3="DO-3#KYJQD";	
	private static String KYJTZ3="DO-3#KYJTZ";
	
	private static String KYJYX="DI-1#KYJYX";
	
	private static String buttonBDYD="DIKYJBDYC";
	private static String buttonZDSD="DOKYJZDSD";
	private static String buttonQD="KYJQD";
	private static String buttonTZ="KYJTZ";
	@Autowired
	UtgardButton  utgardButton;

  @RequestMapping("compressorAA")
  public void UpdateButton(@RequestBody Map<String,Object> map){
	  String address=null;
	  for (String string : map.keySet()) {
		  address=string;
	}		 	
	 if (address.equals(buttonBDYD) && map.get(buttonBDYD)!=null ) {	
		  if (map.get(buttonBDYD).equals(1)) {
			utgardButton.UpdateUtgard(BDYC,0);
		} if (map.get(buttonBDYD).equals(0)){
			utgardButton.UpdateUtgard(BDYC,1);
		}
	} if (address.equals(buttonZDSD) && map.get(buttonZDSD)!=null  ) {
		 if (map.get(buttonZDSD).equals(1)) {
				utgardButton.UpdateUtgard(ZDSD,0);
	   } if (map.get(buttonZDSD).equals(0)){
				utgardButton.UpdateUtgard(ZDSD,1);
	   }
	} if (address.equals(buttonQD) && map.get(buttonQD)!=null  ) {
		 if (map.get(buttonQD).equals(0)){
				utgardButton.UpdateUtgard(KYJQD,1);
	   }
	} if (address.equals(buttonTZ) && map.get(buttonTZ)!=null  ) {
		 if (map.get(buttonTZ).equals(0)){
				utgardButton.UpdateUtgard(KYJTZ,1);
	   }
	}
	  
  }
  
  @RequestMapping("compressorBB")
  public void UpdateButton2(@RequestBody Map<String,Object> map){
	  String address=null;
	  for (String string : map.keySet()) {
		  address=string;
	}		 	
	 if (address.equals(buttonBDYD) && map.get(buttonBDYD)!=null ) {	
		  if (map.get(buttonBDYD).equals(1)) {
			utgardButton.UpdateUtgard(BDYC2,0);
		} if (map.get(buttonBDYD).equals(0)){
			utgardButton.UpdateUtgard(BDYC2,1);
		}
	} if (address.equals(buttonZDSD) && map.get(buttonZDSD)!=null  ) {
		 if (map.get(buttonZDSD).equals(1)) {
				utgardButton.UpdateUtgard(ZDSD2,0);
	   } if (map.get(buttonZDSD).equals(0)){
				utgardButton.UpdateUtgard(ZDSD2,1);
	   }
	} if (address.equals(buttonQD) && map.get(buttonQD)!=null  ) {
		 if (map.get(buttonQD).equals(0)){
				utgardButton.UpdateUtgard(KYJQD2,1);
	   }
	} if (address.equals(buttonTZ) && map.get(buttonTZ)!=null  ) {
		 if (map.get(buttonTZ).equals(0)){
				utgardButton.UpdateUtgard(KYJTZ2,1);
	   }
	}
	  
  }
  
  @RequestMapping("compressorCC")
  public void UpdateButton3(@RequestBody Map<String,Object> map){
	  String address=null;
	  for (String string : map.keySet()) {
		  address=string;
	}		 	
	 if (address.equals(buttonBDYD) && map.get(buttonBDYD)!=null ) {	
		  if (map.get(buttonBDYD).equals(1)) {
			utgardButton.UpdateUtgard(BDYC3,0);
		} if (map.get(buttonBDYD).equals(0)){
			utgardButton.UpdateUtgard(BDYC3,1);
		}
	} if (address.equals(buttonZDSD) && map.get(buttonZDSD)!=null  ) {
		 if (map.get(buttonZDSD).equals(1)) {
				utgardButton.UpdateUtgard(ZDSD3,0);
	   } if (map.get(buttonZDSD).equals(0)){
				utgardButton.UpdateUtgard(ZDSD3,1);
	   }
	} if (address.equals(buttonQD) && map.get(buttonQD)!=null  ) {
		 if (map.get(buttonQD).equals(0)){
				utgardButton.UpdateUtgard(KYJQD3,1);
	   }
	} if (address.equals(buttonTZ) && map.get(buttonTZ)!=null  ) {
		 if (map.get(buttonTZ).equals(0)){
				utgardButton.UpdateUtgard(KYJTZ3,1);
	   }
	}
  }
  
  
  
}
