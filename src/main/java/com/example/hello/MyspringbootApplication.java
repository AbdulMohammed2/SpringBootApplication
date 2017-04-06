package com.example.hello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

import myspringproject.MyBean;

@SpringBootApplication
@ComponentScan({"myspringproject","com.example.hello"})
public class MyspringbootApplication implements CommandLineRunner{
	
	@Autowired
    private MyBean myBean;
	
	@Autowired
    private PojoConfiguration myConfig;
	
	 @Value("${mycustom}")
	 private String prop;
	 
	 @Value("${iassconfig.getaccess.rolecategory}")
	 private String prop1;
	 
	 private Map<String, String> myInfo = new HashMap<String, String>();


	public static void main(String[] args) {
		//SpringApplication.run(MyspringbootApplication.class, args);
		//System.out.println(serverIp);
		
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MyspringbootApplication.class)
				.properties("spring.config.name:application,application-dev",
						"spring.config.location:classpath:/src/main/resources/")
				.build().run(args);
 
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
 
		System.out.println(environment.getProperty("mycustom"));
		System.out.println(environment.getProperty("my.pojo.name"));
		System.out.println(environment.getProperty("iassconfig.getaccess.rolecategory"));
		
	}


	@Bean
	CommandLineRunner myValues()
	{
		return args -> {System.out.println(myBean.myValue());};
		
	}
	
	//@Bean(initMethod="initialize")
	@Bean
	public ClassicSingleton classicSingleton()
	{
		return  ClassicSingleton.getInstance(prop);
	}
    
	   @Value("#{${iassconfig.settings.mappings}}")
	    private Map<String,String> mymaps;
	   
	  // @Value("#{${iassconfig.settings.gwservicesgarolesmappings}}")  
	  // private Map<String, String> gwservicesgarolesmappings;

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("mycustom"+prop);
		
		System.out.println("mysecond"+myBean.myValue());
		myBean.mymapIterate();
		mymapIterate();
		mymap1Iterate();
		
		System.out.println("mycustom one from yaml : "+prop1);
		
	}
	
	
	public void mymapIterate()
    {
    	mymaps.forEach((k,v) -> System.out.println("key is :"+k+"Value is"+v));
    }
	
	public void mymap1Iterate()
    {
		
		myConfig.pojo().getMyInfo().forEach((k,v) -> System.out.println("key is :"+k+"Value is"+v));
    }
	
	
	/*@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}*/
	
	public Map<String, String> getMyInfo() {
    	System.out.println("myinfo is : " + this.myInfo);
        return this.myInfo;
    }

}
