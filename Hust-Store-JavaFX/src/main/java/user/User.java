package user;
import user.PasswordHelper;
public class User {
    private String userId;
    private String name;
    private String phoneNumber;
    private String email;
    private byte[] passwordHash;
    private byte[] salt;
    private String password;
    public User() {
    }

    public User(String userId, String name, String phoneNumber, String email) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(String userId, String name, String phoneNumber, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        PasswordHelper passwordHelper = new PasswordHelper();
        this.salt = passwordHelper.generateSalt();
        this.password = password;
        try {
            this.passwordHash = passwordHelper.hashPassword(password, salt);
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void login() {
        // Log in bằng cách nào?
    }

    public void login(String password) {
        // Assuming that they have already registered
        PasswordHelper passwordHelper = new PasswordHelper();
        try {
            if (passwordHelper.verifyPassword(password, this.salt, this.passwordHash)) {
                // Login successful
            } else {
                throw new RuntimeException("Invalid password");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error verifying password", e);
        }
    }

    public void logout() {
        // Log out bằng cách nào?

    }

    public void updateProfile(String name, String phoneNumber, String email) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            this.phoneNumber = phoneNumber;
        }
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
    }

    public void changePassword() {
        // Tương tự updateProfile
    }

    public void changePassword(String newPassword) {
        // Assuming that they have already logged in
        PasswordHelper passwordHelper = new PasswordHelper();
        // Try to log in with the new password, we can't let them change password if it's the same as the old one
        try {
            if (passwordHelper.verifyPassword(newPassword, this.salt, this.passwordHash)) {
                throw new RuntimeException("New password cannot be the same as the old password");
            }
            this.salt = passwordHelper.generateSalt();
            this.passwordHash = passwordHelper.hashPassword(newPassword, salt);
        } catch (Exception e) {
            throw new RuntimeException("Error changing password", e);
        }

    }

}
