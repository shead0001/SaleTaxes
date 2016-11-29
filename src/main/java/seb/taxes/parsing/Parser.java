/**
 * 
 */
package seb.taxes.parsing;

import seb.taxes.Basket;


/**
 * Interfaccia Parser con metodo per la generazione di un oggetto
 *  Basket popolato con le informazioni estratte dalla stringa di input
 *  passata al programma
 * 
 * @author caponnetto
 *
 */
public interface Parser {
	/**
	 * 
	 * @param input Stringa di input passata al programma
	 * @return Oggetto popolato con le informazioni estratte dalla stringa di input
	 */
    Basket parse(String input);
}

