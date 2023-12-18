import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    @Test
    public void testAddContactSuccess() {
        ContactService contactService = new ContactService();
        // Attempt to add a contact with a unique ID
        Contact contact = new Contact("67890", "Alice", "Johnson", "5555555555", "789 Elm St");

        // Ensure no exception is thrown
        assertDoesNotThrow(() ->
                contactService.addContact(contact)
        );

        // Ensure the new contact is in the contactService
        assertEquals(contact, contactService.getContact("67890"));
    }

    @Test
    public void testContactServiceIdSuccess() {
        // Test getting contact
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("12345"));
    }

    @Test
    public void testContactServiceUpdateFirstNameSuccess() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Test updating contact's first name
        contactService.updateFirstName("12345", "Jane");
        assertEquals("Jane", contactService.getContact("12345").getFirstName());
    }

    @Test
    public void testContactServiceUpdateFirstNameNoContact() {
        ContactService contactService = new ContactService();
        // Test updating contact's first name
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateFirstName("12345", "Jane")
        );
    }

    @Test
    public void testContactServiceUpdateLastNameSuccess() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Test updating contact's last name
        contactService.updateLastName("12345", "Smith");
        assertEquals("Smith", contactService.getContact("12345").getLastName());
    }

    @Test
    public void testContactServiceUpdateLastNameNoContact() {
        ContactService contactService = new ContactService();
        // Test updating contact's first name
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateLastName("12345", "Smith")
        );
    }

    @Test
    public void testContactServiceUpdatePhoneSuccess() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Test updating contact's phone
        contactService.updatePhone("12345", "9876543210");
        assertEquals("9876543210", contactService.getContact("12345").getPhone());
    }

    @Test
    public void testContactServiceUpdatePhoneNoContact() {
        ContactService contactService = new ContactService();
        // Test updating contact's first name
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updatePhone("12345", "01234567891")
        );
    }

    @Test
    public void testContactServiceUpdateAddressSuccess() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Test updating contact's address
        contactService.updateAddress("12345", "456 Oak St");
        assertEquals("456 Oak St", contactService.getContact("12345").getAddress());
    }

    @Test
    public void testContactServiceUpdateAddressNoContact() {
        ContactService contactService = new ContactService();
        // Test updating contact's first name
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateAddress("12345", "456 Oak St")
        );
    }

    @Test
    public void testContactServiceDeleteSuccess() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Test deleting contact
        contactService.deleteContact("12345");
        assertNull(contactService.getContact("12345"));
    }

    @Test
    public void testContactServiceDeleteNoContact() {
        ContactService contactService = new ContactService();
        // Test updating contact's first name
        assertThrows(IllegalArgumentException.class, () ->
                contactService.deleteContact("12345")
        );
    }

    @Test
    public void testAddContactWithDuplicateId() {
        // Attempt to add a contact with a duplicate ID
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Contact duplicateContact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        // Ensure an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () ->
                contactService.addContact(duplicateContact)
        );
    }
}