package com.lapum.ethical_fishing.firebase_rest;

import com.lapum.ethical_fishing.Utilities;
import com.lapum.ethical_fishing.firebase_rest.client.FirebaseClient;
import com.lapum.ethical_fishing.objects.Victim;

public class FirebaseManager {

    private final static String VICTIM_PATH_KEY = "victimPath";
    private final static String FIREBASE_URL_KEY = "firebaseUrl";

    public static void postData() {
        final FirebaseClient client = new FirebaseClient(Utilities.getStringProperty(FIREBASE_URL_KEY));
        Victim victim = new Victim();
        client.post(Utilities.getStringProperty(VICTIM_PATH_KEY), victim.toData());
    }
}
