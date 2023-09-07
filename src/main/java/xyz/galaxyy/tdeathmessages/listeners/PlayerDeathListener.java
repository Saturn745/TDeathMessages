package xyz.galaxyy.tdeathmessages.listeners;

import io.github.miniplaceholders.api.MiniPlaceholders;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.galaxyy.tdeathmessages.TDeathMessages;

import java.util.List;
import java.util.Objects;

public class PlayerDeathListener implements Listener {
    private final TDeathMessages plugin;
    public PlayerDeathListener(TDeathMessages plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        if (Objects.requireNonNull(event.getPlayer().getLastDamageCause()).isCancelled()) {
            return;
        }

        Player player = event.getPlayer();
        Player killer = event.getPlayer().getKiller();

        TagResolver resolver = null;
        if (this.plugin.miniPlaceholders) {
            if (killer == null) {
                resolver = MiniPlaceholders.getAudienceGlobalPlaceholders(player);
            } else {
                resolver = MiniPlaceholders.getRelationalGlobalPlaceholders(player, killer);
            }
        }

        List<String> messages = plugin.getConfig().getStringList("messages."+player.getLastDamageCause().getCause().toString().toLowerCase());
        if (messages.size() == 0) {
            event.deathMessage(MiniMessage.miniMessage().deserialize(plugin.getConfig().getStringList("messages.unknown").get(0)));
            return;
        }
        String message = messages.get((int) (Math.random() * messages.size()));
        assert killer != null;
        event.deathMessage(MiniMessage.miniMessage().deserialize(message,
                Placeholder.unparsed("player", player.getName()),
                Placeholder.parsed("killer", killer == null ? "Unknown" : killer.getName()),
                Placeholder.component("weapon",
                        killer != null && killer.getEquipment().getItemInMainHand().getType() != Material.AIR ?
                                Component.text()
                                        .append(killer.getEquipment().getItemInMainHand().getItemMeta().hasDisplayName() ? Objects.requireNonNull(killer.getEquipment().getItemInMainHand().getItemMeta().displayName()) : Component.translatable(killer.getEquipment().getItemInMainHand()))
                                        .hoverEvent(killer.getEquipment().getItemInMainHand())
                                : Component.text("fists")),
                resolver == null ? TagResolver.empty() : resolver)
        );

    }
}
