public class RogueThread implements Runnable {

    String sThreadName1 = "Rogue";

    public void run() {
        Util oUtil = new Util();

        MerkleManager oMerkleManager = new MerkleManager();

        while (true) {

            oUtil.sleepRandomTime(sThreadName1);

            String sNewWord = MerkleManager.grabWord();

            if (sNewWord != null) {

                MerkleManager.strikes++;

                System.out.println("STRIKE! " + MerkleManager.strikes + " out of 3 strikes ");
            }
        }
    }
}