
public class RCMFactory extends GeneralFactory{
	@Override
	public  Machine createMachine() {
		return new RecycleMachine();
	}
	@Override
	public  View createView() {
		return new RecycleMachineView();
	}
}
