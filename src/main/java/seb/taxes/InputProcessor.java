package seb.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Map.Entry;
import java.util.Set;

import seb.taxes.report.ReportGenerator;
import seb.taxes.report.ReportGeneratorFactory;
import seb.taxes.report.data.Inputs;
import seb.taxes.type.GoodType;

public class InputProcessor {

	public static void main(String[] args) {

		InputProcessor inputtProc = new InputProcessor();
		Basket basket = inputtProc.processInput(Inputs.input1);
		// System.out.println(basket.toString());
		ReportGenerator gen = ReportGeneratorFactory.createTxtReportGenerator();
		gen.generate(basket).print();
	}

	public InputProcessor() {
	}

	public Basket processInput(String input) {

		Basket basket = new Basket();
		try (BufferedReader reader = new BufferedReader(new StringReader(input))) {
			String line = reader.readLine();
			while (line != null) {
				Good good = extractGood(line);
				basket.add(good);
				line = reader.readLine();
			}
		} catch (IOException exc) {

		}
		return basket;
	}

	public Good extractGood(String input) {
		Good goodNew = new Good();

		goodNew.setImported(false);
		if (input.contains("imported")) {
			goodNew.setImported(true);

		}

		String input2 = input.replace("imported ", "");
		int goodsNumber = Integer.parseInt(input2.substring(0,
				input2.indexOf(' ')));
		goodNew.setNumber(goodsNumber);

		String input3 = input2.substring(input2.indexOf(' ') + 1);
		int atPosition = input3.indexOf(" at ");
		String goodName = input2.substring(2, atPosition + 2);
		goodNew.setName(goodName);

		GoodType goodType = getGoodTypeFromName(goodName);
		goodNew.setType(goodType);

		String price = input2.substring(atPosition + 6);
		goodNew.setPrice(new BigDecimal(price));

		return goodNew;

	}

	private GoodType getGoodTypeFromName(String name) {
		Set<Entry<String, GoodType>> es = ClassificationManager.MY_MAP
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
