package com.validatepolicy.ValidatePolicy.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestPayload {
    @JsonProperty("message_validation")
    private MessageValidation messageValidation;

    @JsonProperty("message_route")
    private MessageRoute messageRoute;

    @JsonProperty("message_body")
    private MessageBody messageBody;

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(MessageBody messageBody) {
        this.messageBody = messageBody;
    }

    public MessageValidation getMessageValidation() {
        return messageValidation;
    }

    public void setMessageValidation(MessageValidation messageValidation) {
        this.messageValidation = messageValidation;
    }

    public MessageRoute getMessageRoute() {
        return messageRoute;
    }

    public void setMessageRoute(MessageRoute messageRoute) {
        this.messageRoute = messageRoute;
    }
// getters and setters
}
