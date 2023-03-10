public class Superblock {
    private final int defaultInodeBlocks = 64;
    public int totalBlocks; // the number of disk blocks
    public int totalInodes; // the number of inodes
    public int freeList; // the block number of the free list's head

    public Superblock( int diskSize ) {
        // read the superblock from disk.
        byte [] superBlock = new byte [Disk.blockSize];
        SysLib.rawread(0, superBlock);
        totalBlocks = SysLib.bytes2int(superBlock, 0);
        totalInodes = SysLib.bytes2int(superBlock, 4);
        freeList = SysLib.bytes2int(superBlock, 0);

        if (totalBlocks == diskSize && totalInodes > 0 && freeList >= 2){
            //disk contents are valid
            return;
        }
        else {
            //need to format disk
            totalBlocks = diskSize;
            format(defaultInodeBlocks);
        }
    }


    void sync( ) {
    // write back in-memory superblock to disk: SysLib.rawwrite( 0, superblock );
    }
    void format( int files ) {
    // initialize the superblock
    // initialize each inode and immediately write it back to disk
    // initialize free blocks
    }
    public int getFreeBlock( ) {
    // get a new free block from the freelist
    //return freeBlockNumber;
    }
    public boolean returnBlock( int oldBlockNumber ) {
    // return this old block to the free list. The list can be a stack.
    // return true or false;
    } 
}