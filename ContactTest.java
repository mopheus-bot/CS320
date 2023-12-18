import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ContactTest {

    @Test
    public void testCreateContactSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testCreateContactContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testCreateContactContactIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testCreateContactFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JohnnyAppleseed", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testCreateContactFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testCreateContactLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "DoeIsNotALongName", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testCreateContactLastNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testCreateContactPhoneNumberTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345678901", "123 Main St");
        });
    }

    @Test
    public void testCreateContactPhoneNumberTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789", "123 Main St");
        });
    }

    @Test
    public void testCreateContactPhoneNumberIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main St");
        });
    }

    @Test
    public void testCreateContactAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890",
                    "This Address needs at least 30 characters");
        });
    }

    @Test
    public void testCreateContactAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    public void testContactFirstNameUpdateSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");

        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testContactFirstNameUpdateFirstNameTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("JohnnyAppleseed");
        });
    }

    @Test
    public void testContactFirstNameUpdateFirstNameIsNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void testContactLastNameUpdateSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");

        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testContactLastNameUpdateLastNameTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("DoeIsNotALongName");
        });
    }

    @Test
    public void testContactLastNameUpdateLastNameIsNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    public void testContactPhoneUpdateSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("9876543210");

        assertEquals("9876543210", contact.getPhone());
    }

    @Test
    public void testContactPhoneUpdatePhoneTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345678901");
        });
    }

    @Test
    public void testContactPhoneUpdatePhoneTooShort() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123456789");
        });
    }

    @Test
    public void testContactPhoneUpdatePhoneIsNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    @Test
    public void testContactAddressUpdateSuccess() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Oak St");

        assertEquals("456 Oak St", contact.getAddress());
    }

    @Test
    public void testContactAddressUpdateAddressTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This Address needs at least 30 characters");
        });
    }

    @Test
    public void testContactAddressUpdateAddressIsNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
}