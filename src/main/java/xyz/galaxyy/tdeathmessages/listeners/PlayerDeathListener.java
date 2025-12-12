package xyz.galaxyy.tdeathmessages.listeners;

import io.github.miniplaceholders.api.MiniPlaceholders;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import xyz.galaxyy.tdeathmessages.TDeathMessages;

import java.util.List;
import java.util.Objects;

public record PlayerDeathListener(TDeathMessages plugin) implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (Objects.requireNonNull(event.getPlayer().getLastDamageCause()).isCancelled()) {
            return;
        }

        Player player = event.getPlayer();
        Player killer = event.getPlayer().getKiller();

        TagResolver resolver = MiniPlaceholders.audiencePlaceholders();

        List<String> messages = plugin.getConfig().getStringList("messages." + player.getLastDamageCause().getCause().toString().toLowerCase());
        if (messages.isEmpty()) {
            event.deathMessage(
                    MiniMessage.miniMessage().
                            deserialize(
                                    plugin.getConfig().getStringList("messages.unknown").get(0),
                                    Placeholder.parsed("player", player.getName()),
                                    Placeholder.parsed("killer", killer == null ? "Unknown" : killer.getName()),
                                    Placeholder.component("original_message", event.deathMessage() != null ? event.deathMessage() : Component.text(""))
                            ));
            return;
        }
        String message = messages.get((int) (Math.random() * messages.size()));
        event.deathMessage(MiniMessage.miniMessage().deserialize(message,
                Placeholder.parsed("player", player.getName()),
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
