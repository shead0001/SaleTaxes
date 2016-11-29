/**
 * 
 */
package seb.taxes.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Set;
import java.util.Map.Entry;

import seb.taxes.Basket;
import seb.taxes.ClassificationUtility;
import seb.taxes.Good;
import seb.taxes.type.GoodType;

/**
 * 
 * @author caponnetto
 *
 */
public class ParserImpl implements Parser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see seb.taxes.parsing.Parser#parse(java.lang.String)
	 */
	@Override
	public Basket parse(final String input) {
		//

		final Basket basket = new Basket();
		try (BufferedReader reader = new BufferedReader(new StringReader(input))) {
			String line = reader.readLine();
			while (line != null) {
				Good good;
				try {
					good = extractGood(line);
					basket.add(good);
				} catch (Exception e) {
					System.out.println("Problemi nella lettura della riga \""
							+ line + "\":" + e.getMessage());
				}

				line = reader.readLine();
			}
		} catch (IOException exc) {
			System.out.println("Problemi nella lettura dell'input"
					+ exc.toString());
		}
		return basket;

	}

	/**
	 * Popolamento dell'oggetto Good a partire dalla riga di input
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 *             eccezioni prodotte nel caso in cui non sia possibile estrarre
	 *             il prezzo o determinare la tipologia
	 */
	public Good extractGood(final String input) throws Exception {
		final Good goodNew = new Good();

		goodNew.setImported(false);

		// determino se è importato
		if (input.contains("imported")) {
			goodNew.setImported(true);

		}

		// ripulisco la riga di input
		String inputElaborated = input.replace("imported ", "");

		// estraggo la quantità
		try {
			final int goodsNumber = Integer.parseInt(inputElaborated.substring(
					0, inputElaborated.indexOf(' ')));
			goodNew.setNumber(goodsNumber);
		} catch (NumberFormatException e) {
			throw new Exception(
					"Problemi nell' estrazione della quantità di oggetti", e);
		}

		// estraggo il nome del bene
		inputElaborated = inputElaborated.substring(inputElaborated
				.indexOf(' ') + 1);
		final int atPosition = inputElaborated.indexOf(" at ");
		String goodName = inputElaborated.substring(0, atPosition);
		goodNew.setName(goodName);

		// determino la tipologia dl bene
		final GoodType goodType = getGoodTypeFromName(goodName);
		if (goodType == null) {
			throw new Exception("Impossibile determinare la tipologia di bene");
		} else {
			goodNew.setType(goodType);
		}

		// estraggo il prezzo del bene
		try {
			final String price = inputElaborated.substring(atPosition + 4);
			goodNew.setPrice(new BigDecimal(price));
		} catch (Exception e) {
			throw new Exception("Impossibile estrarre prezzo dei beni", e);
		}

		return goodNew;

	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	private GoodType getGoodTypeFromName(String name) {
		Set<Entry<String, GoodType>> es = ClassificationUtility.GOODS_TYPES
				.entrySet();
		for (Entry<String, GoodType> entry2 : es) {
			Entry<String, GoodType> entry = (Entry<String, GoodType>) entry2;
			if (name.contains(entry.getKey())) {
				return entry.getValue();
			}

		}
		return null;
	}

}
