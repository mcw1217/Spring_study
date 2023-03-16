package polymorphism4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv1")
public class SamsungTV implements TV{

	@Autowired
	@Qualifier("sonySpeaker")
	private Speaker speaker;
	private int price;
	private String model;
	
	public SamsungTV()
	{
		System.out.println("SamsungTV(1) 객체 생성");
	}
	
	public SamsungTV(Speaker speaker)
	{
		this.speaker = speaker;
		System.out.println("SamsungTV 객체 생성");
	}
	
	public SamsungTV(Speaker speaker, int price, String model)
	{
		this.speaker = speaker;
		this.price = price;
		this.model = model;
		System.out.println("SamsungTV(Speaker, price, model) 객체 생성:" + model +","+ price);
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
		System.out.println("SamsungTV....전원켠다");
	}

	@Override
	public void turnOff() {
		System.out.println("SamsungTV....전원끈다");
		
	}

	@Override
	public void volumeUp() {
//		System.out.println("SamsungTV....소리 올린다");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
//		System.out.println("SamsungTV....소리 내린다");
		speaker.volumeDown();
		
	}
}
