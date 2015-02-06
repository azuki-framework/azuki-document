package org.azkfw.document.database;

import java.io.File;

import org.azkfw.database.definition.model.DatabaseModel;
import org.azkfw.database.definition.parser.DatabaseDefinitionParser;

public class DatabaseDefinitionDocument {

	public static boolean outputXlsxFile(final DatabaseDefinitionParser parser, final File destFile) {
		//Class.forName("com.mysql.jdbc.Driver");
		//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bpsrv?useUnicode=true&characterEncoding=utf8", "kdl", "kdlkdl");
		//String schema = "bpsrv";

		return false;
	}

	public static boolean outputXlsxFile(final DatabaseModel database, final File destFile) {

		return false;
	}

	private DatabaseDefinitionDocument() {

	}
}
