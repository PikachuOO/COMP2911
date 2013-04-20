
public class DeleteInputs extends Inputs {

	public DeleteInputs(String[] params) {
		super(params);
		this.room = params[2];
	}
	
	public String getRoom() {
		return room;
	}

	@Override
	public User getUser() {
		return super.getUser();
	}

	@Override
	public int getMonth() {
		return super.getMonth();
	}

	@Override
	public int getDate() {
		return super.getDate();
	}

	@Override
	public int getTime() {
		return super.getTime();
	}

	private String room;
}
