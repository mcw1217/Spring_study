package polymorphism3;

public class TvUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory = new BeanFactory();
//		TV tv = (TV)factory.getBean("lg");
		TV tv = (TV)factory.getBean(args[1]);
		tv.turnOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.turnOn();

	}

}
