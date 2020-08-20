package pl.coderslab.tdd;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserRepositoryTest {

    private static UserRepository userRepository;
    private static String USER_NAME = "John";
    private static String USER_NAME_EDITED = "John edited";
    private static String USER_SURNAME = "Doe";
    private static String USER_SURNAME_EDITED = "Doe edited";
    private static int USER_ID = 1001;
    private static int DELETED_USER_ID = 2002;


    @BeforeClass
    public static void beforeClass() throws Exception {
        userRepository = new UserRepository();
    }

    @Test
    public void shouldCreateUser() {
        //given
        User user = new User(USER_ID, USER_NAME, USER_SURNAME);
        //when
        userRepository.createNewUser(user);
        //then
        assertSame(user, userRepository.findUserById(USER_ID));
    }

    @Test
    public void shouldDeleteUser() {
        //given
        User user = new User(DELETED_USER_ID, USER_NAME, USER_SURNAME);
        userRepository.createNewUser(user);
        //when
        userRepository.deleteUserById(DELETED_USER_ID);
        //then
        assertNull(userRepository.findUserById(DELETED_USER_ID));
    }

    @Test
    public void shouldEditUser() {
        //given
        User user = new User(DELETED_USER_ID, USER_NAME, USER_SURNAME);
        userRepository.createNewUser(user);
        //when
        user.setName(USER_NAME_EDITED);
        user.setSurname(USER_SURNAME_EDITED);

        userRepository.updateUser(user);

        //then
        User userById = userRepository.findUserById(DELETED_USER_ID);
        assertEquals(USER_NAME_EDITED, userById.getName());
        assertEquals(USER_SURNAME_EDITED, userById.getSurname());
    }

}
