package com.denarious.transversal.domain.message;

public class APIMessage {
    public static final String HEALTH_API_TAG = "Status of the application server";
    public static final String CHECK_HEALTH_SUMMARY = "Check the status of the application server";
    public static final String CHECK_HEALTH_DESCRIPTION = "This endpoint is used to check the status of the application where it will return an OK if the server is up";

    private APIMessage() {}
}