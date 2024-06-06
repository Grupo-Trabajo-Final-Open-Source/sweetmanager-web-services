package com.git.sweetmanager.iam.infrastructure.hashing.bcrypt;

import com.git.sweetmanager.iam.application.internal.outboundservices.hashings.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {

}
