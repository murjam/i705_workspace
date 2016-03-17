package teaparty;

public class BigBowlTeaService implements TeaService {

	private Water lotsOfBoiledWater = new Water();
	private Tea lotsOfTea = new Tea(lotsOfBoiledWater);
	
	@Override
	public Tea makeTea() {
		return lotsOfTea;
	}

}
