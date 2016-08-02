package sk.tsystems.gamestudio.game.memorygame;

public class Tile {
	
	public enum State{
		CLOSED,
		OPEN
	}
	
	private State state = State.CLOSED;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
