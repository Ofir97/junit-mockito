import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    // Testing private methods:

    private GradeCalculator gc;

    @BeforeEach
    void setUp() {
        gc = new GradeCalculator();
    }

    @Test
    public void computeGradeWithReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class[] parameters = new Class[1];
        parameters[0] = Integer.class;
        Method methodCall = gc.getClass().getDeclaredMethod("computeGrade", Integer.class);
        methodCall.setAccessible(true);

        Object[] methodArguments = new Object[1];
        methodArguments[0] = 70;

        String grade = (String)methodCall.invoke(gc, methodArguments);
        assertEquals("Pass", grade);
    }

    @Test
    public void computeGradeWithPowermock() throws Exception {
        String grade = Whitebox.invokeMethod(gc, "computeGrade", 50);
        assertEquals("Fail", grade);
    }

}