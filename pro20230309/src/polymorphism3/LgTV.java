package polymorphism3;

public class LgTV implements TV{

	@Override
	public void turnOn() {
		System.out.println("LgTV....전원켠다");
	}

	@Override
	public void turnOff() {
		System.out.println("LgTV....전원끈다");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV....소리 올린다");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV....소리 내린다");
		
	}
	
}
