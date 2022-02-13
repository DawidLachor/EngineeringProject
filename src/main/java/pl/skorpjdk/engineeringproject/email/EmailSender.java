package pl.skorpjdk.engineeringproject.email;

public interface EmailSender {
    void send(String to, String bodyEmail);
}
