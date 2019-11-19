package org.spongepowered.spunbric.plugin.sponge;

import net.fabricmc.loader.api.metadata.ContactInformation;
import net.fabricmc.loader.api.metadata.Person;

public class FabricPerson implements Person {
    private final String name;

    public FabricPerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ContactInformation getContact() {
        return ContactInformation.EMPTY; // Sponge does not supply author contact info.
    }
}
