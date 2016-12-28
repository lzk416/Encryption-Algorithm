package com.lzk.gdut.audio.sm;


import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;

public class AESKey {
	
	 public static byte[] initKey() throws Exception{  
	        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
	        kgen.init(128);  
	        SecretKey skey = kgen.generateKey();  
	        return skey.getEncoded();  
	    }  
	public static String getkey() {
			String str=null;
				try {
					byte[] key = AESKey.initKey();
					str =byteToHexString(key);  
				} catch (Exception e) {
					e.printStackTrace();
				}  
			 String key=str.substring(0, 16).replaceAll("a", "A").replace("2", "G").replaceAll("d", "Q").replaceAll("3", "E");
			 return key;
			
	}
	public static String byteToHexString(byte[] bytes){     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < bytes.length; i++) {     
             String strHex=Integer.toHexString(bytes[i]);     
             if(strHex.length() > 3){     
                    sb.append(strHex.substring(6));     
             } else {  
                  if(strHex.length() < 2){  
                     sb.append("0" + strHex);  
                  } else {  
                     sb.append(strHex);     
                  }     
             }  
        }  
       return  sb.toString();     
   }  
}
