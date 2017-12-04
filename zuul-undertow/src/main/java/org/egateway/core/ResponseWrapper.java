package org.egateway.core;

import java.util.Map;

/**
 * wrap the response
 */
public interface ResponseWrapper {
	/**
	 * get the detail response data by wrap
	 * @return
	 */
	Object getResponse();
	/**
	 * @return
	 */
	Map<String, String> getHeaders();
	/**
	 * @param header
	 */
	void setHeaders(Map<String, String> header);
	/**
	 * @param data
	 */
	void setBody(byte[] data);
	/**
	 * @return
	 */
	byte[] getBody();
}
