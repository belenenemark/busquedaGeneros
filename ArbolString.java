
import java.util.LinkedList;

public class ArbolString {
	private String dato;
	private ArbolString izq;
	private ArbolString der;
	private LinkedList<Libro> libros;
	
	public ArbolString(){
		dato=null;
		izq=null;
		der=null;
		libros= new LinkedList<Libro>();
		
	}
	public boolean isEmpty(){
		return (this.dato==null) && (this.izq==null) &&(this.der==null);
		
	}
	public void Insert(String dato){
		
		if(this.isEmpty()){
			this.dato=dato;
			this.izq=new ArbolString();
			this.der= new ArbolString();
		}else{
			if (dato.compareTo(this.dato)<0){
				this.izq.Insert(dato);
				
			}else{
				this.der.Insert(dato);
			}
		}
	}
	public void PreOrder(ArbolString raiz){
		if(!raiz.isEmpty()){
			System.out.print(raiz.dato + ";");
			PreOrder(raiz.izq);
			PreOrder(raiz.der);
		}
	}
	public void InOrder(ArbolString raiz){
		if(!raiz.isEmpty()){
			InOrder(raiz.izq);
			System.out.print(raiz.dato + ";");
			InOrder(raiz.der);
			
		}
	}
	public void PosOrder(ArbolString raiz){
		if(!raiz.isEmpty()){
			PosOrder(raiz.der);
			PosOrder(raiz.izq);
			System.out.print(raiz.dato + ";");
			
		}
	}
	public boolean hasElement(String valor){
		
		if (!this.isEmpty()){
			
			if (this.dato.equals(valor)){
				
				return true;
			}else 
			{if(this.dato.compareTo(valor)<0)
				 return this.der.hasElement(valor);
			 if(this.dato.compareTo(valor)>0){
				 return this.izq.hasElement(valor);
				 }
			 }
		}
		
		return false;
		
	}
	public void conectarLibro(Libro lib){
		 
		libros.add(lib);
		
	}
	public ArbolString getpos(String gen){
		
		
		if(!this.isEmpty()){
			if(this.dato.equals(gen)){
				
				return this;
			}else{if(this.dato.compareTo(gen)<0)
				 return this.der.getpos(gen);
			 if(this.dato.compareTo(gen)>0){
				 return this.izq.getpos(gen);
				 }
				
			}
		}
		return null;
	}
	public String getDato() {
		return dato;
	}
	public LinkedList<Libro> getLibros() {
		return libros;
	}
}
