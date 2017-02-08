package logic;

import org.junit.Assert;
import org.junit.Test;
import utils.ResourceUtil;

public class ValidatorIntegrationTest {

    private static final String IMAGENAME = "lennyface.jpg";

    @Test
    public void shouldAcceptProperlySizedImage(){
        //given
        String imagePath = ResourceUtil.resolveImagePathFromResources(IMAGENAME);
        Validator validator = new Validator();

        //when
        boolean isValid = validator.validate(imagePath);

        //then
        Assert.assertTrue(isValid);
    }
}
