package org.spongepowered.spunbric.launch;

import net.fabricmc.loader.launch.common.FabricLauncherBase;

import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.util.Optional;

public final class PluginSource {

    public static final PluginSource CLASSPATH = new PluginSource();

    private final Optional<Path> source;
    private boolean onClasspath;

    private PluginSource() {
        this.source = Optional.empty();
        this.onClasspath = true;
    }

    PluginSource(Path path) {
        this.source = Optional.of(path);
    }

    public Optional<Path> getPath() {
        return this.source;
    }

    public void addToClasspath() {
        if (this.onClasspath) {
            return;
        }

        this.onClasspath = true;

        try {
            // Source should be always present at this point\
            // FabricLoader acts as an abstraction to LaunchWrapper (even though it is present on the classpath).
            // So instead we would interact through the launcher to add to the classloader.
            // We can get the classloader using FabricLauncherBase.getLauncher().getTargetClassLoader()
            // However it is much easier to use FabricLauncherBase.getLauncher().propose(URL) rather than cast to a URLClassLoader.
            FabricLauncherBase.getLauncher().propose(this.source.get().toUri().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to add plugin " + this + " to classpath", e);
        }
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PluginSource other = (PluginSource) o;
        return this.source.equals(other.source);
    }

    @Override
    public int hashCode() {
        return this.source.hashCode();
    }

    @Override
    public String toString() {
        if (this.source.isPresent()) {
            return this.source.get().toString();
        }

        return "unknown";
    }

    public static Optional<Path> find(Class<?> type) {
        CodeSource source = type.getProtectionDomain().getCodeSource();
        if (source == null) {
            return Optional.empty();
        }

        URL location = source.getLocation();
        String path = location.getPath();

        if (location.getProtocol().equals("jar")) {
            // LaunchWrapper returns the exact URL to the class, not the path to the JAR
            if (path.startsWith("file:")) {
                int pos = path.lastIndexOf('!');
                if (pos >= 0) {
                    // Strip path in JAR
                    path = path.substring(0, pos);
                }
            }
        } else if (location.getProtocol().equals("file")) {
            final String classPath = type.getName().replace('.', '/') + ".class";
            final int pos = path.lastIndexOf(classPath);
            if (pos != -1) {
                path = path.substring(0, pos);
            }
            path = "file:" + path;
        } else {
            return Optional.empty();
        }

        try {
            return Optional.of(Paths.get(new URI(path)));
        } catch (URISyntaxException e) {
            throw new InvalidPathException(path, "Not a valid URI");
        }
    }
}
