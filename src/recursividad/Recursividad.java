package recursividad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursividad {
	
	public static List<List<String>> combinaciones(List<String> menus, int numPersonas){
		List<List<String>> resultado = new ArrayList<>();
		combinacionesR(resultado,numPersonas,menus,new ArrayList<>(), 0);
		return resultado;
	}
	public static void combinacionesR(List<List<String>> resultado, int numPersonas, List<String> menus, List<String> temp, int cont) {
		if(cont == numPersonas) {
			resultado.add(new ArrayList<>(temp));
		}else {
			for(int i=0;i<menus.size();i++) {
				temp.add(menus.get(i));
				combinacionesR(resultado, numPersonas, menus, temp, cont+1);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		List<String> menis = new ArrayList<>();
		menis.add("M1");
		menis.add("M2");
		menis.add("M3");
		menis.add("M4");
		List<List<String>> mm = new ArrayList<>();
		mm=combinaciones(menis, 3);
		for(List<String> m : mm) {
			System.out.println(m);
		}
		
		
	}

}
