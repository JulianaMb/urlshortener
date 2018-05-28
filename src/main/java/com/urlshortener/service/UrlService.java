package com.urlshortener.service;

import java.util.List;

import com.urlshortener.model.Url;

public interface UrlService {
	
	public List<Url> getAll();
	
	public String getById(String shortUrl);
	
	public String insert(String longUrl);
	
	public String getCountAcesses(String shortUrl);

}
