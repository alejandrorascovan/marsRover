package main;


enum enumC {
	;
	
	
	private static boolean contains(String test) {

	    for (enumC c : enumC.values()) {
	        if (c.name().equals(test)) {
	            return true;
	        }
	    }

	    return false;
	}
	
}
