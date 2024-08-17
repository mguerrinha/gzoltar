/**
 * Copyright (C) 2020 GZoltar contributors.
 *
 * This file is part of GZoltar.
 *
 * GZoltar is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * GZoltar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with GZoltar. If
 * not, see <https://www.gnu.org/licenses/>.
 */
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
