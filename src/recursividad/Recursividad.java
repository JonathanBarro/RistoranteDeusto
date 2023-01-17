package recursividad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursividad {
	
	public static List<List<Integer>> combinaciones(List<Integer> menus, int numPersonas){
		List<List<Integer>> resultado = new ArrayList<>();
		combinacionesR(resultado,numPersonas,menus,new ArrayList<>(), 0);
		return resultado;
	}
	public static void combinacionesR(List<List<Integer>> resultado, int numPersonas, List<Integer> menus, List<Integer> temp, int cont) {
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
		List<Integer> menis = new ArrayList<>();
		menis.add(1);
		menis.add(2);
		menis.add(3);
		menis.add(4);
		List<List<Integer>> mm = new ArrayList<>();
		mm=combinaciones(menis, 3);
		for(List<Integer> m : mm) {
			System.out.println(m);
		}
		
		
	}

}
