package net.papasconcheddar.cloudbackupmod.screen;
import net.papasconcheddar.cloudbackupmod.screen.custom.PanelMenu;
import net.papasconcheddar.cloudbackupmod.screen.custom.PanelScreen;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.papasconcheddar.cloudbackupmod.CloudBackupMod;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, CloudBackupMod.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<PanelMenu>> PANEL_MENU =
            registerMenuType("panel_menu", PanelMenu::new);

    private static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                              IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
