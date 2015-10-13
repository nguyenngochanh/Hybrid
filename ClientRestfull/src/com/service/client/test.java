package com.service.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class test {
	public static void main(String[] args) {
		try {
			String urlString = "https://dky365.sharepoint.com/portals/community/pVid/IMG_2052.MOV";
			URL url = new URL(urlString);
			InputStream is = url.openStream(); 
			HttpURLConnection huc = (HttpURLConnection)url.openConnection();
			int size = huc.getContentLength();
			 if(huc != null){
	              String fileName = "test.mp4";
	              String storagePath="D:/";
	 
	              File f = new File(storagePath,fileName);
	 
	              FileOutputStream fos = new FileOutputStream(f);
	              byte[] buffer = new byte[1024];
	              int len1 = 0;
	              if(is != null){
	                 while ((len1 = is.read(buffer)) > 0) {
	                       fos.write(buffer,0, len1);   
	                 }
	                 System.out.println("done");
	              }
	              if(fos != null){
	                 fos.close();
	              }
	          }  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
