package com.borderlands3trainer.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the TrainerEngine class.
 * Verifies feature toggling behavior.
 */
class TrainerEngineTest {

    private MemoryManager memoryManager;
    private TrainerEngine engine;

    @BeforeEach
    void setUp() {
        // Use a fresh MemoryManager for each test (simulated)
        memoryManager = new MemoryManager("TestProcess");
        memoryManager.attachToProcess();
        engine = new TrainerEngine(memoryManager);
    }

    @Test
    void testToggleInfiniteHealthInitiallyDisabled() {
        assertFalse(engine.isInfiniteHealthEnabled(), "Health should start disabled");
    }

    @Test
    void testToggleInfiniteHealthEnables() {
        engine.toggleInfiniteHealth();
        assertTrue(engine.isInfiniteHealthEnabled(), "Health should be enabled after toggle");
    }

    @Test
    void testToggleInfiniteHealthDisables() {
        engine.toggleInfiniteHealth();
        engine.toggleInfiniteHealth();
        assertFalse(engine.isInfiniteHealthEnabled(), "Health should be disabled after second toggle");
    }

    @Test
    void testToggleInfiniteAmmoInitiallyDisabled() {
        assertFalse(engine.isInfiniteAmmoEnabled(), "Ammo should start disabled");
    }

    @Test
    void testToggleInfiniteAmmoEnables() {
        engine.toggleInfiniteAmmo();
        assertTrue(engine.isInfiniteAmmoEnabled(), "Ammo should be enabled after toggle");
    }

    @Test
    void testToggleInfiniteMoneyInitiallyDisabled() {
        assertFalse(engine.isInfiniteMoneyEnabled(), "Money should start disabled");
    }

    @Test
    void testToggleInfiniteMoneyEnables() {
        engine.toggleInfiniteMoney();
        assertTrue(engine.isInfiniteMoneyEnabled(), "Money should be enabled after toggle");
    }

    @Test
    void testMultipleTogglesIndependent() {
        engine.toggleInfiniteHealth();
        engine.toggleInfiniteAmmo();
        assertTrue(engine.isInfiniteHealthEnabled());
        assertTrue(engine.isInfiniteAmmoEnabled());
        assertFalse(engine.isInfiniteMoneyEnabled());
        engine.toggleInfiniteHealth();
        assertFalse(engine.isInfiniteHealthEnabled());
        assertTrue(engine.isInfiniteAmmoEnabled());
    }
}
