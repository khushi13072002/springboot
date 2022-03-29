package com.example.demo;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class ser1 {
		  
		   
		    public static ArrayList<el> doGet() throws IOException{
		    	ArrayList<el>  lst = new ArrayList<el>(); 
		    	Document doc = Jsoup.connect("https://store.cashify.in/collections/buy-refurbished-smartphones/").get();
		        Elements links = doc.select(".product-container .product");    
		           
		            for(Element link:links){
		            	 el ele = new el();
		                String mLink=link.attr("href");
		                
		                
		                String Title=link.select(".product-text .product-title").text();
		                ele.setTitle(Title);
		               
		             
		                	
		                 
		                String Price=link.select(".product-prices .price--listing .price__regular dd span").text();
		               ele.setPrice(Price.substring(1));
		               System.out.print(Price.substring(1));
		                Element Image=link.select(".product_list_wrap .productimage .product-image").first();
		                String ImageLink=Image.attr("src");
		                
		                System.out.print(ImageLink);
		               ele.setImageLink(ImageLink);
		                String condition = link.select(".rg-div .refurbished").text();
		                System.out.println("MOdel Name: "+Title);
		                System.out.println("Condition is:  "+condition);
		                ele.setcondition(condition);
                        System.out.print(condition);

		                
		                doc=Jsoup.connect("https://store.cashify.in/"+mLink).get();
		                Elements mLinks=doc.select(".details-right-side");
		                
		                
		                
		                for(Element link1:mLinks){
		                    
		                    String Ram=link1.select(".ram-storage .wrapper .selected .option span").text();
		                   System. out.println("Ram is:  "+Ram);

		                    String Color=link1.select(".variants-container p #varColors span").text();
		                   System. out.println("Color is:  "+Color);  
		                   
		                }
		               System. out.println("");
		                    
		                    
		                System.out.println(links.size());
		                lst.add(ele);
		            
		}
		            return lst;
		    }
		  
		}
