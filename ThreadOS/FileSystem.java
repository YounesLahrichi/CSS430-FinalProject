public class FileSystem {
    private Superblock superblock;
    private Directory directory;
    private FileStructureTable filetable;

    public FileSystem (int diskBlocks){
        superblock = new SuperBlock (diskBlocks);
        directory = new Directory(superblock.totalInodes);
        filetable = new FileStructureTable(directory);

        //Read the "/" file from disk
        FileTableEntry dirEnt = open ("/", "r");
        int dirSize = fsize(dirEnt);
        if (dirSize > 0){
            // the directory has some data
            byte [] dirData = new byte [dirSize];
            read(dirEnt , dirData);
            directory.bytes2directory(dirData);
        }
        close(dirEnt);
    }
}
