package top.subkey.key.plugin.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import top.subkey.key.plugin.KeyFileType
import top.subkey.key.plugin.KeyLanguage

class KeyFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, KeyLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return KeyFileType.INSTANCE
    }

    override fun toString(): String {
        return "Key File"
    }
}