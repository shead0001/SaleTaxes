package seb.taxes;

import org.junit.Assert;
import org.junit.Test;

import seb.taxes.Basket;
import seb.taxes.data.Inputs;
import seb.taxes.data.Results;
import seb.taxes.parsing.Parser;
import seb.taxes.parsing.ParserImpl;
import seb.taxes.report.ReportGenerator;
import seb.taxes.report.ReportGeneratorFactory;
import seb.taxes.report.TxtReport;

/**
 * Classe per il testing dell'itero processo: - parsing dell'input - produzione
 * della stringa di output
 * 
 * @author caponnetto
 *
 */
public class MainTest {

	/**
	 * Testing della corretta dell'output a partire dalla stringa di input 1
	 */
	@Test
	public void genereTextReportFromInputText1() {

		final Parser parser = new ParserImpl();
		final Basket basket = parser.parse(Inputs.input1);

		final ReportGenerator gen = ReportGeneratorFactory
				.createTxtReportGenerator();
		final String risultato1 = ((TxtReport) (gen.generate(basket)))
				.generateString(basket);

		Assert.assertEquals(Results.output1, risultato1);
	}

	/**
	 * Testing della corretta dell'output a partire dalla stringa di input 2
	 */
	@Test
	public void genereTextReportFromInputText2() {

		final Parser parser = new ParserImpl();
		final Basket basket = parser.parse(Inputs.input2);

		final ReportGenerator gen = ReportGeneratorFactory
				.createTxtReportGenerator();
		final String risultato2 = ((TxtReport) (gen.generate(basket)))
				.generateString(basket);

		Assert.assertEquals(Results.output2, risultato2);

	}

	/**
	 * Testing della corretta dell'output a partire dalla stringa di input 3
	 */
	@Test
	public void genereTextReportFromInputText3() {

		final Parser parser = new ParserImpl();
		final Basket basket = parser.parse(Inputs.input2);

		final ReportGenerator gen = ReportGeneratorFactory
				.createTxtReportGenerator();
		final String risultato3 = ((TxtReport) (gen.generate(basket)))
				.generateString(basket);

		Assert.assertEquals(Results.output2, risultato3);

	}

}