package top.subkey.key.plugin.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.descendantsOfType
import top.subkey.key.plugin.KeyLanguage

object KeyElementFactory {
    fun createIdentifier(project: Project, name: String): KeyIdentifier {
        val file = createFile(project, name)
        return file.descendantsOfType<KeyIdentifier>().first()
    }

    fun createFile(project: Project, text: String): KeyFile {
        val name = "dummy.ks"
        return PsiFileFactory.getInstance(project).createFileFromText(
            name, KeyLanguage.INSTANCE, text
        ) as KeyFile
    }
}
