package me.jiyun233.nya.inject

import me.jiyun233.nya.NyaHack
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion
import org.spongepowered.asm.launch.MixinBootstrap
import org.spongepowered.asm.mixin.MixinEnvironment
import org.spongepowered.asm.mixin.Mixins

@MCVersion("1.12.2")
@IFMLLoadingPlugin.Name("Nya")
class ForgeCoreModsLoader : IFMLLoadingPlugin {
    init {
        MixinBootstrap.init()
        Mixins.addConfiguration("mixins.nya.json")
        MixinEnvironment.getDefaultEnvironment().obfuscationContext = "searge"
        NyaHack.logger.info(MixinEnvironment.getDefaultEnvironment().obfuscationContext)
    }
    override fun getASMTransformerClass(): Array<String?> { return arrayOfNulls(0) }
    override fun getModContainerClass(): String? { return null }
    override fun getSetupClass(): String? { return null }
    override fun injectData(data: Map<String, Any>) {}
    override fun getAccessTransformerClass(): String? { return null }
}