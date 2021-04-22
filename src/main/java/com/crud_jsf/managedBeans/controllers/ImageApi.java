package com.crud_jsf.managedBeans.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.core.Request;

import com.crud_jsf.model.GamesModel;
import com.crud_jsf.model.ImagePath;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource.Builder;

@ManagedBean
public class ImageApi {
	
	public String getImage(String imageName) throws IOException, InterruptedException {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI?q="+imageName.replaceAll(" ", "%20")+"&pageNumber=1&pageSize=10&autoCorrect=true"))
				.header("x-rapidapi-key", "f27c262c26msh112560fefd80c61p1f7795jsnbccc45c1956d")
				.header("x-rapidapi-host", "contextualwebsearch-websearch-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		String json = response.body();
		Gson gson = new Gson();
		ImagePath img = gson.fromJson(json, ImagePath.class);
		
		if(img.getValue() == null) {	
			return "https://drive.google.com/thumbnail?id=1gipZ0jiczZXdB5gWlVm0gZa6oTsrGoG6";
			}
		
		return img.getValue().get(1).getUrl();
		
		
	}
}
