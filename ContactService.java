import java.util.HashMap;
import java.util.Map;
public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Creates new contact
    // Verifies contactId does not already exist
    public void addContact(Contact contact) {
        String contactId = contact.getContactId();
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Duplicate Contact ID");
        }
        contacts.put(contactId, contact);
    }

    // Deletes contact
    // Verifies contact exists before deletion
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    // Updates first name field of contact
    // Verifies contact exists
    public void updateFirstName(String contactId, String firstName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    // Updates last name field of contact
    // Verifies contact exists
    public void updateLastName(String contactId, String lastName) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    // Updates phone number field of contact
    // Verifies contact exists
    public void updatePhone(String contactId, String phone) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    // Updates address field of contact
    // Verifies contact exists
    public void updateAddress(String contactId, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    // For testing
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
