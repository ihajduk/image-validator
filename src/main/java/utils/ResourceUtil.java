package utils;

import java.io.File;

public class ResourceUtil {
    private static ClassLoader classLoader = ResourceUtil.class.getClassLoader();

    public static String resolveImagePathFromResources(String imageName) {
        File file;
        try {
            file = new File(classLoader.getResource(imageName).getFile());
        } catch (NullPointerException e) {
            throw new RuntimeException("File "+imageName+" not found");
        }
        return file.getAbsolutePath();
    }
}
