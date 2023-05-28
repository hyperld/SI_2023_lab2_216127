import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void testEveryBranch(){

        RuntimeException e = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertEquals("Mandatory information missing!", e.getMessage());
        List<User> users = new LinkedList<>();
        users.add(new User(null, "!asdwerasd", "niki@gmail.com"));

        //A-C-D-E-F-G-H-I-J-K-G-L-M-N-U
        assertFalse(SILab2.function(new User(null, "!qwerty", "niki@gmail.com"), users));

        //A-C-E-M-O-T-U
        assertFalse(SILab2.function(new User("kompir", "!qwertyu dasasderrw2dw", "niki2gmailcom"), users));

        //A-C-D-E-F-G-H-J-G-L-M-O-P-Q-R-U
        assertTrue(SILab2.function(new User("kompir", "!mjaumjauoqwe", "niki3@gmail.com"), users));

    }

    @Test
    void multipleCondition(){

        RuntimeException e = assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, null), null));
        assertEquals("Mandatory information missing!", e.getMessage());
        e = assertThrows(RuntimeException.class, () -> SILab2.function(new User("niki", null, null), null));
        assertEquals("Mandatory information missing!", e.getMessage());
        e = assertThrows(RuntimeException.class, () -> SILab2.function(new User("niki", "asqwetqw!", null), null));
        assertEquals("Mandatory information missing!", e.getMessage());
        e = assertThrows(RuntimeException.class, () -> SILab2.function(new User("niki", "asdasqwers!dwa", "niki@gmail.com"), null));
        assertNotEquals("Mandatory information missing!", e.getMessage());
    }
}