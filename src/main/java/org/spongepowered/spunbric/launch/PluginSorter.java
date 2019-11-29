package org.spongepowered.spunbric.launch;

import org.spongepowered.spunbric.SpunbricImpl;
import org.spongepowered.spunbric.launch.util.CyclicGraphException;
import org.spongepowered.spunbric.launch.util.DirectedGraph;
import org.spongepowered.spunbric.launch.util.TopologicalOrder;

import java.util.List;

public final class PluginSorter {

    private PluginSorter() {
    }

    public static List<PluginCandidate> sort(Iterable<PluginCandidate> candidates) {
        DirectedGraph<PluginCandidate> graph = new DirectedGraph<>();

        for (PluginCandidate candidate : candidates) {
            graph.add(candidate);
            for (PluginCandidate dependency : candidate.getDependencies()) {
                graph.addEdge(candidate, dependency);
            }
        }

        try {
            return TopologicalOrder.createOrderedLoad(graph);
        } catch (CyclicGraphException e) {
            StringBuilder msg = new StringBuilder();
            msg.append("Plugin dependencies are cyclical!\n");
            msg.append("Dependency loops are:\n");
            for (DirectedGraph.DataNode<?>[] cycle : e.getCycles()) {
                msg.append("[");
                for (DirectedGraph.DataNode<?> node : cycle) {
                    msg.append(node.getData().toString()).append(" ");
                }
                msg.append("]\n");
            }
            SpunbricImpl.getLogger().fatal(msg.toString());
            throw new RuntimeException("Plugin dependencies error.");
        }
    }

}
