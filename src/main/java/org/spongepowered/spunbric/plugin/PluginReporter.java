package org.spongepowered.spunbric.plugin;

import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;
import org.spongepowered.spunbric.launch.PluginCandidate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

final class PluginReporter {

    private static final String NEW_DETAILS_LINE = "\n\t\t";
    private static final String SEPARATOR = ": ";

    private PluginReporter() {
    }

    static String formatRequirements(Map<String, String> requirements) {
        StringBuilder builder = new StringBuilder();
        formatRequirements(builder, requirements);
        return builder.toString();
    }

    private static void formatRequirements(StringBuilder builder, Map<String, String> requirements) {
        checkArgument(!requirements.isEmpty(), "Requirements cannot be empty");

        boolean first = true;
        for (Map.Entry<String, String> entry : requirements.entrySet()) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }

            // Append plugin ID
            builder.append(entry.getKey());

            final String version = entry.getValue();
            if (version != null) {
                builder.append(" (Version ").append(version).append(')');
            }
        }
    }

    static RuntimeException crash(Throwable e, Collection<PluginCandidate> candidates) {
        CrashReport crash = CrashReport.create(e, "Loading Sponge plugins");
        CrashReportSection section = crash.addElement("Plugins being loaded");

        StringBuilder pluginsBuilder = new StringBuilder();
        StringBuilder requirementsBuilder = new StringBuilder();
        StringBuilder dependenciesBuilder = new StringBuilder();

        for (PluginCandidate candidate : candidates) {
            pluginsBuilder.append(NEW_DETAILS_LINE).append(candidate);

            if (candidate.dependenciesCollected()) {
                Set<PluginCandidate> requirements = candidate.getRequirements();
                Map<String, String> missingRequirements = candidate.getMissingRequirements();

                if (!requirements.isEmpty() || !missingRequirements.isEmpty()) {
                    requirementsBuilder.append(NEW_DETAILS_LINE).append(candidate.getId()).append(SEPARATOR);

                    if (!requirements.isEmpty()) {
                        Map<String, String> versioned = new HashMap<>();
                        for (PluginCandidate requirement : requirements) {
                            versioned.put(requirement.getId(), candidate.getVersion(requirement.getId()));
                        }

                        formatRequirements(requirementsBuilder, versioned);
                        if (!missingRequirements.isEmpty()) {
                            requirementsBuilder.append(", ");
                        }
                    }

                    if (!missingRequirements.isEmpty()) {
                        requirementsBuilder.append("missing: ");
                        formatRequirements(requirementsBuilder, missingRequirements);
                    }
                }

                if (!candidate.getDependencies().isEmpty()) {
                    dependenciesBuilder.append(NEW_DETAILS_LINE).append(candidate.getId()).append(SEPARATOR).append(candidate.getDependencies());
                }
            }
        }

        section.add("Plugins", pluginsBuilder);
        if (requirementsBuilder.length() > 0) {
            section.add("Requirements", requirementsBuilder);
        }
        if (dependenciesBuilder.length() > 0) {
            section.add("Dependencies", dependenciesBuilder);
        }

        throw new CrashException(crash);
    }

}
