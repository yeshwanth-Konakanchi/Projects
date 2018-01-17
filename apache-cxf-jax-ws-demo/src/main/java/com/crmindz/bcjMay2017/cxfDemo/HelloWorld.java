package com.crmindz.bcjMay2017.cxfDemo;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}

