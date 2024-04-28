package top.subkey.key.plugin.psi

import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls
import top.subkey.key.plugin.KeyLanguage

class KeyElementType(debugName: @NonNls String) : IElementType(debugName, KeyLanguage.INSTANCE)