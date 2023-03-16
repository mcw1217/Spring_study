package polymorphism4;

import org.springframework.stereotype.Component;

@Component
public class SonySpeaker implements Speaker{

	public SonySpeaker()
	{
		System.out.println("SonySpeaker 생성됨");
	}
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker...소리 높임");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker...소리 줄임");
		
	}

}
