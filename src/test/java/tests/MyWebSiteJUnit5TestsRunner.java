package tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import tests.unit.utils.ResourcesFolderUtilTest;
import tests.unit.utils.ForSimpleTest;
import tests.unit.utils.OSControllerTest;

@RunWith(JUnitPlatform.class)
@SelectClasses(
        {
                ResourcesFolderUtilTest.class,
                ForSimpleTest.class,
                OSControllerTest.class,
                unit.utils.PropertyControllerTest.class
        }
)
public class MyWebSiteJUnit5TestsRunner {
}