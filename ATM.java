import java.util.ArrayList;

public class ATM {
    private ArrayList<Account> accounts;

    public ATM() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account authenticate(int userId, int pin) {
        for (Account account : accounts) {
            if (account.getUserId() == userId && account.getPin() == pin) {
                return account;
            }
        }
        return null;
    }
}