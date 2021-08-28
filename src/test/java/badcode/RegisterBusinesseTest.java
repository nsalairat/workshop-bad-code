package badcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegisterBusinesseTest {
    private RegisterBusiness testBusiness = new RegisterBusiness();
    private Speaker speaker = new Speaker();

    @Test
    @DisplayName("ไม่กำหนดชื่อ จะเกิด exception firstname")
    public void testRegisterCaseFirstNameIsNull() {
        try {
            testBusiness.register(null, new Speaker());
        } catch (ArgumentNullException e) {
            assertEquals("First name is required.", e.getMessage());
        }
    }

    @Test
    public void testRegisterCaseLastNameIsNull() {
        try {
            speaker.setFirstName("firstName");
            testBusiness.register(null, speaker);
            fail();
        } catch (ArgumentNullException e) {
            assertEquals("Last name is required.", e.getMessage());
        }
    }

    @Test
    public void testRegisterCaseEmailIsNull() {
        try {
            speaker.setFirstName("firstName");
            speaker.setLastName("lastName");
            testBusiness.register(null, speaker);
            fail();
        } catch (ArgumentNullException e) {
            assertEquals("Email is required.", e.getMessage());
        }
    }

    @Test
    public void testRegisterCaseEmailIsInValid() {
        try {
            speaker.setFirstName("firstName");
            speaker.setLastName("lastName");
            speaker.setEmail("email");
            testBusiness.register(null, speaker);
            fail();
        } catch (DomainEmailInvalidException e) {

        }
    }

    @Test
    public void testRegisterCaseSave() {
        try {
            speaker.setFirstName("firstName");
            speaker.setLastName("lastName");
            speaker.setEmail("email@gmail.com");
            testBusiness.register(null, speaker);
            fail();
        } catch (SaveSpeakerException e) {
            assertEquals("Can't save a speaker.", e.getMessage());
        }
    }
}
