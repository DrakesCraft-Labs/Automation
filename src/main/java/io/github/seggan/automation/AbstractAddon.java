package io.github.seggan.automation;

import com.github.drakescraft_labs.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.java.JavaPlugin;

// Kotlin doesn't like multiple implementations of the same method, so we have to use Java for this
public abstract class AbstractAddon extends JavaPlugin implements SlimefunAddon {
}
