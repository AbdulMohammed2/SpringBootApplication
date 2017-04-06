package com.example.hello.test;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev") // FIXME
@ContextConfiguration(classes = { PojoConfiguration.class }, initializers = ConfigFileApplicationContextInitializer.class)
public class PojoTest {

    @Autowired
    private Pojo myPojo;

    @Value("${my.pojo.name}") String name;

    @Autowired
    private ConfigurableApplicationContext c;
    
   // @Value("#{${iassconfig.mysettings.myInfo}}")
    //private Map<String,String> mymaps;

    @Autowired
    private Environment env;
    
    //@Value("${myInfo}")  
	//private Map<String, String> gwservicesgarolesmappings;

    @Test
    public void testValue() {
        String value = c.getEnvironment().getProperty("my.pojo.name");
        String property = env.getProperty("my.pojo.name");
        System.out.println("value via appContext:Â " + value);
        System.out.println("value via env       : " + property);
        System.out.println("value via injection : " + name);
        
        mymap1Iterate(myPojo.getMyInfo());
        myPojo.getMapProp();
        mymap2Iterate(myPojo.getMysettings());
        Assert.assertEquals(myPojo.getName(), "suboortest");
    }
    
    public void mymap1Iterate(Map<String,String> test)
    {
    	test.forEach((k,v) -> System.out.println("key is :"+k+" Value is  "+v));
    	//mymaps.forEach((k,v) -> System.out.println("key is :"+k+"Value is"+v));
    }
	
    public void mymap2Iterate(Map<String,Map<String,String>> test)
    {
    	test.forEach((k,v) -> {	
    	System.out.println("key is :"+k+" Value is"+v);
    	v.forEach((k1,v1) -> System.out.println("key 1 is :"+k1+" Value is  "+v1));
    	});
    	//mymaps.forEach((k,v) -> System.out.println("key is :"+k+"Value is"+v));
    }
}

