/**
 * 
 */
package com.sambit.CustomException;

/**
 * @author ipsita.shaw
 *
 */
public class CryptoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CryptoException() {
    }
 
    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
