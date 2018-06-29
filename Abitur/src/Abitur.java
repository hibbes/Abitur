import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Abitur {

	private static int[] kernfaecher = {8,2,10,3,9,11,15,6,9,10};
	private static int[] pflichtfaecher = {8,7,9};
	static String[][] array = new String[10][];
	
	
	public static void main(String[] args) {
		System.out.println(durchschnitt(kernfaecher));
		System.out.println(durchschnitt(pflichtfaecher));
		System.out.println(durchschnittgesamt(kernfaecher, pflichtfaecher));

	}
	
	private static double durchschnitt(int[] punkte){
		double durchschnitt = 0;
		
		for(int i=0; i<punkte.length; i++){
			durchschnitt=durchschnitt+punkte[i];
		}
		
		return durchschnitt/punkte.length;
	}
	
	private static double durchschnittgesamt(int[]kernfaecher, int[] pflichtfaecher){
		int[] alleFaecher = new int[kernfaecher.length + pflichtfaecher.length];
		System.arraycopy(kernfaecher, 0, alleFaecher, 0, kernfaecher.length);
		System.arraycopy(pflichtfaecher, 0, alleFaecher, kernfaecher.length, pflichtfaecher.length);
		
		return durchschnitt(alleFaecher);
	}
	
	static void importFile() {
	    /*
	     * Liest die Datei ein und speichert sie in den String[][] array
	     */
		
	    try{
	    	
	        BufferedReader reader = new BufferedReader(new FileReader("textdatei.txt"));
	        String line;
	        
	        for(int i = 0; (line = reader.readLine()) != null; i++) {
	            array[i] = line.split(" ");
	        }

	        reader.close();

	    } // end try
	    catch(FileNotFoundException ex){
	        System.out.println("File nicht gefunden");
	    } // end catch
	    catch(IOException ex){
	        System.out.println ("Lesefehler");
	    } // end catch
	    catch (IndexOutOfBoundsException ex) {
	        System.out.println("ups, der String[][] array ist zu klein für diese Textfilegroesse");
	        System.out.println("maximal sind "+array.length+" Zeilen moeglich, sonst muss die Groesse von array in Zeile 9 erhoeht werden");
	        System.exit(1);
	    } // end try

	    
	    
	} // end importFile


}
