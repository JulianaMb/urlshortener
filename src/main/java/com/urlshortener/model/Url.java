package com.urlshortener.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
*
* <p>
* <b>Description: </b>
* 
* Url class 
* id = shortUrl is the id
* longUrl = the orignal url
* acesses = stores a date when the shorturl is created and every time the short link is used
* 
* Acesses is necessary to 2 basic informations about urls: 
* 1 count the times the shorturl was acessed 
* 2 doing a group we can have the dates with more acesses  
* </p>
*
* @since 24/05/2018 
*
* @version 1.0.0
* @author juliana.barbosa
*
*/
@Document(collection = "urls")
public class Url {
	
	@Id
	private String id; //MongoDB uses strings as Ids	
	private String longUrl;
	private List<LocalDateTime> acesses = new ArrayList<LocalDateTime>();
		
	public Url() {
		
	}
	
	public Url(String longUrl, String id, LocalDateTime dataAcess) {		
		this.longUrl = longUrl;		
		this.id = id;
		setNewAcess(dataAcess);
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public List<LocalDateTime> getAcesses() {
		return acesses;
	}

	public void setAcess(List<LocalDateTime> acesses) {
		this.acesses = acesses;
	}
	
	public void setNewAcess(LocalDateTime acess) {
		this.acesses.add(acess);
	}
			

}
