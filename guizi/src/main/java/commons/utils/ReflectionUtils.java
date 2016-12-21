package commons.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {
	public static Class getParamClassType(Class clazz) {
		try {
			Type type = clazz.getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
				return (Class)parameterizedType[0];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Object.class;
	}
}
