package arbolAVL;
//importe la clase Pila

//importe la clase Cola

//IMPORTE la clase NODO necesario para un ARBOL BINARIO BALANCEADO
/**
 * Representa un árbol binario ordenado. Tiene las operaciones
 * básicas: insertar, eliminar, buscar y recorridos
 */

 public class ArbolAVL  {
	/**
	 * Raiz del arbol
	 */
	private Nodo raiz;
	
	/**
	 * Constructor por defecto
	 */
	
	public ArbolAVL() {
		raiz = null;
	}
	public Nodo getRaiz() {
		return raiz;
	}
	
	/**
	 * ROTACIONES
	 * @param n
	 * @param n1
	 * @return
	 */
	
	private Nodo rotacionII(Nodo n, Nodo n1) {
		n.setIzquierdo(n1.getDerecho());
		n1.setDerecho(n);
		//Actualizacion de los factores de equilibrio
		if(n1.getFe()==-1){ //Se cumple en la insercion
			n.setFe(0);
			n1.setFe(0);
		}
		else {
			n.setFe(-1);
			n1.setFe(+1);
		}
		return n1;
	}
	
	
	/**
	 * Rotación simple:derecha-derecha
	 * @param n referencia al nodo problema con fe +2
	 * @param n1 referencia al nodo de su rama derecha
	 * @return
	 */
	
	private Nodo rotacionDD(Nodo n, Nodo n1) {
		n.setDerecho(n1.getIzquierdo());
		n1.setIzquierdo(n);
		//Actualización de factores de equilibrio
		if(n1.getFe()==+1) {// se cumple en la inserción
			n.setFe(0);
			n1.setFe(0);
			
		}
		else {
			n.setFe(+1);
			n1.setFe(-1);
		}
		return n1;
	}
	
	
	/**
	 * Rotación doble:derecha-derecha
	 * @param n referencia al nodo problema con fe -2
	 * @param n1 referencia al nodo de su rama izquierda
	 * @return
	 */
	
	private Nodo rotacionID(Nodo n, Nodo n1) {
		Nodo n2;
		n2 = (Nodo)n1.getDerecho();
		n.setIzquierdo(n2.getDerecho());
		n2.setDerecho(n);
		n1.setDerecho(n2.getIzquierdo());
		n2.setIzquierdo(n1);
		//Actualización de los factores de equillibrio
		if(n2.getFe()==+1)
			n1.setFe(-1);
		else
			n1.setFe(0);
		if(n2.getFe()==-1)
			n.setFe(1);
		else
			n.setFe(0);
		n2.setFe(0);
		return n2;
		
	}
	
	
	/**
	 * Rotación doble:derecha-izquierda
	 * @param n referencia al nodo problema con fe -2
	 * @param n1 referencia al nodo de su rama izquierda
	 * @return
	 */
	
	private Nodo rotacionDI(Nodo n, Nodo n1) {
		Nodo n2;
		n2 = (Nodo)n1.getIzquierdo();
		n.setDerecho(n2.getIzquierdo());
		n2.setIzquierdo(n);
		n1.setIzquierdo(n2.getDerecho());
		n2.setDerecho(n1);
		//Actualización de los factores de equillibrio
		if(n2.getFe()==+1)
			n.setFe(-1);
		else
			n.setFe(0);
		if(n2.getFe()==-1)
			n1.setFe(1);
		else
			n1.setFe(0);
		n2.setFe(0);
		return n2;
		
	}
	
	
	
		//Implementación recursiva de los recorridos
		/**
		 * Invoca al método recursivo
		 */
		public void preorden() {
			preorden(raiz);
		}
		/**
		 * 
		 * @param aux
		 */
		private void preorden(Nodo aux) {
			if(aux !=null) {
				visitar(aux);
				preorden(aux.getIzquierdo());
				preorden(aux.getDerecho());
			}
		}
		private void visitar(Nodo aux) {
			System.out.print(aux.getValor()+" ");
		}
		public String preorden2() {
			return preorden2(raiz,"");
		}
		/**
		 * 
		 * @param aux
		 */
		private String preorden2(Nodo aux,String cadena) {
			//String cadena = "";
			if(aux !=null) {
				cadena=cadena+visitar2(aux);
				System.out.println("En la funcion preorden2 recursiva: "+cadena);
				preorden2(aux.getIzquierdo(),cadena);
				preorden2(aux.getDerecho(),cadena);
			}
			return cadena;
		}
		private String visitar2(Nodo aux) {
			return aux.getValor()+",";
			
		}
		/**
		 * Invoca al método recursivo
		 */
		public void inorden() {
			inorden(raiz);
		}
		/**
		 * 
		 * @param aux referencia a un nodo
		 */
		private void inorden(Nodo aux) {
			if(aux !=null) {
				inorden(aux.getIzquierdo());
				visitar(aux);
				inorden(aux.getDerecho());
			}
		}
		/**
		 * Invoca al método recursivo
		 */
		public void postorden() {
			postorden(raiz);
		}
		/**
		 * 
		 * @param aux referencia a un nodo
		 */
		
		private void postorden(Nodo aux) {
			if(aux !=null) {
				postorden(aux.getIzquierdo());
				postorden(aux.getDerecho());
				visitar(aux);
			}
			
			
		}
		
	
	
	/**
	 * Inserta un nodo en el árbol binario version Iterativa
	 * @param valor
	 * @throws Exception
	 * Pendiente de modificar
	 */
	
	public void insertar2(Object valor) throws Exception{
		Comparable dato = (Comparable) valor;
		Nodo nuevo = new Nodo();
		nuevo.setValor(dato);
		
		if(raiz==null)
			raiz=nuevo;
		else {
			//anterior: referencia al padre de aux
			Nodo anterior = null;
			//aux: auxiliar para recorrer los nodos, desde la raiz
			Nodo aux = raiz;
			while (aux!=null) {
				anterior = aux;
				if(dato.esMenor(aux.getValor()))
					aux = aux.getIzquierdo();
				else if (dato.esMayor(aux.getValor()))
					aux = aux.getDerecho();
				else
					throw new Exception("Dato duplicado");
				
			}
			if(dato.esMenor(anterior.getValor()))
				anterior.setIzquierdo(nuevo);
			else
				anterior.setDerecho(nuevo);
			
			
		}
		
		
	}
	/**
	 * versión recursiva
	 * Inserta un elemento en el arvol AVL, llama al método
	 * recursivo insertarAVL
	 * @param valor a insertar
	 * @throws Exception
	 */
	public void insertar(Object valor) throws Exception{
		//complete el código faltante
	}
	/**
	 * Método Recursivo
	 * @param raizSub
	 * @param dato
	 * @param h
	 * @return Nodo
	 * @throws Exception
	 */
	private Nodo insertarAVL(Nodo raiz, Comparable dt, Logical h) throws Exception{
		//complete el código faltante
	}
	
	/**
	 *  Version iterativa
	 * @param valor a buscar
	 * @return Nodo buscado o Null si no lo encuentra
	 */
	public Nodo buscar(Object valor) {
		Comparable dato = (Comparable)valor;
		if(raiz ==null)
			return raiz;
		else {
			//aux: auxiliar que va recorriendo los nodos, desde la raiz
			Nodo aux = raiz;
			while (aux !=null) {
				if(dato.esIgual(aux.getValor()))
					return aux;
				if(dato.esMenor(aux.getValor()))
					aux = aux.getIzquierdo();
				else
					aux = aux.getDerecho();
			}
			return null;
		}
		
	}
	
	/**
	 * Version Recursiva
	 * @param Elemento Buscado
	 * @return Nodo si lo encuentra y si no Null
	 */
	public Nodo buscar2(Object buscado) {
		Comparable dato = (Comparable)buscado;
		if (raiz ==null)
			return null;
		else
			return localizar(raiz, dato);
	}
	
	public Nodo localizar(Nodo raizSub, Comparable buscado) {
		if (raizSub ==null)
			return null;
		else if(buscado.esIgual(raizSub.getValor()))
			return raizSub;
		else if(buscado.esMenor(raizSub.getValor()))
			return localizar(raizSub.getIzquierdo(),buscado);
		else
			return localizar(raizSub.getDerecho(),buscado);
	}
	/**
	 * 
	 * @param valor a eliminar
	 * @throws Exception
	 */
	public void eliminar(Object valor) throws Exception{
		//complete el código faltante
		
	}
	/**
	 * 
	 * @param r Nodo raiz
	 * @param clave elemento a borrar
	 * @param cambioAltura tipo Logical
	 * @return 
	 * @throws Exception
	 */
	
	public Nodo borrarAVL(Nodo r, Comparable clave, Logical cambioAltura) 
			throws Exception{

		//complete el código faltante
		
	}
		
	/**
	 * Reemplaza el nodo a eliminar por el nodo mas a la izquierda
	 * del hijo derecho
	 * @param n nodo a reemplazar
	 * @param act dato a actualizar
	 * @param cambioAltura
	 * @return
	 */
	
	private Nodo reemplazar(Nodo n, Nodo act,Logical cambioAltura)  {
		
		if(act.getDerecho()!=null) {
			Nodo d;
			
			d = reemplazar(n,(Nodo)act.getDerecho(),cambioAltura);
			
			act.setDerecho(d);
			if(cambioAltura.booleanValue())
				act=equilibrar2(act,cambioAltura);
		}else {

			n.setValor(act.getValor());
			n=act;
			act=(Nodo)act.getIzquierdo();
			n=null;
			cambioAltura.setLogical(true);
		}
		return act;
		
	}
	
	/**
	 * Equilibrar el arbol
	 * @param n
	 * @param cambioAltura
	 * @return
	 */
	private Nodo equilibrar1(Nodo n,Logical cambioAltura)  {
		Nodo n1;
		switch(n.getFe()) {
		case -1:
			n.setFe(0);
			break;
		case 0:
			n.setFe(1);
			cambioAltura.setLogical(false);
			break;
		case +1:
			//Se aplica un tipo de rotación derecha
			n1=(Nodo) n.getDerecho();
		    if(n1.getFe()>=0) {
		    	if(n1.getFe()==0)//La altura no vuelve a disminuir
		    		cambioAltura.setLogical(false);
		    	n=rotacionDD(n,n1);
		    }
		    else
		    	n=rotacionDI(n,n1);
		    break;
			
		}
		return n;
		
	}
	
	/**
	 * Equilibrar el arbol
	 * @param n
	 * @return
	 */
	
	private Nodo equilibrar2(Nodo n, Logical cambioAltura) {
		Nodo n1;
		switch(n.getFe()) {
		case -1:
			//Se aplica rotacion izquierda
			n1 = (Nodo) n.getIzquierdo();
			if(n1.getFe()<=0) {
				if(n1.getFe()==0)
					cambioAltura.setLogical(false);
				n=rotacionDD(n,n1);
			}
			else
				n=rotacionID(n,n1);
			
			break;
		case 0:
			n.setFe(-1);
			cambioAltura.setLogical(false);
			break;
		case +1:
			n.setFe(0);
		    break;
			
		}
		return n;
		
	}
    

    //Recorrido Iterativo en Preorden, utilizando una pila
    public void preordenIterativo(){
        Pila<Nodo> pila = new Pila<Nodo>();
        pila.apilar(raiz);
        while (!pila.esVacia()){
            Nodo aux = pila.cima();
            visitar(aux);
            pila.retirar();
            if(aux.getDerecho() !=null)
               pila.apilar(aux.getDerecho());
            if(aux.getIzquierdo() !=null)
               pila.apilar(aux.getIzquierdo());
        }
    }

    //Recorrido  Iterativo en InOrden, utilizando una pila
    public void inordenIterativo(){
        Pila<Nodo> pila = new Pila<Nodo>();
        pila.apilar(raiz);
        Nodo aux = raiz.getIzquierdo();
        while(aux != null || !pila.esVacia()){
            if(aux !=null){
                pila.apilar(aux);
                aux = aux.getIzquierdo();
            }else{
                aux = pila.cima();
                pila.retirar();
                visitar(aux);
                aux = aux.getDerecho();
            }
        }

    }

    //Recorrido Iterativo en PostOrden, utilizando una pila
    public void postordenIterativo(){
        Pila<Nodo> pila = new Pila<Nodo>();
        Nodo aux = raiz;
        Nodo q = raiz;
        while(aux !=null){
            //avanza por la izquierda y apila los nodos
            while(aux.getIzquierdo() !=null){
                pila.apilar(aux);
                aux = aux.getIzquierdo();
            }
            while (aux !=null && (aux.getDerecho() == null || aux.getDerecho() == q)){
                visitar(aux);
                q = aux;
                if (pila.esVacia())
                  return;

                aux = pila.cima();
                pila.retirar();
            }
            pila.apilar(aux);
            aux = aux.getDerecho();
        }
    }
    public void recorridoPorNivel(){
        Cola<Nodo> cola = new Cola<Nodo>();
        cola.encolar(raiz);
        while(!cola.esVacia()){
            Nodo aux = cola.frente();
            visitar(aux);
            
            if(aux.getIzquierdo()!=null)
               cola.encolar(aux.getIzquierdo());
            if(aux.getDerecho() !=null)
               cola.encolar(aux.getDerecho());
            cola.desencolar();

        }

    }



}