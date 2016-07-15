package sk.tsystems.gamestudio.game.stones;

import sk.tsystems.gamestudio.game.stones.consoleui.ConsoleUI;

public class Stone implements Runnable{
	
	@Override
	public void run(){
		new ConsoleUI().run();
	}
}
