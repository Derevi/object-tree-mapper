package kkn.derevi;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.*;

public class ClassModelsCatalogTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        //todo create class models

    }

    @Test
    public void loadingSerializedObjectReturnsProperClassModelsList() {
        //todo load .ser test file and assert file

    }

    @Test
    public void loadingEmptyFileProducesNull() {

        //todo load empter .ser file
    }

    @Test
    public void loadingNonExistantFileNotAllowed() {
        thrown.expect(IOException.class);
        //todo load file that DNE
    }

    @Test
    public void loadingInvalidSerializedObjectNotAllowed() {
        thrown.expect(ClassNotFoundException.class);
        //todo load improper serlized object
    }



    @Test
    public void savingToNonExistantFileNotAllowed() {
        thrown.expect(IOException.class);
        //todo save to file that DNE
    }

    @Test
    public void savingProducesProperSerializedObject() {
        //todo save to .ser and load to check .ser assert equals appropriate size
    }
}