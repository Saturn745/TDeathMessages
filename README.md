**TDeathMessages** is a lightweight and customizable Minecraft plugin that allows you to personalize the vanilla death messages using MiniMessage and MiniPlaceholders. With DeathMessages, you can create unique and immersive death messages for players on your server.

## Features

- Customize death messages using MiniMessage and MiniPlaceholders.
- Lightweight and efficient, ensuring minimal impact on server performance.
- Create engaging and dynamic death messages for a more immersive gaming experience.
- No extra necessary features!

## Default Configuration

<details>
<summary>Click to expand</summary>
  
## **Note:** This default configuration requires [MiniPlaceholder](https://github.com/MiniPlaceholders/MiniPlaceholders) and the [Expressions Expansion](https://github.com/MiniPlaceholders/Expressions-Expansion) to work correctly.

```yaml
messages:
  contact:
    - "<red>☠ <player> was pricked to death <expr_if:<killer>:Unknown: :by <killer>>"
  entity_attack:
    - "<red>☠ <player> was attacked by <killer> using <weapon>"
  entity_sweep_attack:
    - "<red>☠ <player> was attacked <expr_if:<killer>:Unknown: :by <killer>>"
  projectile:
    - "<red>☠ <player> was shot <expr_if:<killer>:Unknown: :by <killer>>"
  suffocation:
    - "<red>☠ <player> suffocated"
  fall:
    - "<red>☠ <player> fell to their death from a great height"
    - "<red>☠ <player> didn't stick the landing"
    - "<red>☠ <player> forgot to open their parachute"
    - "<red>☠ <player> left the plane without a parachute"
    - "<red>☠ <player> left their parachute at home"
    - "<red>☠ <player> thought they could fly"
  fire:
    - "<red>☠ <player> was burned to death <expr_if:<killer>:Unknown: :by <killer>>"
    - "<red>☠ <player> went up in flames <expr_if:<killer>:Unknown: :from <killer>>"
  fire_tick:
    - "<red>☠ <player> succumbed to burns caused by fire"
    - "<red>☠ <player> burned to death"
  melting:
    - "<red>☠ <player> melted away"
  lava:
    - "<red>☠ <player> was engulfed in lava <expr_if:<killer>:Unknown: :while trying to escape from <killer>>"
    - "<red>☠ <player> tried to swim in lava <expr_if:<killer>:Unknown: :while trying to escape from <killer>>"
  drowning:
    - "<red>☠ <player> drowned"
    - "<red>☠ <player> forgot to breathe"
    - "<red>☠ <player> forgot to come up for air"
    - "<red>☠ <player> forgot to hold their breath"
  block_explosion:
    - "<red>☠ <player> was caught in a explosion <expr_if:<killer>: :caused by <killer>>"
  entity_explosion:
    - "<red>☠ <player> was caught in a explosion <expr_if:<killer>: :caused by <killer>>"
  void:
    - "<red>☠ <player> fell into the void <expr_if:<killer>:Unknown: :while trying to escape from <killer>>"
    - "<red>☠ <player> fell out of the world <expr_if:<killer>:Unknown: :while trying to escape from <killer>>"
  lightning:
    - "<red>☠ <player> was struck by lightning"
  suicide:
    - "<red>☠ <player> committed suicide"
  starvation:
    - "<red>☠ <player> starved to death"
  poison:
    - "<red>☠ <player> succumbed to poison"
  magic:
    - "<red>☠ <player> was killed by a magical force"
  wither:
    - "<red>☠ <player> withered away"
  falling_block:
    - "<red>☠ <player> was crushed by a falling block"
  thorns:
    - "<red>☠ <player> was pricked to death <expr_if:<killer>:Unknown: :by <killer>'s thorns>"
  dragon_breath:
    - "<red>☠ <player> was caught in a dragon's breath attack"
  custom:
    - "<red>☠ <player> met an unusual demise<expr_if:<killer>:Unknown: : by <killer>>"
  fly_into_wall:
    - "<red>☠ <player> flew into a wall"
    - "<red>☠ <player> thought they were a ghost"
  hot_floor:
    - "<red>☠ <player> couldn't handle the heat"
  cramming:
    - "<red>☠ <player> was crushed by too many entities"
  dryout:
    - "<red>☠ <player> dried out"
  freeze:
    - "<red>☠ <player> froze to death"
  sonic_boom:
    - "<red>☠ <player> was shattered by a sonic boom"
  unknown:
    - "<red>☠ <original_message>"
```
</details>
