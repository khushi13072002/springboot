package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  TestAPIController 
{
	
	//scrapes all data
	 @CrossOrigin
     @RequestMapping(value = "getAllPhone" , method = RequestMethod.GET)
     public ArrayList<el> getAllPhone(){
         try {
             return ser1.doGet();
             //return TestAPIController.convertString(lstEL);
             // return TestAPIController.sendGET();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }
    
     //returns when brand model is specified..
	@CrossOrigin
	@RequestMapping(value = "getPhoneInfo" , method = RequestMethod.GET)
    public ArrayList<el> getPhoneInfo(@RequestParam  String brand){		
        System.out.println("BRAND :: "+brand);
      //  System.out.println("Model :: "+model);
        
       
       try
       {
    	   ArrayList<el> lst=ser1.doGet();
        	
    	  
    	   
            return filterWithBrandBame(lst,brand);
            
            
            //return TestAPIController.convertString(lstEL);
            // return TestAPIController.sendGET();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    
    //runs when brand and models are specified..
    @CrossOrigin
	@RequestMapping(value = "getPhoneInfoWithCered" , method = RequestMethod.GET)
    public ArrayList<el> getPhoneInfoWithCered(@RequestParam  String brand,@RequestParam String model){
        System.out.println("BRAND :: "+brand);
        
      //  System.out.println("Model :: "+model);
       
       try
       {
    	   ArrayList<el> lst=ser1.doGet();
        	
    	  
    	   
          
            return filterWithBrandNModelName(lst,model,brand);
            
            //return TestAPIController.convertString(lstEL);
            // return TestAPIController.sendGET();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        
    }
    
    //return list of selected brand and model name
    public static ArrayList<el> filterWithBrandNModelName(ArrayList<el> lst , String model , String brand){
        ArrayList<el> resultantLst = new ArrayList<el>();
        
        for(el ele : lst){
            if(ele.getTitle().contains(brand) && ele.getTitle().equalsIgnoreCase(model)){
                resultantLst.add(ele);
  
            }
        }
        return resultantLst;
    }

    //returns list of selected brand..
	public static  ArrayList<el> filterWithBrandBame(ArrayList<el> lst , String brand){
        ArrayList<el> resultantLst = new ArrayList<el>();
        for(el ele : lst){
            if(ele.getTitle().contains(brand)){
                resultantLst.add(ele);
            }
        }
        return resultantLst;
    }

    private String getAllPhoneInfo(){
    	
        // scrapping logic here 
        return null;
    }

	/*
	 * private static String sendGET() throws IOException { URL obj = new URL(
	 * "https://notes-salesforce-default-rtdb.firebaseio.com/.json?auth=gQHPosmt6fPIReF4BYATFaaF9yugtfLc3TJLPYPS"
	 * ); HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 * con.setRequestMethod("GET"); int responseCode = con.getResponseCode();
	 * System.out.println("GET Response Code :: " + responseCode); if (responseCode
	 * == HttpURLConnection.HTTP_OK) { // success BufferedReader in = new
	 * BufferedReader(new InputStreamReader( con.getInputStream())); String
	 * inputLine; StringBuffer response = new StringBuffer();
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * in.close();
	 * 
	 * // print result
	 * 
	 * return response.toString(); } else {
	 * System.out.println("GET request not worked"); return null; }
	 * 
	 * }
	 */
    
    
}