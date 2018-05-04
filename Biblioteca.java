
import java.util.LinkedList;


public class Biblioteca {
	private LinkedList<Libro> libros;
	private ArbolString indiceGeneros;
	
	public Biblioteca(){
		libros = new LinkedList<Libro>();
		indiceGeneros=new ArbolString();
	}
	
	public void addLibro(Libro nuevo){
		 libros.add(nuevo);
		 LinkedList<String> generos=nuevo.getGeneros();
		 for(String i:generos){
			
			 ArbolString aux = indiceGeneros.getpos(i);
			 if (aux==null){
				 
				 indiceGeneros.Insert(i);
				
				
				 aux = indiceGeneros.getpos(i);
				 
				 
				 aux.conectarLibro(nuevo);
				 
			 }else{
				
				 aux.conectarLibro(nuevo);
			 }
		 }
	}
	
	public boolean hasGenero(String aux){
		return indiceGeneros.hasElement(aux);
		
	}
	
	public LinkedList<Libro> getLibros() {
		return libros;
	}
	public ArbolString getIndiceGeneros() {
		return indiceGeneros;
	}
	public LinkedList<Libro> getLibrosdeArbol(String genero){
		if(hasGenero(genero)){
			ArbolString aux= indiceGeneros.getpos(genero);
			return aux.getLibros();
		}
		return null;
	}

}
