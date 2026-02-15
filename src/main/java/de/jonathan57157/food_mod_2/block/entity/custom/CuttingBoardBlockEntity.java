package de.jonathan57157.food_mod_2.block.entity.custom;

import de.jonathan57157.food_mod_2.block.entity.ImplementedInventory;
import de.jonathan57157.food_mod_2.block.entity.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class CuttingBoardBlockEntity extends BlockEntity implements ImplementedInventory {

    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(1, ItemStack.EMPTY);

    public CuttingBoardBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CUTTING_BOARD_BE, pos, state);
    }

    /* ---------- Inventory ---------- */

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public ItemStack getStack() {
        return inventory.get(0);
    }

    public void setStack(ItemStack stack) {
        inventory.set(0, stack);
        markDirty();
    }

    public ItemStack removeStack() {
        ItemStack result = inventory.get(0);
        inventory.set(0, ItemStack.EMPTY);
        markDirty();
        return result;
    }


    /* ---------- NBT ---------- */

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);

        inventory.clear();

        Inventories.readNbt(nbt, inventory, registryLookup);
    }


    /* ---------- Sync ---------- */

    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public void markDirty() {
        super.markDirty();

        if (world != null && !world.isClient) {
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_LISTENERS);
        }
    }

}
