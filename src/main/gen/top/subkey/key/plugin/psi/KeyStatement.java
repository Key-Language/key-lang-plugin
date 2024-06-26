// This is a generated file. Not intended for manual editing.
package top.subkey.key.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KeyStatement extends PsiElement {

  @Nullable
  KeyBlock getBlock();

  @Nullable
  KeyConstStatement getConstStatement();

  @Nullable
  KeyExpr getExpr();

  @Nullable
  KeyLetStatement getLetStatement();

  @Nullable
  KeyLockStatement getLockStatement();

}
