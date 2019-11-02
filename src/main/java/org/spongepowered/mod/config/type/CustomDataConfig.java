package org.spongepowered.mod.config.type;

import ninja.leaping.configurate.objectmapping.Setting;
import org.spongepowered.mod.config.category.CustomDataRegistrationCategory;

public class CustomDataConfig extends ConfigBase {

    @Setting(value = "data-registration")
    private CustomDataRegistrationCategory datalists = new CustomDataRegistrationCategory();

    public CustomDataConfig() {
    }

    public CustomDataRegistrationCategory getDataRegistrationConfig() {
        return this.datalists;
    }

}
