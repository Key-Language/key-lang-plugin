package top.subkey.key.plugin

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import top.subkey.key.plugin.parser.KeyParser
import top.subkey.key.plugin.psi.KeyFile
import top.subkey.key.plugin.psi.KeyTokenSets
import top.subkey.key.plugin.psi.KeyTypes

class KeyParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?): Lexer {
        return KeyLexerAdapter()
    }

    override fun createParser(project: Project?): PsiParser {
        return KeyParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return KeyTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        // TODO 实现字符串解析
        return TokenSet.EMPTY
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return KeyTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return KeyFile(viewProvider)
    }
}

@JvmField
val FILE: IFileElementType = IFileElementType(KeyLanguage.INSTANCE)