package com.neuedu.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.pojo.UserEntity;

public class DataUtils {
	
	public static String readData(String fileName) {
		StringBuffer data=new StringBuffer();
		  String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+fileName+".txt";
		  try {
				path = URLDecoder.decode(path, "UTF-8");
			 } catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			 }
		  File file=new File(path);
		  try {
		       if(!file.exists())
			    file.createNewFile();
		       BufferedReader br=new BufferedReader(new FileReader(file));
		       String s=br.readLine();
		       while(s!=null) {
		    	   data.append(s+"/");
		    	   s=br.readLine();
		       }
		       br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   return data.toString();
	}
	
	public static void writeData(String fileName,String json) throws IOException {
		  String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+fileName+".txt";
		  try {
			path = URLDecoder.decode(path, "UTF-8");
		 } catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 }
		  File file=new File(path); 
		  try {
			   if(!file.exists())
			   {
				   file.createNewFile();
			   }
			   BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
			   bw.write(json);
			   bw.newLine();
			   bw.flush();
			   bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void deleteDataFile(String fileName) {

		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + fileName + ".txt";
		try {
			path = URLDecoder.decode(path,"utf-8");
		}catch(UnsupportedEncodingException  e) {
			e.printStackTrace();
		}
		File file = new File(path);
		file.delete();
	}

	public static void creatFile(String fileName) throws IOException {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + fileName + ".txt";
		  try {
			path = URLDecoder.decode(path, "UTF-8");
		 } catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 }
		  File file=new File(path);
		  file.createNewFile();
	}
	

	
}

