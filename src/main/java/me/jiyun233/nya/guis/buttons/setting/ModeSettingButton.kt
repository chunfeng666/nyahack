package me.jiyun233.nya.guis.buttons.setting

import me.jiyun233.nya.NyaHack
import me.jiyun233.nya.guis.buttons.ModuleButton
import me.jiyun233.nya.guis.buttons.SettingButton
import me.jiyun233.nya.settings.ModeSetting
import me.jiyun233.nya.utils.render.Render2DUtil
import java.awt.Color

class ModeSettingButton(
    width: Float,
    height: Float,
    value: ModeSetting<*>,
    father: ModuleButton
) : SettingButton<ModeSetting<*>>(width, height, value, father) {
    override fun drawButton(x: Float, y: Float, mouseX: Int, mouseY: Int) {
        Render2DUtil.drawRect(x, y, this.width, this.height, Color(15, 15, 15, 95).rgb)
        NyaHack.fontManager!!.CustomFont.drawStringWithShadow(
            value.name,
            x + 3,
            y + (height / 2) - (NyaHack.fontManager!!.CustomFont.height / 4),
            Color.WHITE
        )
        NyaHack.fontManager!!.CustomFont.drawStringWithShadow(
            (value as ModeSetting<*>).valueAsString,
            x + width - 3 - NyaHack.fontManager!!.CustomFont.getWidth(value.valueAsString),
            y + (height / 2) - (NyaHack.fontManager!!.CustomFont.height / 4),
            Color.WHITE
        )
        this.x = x
        this.y = y
    }

    override fun mouseClicked(mouseX: Int, mouseY: Int, mouseButton: Int) {
        if (!this.isHoveredButton(mouseX, mouseY) || !value.isVisible || !father.isShowSettings) {
            return
        }
        if (mouseButton == 0) {
            (this.value as ModeSetting<*>).forwardLoop()
        }
    }
}