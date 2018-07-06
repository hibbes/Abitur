import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Abitur {

	private static int[] kernfaecher = new int[10];
	private static int[] pflichtfaecher = new int[10];
	
	static String[][] array = new String[10][];
	
	
	public static void main(String[] args) {
		importFile();
		System.out.println(durchschnitt(kernfaecher));
		System.out.println(durchschnitt(pflichtfaecher));
		System.out.println(durchschnittgesamt(kernfaecher, pflichtfaecher));
		
		
		System.out.println(toString(array));

	}
	
	private static double durchschnitt(int[] punkte){
		double durchschnitt = 0;
		int teiler=0;
		
		for(int i=0; i<punkte.length; i++){
			if(punkte[i]!=0){
				durchschnitt=durchschnitt+punkte[i];
				teiler++;
			}
		}
		
		return durchschnitt/teiler;
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

	    for (int i = 0; i<array[0].length; i++){
	    	if(array[0][i]!=null){
	    		kernfaecher[i]= Integer.parseInt(array[0][i]);}
	    }
	    for (int i = 0; i<array[0].length; i++){
	    	if(array[1][i]!=null){
	    		pflichtfaecher[i]= Integer.parseInt(array[1][i]);}
	    }
	   	    
	} // end importFile


	public static String toString(String array[][]){
		
		String Noten=null;
		
				
		for (int i=0; i<2; i++){
			if(i==0){Noten = "Kernfächer:\n";}
				else{Noten = Noten+"Pflichtfächer:\n";};
			
			for(int j=0; j<array[i].length;j++){
				Noten = Noten+(array[i][j]+" ");
			}
			Noten = Noten+("\n");
			
		}
		return Noten;
	}
}
