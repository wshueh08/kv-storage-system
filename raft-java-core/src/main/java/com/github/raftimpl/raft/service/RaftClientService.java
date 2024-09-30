package com.github.raftimpl.raft.service;

import com.github.raftimpl.raft.proto.RaftProto;

/**
 * Defines the client-facing operations for interacting with a Raft cluster.
 * This interface provides methods for cluster management operations such as
 * getting leader information, retrieving cluster configuration, and modifying
 * cluster membership.
 * @param request
 * @return  Leader node
 */

public interface RaftClientService {

    RaftProto.GetLeaderResponse getLeader(RaftProto.GetLeaderRequest request);

    /**
     * Get information about all nodes in the Raft cluster
     * @param request 
     * @return Addresses of all nodes in the Raft cluster and their master-slave relationships
     */
    RaftProto.GetConfigurationResponse getConfiguration(RaftProto.GetConfigurationRequest request);

    /**
     * Add a node to the Raft cluster
     * @param request request Information about the node to be added
     * @return Success or failure
     */
    RaftProto.AddPeersResponse addPeers(RaftProto.AddPeersRequest request);

    /**
     * Remove a node from the Raft cluster
     * @param request Request
     * @return Success or failure
     */
    RaftProto.RemovePeersResponse removePeers(RaftProto.RemovePeersRequest request);
}
