package seb.taxes.report;

import seb.taxes.Basket;

/**
 * @author caponnetto
 *
 */
public interface Report {

	/**
	 * 
	 * @param basket
	 */
	void generate(Basket basket);

	void print();
}