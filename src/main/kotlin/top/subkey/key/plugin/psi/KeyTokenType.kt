package top.subkey.key.plugin.psi

import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls
import top.subkey.key.plugin.KeyLanguage

class KeyTokenType(debugName: @NonNls String) : IElementType(debugName, KeyLanguage.INSTANCE) {
    override fun toString(): String {
        return "KeyTokenType." + super.toString()
    }
}