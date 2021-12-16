package com.crud_jsf.managedBeans.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.core.Request;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.crud_jsf.model.GamesModel;
import com.crud_jsf.model.ImagePath;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource.Builder;

@ManagedBean
public class ImageApi {
	
	private static final Logger logger = LoggerFactory.logger(ImageApi.class);
	
	public String getImage(String imageName) throws IOException, InterruptedException {
		
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI?q="+imageName.replaceAll(" ", "%20")+"&pageNumber=1&pageSize=10&autoCorrect=true"))
//				.header("x-rapidapi-key", "f27c262c26msh112560fefd80c61p1f7795jsnbccc45c1956d")
//				.header("x-rapidapi-host", "contextualwebsearch-websearch-v1.p.rapidapi.com")
//				.method("GET", HttpRequest.BodyPublishers.noBody())
//				.build();
//		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		String json = response.body();
//		Gson gson = new Gson();
//		ImagePath img = gson.fromJson(json, ImagePath.class);
//		
//		if(img.getValue() == null) {	
//			return "https://drive.google.com/thumbnail?id=1gipZ0jiczZXdB5gWlVm0gZa6oTsrGoG6";
//			}
		
		
		String url_serarch = "https://www.google.com/search?q="+imageName+"+capa&tbm=isch&hl=pt-BR&tbs=isz:l&oq="+imageName+"+capa&gs_lcp=CgNpbWcQA1AAWABgAGgAcAB4AIABAIgBAJIBAJgBAKoBC2d3cy13aXotaW1n&sclient=img&ei=8SW5YbaHEoSL0Abt4IW4Dg&bih=881&biw=1730&rlz=1C1GCEA_enBR868BR868&hl=pt-BR";
		
		String imagem = null;
		
		Document doc = Jsoup.connect(url_serarch).get();
		
		Elements imgs = doc.getElementsByTag("a");
		
		List<Elements> imgss = new ArrayList<Elements>();
		
		imgs.forEach(i -> {
			imgss.add(i.getElementsByTag("img"));
		});
		
		
		for(Elements element : imgss) {
			if( element.attr("data-src").contains("https://encrypted-tbn0") && Integer.parseInt(element.attr("width")) > 299 ) {
				imagem = element.attr("data-src");
				break;
			}
		
			 
			if(imagem != " " && imagem != null && imagem != "") {
				break;
			}
		}
		
		logger.info("SETANDO IMAGENS...");
		return imagem;
		
		
	}
}
