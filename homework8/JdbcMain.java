package jp.co.aivick.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain
{
    public static void main(String[] args) throws Exception {
 //      insertMaterial(args[0], Double.parseDouble(args[1]));
   //       selectMenu();
        //selectMenuByNameDanger(args[0]);
        //selectMenuByNameSafe(args[0]);
    	//getCal();
    	//averageCal();
    	//hasSalt();
    	over250kcal();
    }

    public static void selectMenu() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            Statement statement = connection.createStatement();

            String sql = "select * from menus";

            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                int menuId = resultset.getInt("menu_id");
                String menuName = resultset.getString("menu_name");
                System.out.println(String.format("menuId:%d, menuName:%s", menuId, menuName));
            }
        }
    }

    public static void selectMenuByNameDanger(String name) throws Exception {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            Statement statement = connection.createStatement();

            String sql = "select * from menus where menu_name = '" + name + "'";

            System.out.println(sql);

            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                int menuId = resultset.getInt("menu_id");
                String menuName = resultset.getString("menu_name");
                System.out.println(String.format("menuId:%d, menuName:%s", menuId, menuName));
            }
        }
    }

    public static void selectMenuByNameSafe(String name) throws Exception {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            String sql = "select * from menus where menu_name = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                int menuId = resultset.getInt("menu_id");
                String menuName = resultset.getString("menu_name");
                System.out.println(String.format("menuId:%d, menuName:%s", menuId, menuName));
            }
        }
    }

	/*public static void insertMaterial(String materialName, double cal) throws Exception {
	    try (Connection connection = DriverManager.getConnection(
	        "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

	        connection.setAutoCommit(false);
	        try {

	            String sql = "insert into materials(material_name, cal) values (?, ?)";

	            PreparedStatement statement = connection.prepareStatement(sql);

	            statement.setString(1, materialName);
	            statement.setDouble(2, cal);

	            int rows = statement.executeUpdate();
	            if(cal == 0) {
	            	throw RuntimeException("zero");
	            }
	            connection.commit();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	            connection.rollback();
	        }
	    }
	}*/
    public static void getCal() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            Statement statement = connection.createStatement();

            String sql = "SELECT M.menu_id  as menu_id," +
            			 "M.menu_name        as name, " +
            			 "SUM(MR.amount / 100 * RM.amount / 100 * MA.cal) as cal " +
            			 "FROM menus M " +
            		     "INNER JOIN menu_recipe MR ON M.menu_id = MR.menu_id " +
            		     "INNER JOIN recipe_material RM ON MR.recipe_id = RM.recipe_id " +
            		     "INNER JOIN materials MA ON RM.material_id = MA.material_id " +
            		     "GROUP BY M.menu_id;";
            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                int menuId = resultset.getInt("menu_id");
                String menuName = resultset.getString("name");
                double cal = resultset.getDouble("cal");
                System.out.println(String.format("menuId:%d, menuName:%s, cal:%f", menuId, menuName, cal));
            }
        }
    }
    public static void averageCal() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            Statement statement = connection.createStatement();

            String sql = "SELECT AVG(cal) " +
            			 "FROM (SELECT M.menu_id   as menu_id, " +
            			 "SUM(MR.amount / 100 * RM.amount / 100 * MA.cal) as cal " +
            			 "FROM menus M " +
            			 "INNER JOIN menu_recipe MR ON M.menu_id = MR.menu_id " +
            			 "INNER JOIN recipe_material RM ON MR.recipe_id = RM.recipe_id " +
            			 "INNER JOIN materials MA ON RM.material_id = MA.material_id " +
            			 "GROUP BY M.menu_id) CAL; ";
            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                double averageCal = resultset.getDouble("AVG(cal)");
                System.out.println(String.format("averageCal:%f", averageCal));
            }
        }
    }
    public static void hasSalt() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            Statement statement = connection.createStatement();

            String sql = "SELECT M.menu_id   as menu_id," +
            			 "M.menu_name as menu_name " +
            			 "FROM menus M " +
            			 "INNER JOIN menu_recipe MR ON M.menu_id = MR.menu_id " +
            			 "INNER JOIN recipe_material RM ON MR.recipe_id = RM.recipe_id " +
            			 "INNER JOIN materials MA ON RM.material_id = MA.material_id " +
            			 "where MA.material_id = 1 " +
            			 "GROUP BY M.menu_id; ";
            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
            	int menuId = resultset.getInt("menu_id");
            	String menuName = resultset.getString("menu_name");
                System.out.println(String.format("menuId: %d , menuName:%s", menuId, menuName));
            }
        }
    }
    public static void over250kcal() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
            "jdbc:mysql://mysql/mydatabase?user=root&password=root")) {

            Statement statement = connection.createStatement();

            String sql = "SELECT M.menu_id   as menu_id, " +
            			 "M.menu_name         as menu_name, " +
            			 "SUM(MR.amount / 100 * RM.amount / 100 * MA.cal ) as cal " +
            			 "FROM menus M " +
            			 "INNER JOIN menu_recipe MR ON M.menu_id = MR.menu_id " +
            			 "INNER JOIN recipe_material RM ON MR.recipe_id = RM.recipe_id " +
            			 "INNER JOIN materials MA ON RM.material_id = MA.material_id " +
            			 "GROUP BY M.menu_id " +
            			 "HAVING cal > 250;";
            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
            	int menuId = resultset.getInt("menu_id");
            	String menuName = resultset.getString("menu_name");
            	double cal = resultset.getDouble("cal");
                System.out.println(String.format("menuId: %d , menuName:%s , cal:%f", menuId, menuName, cal));
            }
        }
    }
}
