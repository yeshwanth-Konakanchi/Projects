
package com.crmindz.bcjMay2017.cxfDemo;

import javax.jws.WebService;

@WebService(endpointInterface = "com.crmindz.bcjMay2017.cxfDemo.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

