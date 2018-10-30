package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.unit.utils.FileUtilTest;
import tests.unit.utils.ForSimpleTest;
import tests.unit.utils.OSControllerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                FileUtilTest.class,
                ForSimpleTest.class,
                OSControllerTest.class,
                unit.utils.PropertyControllerTest.class
        }
)
public class MyWebSiteJUnit4TestsRunner {
}