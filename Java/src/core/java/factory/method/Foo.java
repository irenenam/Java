package core.java.factory.method;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 
 * @author yeonsooknam
 *
 */
public abstract class Foo {
	private static Map implementations = null;
	private static ResourceBundle classNames;
	
	// Initializes implementations map the first time it's called. 
	private static synchronized void initMapIfNecessary() {
		if(implementations == null)
			implementations = new HashMap();
		    
		
		String firstFoo = getValue("firstFoo");
		String secondFoo = getValue("secondFoo");
		String thirdFood = getValue("thirdFoo");
		
		try {  
			Class obj1 = Class.forName(firstFoo);
			Class obj2 = Class.forName(secondFoo);
			Class obj3 = Class.forName(thirdFood);
			
			implementations.put("firstFoo", obj1);
			implementations.put("secondFoo", obj2);
			implementations.put("thirdFood", obj3);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
		
	}
	
	private static String getValue(String s) {
		String value = classNames.getString(s);
		return value;
	}
	
	// static 초기화 블록을 사용하게 되면 클래스가 로딩될 때, 한번만 실행하게 된다. 
	// 복잡한 초기화 변수 셋팅 혹은 에러 처리를 위한 구문을 넣을 수 있다. 
	static {
		try {
			classNames = ResourceBundle.getBundle("TableText");
		} catch (java.util.MissingResourceException e) {
			System.out.println("Resource File not Found");
			System.exit(1);
		}
	}
	public static Foo getInstance(String key) {
		initMapIfNecessary();
		Class c = (Class)implementations.get(key);
		
		if (c == null)
			return new DefaultFoo();
		try {
			return (Foo)c.newInstance();
		} catch (Exception e) {
			return new DefaultFoo();
		}
		
	}
}
