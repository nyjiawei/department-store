package com.fjw.provide.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 网络工具
 * @author jiawei
 *
 */
public class HttpUtils {
	
	/**
	 * 获取请求IP地址
	 * @param request 
	 * @return 对方的ip
	 */
	public static String getIpAddress(HttpServletRequest request) { 
	
		String ip = request.getHeader("x-forwarded-for"); 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		  ip = request.getHeader("Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		  ip = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		  ip = request.getHeader("HTTP_CLIENT_IP"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		  ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		} 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getRemoteAddr(); 
		    } 
		return ip; 
	}


}
