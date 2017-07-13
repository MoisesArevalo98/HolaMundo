package encriptar;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Encriptar sec = new Encriptar();
		Scanner entrada= new Scanner(System.in);
		String campo="";
		String texto="";
		System.out.println( "Ingrese el texto a encriptar RC2: " );
	    campo=entrada.nextLine();
	    System.out.println( " ------------ Encriptado ------------ " );
		texto = sec.encriptar(campo);
        System.out.println( texto );
        System.out.println("---------------------------------------");
        System.out.println( " ------------ Desencriptado ------------ " );
	    System.out.println( sec.desencriptar(texto) );
	    System.out.println("----------------------------------------");
        
       
	}

}
