package org.spongepowered.spunbric;

import com.google.common.base.MoreObjects;
import org.spongepowered.api.MinecraftVersion;

public final class SpongeMinecraftVersion implements MinecraftProtocolVersion, MinecraftVersion {

    private final String name;
    private final int protocol;

    public SpongeMinecraftVersion(String name, int protocol) {
        this.name = name;
        this.protocol = protocol;
    }

    public static int compare(MinecraftProtocolVersion version, MinecraftVersion to) {
        if (version.equals(to)) {
            return 0;
        } else if (to.isLegacy()) {
            return 1;
        } else {
            return version.getProtocol() - ((MinecraftProtocolVersion) to).getProtocol();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getProtocol() {
        return this.protocol;
    }

    @Override
    public boolean isLegacy() {
        return false;
    }

    @Override
    public int compareTo(MinecraftVersion o) {
        return compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MinecraftProtocolVersion)) {
            return false;
        }

        MinecraftProtocolVersion that = (MinecraftProtocolVersion) o;
        return this.getProtocol() == that.getProtocol();

    }

    @Override
    public int hashCode() {
        return this.protocol;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", this.name)
                .add("protocol", this.protocol)
                .toString();
    }
}