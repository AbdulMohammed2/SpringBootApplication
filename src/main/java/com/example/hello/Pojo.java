package com.example.hello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//@ConfigurationProperties(prefix = "my")
//@Component
public class Pojo {
    private final String name;

    public Pojo(final String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pojo{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
    private Map<String, String> myInfo = new HashMap<String, String>();
    private Map<String, String> mapProp = new HashMap<String, String>();
    

    public Map<String, String> getMyInfo() {
    	System.out.println("myinfo is : " + this.myInfo);
        return this.myInfo;
    }
    
    public Map<String, String> getMapProp() {
    	System.out.println("myprop is : " + this.mapProp);
        return this.mapProp;
    }
}
