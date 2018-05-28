package com.urlshortener.framework;

import java.util.zip.CRC32;

/**
*
* <p>
* <b>Description: </b>
* Responsible to generate the longurl hash using java crc32 hash function 
* </p>
*
* @since 24/05/2018 
*
* @version 1.0.0
* @author juliana.barbosa
*
*/
public final class ShortURLCRC32 {
	
	private ShortURLCRC32(){}
	
	public static String encode(String longUrl) {
		CRC32 crc32 = new CRC32();
		crc32.update(longUrl.getBytes());
		return Long.toHexString(crc32.getValue()) ;
	}

}
