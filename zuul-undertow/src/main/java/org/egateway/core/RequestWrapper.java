package org.egateway.core;

import java.util.Map;

/**
 * request wrapper
 */
public interface RequestWrapper {
	/**
	 * get the detail response data by wrap
	 * @return
	 */
	Object getRequest();
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
