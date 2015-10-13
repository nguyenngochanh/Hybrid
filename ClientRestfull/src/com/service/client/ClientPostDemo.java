package com.service.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;

public class ClientPostDemo {

	public static void main(String[] args) throws HttpException, IOException, URISyntaxException {
//		try {
//			HttpClient httpClient = HttpClientBuilder.create().build();
//			HttpPost postRequest = new HttpPost(
//					"http://localhost:8080/ServiceDemo/api/hello/getPhoto");		
//			String name = "HanhNNNNN";
//			StringEntity input = new StringEntity(name);
//			input.setContentType("text/plain");
//			postRequest.setEntity(input);
//			HttpResponse response = httpClient.execute(postRequest);
//
//			if (response.getStatusLine().getStatusCode() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//						+ response.getStatusLine().getStatusCode());
//			}
//
//			BufferedReader br = new BufferedReader(
//					new InputStreamReader((response.getEntity().getContent())));
//
//			String output;
//			System.out.println("Output Post from Server .... \n");
//			while ((output = br.readLine()) != null) {
//				System.out.println(output);
//			}
//
//
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		} catch (ExceptionInInitializerError e) {
//
//			e.printStackTrace();
//
//		}
		method();
	}
// TODO upload file to server
	public static void method() throws HttpException, IOException, URISyntaxException {
	    String url = "http://localhost:8080/ServiceDemo/api/hello/upload";  //Your service URL
	    String fileName = "D:/abc.txt"; //file name to be uploaded
	    File file = new File(fileName);
	    HttpClient httpClient = HttpClientBuilder.create().build();
	    
	    HttpPost httppost = new HttpPost(url);
	    FileBody fileContent = new FileBody(file);
	    HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("file", fileContent)
                .build();


        httppost.setEntity(reqEntity);

        System.out.println("executing request " + httppost.getRequestLine());
	    

	    HttpResponse response = httpClient.execute(httppost);
	    HttpEntity resEntity = response.getEntity();
	    
	    
	    
	    System.out.print("abcdef:" + resEntity);
	}
}
