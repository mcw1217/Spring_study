package polymorphism4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser3 {

	public static void main(String[] args) {

		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext3.xml");
		
		TV tv = (TV)factory.getBean("tv1");
		tv.turnOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.turnOn();
//		TV tv = (TV)factory.getBean("tv2");
//		tv.turnOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.turnOn();

	}

}
