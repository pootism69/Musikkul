import Database.Database;
import java.io.IOException;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Model_Music;

public class DatabaseTest {

    private static Database database;

    @BeforeClass
    public static void setUp() {
        database = Database.getInstance();
    }

    @Test
    public void testLoginDBSuccess() {
        int adminLoginResult = database.loginDB("fawwaz_yasirah", "696969");
        assertEquals(1, adminLoginResult); // Assuming admin login is successful

        int userLoginResult = database.loginDB("abijar", "111");
        assertEquals(2, userLoginResult); // Assuming user login is successful
    }

    @Test
    public void testLoginDBFailure() {
        int invalidUserLoginResult = database.loginDB("xiami", "000");
        assertEquals(-1, invalidUserLoginResult); // Assuming login fails for nonexistent user

        int invalidPasswordResult = database.loginDB("abijar", "000");
        assertEquals(0, invalidPasswordResult); // Assuming login fails for invalid password
    }

    @Test
    public void testCheckDBStringSuccess() {
        boolean existingUser = database.checkDBString("user", "nama", "suharto");
        assertTrue(existingUser); // Assuming "testuser" exists in the 'user' table under 'nama' column
    }

    @Test
    public void testCheckDBStringFailure() {
        boolean nonExistingUser = database.checkDBString("user", "nama", "nonexistentuser");
        assertFalse(nonExistingUser); // Assuming "nonexistentuser" doesn't exist in the 'user' table under 'nama' column
    }

    @Test
    public void testCheckDBIntSuccess() {
        boolean existingSong = database.checkDBInt("song", "songID", 0);
        assertTrue(existingSong); // Assuming there is a song with ID 1 in the 'song' table
    }

    @Test
    public void testCheckDBIntFailure() {
        boolean nonExistingSong = database.checkDBInt("song", "songID", 999);
        assertFalse(nonExistingSong); // Assuming there is no song with ID 999 in the 'song' table
    }



    @Test
    public void testInsertRegDBSuccess() throws SQLException {
        boolean insertResult = database.insertRegDB("newuser", "newpassword", 101);
        assertTrue(insertResult); // Assuming registration is successful for a new user
    }

    @Test
    public void testInsertRegDBFailure() throws SQLException {
        // Assuming registration fails for an already existing username
        boolean existingUserInsertResult = database.insertRegDB("bijar", "newpassword", 101);
        assertFalse(existingUserInsertResult);
    }
    
     @Test
    public void testInsertMusicSuccess() throws SQLException, ClassNotFoundException {
        Model_Music testMusic = new Model_Music();
        testMusic.setName("wahai");
        testMusic.setTime(187);
        testMusic.setPenyanyi("manusia");
        testMusic.setLink("www.google.com");
        testMusic.setLirik("mau tau?");
        testMusic.setGenre("koshidah");
        

        // Assuming the song with ID 200 doesn't exist
        boolean insertMusicResult = database.InsertMusic(testMusic, 11);
        assertTrue(insertMusicResult); // Assuming insertion is successful
    }

    @Test
    public void testInsertMusicFailure() throws SQLException, ClassNotFoundException {
        // Assuming the song with ID 1 already exists
        Model_Music existingMusic = new Model_Music();
        
        existingMusic.setName("wahai");
        existingMusic.setTime(187);
        existingMusic.setPenyanyi("manusia");
        existingMusic.setLink("www.google.com");
        existingMusic.setLirik("mau tau?");
        existingMusic.setGenre("koshidah");

        boolean existingMusicInsertResult = database.InsertMusic(existingMusic, 0);
        assertFalse(existingMusicInsertResult); // Assuming insertion fails for existing song

        // You can add more cases to cover failure scenarios for InsertMusic
    }

    @Test
    public void testCreatePlaylistSuccess() {
        // Assuming the playlist named "New Playlist" doesn't exist
        boolean createPlaylistResult = database.createPlaylist("News", 762);
        assertTrue(createPlaylistResult); // Assuming playlist creation is successful
    }

    @Test
    public void testCreatePlaylistFailure() {
        // Assuming the playlist named "Existing Playlist" already exists
        boolean existingPlaylistResult = database.createPlaylist("Playlist1", 1);
        assertFalse(existingPlaylistResult); // Assuming creation fails for existing playlist

        // You can add more cases to cover failure scenarios for createPlaylist
    }

