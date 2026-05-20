package com.borderlands3trainer.core;

/**
 * Core engine that manages trainer features such as infinite health, ammo, and money.
 * Uses MemoryManager to read/write game memory addresses.
 */
public class TrainerEngine {

    private final MemoryManager memoryManager;

    // Feature states
    private boolean infiniteHealthEnabled = false;
    private boolean infiniteAmmoEnabled = false;
    private boolean infiniteMoneyEnabled = false;

    // Memory offsets (example values, would be updated per game version)
    private static final long HEALTH_OFFSET = 0x12345678;
    private static final long AMMO_OFFSET = 0x9ABCDEF0;
    private static final long MONEY_OFFSET = 0x11223344;

    /**
     * Constructs the trainer engine with a given memory manager.
     *
     * @param memoryManager The MemoryManager instance for process interaction.
     */
    public TrainerEngine(MemoryManager memoryManager) {
        this.memoryManager = memoryManager;
    }

    /**
     * Toggles infinite health on or off. When enabled, health is set to max each frame.
     */
    public void toggleInfiniteHealth() {
        infiniteHealthEnabled = !infiniteHealthEnabled;
        System.out.println("Infinite Health: " + (infiniteHealthEnabled ? "ENABLED" : "DISABLED"));
        if (infiniteHealthEnabled) {
            // Write max health value (e.g., 1000) to the health address
            memoryManager.writeInt(HEALTH_OFFSET, 1000);
        }
    }

    /**
     * Toggles infinite ammo on or off. When enabled, ammo is set to a high value.
     */
    public void toggleInfiniteAmmo() {
        infiniteAmmoEnabled = !infiniteAmmoEnabled;
        System.out.println("Infinite Ammo: " + (infiniteAmmoEnabled ? "ENABLED" : "DISABLED"));
        if (infiniteAmmoEnabled) {
            memoryManager.writeInt(AMMO_OFFSET, 999);
        }
    }

    /**
     * Toggles infinite money on or off. When enabled, money is set to a large amount.
     */
    public void toggleInfiniteMoney() {
        infiniteMoneyEnabled = !infiniteMoneyEnabled;
        System.out.println("Infinite Money: " + (infiniteMoneyEnabled ? "ENABLED" : "DISABLED"));
        if (infiniteMoneyEnabled) {
            memoryManager.writeInt(MONEY_OFFSET, 999999);
        }
    }

    /**
     * Returns whether infinite health is currently enabled.
     *
     * @return true if enabled.
     */
    public boolean isInfiniteHealthEnabled() {
        return infiniteHealthEnabled;
    }

    /**
     * Returns whether infinite ammo is currently enabled.
     *
     * @return true if enabled.
     */
    public boolean isInfiniteAmmoEnabled() {
        return infiniteAmmoEnabled;
    }

    /**
     * Returns whether infinite money is currently enabled.
     *
     * @return true if enabled.
     */
    public boolean isInfiniteMoneyEnabled() {
        return infiniteMoneyEnabled;
    }

    /**
     * Gets the underlying MemoryManager (for advanced use).
     *
     * @return the MemoryManager instance.
     */
    public MemoryManager getMemoryManager() {
        return memoryManager;
    }
}
