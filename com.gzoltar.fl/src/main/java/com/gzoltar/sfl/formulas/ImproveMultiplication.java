package com.gzoltar.sfl.formulas;

import com.gzoltar.core.model.Node;
import com.gzoltar.core.runtime.Probe;
import com.gzoltar.core.runtime.ProbeGroup;
import com.gzoltar.core.spectrum.ISpectrum;

import java.util.Map;

public class ImproveMultiplication {

    public static void improvement (final ISpectrum iSpectrum) {
        for (ProbeGroup probeGroup : iSpectrum.getProbeGroups()) {
            for (Probe probe : probeGroup.getProbes()) {
                Node node = probe.getNode();
                Map<String, Integer> elementsStatistics = node.getElementsStatistics();
                for (Map.Entry<String, Double> suspiciousnessValues : node.getSuspiciousnessValues().entrySet()) {
                    node.addSuspiciousnessValue(suspiciousnessValues.getKey(), suspiciousnessValues.getValue() * ((double) elementsStatistics.get("n11") / (elementsStatistics.get("n11") + elementsStatistics.get("n01"))));
                }
            }
        }
    }
}
