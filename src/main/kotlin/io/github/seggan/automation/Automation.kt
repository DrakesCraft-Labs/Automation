package io.github.seggan.automation

import io.github.seggan.automation.commands.SuperCommand
import io.github.seggan.automation.computing.CpuTask
import io.github.seggan.automation.registries.Items
import org.bukkit.NamespacedKey
import org.bukkit.plugin.java.JavaPlugin
import kotlin.io.path.createDirectories
import kotlin.properties.Delegates

class Automation : AbstractAddon() {

    var interactionRadius by Delegates.notNull<Double>()
        private set

        private set


    override fun onEnable() {
        instance = this

        config.options().copyDefaults(true)
        saveConfig()


        runOnNextTick {
            log(
                """
                ################# 自动化 Automation $pluginVersion #################
                
                Automation 是开源的，你可以作出贡献或在此汇报问题：
                $bugTrackerURL
                加入 Slimefun 附属社区 Discord：discord.gg/SqD3gg5SAU
                
                ###################################################
                """.trimIndent()
            )
        }

        val mainCommand = getCommand("automation") ?: error("无法获取指令")
        mainCommand.setExecutor(SuperCommand.MAIN)
        mainCommand.tabCompleter = SuperCommand.MAIN

        Items.register(this)

        interactionRadius = config.getDouble("computers.interaction-radius", 3.0)

        dataFolder.toPath().resolve("local-repo").createDirectories()

        CpuTask.shutDown = false
        Thread(CpuTask, "Automation CPUs").start()
    }

    override fun onDisable() {
        instance = null
        CpuTask.shutDown = true
    }

    fun log(message: String) {
        for (line in message.split('\n')) {
            server.logger.info(line)
        }
    }

    fun runOnNextTick(ticks: Int = 0, action: () -> Unit) {
        server.scheduler.runTaskLater(this, action, ticks.toLong())
    }

    fun key(key: String) = NamespacedKey(this, key)

    override fun getJavaPlugin(): JavaPlugin = this
    override fun getBugTrackerURL(): String = "https://github.com/DrakesCraft-Labs/Automation/issues"
}

private var instance: Automation? = null

internal val pluginInstance: Automation
    get() = instance ?: error("Plugin is not enabled")