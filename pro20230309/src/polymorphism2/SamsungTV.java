package polymorphism2;

public class SamsungTV implements TV{

	@Override
	public void turnOn() {
		System.out.println("SamsungTV....전원켠다");
	}

	@Override
	public void turnOff() {
		System.out.println("SamsungTV....전원끈다");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV....소리 올린다");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV....소리 내린다");
		
	}
}
