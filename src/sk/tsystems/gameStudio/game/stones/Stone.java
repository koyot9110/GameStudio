package sk.tsystems.gameStudio.game.stones;

import sk.tsystems.gameStudio.game.stones.consoleui.ConsoleUI;

public class Stone implements Runnable{
	
	@Override
	public void run(){
		new ConsoleUI().run();
	}
}
