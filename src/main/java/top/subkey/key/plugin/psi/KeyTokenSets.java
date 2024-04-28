package top.subkey.key.plugin.psi;

import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public interface KeyTokenSets {
    @NotNull TokenSet COMMENTS = TokenSet.create(KeyTypes.COMMENT);
}
