/*
 * Copyright (c) 2020-2021 Polyhedral Development
 *
 * The Terra Core Addons are licensed under the terms of the MIT License. For more details,
 * reference the LICENSE file in this module's root directory.
 */

package com.dfsek.terra.addons.biome.command.biome.arg;

import com.dfsek.terra.api.Platform;
import com.dfsek.terra.api.command.arg.ArgumentParser;
import com.dfsek.terra.api.entity.CommandSender;
import com.dfsek.terra.api.entity.Player;
import com.dfsek.terra.api.inject.annotations.Inject;
import com.dfsek.terra.api.world.biome.TerraBiome;


public class BiomeArgumentParser implements ArgumentParser<TerraBiome> {
    @Inject
    private Platform platform;
    
    @Override
    public TerraBiome parse(CommandSender sender, String arg) {
        Player player = (Player) sender;
        return player.world().getConfig().getRegistry(TerraBiome.class).get(arg);
    }
}
