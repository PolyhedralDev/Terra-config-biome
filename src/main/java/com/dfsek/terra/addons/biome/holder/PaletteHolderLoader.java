package com.dfsek.terra.addons.biome.holder;

import com.dfsek.tectonic.exception.LoadException;
import com.dfsek.tectonic.loading.ConfigLoader;
import com.dfsek.tectonic.loading.TypeLoader;

import java.lang.reflect.AnnotatedType;
import java.util.List;
import java.util.Map;

import com.dfsek.terra.api.world.generator.Palette;


public class PaletteHolderLoader implements TypeLoader<PaletteHolder> {
    @SuppressWarnings("unchecked")
    @Override
    public PaletteHolder load(AnnotatedType type, Object o, ConfigLoader configLoader) throws LoadException {
        List<Map<String, Integer>> palette = (List<Map<String, Integer>>) o;
        PaletteHolderBuilder builder = new PaletteHolderBuilder();
        for(Map<String, Integer> layer : palette) {
            for(Map.Entry<String, Integer> entry : layer.entrySet()) {
                builder.add(entry.getValue(), configLoader.loadType(Palette.class, entry.getKey()));
            }
        }
        return builder.build();
    }
}
