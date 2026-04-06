package oop2.lambdas.permissions2;

public class SecuritySubSystem {
    public boolean checkAddPermission(String userId) {
        if (userId.equals("1")) {
            return true;
        }
        return false;
    }

    public boolean checkRemovePermission(String userId) {
        if (userId.equals("1")) {
            return true;
        }
        return false;
    }

    public boolean checkListPermission(String userId) {
        if (userId.equals("1")) {
            return true;
        }
        return false;
    }
}

