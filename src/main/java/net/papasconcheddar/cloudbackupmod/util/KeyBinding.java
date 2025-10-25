package net.papasconcheddar.cloudbackupmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_CLOUDBACKUPMOD = "key.category.cloudbackupmod.cloudbackup";
    public static final String KEY_BACKUP_MENU = "key.cloudbackupmod.backup_menu";

    public static final KeyMapping BACKUP_MENU_KEY = new KeyMapping(KEY_BACKUP_MENU, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_CLOUDBACKUPMOD);
}