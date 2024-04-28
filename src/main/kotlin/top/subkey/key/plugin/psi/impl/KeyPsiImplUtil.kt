package top.subkey.key.plugin.psi.impl

import com.intellij.psi.PsiElement
import top.subkey.key.plugin.psi.KeyElementFactory
import top.subkey.key.plugin.psi.KeyIdentifier
import top.subkey.key.plugin.psi.KeyTypes

object KeyPsiImplUtil {

    @JvmStatic
    fun getName(element: KeyIdentifier): String {
        return element.node.text
    }
    
    @JvmStatic
    fun setName(element: KeyIdentifier, newName: String): PsiElement {
        val id = element.node.findChildByType(KeyTypes.ID)
        if (id != null) {
            val newEle = KeyElementFactory.createIdentifier(element.project, newName)
            val newNode = newEle.node
            element.node.treeParent.replaceChild(element.node, newNode)
        }
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: KeyIdentifier): PsiElement {
        return element
    }
}
