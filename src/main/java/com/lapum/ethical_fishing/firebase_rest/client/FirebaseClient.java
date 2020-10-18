package com.lapum.ethical_fishing.firebase_rest.client;

import com.lapum.ethical_fishing.Utilities;

import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * A thin wrapper on firebase4j
 */
public class FirebaseClient {

    final private static String TAG = "FirebaseRest";

    Firebase client;

    public FirebaseClient(String url) {
        try {
            client = new Firebase(url);
        } catch (FirebaseException e) {
            e.printStackTrace();
        }
    }

    public FirebaseResponse get(String path) {
        try {
            return client.get(path);
        } catch (FirebaseException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void post(String path, Map<String, Object> data) {
        try {
            FirebaseResponse response = client.post(path, data);
            Utilities.log(TAG, "Firebase Response: " + response);
        } catch (FirebaseException | UnsupportedEncodingException | JacksonUtilityException e) {
            e.printStackTrace();
        }
    }

    public void put(String path, Map<String, Object> data) {
        try {
            FirebaseResponse response = client.put(path, data);
            Utilities.log(TAG, "Firebase Response: " + response);
        } catch (JacksonUtilityException | FirebaseException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void patch(String path, Map<String, Object> data) {
        try {
            FirebaseResponse response = client.patch(path, data);
            Utilities.log(TAG, "Firebase Response: " + response);
        } catch (FirebaseException | JacksonUtilityException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void delete(String path) {
        try {
            FirebaseResponse response = client.delete(path);
            Utilities.log(TAG, "Firebase Response: " + response);
        } catch (FirebaseException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
