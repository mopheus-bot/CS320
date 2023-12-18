public class Contact {
// alt + enter
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        // Verify the contactId
        if (contactId == null || contactId.length()>10) {
            throw new IllegalArgumentException("Invalid Contact ID");
        }

        // Verify the firstName input
        if (firstName == null || firstName.length()>10) {
            throw new IllegalArgumentException("Invalid First Name");
        }

        // Verify the lastName input
        if (lastName == null || lastName.length()>10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }

        // Verify the phone input
        if (phone == null || phone.length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        // Verify the address input
        if (address == null || address.length()>30) {
            throw new IllegalArgumentException("Invalid Address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // contact ID getter
    public String getContactId() {
        return contactId;
    }

    // first name getter
    public String getFirstName() {
        return firstName;
    }


    // first name setter
    // verifies input
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length()>10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        this.firstName = firstName;
    }

    // last name getter
    public String getLastName() {
        return lastName;
    }

    // last name setter
    // verifies input
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length()>10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        this.lastName = lastName;
    }


    // phone number getter
    public String getPhone() {
        return phone;
    }

    // phone number setter
    // verifies the input
    public void setPhone(String phone) {
        if (phone == null || phone.length()!=10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        this.phone = phone;
    }

    // address getter
    public String getAddress() {
        return address;
    }

    // address setter
    // verifies input
    public void setAddress(String address) {
        if (address == null || address.length()>30) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.address = address;
    }
}