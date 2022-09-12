public class MonitorThread implements Runnable{
    MerkleManager oMerkleManager = new MerkleManager();
    Util oUtil = new Util();
    String threadName;
    public void run() {
        while(true) {
            if(MerkleManager.sMerkleRoot != null) {
                if((MerkleManager.sMerkleRoot).equals(MerkleManager.expectedRoot)) {
                    System.out.println("You win: " + MerkleManager.sMerkleRoot);
                    System.exit(0);
                }else if (MerkleManager.sMerkleRoot != MerkleManager.expectedRoot)
                {
                    System.out.println("You lost, please exit the app.");
                    System.exit(0);
                }
            }
            else if (MerkleManager.strikes == 3) {
                System.out.println("3 strikes: you lost!");
                System.exit(0);
            }
            oUtil.sleep(1);
        }
    }
}

