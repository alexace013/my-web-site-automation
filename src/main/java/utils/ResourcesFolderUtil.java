package utils;

import static utils.ResourcesFolderUtil.ResourcesFolder.MAIN;
import static utils.ResourcesFolderUtil.ResourcesFolder.TEST;
import static controller.PropertyController.PropertyType.PROP;
import static controller.PropertyController.PropertyType.TST;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

@Log4j
public class ResourcesFolderUtil {

    public static String[] getMainResourcesFolderPropertiesFilenames() {
        return getResourcesFolderFilenamesByTypeOfFiles(MAIN.toString().toLowerCase(), PROP.getProperty());
    }

    public static String[] getTestResourcesFolderPropertiesFilenames() {
        return getResourcesFolderFilenamesByTypeOfFiles(TEST.toString().toLowerCase(), TST.getProperty(), "test");
    }

    /**
     * @param resourcesFolder resources main or test folderName
     * @param typeOfFiles     filenames type of files
     * @param directoryPath   another directory path i project structure
     * @return array Strings with resources folderName filenames
     */
    public static String[] getResourcesFolderFilenamesByTypeOfFiles(
            final String resourcesFolder,
            final String typeOfFiles,
            final String... directoryPath) {
        String dirPath = String.format("%s/src/%s/resources/%s",
                System.getProperty("user.dir"),
                resourcesFolder,
                Arrays.toString(directoryPath).replace("[", "").replace("]", ""));
        log.debug(String.format("path: %s", dirPath));
        File file = new File(dirPath);
        File[] files = file.listFiles();
        assert files != null;
        ArrayList<String> filenamesList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                log.debug(String.format("<%s> is directory.", files[i].getName()));
            } else if (files[i].isFile()) {
                if (files[i].getName().contains(typeOfFiles)) {
                    filenamesList.add(files[i].getName());
                }
            }
        }
        return filenamesList.toArray(new String[0]);
    }

    public enum ResourcesFolder {
        MAIN, TEST
    }
}