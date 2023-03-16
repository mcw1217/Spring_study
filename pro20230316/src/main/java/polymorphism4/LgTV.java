package polymorphism4;

public class LgTV implements TV{

	private Speaker speaker;
	private int price;
	private String model;
	
	public LgTV()
	{
		System.out.println("lG(1)");
	}
	public LgTV(Speaker speaker)
	{
		this.speaker = speaker;
		System.out.println("LgTV객체 생성됨");
	}
	
	public LgTV(Speaker speaker, int price, String model)
	{
		this.speaker = speaker;
		this.price = price;
		this.model = model;
		System.out.println("LgTV(Speaker, price, model) 객체 생성:" + model +","+ price);
	}
	
	
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

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
//		System.out.println("LgTV....소리 올린다");
		speaker.volumeUp();
		
		
	}

	@Override
	public void volumeDown() {
//		System.out.println("LgTV....소리 내린다");
		speaker.volumeDown();
		
	}
	
}
