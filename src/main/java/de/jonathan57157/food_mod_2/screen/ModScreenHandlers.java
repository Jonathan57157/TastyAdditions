package de.jonathan57157.food_mod_2.screen;

import de.jonathan57157.food_mod_2.FoodMod2;
import de.jonathan57157.food_mod_2.screen.custom.IceCreamMakerScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {

    public static ScreenHandlerType<IceCreamMakerScreenHandler>
            ICE_CREAM_MAKER_SCREEN_HANDLER;

    public static void registerScreenHandlers() {
        ICE_CREAM_MAKER_SCREEN_HANDLER =
                Registry.register(
                        Registries.SCREEN_HANDLER,
                        Identifier.of(FoodMod2.MOD_ID, "ice_cream_maker_screen_handler"),
                        new ExtendedScreenHandlerType<>(
                                IceCreamMakerScreenHandler::new,
                                BlockPos.PACKET_CODEC
                        )
                );

        FoodMod2.LOGGER.info("Registered Screen Handlers for " + FoodMod2.MOD_ID);
    }
}
