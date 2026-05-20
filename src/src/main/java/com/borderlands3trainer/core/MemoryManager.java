package com.borderlands3trainer.core;

/**
 * Manages low-level memory operations for reading/writing to the Borderlands 3 process.
 * This is a simulated implementation for demonstration; real usage would involve JNI or a library like JNA.
 */
public class MemoryManager {

    private final String processName;
    private boolean attached;

    /**
     * Constructs a MemoryManager for the given process name.
     *
     * @param processName The name of the target process (e.g., "Borderlands3").
     */
    public MemoryManager(String processName) {
        this.processName = processName;
        this.attached = false;
    }

    /**
     * Attempts to attach to the running game process.
     *
     * @return true if attachment succeeded, false otherwise.
     */
    public boolean attachToProcess() {
        // Simulate process attachment
        System.out.println("Attaching to process: " + processName);
        attached = true;
        return attached;
    }

    /**
     * Reads an integer value from the specified memory address.
     *
     * @param address The memory address to read from.
     * @return The integer value at that address, or 0 if not attached.
     */
    public int readInt(long address) {
        if (!attached) {
            System.err.println("Not attached to process. Cannot read memory.");
            return 0;
        }
        // Simulated read: return a placeholder value
        System.out.println("Reading int from address: 0x" + Long.toHexString(address));
        return 100;
    }

    /**
     * Writes an integer value to the specified memory address.
     *
     * @param address The memory address to write to.
     * @param value   The integer value to write.
     */
    public void writeInt(long address, int value) {
        if (!attached) {
            System.err.println("Not attached to process. Cannot write memory.");
            return;
        }
        // Simulated write
        System.out.println("Writing value " + value + " to address: 0x" + Long.toHexString(address));
    }

    /**
     * Checks if the manager is currently attached to the process.
     *
     * @return true if attached.
     */
    public boolean isAttached() {
        return attached;
    }

    /**
     * Detaches from the process and cleans up.
     */
    public void detach() {
        attached = false;
        System.out.println("Detached from process: " + processName);
    }
}
