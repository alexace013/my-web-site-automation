package tests.unit.utils;

import lombok.extern.log4j.Log4j;
import org.assertj.core.api.SoftAssertions;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import utils.FilesUtil;

import java.util.Arrays;

@Log4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileUtilTest {

    @Test
    public void testMainResourcesFolderFilenames() {
        SoftAssertions softly = new SoftAssertions();
        String[] actualFilenames = FilesUtil.getMainResourcesFolderPropertiesFilenames();
        log.debug(Arrays.toString(actualFilenames));
        softly.assertThat(actualFilenames.length).as("Not actual length").isNotEqualTo(0);
        softly.assertThat(actualFilenames[0]).as("Not actual filename").isNotEmpty();
    }

    @Test
    public void testTestResourcesFolderFilenames() {
        SoftAssertions softly = new SoftAssertions();
        String[] actualFilenames = FilesUtil.getTestResourcesFolderPropertiesFilenames();
        log.debug(Arrays.toString(actualFilenames));
        softly.assertThat(actualFilenames.length).as("Not actual length").isEqualTo(1);
        softly.assertThat(actualFilenames[0]).as("Not actual filename").isEqualTo("test.tst");
    }
}