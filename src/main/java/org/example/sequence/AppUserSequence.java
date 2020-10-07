package org.example.sequence;

public class AppUserSequence {

    private static int appUserSequence;

    public static int nextAppUserId() {
        return ++ appUserSequence;
    }

    public static int getAppUserSequence() {
        return appUserSequence;
    }
}
