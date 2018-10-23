package labfive;

import java.util.stream.Collectors;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import labfive.JSONProperty;

public class Main {
	
    private static String propertyName(String name) {
    	return Character.toLowerCase(name.charAt(3)) + name.substring(4);
    }
    
    private static String getField(Object obj, Method m) {
    	String toReturn = "";
    	try {
    		toReturn = m.invoke(obj).toString();
    	}
    	catch (IllegalStateException e) {
    		throw new IllegalStateException();
    	}
    	catch (IllegalAccessException e) {
    		throw new IllegalStateException(e);
    	}
    	catch (InvocationTargetException e) {
    		var cause = e.getCause();
    		if (cause instanceof RuntimeException )
    			throw (RuntimeException) cause;
    		throw new UndeclaredThrowableException(cause);
    	}
    	return (toReturn);
    }
    
	public static String toJSON(Object obj) {
		var insideObj = obj.getClass();
		Method methods[] = insideObj.getMethods();
		String str = Arrays.stream(methods)
				.filter(m -> m.getName().substring(0, 3).equals("get"))
				.filter(m -> m.getAnnotation(JSONProperty.class) instanceof JSONProperty)
				.map(m -> "  \"" + propertyName(m.getName()) + "\": \"" + getField(obj, m) + "\"").collect(Collectors.joining("\n"));
		return ("{\n" + str + "\n}\n");
	}

	public static void main(String[] args) {
	}
}
