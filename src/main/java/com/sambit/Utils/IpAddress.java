package com.sambit.Utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class IpAddress {

	public String getClientIpAddr(HttpServletRequest request) {
		String ip = "";
		try {
			ip = request.getHeader("X-Forwarded-For");
			if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} catch (Exception e) {
		}
		return ip;
	}

	public String getClientIpAddr1(HttpServletRequest request) {
		String[] headersToCheck = {
				"X-Forwarded-For",
				"Proxy-Client-IP",
				"WL-Proxy-Client-IP",
				"HTTP_CLIENT_IP",
				"HTTP_X_FORWARDED_FOR"
		};

		for (String header : headersToCheck) {
			String ip = request.getHeader(header);
			if (ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}

		return request.getRemoteAddr();
	}


}
