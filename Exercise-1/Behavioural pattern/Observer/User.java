class User implements Observer {
    private String name;
    private String phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String commentary) {
        sendSMS(phoneNumber, commentary);
    }

    private void sendSMS(String phoneNumber, String message) {
        // Simulate sending an SMS
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }

    public String getName() {
        return name;
    }
}
