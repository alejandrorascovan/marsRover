package main;

import main.enumC;

public class Rover {
	private Compass compass;
	private int x;
	private int y;
	private static int xLimit;
	private static int yLimit;
	private String name;

	private static enum Compass{
		N, W, S, E;				
	}

	private static enum Commands {
		L,R,M;

		private static boolean contains(String test) {

			for (Commands c : Commands.values()) {
				if (c.name().equals(test)) {
					return true;
				}
			}
			return false;
		}
	}

	private Boolean isBounded(){
		switch (this.compass){
		case N:
			if (this.y==Rover.yLimit)
				return true;
			break;
		case W:
			if (this.x==0)
				return true;
			break;
		case S:
			if (this.y==0)
				return true;
			break;
		case E:
			if (this.x==Rover.xLimit)
				return true;
			break;
		}
		return false;
	}
	
	private void talk (String words){
		System.out.println(this.name + " says: " + words);
	}
	
	public Rover(int x, int y, String compass){
		this(x,y,compass,"Unnamed");
	}
	
	public Rover (int x, int y, String compass, String name){
		
		this.x = x;
		this.y = y;
		this.compass = Compass.valueOf(compass);
		this.name = name;
	}
	public void setPosition (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int[] getPosition (){
		int[] pos = {this.x, this.y};
		return pos;
	}	

	public static void setLimits (int xLimit, int yLimit){
		Rover.xLimit = xLimit;
		Rover.yLimit = yLimit;
	}
	

	public static int[] getLimits(){
		int[] limits = {Rover.xLimit, Rover.yLimit};
		return limits;
	}

	public void turnLeft(){
		switch (this.compass){
		case N:
			this.compass=Compass.W;
			break;
		case W:
			this.compass=Compass.S;
			break;
		case S:
			this.compass=Compass.E;
			break;
		case E:
			this.compass=Compass.N;
			break;

		}		
	}

	public void turnRight(){
		switch (this.compass){
		case N:
			this.compass=Compass.E;
			break;
		case W:
			this.compass=Compass.N;
			break;
		case S:
			this.compass=Compass.W;
			break;
		case E:
			this.compass=Compass.S;
			break;

		}		
	}

	public void move(){
		if (isBounded()){
			this.talk("I can't move any farther!");
		}else{
			switch (this.compass){
			case N:
				this.y=this.y+1;
				break;
			case W:
				this.x=this.x-1;
				break;
			case S:
				this.y=this.y-1;
				break;
			case E:
				this.x=this.x+1;
				break;

			}
		}
	}
	
	public void executeCommand (String command){
		if (Commands.contains(command) && command.length()==1){		
			switch (Commands.valueOf(command)){
			case L:
				this.turnLeft();
				break;
			case R:
				this.turnRight();
				break;
			case M:
				this.move();
				break;
			}
		}else{
			this.talk ("I dont know the " + command + " command!");
		}
	}

	public void feed(String input){
		for (int i = 0, n = input.length(); i<n; i++){
			String str = input.substring(i,i+1);
			this.executeCommand(str);
		}
		this.talk(this.x + " " + this.y + " " + this.compass.toString());
	}

}

