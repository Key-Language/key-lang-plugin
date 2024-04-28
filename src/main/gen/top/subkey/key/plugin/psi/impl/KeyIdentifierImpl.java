// This is a generated file. Not intended for manual editing.
package top.subkey.key.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static top.subkey.key.plugin.psi.KeyTypes.*;
import top.subkey.key.plugin.psi.*;

public class KeyIdentifierImpl extends KeyNamedElementImpl implements KeyIdentifier {

  public KeyIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KeyVisitor visitor) {
    visitor.visitIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KeyVisitor) accept((KeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement setName(@NotNull String newName) {
    return KeyPsiImplUtil.setName(this, newName);
  }

  @Override
  @NotNull
  public String getName() {
    return KeyPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public PsiElement getNameIdentifier() {
    return KeyPsiImplUtil.getNameIdentifier(this);
  }

}
