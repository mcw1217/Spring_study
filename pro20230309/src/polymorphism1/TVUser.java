package polymorphism1;

public class TVUser {
	public static void main(String [] args)
	{
//		SamsungTV tv = new SamsungTV();
//		tv.turnOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.turnOff();
//	
		LgTV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeOff();
		tv.powerOff();
		
	}
}
