package com.service.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.arnx.jsonic.JSON;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.service.entity.Photo;

public class ClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			//DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet getRequest = new HttpGet(
					"http://localhost:8080/ServiceDemo/api/hello/getPhoto");
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader((response.getEntity().getContent())));

			String output = null;
				
					
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				Photo photo = JSON.decode(output, Photo.class);
				System.out.println("name:" + photo.getName() +"\n" + "path:"+ photo.getPath());
			}

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
