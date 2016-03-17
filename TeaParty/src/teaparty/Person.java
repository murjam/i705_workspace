package teaparty;

public class Person {
	
	TeaService teaService;
	MessageService messageService;

	public void drinkTea() {
		
		Tea tea = teaService.makeTea();
		
		// TODO drink up tea somehow
	}
	
	public void sendMessage(String title, String message) {
		messageService.sendMessage(title, message);
	}
	
}
