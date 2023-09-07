package xyz.galaxyy.tdeathmessages;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.galaxyy.tdeathmessages.listeners.PlayerDeathListener;

import java.util.List;
import java.util.Objects;

public final class TDeathMessages extends JavaPlugin {
    public boolean miniPlaceholders = false;
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.checkGamerule();
        this.getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
        if (this.getServer().getPluginManager().getPlugin("MiniPlaceholders") != null && Objects.requireNonNull(this.getServer().getPluginManager().getPlugin("MiniPlaceholders")).isEnabled()) {
            this.miniPlaceholders = true;
        }
    }

    private void checkGamerule() {
        List<World> worlds = this.getServer().getWorlds();
        for (World world : worlds) {
            if (!Objects.requireNonNull(world.getGameRuleValue(GameRule.SHOW_DEATH_MESSAGES))) {
                this.getLogger().warning("The gamerule showDeathMessages is set to false in: " + world.getName() + ". Death messages will not be shown!.");
            }
        }
    }
}