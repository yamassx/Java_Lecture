package aivick;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ListUtilTest {
//privateなメソッドをリフレクションで参照可能にする処理	
//		ListUtil listutil = new ListUtil();
//		Method evensof = ListUtil.class.getDeclaredMethod("evensof", List<Integer>);
//		evensof.setAccessible(true);
//		int actual = (戻り値の型)method.invoke(<インスタンス>,引数1,引数2...);
	
//evensofのテスト	
	@Test
		public void evensofTest()
				throws NoSuchMethodException,
		        SecurityException,
		        IllegalAccessException,
		        IllegalArgumentException,
		        InvocationTargetException
		{
			ListUtil listutil = new ListUtil();
			Method evensof = ListUtil.class.getDeclaredMethod("evensof", List.class);
			evensof.setAccessible(true);
			var actual   = (List<Integer>)evensof.invoke(listutil , List.of(1,2,3,4,5,6,7));
			var expected = List.of(2,4,6);
			assertEquals(actual, expected);
		}
//replicateのテスト
	@Test
	public void replicateTest()
			throws NoSuchMethodException,
	        SecurityException,
	        IllegalAccessException,
	        IllegalArgumentException,
	        InvocationTargetException
	{
		ListUtil listutil = new ListUtil();
		Method replicate = ListUtil.class.getDeclaredMethod("replicate", int.class, String.class);
		replicate.setAccessible(true);
		var actual   = (List<String>)replicate.invoke(listutil, 3, "金");
		var expected = List.of("金","金","金");
		assertEquals(actual,expected);
	}
//zipのテスト
	@Test
	public void zipTest()
		throws NoSuchMethodException,
	    SecurityException,
	    IllegalAccessException,
	    IllegalArgumentException,
	    InvocationTargetException
	{
		ListUtil listutil = new ListUtil();
		Method zip = ListUtil.class.getDeclaredMethod("zip", List.class, List.class);
		zip.setAccessible(true);
		var actual   = (List<String>)zip.invoke(listutil, List.of(1,2,3,4), List.of(5,6,7));
		var expected = List.of(new Pair(1,5), new Pair(2,6), new Pair(3,7));
		assertEquals(actual,expected);
	}
//factersのテスト
	@Test
	public void factersTest()
			throws NoSuchMethodException,
	        SecurityException,
	        IllegalAccessException,
	        IllegalArgumentException,
	        InvocationTargetException
	{
		ListUtil listutil = new ListUtil();
		Method facters = ListUtil.class.getDeclaredMethod("facters", int.class);
		facters.setAccessible(true);
		var actual   = (List<Integer>)facters.invoke(listutil , 36);
		var expected = List.of(1,2,3,4,6,9,12,18,36);
		assertEquals(actual, expected);
	}
//perfectsのテスト
	@Test
	public void perfectsTest()
			throws NoSuchMethodException,
	        SecurityException,
	        IllegalAccessException,
	        IllegalArgumentException,
	        InvocationTargetException
	{
		ListUtil listutil = new ListUtil();
		Method perfects = ListUtil.class.getDeclaredMethod("perfects", int.class);
		perfects.setAccessible(true);
		var actual   = (List<Integer>)perfects.invoke(listutil , List.of(500);
		var expected = List.of(6,28,496);
		assertEquals(actual, expected);
	}
//pairs
	@Test
	public void pairsTest()
			throws NoSuchMethodException,
	        SecurityException,
	        IllegalAccessException,
	        IllegalArgumentException,
	        InvocationTargetException
	{
		ListUtil listutil = new ListUtil();
		Method pairs = ListUtil.class.getDeclaredMethod("pairs", List.class);
		pairs.setAccessible(true);
		var actual   = (List<Integer>)pairs.invoke(listutil , List.of(1,2,3,4,));
		var expected = List.of(new Pair(1,2), new Pair(2,3), new Pair(3,4));
		assertEquals(actual, expected);
	}
//isSorted
	@Test
	public void isSortedTest()
			throws NoSuchMethodException,
	        SecurityException,
	        IllegalAccessException,
	        IllegalArgumentException,
	        InvocationTargetException
	{
		ListUtil listutil = new ListUtil();
		Method isSorted = ListUtil.class.getDeclaredMethod("isSorted", List.class);
		isSorted.setAccessible(true);
		var actual   = (List<Integer>)isSorted.invoke(listutil , List.of(1,2,3,4,5,6,7));
		var expected = true;
		assertEquals(actual, expected);
	}
//positions
	@Test
	public void positionsTest()
			throws NoSuchMethodException,
	        SecurityException,
	        IllegalAccessException,
	        IllegalArgumentException,
	        InvocationTargetException
	{
		ListUtil listutil = new ListUtil();
		Method positions = ListUtil.class.getDeclaredMethod("positions", int.class, List.class);
		positions.setAccessible(true);
		var actual   = (List<Integer>)positions.invoke(listutil , 3,List.of(1,2,3,4,5,6,7));
		var expected = 3;
		assertEquals(actual, expected);
	}
}
