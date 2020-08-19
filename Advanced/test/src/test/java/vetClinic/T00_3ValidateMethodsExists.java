package vetClinic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.Classes;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



    public class T00_3ValidateMethodsExists {
        private static final String METHOD_NOT_PRESENT_ERROR_MESSAGE = "The method '%s.%s' does not exist(actual methods parameter types: '%s' ;expected - '%s')!";

        private class ExpMethod {
            String name;
            Class[] parameterTypes;

            public ExpMethod(String name, Class... parameterTypes) {
                this.name = name;
                this.parameterTypes = parameterTypes;
            }
        }

        @Test
        public void validateClassMethods() throws ClassNotFoundException {
            Class carClazz = getType("Pet");

            ExpMethod[] carMethods = new ExpMethod[]{
                    new ExpMethod("getName"),
                    new ExpMethod("getAge"),
                    new ExpMethod("getOwner"),
                    new ExpMethod("toString"),
            };

            for (ExpMethod method : carMethods) {
                validateMethod(carClazz, method);
            }

            Class parkingClazz = getType("Clinic");

            ExpMethod[] parkingMethods = new ExpMethod[]{
                    new ExpMethod("add", getType("Pet")),
                    new ExpMethod("remove", String.class),
                    new ExpMethod("getPet", String.class, String.class),
                    new ExpMethod("getOldestPet"),
                    new ExpMethod("getCount"),
                    new ExpMethod("getStatistics"),
            };

            for (ExpMethod method : parkingMethods) {
                validateMethod(parkingClazz, method);
            }
        }

        private void validateMethod(Class clazz, ExpMethod expMethod) {
            List<Pet> test = new ArrayList<>();
            for (Pet pet : test) {
                pet.getAge();
            }
            String expectedName = expMethod.name;
            Class[] expectedParameterTypes = expMethod.parameterTypes;

            Method actualMethod = getMethod(clazz, expectedName, expectedParameterTypes);

            // Tests whether the method exist
            String actualMethodsParametersMessage = null;

            if (actualMethod == null) {
                actualMethodsParametersMessage = findMethodFromMethods(clazz, expectedName);
            }

            String existMessage = String.format(METHOD_NOT_PRESENT_ERROR_MESSAGE, clazz.getSimpleName(), expectedName, actualMethodsParametersMessage, arrayToString(expectedParameterTypes));
            Assert.assertNotNull(existMessage, actualMethod);
        }

        private String arrayToString(Class[] array) {
            String[] stringArray = Arrays.stream(array).map(Class::getSimpleName).toArray(String[]::new);
            String arrayStr = String.join(", ", stringArray);

            return arrayStr;
        }

        private String findMethodFromMethods(Class clazz, String methodName) {
            Method[] methods = clazz.getMethods();

            Method[] methodsWithGivenName = Arrays.stream(methods).filter(m -> m.getName().equals(methodName)).toArray(Method[]::new);

            StringBuilder sb = new StringBuilder();

            for (Method method : methodsWithGivenName) {
                String parameterTypes = arrayToString(method.getParameterTypes());
                sb.append("{ " + parameterTypes + " } ");
            }

            return sb.toString().trim();
        }

        private Method getMethod(Class clazz, String expectedName, Class... parameterTypes) {
            Method method = null;

            try {
                method = clazz.getMethod(expectedName, parameterTypes);
            } catch (NoSuchMethodException e) {
            }

            return method;
        }
        private static Class getType(String name) throws ClassNotFoundException {
            Class clazz = Classes.getClass(name);
            return clazz;
        }
    }


