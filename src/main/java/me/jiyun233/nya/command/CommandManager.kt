package me.jiyun233.nya.command

import me.jiyun233.nya.NyaHack
import me.jiyun233.nya.command.commands.*
import me.jiyun233.nya.utils.client.ChatUtil
import java.util.*


class CommandManager {
    val commands = arrayListOf<Command>()

    init {
        register(ModuleBindCommand())
        register(PreFixCommand())
        register(HelpCommand())
        register(ReloadCommand())
    }

    private fun register(command: Command) {
        if (!commands.contains(command)) commands.add(command)
    }

    fun run(run: String) {
        val readString: String = run.trim().substring(NyaHack.commandPrefix.length).trim()
        var commandResolved = false
        val hasArgs = readString.trim { it <= ' ' }.contains(" ")
        val commandName = if (hasArgs) readString.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()[0] else readString.trim { it <= ' ' }
        val args: Array<out String?> =
            if (hasArgs) readString.substring(commandName.length).trim { it <= ' ' }.split(" ".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray() else arrayOfNulls(0)

        for (command in commands) {
            if (command.name.trim().lowercase()
                == (commandName.trim { it <= ' ' }.lowercase(Locale.getDefault())).lowercase()
                || command.aliases.ignoreCaseContains(commandName.trim { it <= ' ' }.lowercase(Locale.getDefault()))
            ) {
                command.execute(args)
                commandResolved = true
                break
            }
        }
        if (!commandResolved) {
            ChatUtil.sendMessage("&c&lUnknown command.")
        }
    }


    private fun Array<String>.ignoreCaseContains(string: String): Boolean {
        for (s in this) {
            if (s.trim().lowercase() == string.lowercase()) return true
        }
        return false
    }
}