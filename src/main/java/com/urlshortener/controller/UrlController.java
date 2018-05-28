package com.urlshortener.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.urlshortener.model.Url;
import com.urlshortener.service.UrlService;

@RestController	
@RequestMapping("/")
public class UrlController {
	
	private UrlService urlService;
	
	public UrlController(UrlService urlService) {
		this.urlService = urlService;
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
	@GetMapping("all")
	public List<Url> getAll(){
		List<Url> urls = this.urlService.getAll();
		
		return urls;
	}
	
	/**
	 * 1 - Check if the URI is valid
	 * 2 - Insert a new shorturl -> longurl and stores the create date 
	 * 3 - If the shorturl already exists return the shorturl 
	 * 
	 * @author juliana.barbosa
	 *
	 * @param longUrl
	 * @return the shorturl or Invalid URL if the URI is invalid
	 */		
	@PutMapping()
	public String insert(@RequestBody String longUrl){
		String shortUrl =  this.urlService.insert(longUrl);
		if (shortUrl != null) {
			return shortUrl;
		}else {
			return "Invalid URL";
		}
					
	}		
	
	@GetMapping("{id}")
	public void redirect(@PathVariable("id") String id, HttpServletResponse resp) throws Exception {
        final String url = this.urlService.getById(id);
        if (url != null)
            resp.sendRedirect(url);
        else
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);		
	}
	
	@GetMapping("getCountAcesses/{id}")
	public String getCountAcesses(@PathVariable("id") String id) {
		return this.urlService.getCountAcesses(id);
	}	

}
