	package encriptar;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * @web http://www.jc.mouse.net/
 * @author Mouse
 */
public class Encriptar{

    private SecretKey key;       
    private Cipher cipher;  
    private String algoritmo= "RC2";
    private int keysize=16;
    /**
 * Crea la Llave para encriptar/desencriptar
 * @param String value
 */
    public void addKey( String value ){
        byte[] valuebytes = value.getBytes();            
        key = new SecretKeySpec( Arrays.copyOf( valuebytes, keysize ) , algoritmo );      
    }

     /**
 * Metodo para encriptar un texto
 * @param String texto
 * @return String texto encriptado
 */
    public String encriptar( String texto ){
        String value="";
        addKey(texto);
        try {
            cipher = Cipher.getInstance( algoritmo );             
            cipher.init( Cipher.ENCRYPT_MODE, key );             
            byte[] textobytes = texto.getBytes();
            byte[] cipherbytes = cipher.doFinal( textobytes );
            for (byte b : cipherbytes) {
   	         	System.out.print(Integer.toHexString(0xFF & b));
   	      	}
            value = new BASE64Encoder().encode( cipherbytes );
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error1");
        } catch (NoSuchPaddingException ex) {
        	 System.out.println("Error2");
        } catch (InvalidKeyException ex) {
        	 System.out.println("Error3");
        } catch (IllegalBlockSizeException ex) {
        	 System.out.println("Error4");
        } catch (BadPaddingException ex) {
        	 System.out.println("Error5");
        }
        return value;
    }

     /**
 * Metodo para desencriptar un texto
 * @param texto Texto encriptado
 * @return String texto desencriptado
 */
    public String desencriptar( String texto ){
        String str="";        
        try {
            byte[] value = new BASE64Decoder().decodeBuffer(texto);                 
            cipher = Cipher.getInstance( algoritmo );            
            cipher.init( Cipher.DECRYPT_MODE, key );
            byte[] cipherbytes = cipher.doFinal( value );
            str = new String( cipherbytes );                                  
        } catch (InvalidKeyException ex) {
            System.err.println( ex.getMessage() );
        }  catch (IllegalBlockSizeException ex) {
            System.err.println( ex.getMessage() );
        } catch (BadPaddingException ex) {
            System.err.println( ex.getMessage() );            
        }   catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }catch (NoSuchAlgorithmException ex) {
            System.err.println( ex.getMessage() );
        } catch (NoSuchPaddingException ex) {
            System.err.println( ex.getMessage() );
        }
        return str;
    }
}
