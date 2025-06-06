# PolarPots

PolarPots is a simple Minecraft plugin that improves splash potion throwing when sprinting and provides commands for quickly filling your inventory with potions.

## Features

* Adjusts splash potion trajectory while sprinting for smoother PvP potting.
* Ensures sprint‑thrown potions give full effect when they land.
* `/polarpots fill [amount]` (alias `/pp fill`) – fills your inventory with splash healing II potions.
* `/polarpots reload` – reloads the configuration.

## Building

The project uses Maven. To build the plugin run:

```bash
mvn package
```

The resulting jar can be found in `target/` and dropped into your server's `plugins` folder.
