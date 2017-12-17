package org.egateway.core.configure;

import java.io.FileNotFoundException;

public interface Configure<T> {
	/**
	 * @param file
	 * @throws FileNotFoundException 
	 */
	void load(String file) throws FileNotFoundException;
	/**
	 * @param name
	 * @return
	 */
	<C> C getProperty(String name, Class<C> clazz);
	/**
	 * @return
	 */
	T getProperties();
}
