// This is a generated file. Not intended for manual editing.
package top.subkey.key.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static top.subkey.key.plugin.psi.KeyTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import top.subkey.key.plugin.psi.*;

public class KeyAssignToImpl extends ASTWrapperPsiElement implements KeyAssignTo {

  public KeyAssignToImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KeyVisitor visitor) {
    visitor.visitAssignTo(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KeyVisitor) accept((KeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KeyAssignDestruct getAssignDestruct() {
    return findChildByClass(KeyAssignDestruct.class);
  }

  @Override
  @Nullable
  public KeyAssignSingle getAssignSingle() {
    return findChildByClass(KeyAssignSingle.class);
  }

}
