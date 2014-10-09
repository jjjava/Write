
package br.com.schumaker.core;

/**
 *
 * @author Hudson Schumaker
 * @param <T>
 */
public interface Pool <T>{
    T aquire();
    void release(T t);
}
