package com.urlshortener.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlshortener.data.UrlRepository;
import com.urlshortener.framework.ShortURLCRC32;
import com.urlshortener.framework.URLUtils;
import com.urlshortener.model.Url;

@Service("urlService")
public class UrlServiceImpl implements UrlService {
	
	@Autowired
	private UrlRepository urlRepository;
	
	public UrlServiceImpl(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;
	}

	/**
	 *
	 * Get all the saved urls 
	 *
	 * @author juliana.barbosa
	 *
	 * @param 
	 * @return List<Url>
	 */	
	@Override
	public List<Url> getAll() {
		List<Url> urls = this.urlRepository.findAll();
		return urls;
	}

	/**
	 * 1 - Check if the URI is valid, if it is invalid return null
	 * 2 - Insert a new shorturl -> longurl and stores the create date 
	 * 3 - If the shorturl already exists return the shorturl 
	 * 
	 * @author juliana.barbosa
	 *
	 * @param longUrl
	 * @return the shorturl or null if the URI is invalid
	 */		
	@Override
	public String insert(String longUrl) {
		if (URLUtils.isURI(longUrl)){		
			String id = ShortURLCRC32.encode(longUrl.trim());
			try {					
				LocalDateTime data = LocalDateTime.now();
				return this.urlRepository.insert(new Url(longUrl, id, data)).getId();			
			}
			catch (org.springframework.dao.DuplicateKeyException e) {
				return id;									
			}
		}
		else {
			return null;
		}
	}

	/**	  
	 * 1 - Insert the acess date in url->acesses collection  
	 * 3 - return the original url 
	 * 
	 * @author juliana.barbosa
	 *
	 * @param shortUrl
	 * @return the longUrl or null 
	 */		
	@Override
	public String getById(String shortUrl) {	
		try {
			Url url = getByIdDB(shortUrl);
			LocalDateTime data = LocalDateTime.now();
			url.setNewAcess(data);
			
			return this.urlRepository.save(url).getLongUrl();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	
	/**	  
	 * 1 - get the Url data by the shortUrl
	 * 
	 * @author juliana.barbosa
	 *
	 * @param shortUrl
	 * @return Url 
	 */		
	private Url getByIdDB(String shortUrl) {
		return this.urlRepository.findById(shortUrl).get();
	}

	/**	  
	 * 1 - number of times the shorturl were acessed
	 * 
	 * @author juliana.barbosa
	 *
	 * @param shortUrl
	 * @return count 
	 */		
	@Override
	public String getCountAcesses(String shortUrl) {
		Url url = getByIdDB(shortUrl);
		
		return String.valueOf(url.getAcesses().size());
	}

}
