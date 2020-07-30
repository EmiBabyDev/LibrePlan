package Projet_1.LibrePlan;

import java.io.File;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

/**
 * ToolBdd is the class of database management methods
 * @author formation
 *
 */
public class ToolBdd {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/libreplan";
	private static final String USER = "libreplan";
	private static final String PASSWORD = "libreplan";
	
	/**
	 * readDataSet() is the method which instantiates a new xml file
	 * @param filename
	 * @throws java.lang.Exception
	 * @return FlatXmlDataSetBuilder construct
	 */
	private static IDataSet readDataSet(String filename) throws Exception {
		return new FlatXmlDataSetBuilder().build(new File(filename));
	}
	
	/**
	 * insertData() is the method that adds datasets
	 * @param path_to_file
	 * @throws java.lang.Exception
	 */
	public static void insertData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}

	/**
	 * deleteAllData() is the method of deleting data
	 * @param path_to_file
	 * @throws java.lang.Exception
	 */
	public static void deleteAllData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.DELETE_ALL);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}

	/**
	 * compareData() is the data comparison method
	 * @param table path_to_file col
	 * @throws java.lang.Exception
	 */
	public static void compareData(String table, String path_to_file, String... col) throws SQLException, Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable(table);
		IDataSet expectedDataSet = readDataSet(path_to_file);
		ITable expectedTable = expectedDataSet.getTable(table);
		String tab[] = col;
		Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, tab);
	}

	/**
	 * dateUpdate() is the static method of updating the data date
	 * @param path_to_file
	 * @throws java.lang.Exception
	 * @return rData update data set
	 */
	public static IDataSet dateUpdate(String path_to_file) throws Exception {
		IDataSet data = readDataSet(path_to_file);
		Calendar date = new GregorianCalendar();
		ReplacementDataSet rData = new ReplacementDataSet(data);
		rData.addReplacementObject("[start_date]", date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH) + 1)
				+ "-" + date.get(Calendar.DAY_OF_MONTH) + " 12:00:00");
		Calendar end_date = date;
		end_date.add(Calendar.DAY_OF_MONTH, 1);
		rData.addReplacementObject("[end_date]", end_date.get(Calendar.YEAR) + "-" + (end_date.get(Calendar.MONTH) + 1)
				+ "-" + end_date.get(Calendar.DAY_OF_MONTH) + " 12:00:00");
		return rData;
	}
	
	/**
	 * insertDataCurrentDate() is the method of inserting the date of the data
	 * @param path_to_file
	 * @throws java.lang.Exception
	 */
	public static void insertDataCurrentDate(String path_to_file) throws Exception {
		IDataSet dataset = dateUpdate(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}
}
