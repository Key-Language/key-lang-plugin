package top.subkey.key.plugin

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import top.subkey.key.plugin.psi.KeyTypes

class KeySyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        @JvmField
        val LINE_COMMENT = TextAttributesKey.createTextAttributesKey(
            "KEY_LINE_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        @JvmField
        val KEYWORD = TextAttributesKey.createTextAttributesKey(
            "KEY_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
        )

        @JvmField
        val ID = TextAttributesKey.createTextAttributesKey(
            "ID",
            DefaultLanguageHighlighterColors.IDENTIFIER
        )

        private val LINE_COMMENT_KEYS = arrayOf(LINE_COMMENT)
        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val ID_KEYS = arrayOf(ID)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }

    override fun getHighlightingLexer(): Lexer {
        return KeyLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        if (tokenType == null) {
            return EMPTY_KEYS
        }
        if (tokenType == KeyTypes.COMMENT) {
            return LINE_COMMENT_KEYS
        }
        if (tokenType == KeyTypes.LET) {
            return KEYWORD_KEYS
        }
        if (tokenType == KeyTypes.ID) {
            return ID_KEYS
        }
        return EMPTY_KEYS
    }
}