package org.smart4j.chapter2.proxy;

/**
 * Created by Bravowhale on 2017/7/11.
 */
public interface Proxy {
    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain)throws Throwable;
}
