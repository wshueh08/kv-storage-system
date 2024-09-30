package com.github.raftimpl.raft;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RaftOptions {

    // A follower would become a candidate if it doesn't receive any message
    // from the leader in electionTimeoutMs milliseconds
    private int electionTimeoutMilliseconds = 5000;

    // A leader sends RPCs at least this often, even if there is no data to send
    private int heartbeatPeriodMilliseconds = 500;

    // Interval for snapshot timer execution
    private int snapshotPeriodSeconds = 3600;
    //  Only take a snapshot if the log entry size reaches snapshotMinLogSize
    private int snapshotMinLogSize = 100 * 1024 * 1024;
    private int maxSnapshotBytesPerRequest = 500 * 1024; // 500k

    private int maxLogEntriesPerRequest = 5000;

    //  Size of a single segment file, default is 100 MB
    private int maxSegmentFileSize = 100 * 1000 * 1000;

    // A follower can participate in elections and provide services only if
    // the gap with the leader is within catchupMargin
    private long catchupMargin = 500;

    // Maximum wait timeout for replication, in milliseconds
    private long maxAwaitTimeout = 1000;

    // Number of threads in the thread pool for synchronization with other nodes,
    // leader election, etc.
    private int raftConsensusThreadNum = 20;

    // Whether to write data asynchronously; true means the leader returns after
    // saving the data, and then asynchronously synchronizes it to the followers;
    // false means the leader returns only after synchronizing the data to the majority of followers.
    private boolean asyncWrite = false;

    // The parent directory for Raft logs and snapshots, absolute path
    private String dataDir = System.getProperty("com.github.raftimpl.raft.data.dir");
}
