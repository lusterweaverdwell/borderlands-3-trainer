package com.borderlands3trainer;

import com.borderlands3trainer.ui.TrainerWindow;
import com.borderlands3trainer.core.MemoryManager;
import com.borderlands3trainer.core.TrainerEngine;
import com.borderlands3trainer.hotkeys.HotkeyListener;

/**
 * Main entry point for the Borderlands 3 Trainer application.
 * Initializes core components and launches the UI.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Starting Borderlands 3 Trainer v1.0.0");

        // Initialize memory manager to access game process
        MemoryManager memoryManager = new MemoryManager("Borderlands3");
        if (!memoryManager.attachToProcess()) {
            System.err.println("Failed to attach to Borderlands 3 process. Ensure the game is running.");
            System.exit(1);
        }

        // Create the trainer engine with default offsets (these would be updated per game patch)
        TrainerEngine engine = new TrainerEngine(memoryManager);

        // Start listening for global hotkeys
        HotkeyListener hotkeyListener = new HotkeyListener(engine);
        hotkeyListener.start();

        // Launch the Swing UI
        javax.swing.SwingUtilities.invokeLater(() -> {
            TrainerWindow window = new TrainerWindow(engine);
            window.setVisible(true);
        });

        System.out.println("Trainer ready. Use hotkeys or UI to toggle features.");
    }
}
