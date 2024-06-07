package com.git.sweetmanager.iam.application.internal.outboundservices.hashings;

public interface HashingService {
    String encode(CharSequence rawPassword);
    boolean matches(CharSequence rawPassword, String encodedPassword);
}
