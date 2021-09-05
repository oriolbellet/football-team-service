package org.oriolbellet.football.team.application.command.shared;

import javax.inject.Named;
import java.util.UUID;

@Named
class RandomUUIDGenerator implements UUIDGenerator {
    @Override
    public UUID generateUUID() {
        return UUID.randomUUID();
    }
}
