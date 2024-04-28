package top.subkey.key.plugin

import com.intellij.lang.Language

class KeyLanguage : Language("Key") {
    companion object {
        @JvmStatic
        val INSTANCE = KeyLanguage()
    }
}