package top.subkey.key.plugin.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import top.subkey.key.plugin.psi.KeyNamedElement

abstract class KeyNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), KeyNamedElement