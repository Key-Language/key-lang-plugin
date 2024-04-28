package top.subkey.key.plugin;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class KeyFileType extends LanguageFileType {
    @SuppressWarnings("unused")
    public static final KeyFileType INSTANCE = new KeyFileType();

    private KeyFileType() {
        super(KeyLanguage.getINSTANCE());
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Key file";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Key language file";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "ks";
    }

    @Override
    public Icon getIcon() {
        return KeyIcon.INSTANCE.getICON();
    }
}
