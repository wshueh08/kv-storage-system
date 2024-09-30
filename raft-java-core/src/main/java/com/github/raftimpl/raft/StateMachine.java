package com.github.raftimpl.raft;


public interface StateMachine {

    /**
     * Take a snapshot of the data in the state machine. This is called periodically on each node.
     * @param snapshotDir snapshotDir Directory to output the snapshot data
     */
    void writeSnapshot(String snapshotDir);

    /**
     * Read a snapshot into the state machine, called when the node starts up
     * @param snapshotDir snapshotDir Directory of the snapshot data
     */
    void readSnapshot(String snapshotDir);

    /**
     * Apply data to the state machine
     * @param dataBytes dataBytes Binary data
     */
    void apply(byte[] dataBytes);
}
