package top.subkey.key.plugin.refactor

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import top.subkey.key.plugin.psi.KeyIdentifier

class KeyRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return element is KeyIdentifier
    }
}