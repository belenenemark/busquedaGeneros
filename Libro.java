public class Libro {
	String nombre;
	String autor;
	String cantPaginas;
	LinkedList<String> generos;
	
	public Libro (String n, String au, String pag, LinkedList<String> gen){
		nombre=n;
		autor=au;
		cantPaginas=pag;
		generos = new LinkedList<String>(gen);
	}
	
	public String getAutor(){
		return autor;
		
	}
	public String getNombre (){
		return nombre;
	}
	public String getCantPag (){
		return cantPaginas;
	}
	public LinkedList<String> getGeneros() {
		return generos;
	}
	
	public boolean hasGenero(String buscar){
		
		Iterator<String> it = generos.iterator();
		boolean encontro = false;
		String aux;
		while(it.hasNext() && !encontro){
			aux=it.next();
			if(aux.equals(buscar)){
				encontro=true;
			}
		}
		
		
		return encontro;
		
	}
}
