package model;

public abstract class TestGame extends AbstractGame{

	private String testNote;

	
	
	public TestGame() {
		super();
	}

	public String getTestNote() {
		return testNote;
	}

	public void setTestNote(String testNote) {
		this.testNote = testNote;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "test";
	}
	
	
}
