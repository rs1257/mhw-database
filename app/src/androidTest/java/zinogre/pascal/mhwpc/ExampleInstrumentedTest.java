package zinogre.pascal.mhwpc;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented decoration_1_slot, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under decoration_1_slot.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("zinogre.pascal.mhwpc", appContext.getPackageName());
    }
}
