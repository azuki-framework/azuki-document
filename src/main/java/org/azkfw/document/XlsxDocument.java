package org.azkfw.document;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxDocument {

	private XSSFWorkbook workbook;

	public XlsxDocument() {
		workbook = new XSSFWorkbook();
	}

	public XlsxDocument(final InputStream stream) throws IOException {
		workbook = new XSSFWorkbook(stream);
	}

	public void write(final OutputStream stream) throws IOException {

		try {
			workbook.write(stream);
		} finally {

		}

	}

}
