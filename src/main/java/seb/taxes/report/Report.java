package seb.taxes.report;

import seb.taxes.Basket;

/**
 *  L’interfaccia Report definisce le operazioni di base che un report deve avere
 * 
 * @author caponnetto
 *
 */
public interface Report {

	/**
	 * Metodo per la generazione del Report a partire dall'oggeto del Basket
	 * @param basket
	 */
	void generate(Basket basket);

	/**
	 * Produzione dell'output dell'oggetto Report
	 */
	void print();
}