    @Test
    public void testInsertMusicToPlaylistSuccess() {
        // Assuming the playlist with ID 300 and song with ID 2 exist
        boolean insertToPlaylistResult = database.insertMusicToPlaylist(6, 2);
        assertTrue(insertToPlaylistResult); // Assuming insertion to playlist is successful
    }

    @Test
    public void testInsertMusicToPlaylistFailure() {
        // Assuming the playlist with ID 300 doesn't exist
        boolean nonExistingPlaylistResult = database.insertMusicToPlaylist(300, 2);
        assertFalse(nonExistingPlaylistResult); // Assuming insertion fails for nonexistent playlist

        // Assuming the song with ID 999 doesn't exist
        boolean nonExistingSongResult = database.insertMusicToPlaylist(762, 999);
        assertFalse(nonExistingSongResult); // Assuming insertion fails for nonexistent song

        // You can add more cases to cover failure scenarios for insertMusicToPlaylist
    }
    

    @Test
    public void testDeleteMusicSuccess() {
        // Assuming the song with ID 5 exists
        boolean deleteMusicResult = database.deleteMusic(0);
        assertTrue(deleteMusicResult); // Assuming deletion is successful
    }

    @Test
    public void testDeleteMusicFailure() {
        // Assuming the song with ID 999 doesn't exist
        boolean nonExistingMusicResult = database.deleteMusic(999);
        assertFalse(nonExistingMusicResult); // Assuming deletion fails for nonexistent song

        // You can add more cases to cover failure scenarios for deleteMusic
    }

    @Test
    public void testInsertMusicToUserSuccess() {
        // Assuming user with ID 1 exists and song with ID 10 exists
        boolean insertToUserResult = database.insertMusicToUser(762, 6, "local/dir");
        assertTrue(insertToUserResult); // Assuming insertion to user is successful
    }

    @Test
    public void testInsertMusicToUserFailure() {
        // Assuming user with ID 999 doesn't exist
        boolean nonExistingUserResult = database.insertMusicToUser(999, 10, "local/dir");
        assertFalse(nonExistingUserResult); // Assuming insertion fails for nonexistent user

        // Assuming song with ID 999 doesn't exist
        boolean nonExistingSongResult = database.insertMusicToUser(1, 999, "local/dir");
        assertFalse(nonExistingSongResult); // Assuming insertion fails for nonexistent song

        // You can add more cases to cover failure scenarios for insertMusicToUser
    }
    



    @Test
    public void testGetDBWhere() {
        // Assuming there is a record in the 'user' table with userID 1
        ResultSet resultSet = database.getDBWhere("user", "userID=1");
        assertNotNull(resultSet); // Assuming the result set is not null
        // You can add more assertions based on the expected result set
    }

    @Test
    public void testDownload() throws IOException {
        // Assuming the provided URL and name are valid
        String url = "https://drive.google.com/uc?export=download&id=1dNH_8qcCSL3f2y20kRZGaygyOGjqLzeM";
        String name = "sample";
        String downloadResult = database.Download(url, name);
        assertNotNull(downloadResult); // Assuming download is successful
        // You can add more assertions based on the expected download result
    }

    @Test
    public void testEditSongSuccess() {
        // Assuming the song with ID 1 exists
        Model_Music editedSong = new Model_Music();
        editedSong.setName("wahai");
        editedSong.setTime(187);
        editedSong.setPenyanyi("manusia");
        editedSong.setLink("www.google.com");
        editedSong.setLirik("mau tau?");
        editedSong.setGenre("koshidah");
        
        boolean editSongResult = database.editSong(editedSong, 1);
        assertTrue(editSongResult); // Assuming song edit is successful
    }

    @Test
    public void testEditSongFailure() {
        // Assuming the song with ID 999 doesn't exist
        Model_Music editedSong = new Model_Music();
        editedSong.setName("wahai");
        editedSong.setTime(187);
        editedSong.setPenyanyi("manusia");
        editedSong.setLink("www.google.com");
        editedSong.setLirik("mau tau?");
        editedSong.setGenre("koshidah");
        boolean nonExistingSongResult = database.editSong(editedSong, 99);
        
        assertFalse(nonExistingSongResult); // Assuming edit fails for nonexistent song

        // You can add more cases to cover failure scenarios for editSong
    }

    // Add more test methods for other functionalities in your Database class

    @AfterClass
    public static void tearDown() {
        // Clean up or release any resources if needed
    }
}