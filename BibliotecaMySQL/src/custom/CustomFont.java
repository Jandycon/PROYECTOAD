package custom;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomFont {
	
    private static final String CADENAF=System.getProperty("user.dir")+"/fonts/";
    private static final String FONT1 ="Comic1.ttf";
    private static final String FONT2 ="HappySchool.ttf";
    private static final String FONT3 ="PonyMaker.ttf";
    private static final String FONT4 ="LynaKety.ttf";
    private static final String FONT5 ="Aste.ttf";
    private static final String FONT6 ="Handy.ttf";
    private static final String FONT7 ="varsity.ttf";
    private static final String FONT8 ="Timeless.ttf";    
    
	public Font Comic1(int fontSize) {
    	return crearFuente(FONT1,fontSize);
	}
	
	public Font HappyFont(int fontSize) {
		return crearFuente(FONT2,fontSize);
	}
	
	public Font PonyMaker(int fontSize) {
		return crearFuente(FONT3,fontSize);
	}
	
	public Font LynaKety(int fontSize) {
		return crearFuente(FONT4,fontSize);
	}
	
	public Font Aste(int fontSize) {
		return crearFuente(FONT5,fontSize);
	}
	
	public Font Handy(int fontSize) {
		return crearFuente(FONT6,fontSize);
	}
	
	public Font Varsity(int fontSize) {
		return crearFuente(FONT7,fontSize);
	}
	
	public Font Timeless(int fontSize) {
		return crearFuente(FONT8,fontSize);
	}
	
	public Font crearFuente(String fuente, int textSize) {		
		Font ttfBase = null;
	    Font telegraficoFont = null;
	    InputStream myStream = null;
		try {
		    //create the font to use. Specify the size!
			myStream = new BufferedInputStream(new FileInputStream(CADENAF+fuente));
            ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
            telegraficoFont = ttfBase.deriveFont(Font.PLAIN, textSize);  
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}	
		return telegraficoFont;
	}
	
}
