package core.java.factory.method;
/**
 *The normal way for a class to allow a client to obtain an instance of itself is to provide a public constructor. 
 *There is another technique that should be a part of every programmer's toolkit. 
 *A class can provide a public static factory method, which is simply a static method that returns an instance of the class.
 *
 * @author yeonsooknam
 */
public class StaticFactoryMethod {
	
	/*
	 * There is some advantages when we use static factory method
	 * 1. unlike constructors, they have names.
	 * 2. We don't need to make a new Object to call.
	 * 	  they are not required to create a new object each time they're invoked.
	 * 3. Constructor returns about defined class and instance, but static factory method
	 *    can return an object of any subtype of their return type.  (flexibility) 
	 *  
	 *  ex) interface-based framework -> Collections Framework 
	 *      java.util.Collections 
	 *      
	 * disadvantages
	 * 1. only static factory methods is that classes without public or protected constructors cannot be subclassed. 
	 * 2. static factory methods is that they are not readily distinguishable (구별할수 있는) from other static methods. 
	 */
	public static Boolean valueOf(boolean b) {
		return (b ? Boolean.TRUE : Boolean.FALSE);
	}
}
