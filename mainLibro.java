import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
public class mainLibro {
	 public static void main(String[] args) {
		 String genero =ingresoGenero();
		 Biblioteca biblioteca=generarBiblioteca();
		 System.out.println();
		 

		if(biblioteca.hasGenero(genero)){
			leerArray(biblioteca.getLibrosdeArbol(genero));
			generarCsvWritter(biblioteca,genero);
		}else 
			System.out.println("no existe categoria solicitada");
		
		
	
		
		 
	 }
	       
	 public static void leerArray(LinkedList<Libro> lib){
		 for(int i=0;i<lib.size();i++){
			 System.out.print(lib.get(i).getNombre());
		 }
	 }
	 //genera la biblioteca de libros
	 public static Biblioteca generarBiblioteca(){
		 String csvFile = "dataset1.csv";
	        String line = "";
	        String cvsSplitBy = ",";
	        Biblioteca libros = new Biblioteca();

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        	boolean primera = true;
	            while ((line = br.readLine()) != null) {
	            	if (primera) {
	            		primera = false;
	            	} else {
		            	//items corta el csv
		                LinkedList<String> items = new LinkedList(Arrays.asList(line.split(cvsSplitBy)));
		                //corta los generos
		                //carga en arraylist los generos
		                LinkedList<String> gene= new LinkedList(Arrays.asList(items.get(3).split(" ")));
		                //carga en el libro
		                Libro l= new Libro(items.get(0),items.get(1),items.get(2),gene);
		                //carga en la biblioteca
		                libros.addLibro(l);
	            	}
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	      return libros;
	 }

	 public static void generarCsvWritter(Biblioteca biblioteca, String genero){
		 BufferedWriter bw = null;
			try {
				File file = new File("salida1.csv");
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file);
				bw = new BufferedWriter(fw);

				// Escribo la primer linea del archivo
				
				//prueba
				LinkedList<Libro> mostrar= biblioteca.getLibrosdeArbol(genero);
				for (int i=0;i<mostrar.size();i++){
					bw.write(mostrar.get(i).getNombre());
					bw.newLine();
				}
				

			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				try {
					if (bw != null)
						bw.close();
				} catch (Exception ex) {
					System.out.println("Error cerrando el BufferedWriter" + ex);
				}
			}
	 }

public static String ingresoGenero() {
	String genero =" ";
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println ("Ingrese genero: ");
			genero = entrada.readLine();
		}
		catch (Exception exc ) {
			System.out.println( exc );
		}
	
	return genero;
}
}
