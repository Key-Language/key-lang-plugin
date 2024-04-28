package top.subkey.key.plugin

import com.intellij.lexer.FlexAdapter

class KeyLexerAdapter : FlexAdapter(KeyLexer(null)) {
}