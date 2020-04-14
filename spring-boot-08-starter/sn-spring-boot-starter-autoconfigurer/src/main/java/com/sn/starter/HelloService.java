package com.sn.starter;

public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloSn(String name){
        return helloProperties.getPrefix()+"-"+name +"-"+helloProperties.getSuffix();
    }
}
