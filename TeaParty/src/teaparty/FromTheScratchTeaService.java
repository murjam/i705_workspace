package teaparty;

public class FromTheScratchTeaService implements TeaService {

	@Override
	public Tea makeTea() {
		Water water = new Water();
		Boiler boiler = new Boiler();
		boiler.boil(water);
		Tea tea = new Tea(water);
		return tea;
	}
	
}